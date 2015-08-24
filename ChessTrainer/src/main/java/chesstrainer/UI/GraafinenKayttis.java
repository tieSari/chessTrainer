package chesstrainer.UI;

//shakkilauta pohjautuu esimerkkiin
//http://stackoverflow.com/questions/21142686/making-a-robust-resizable-swing-chess-gui
import chesstrainer.rakenteet.NappulaTehdas;
import chesstrainer.rakenteet.Nappula;
import chesstrainer.apuluokat.*;
import chesstrainer.logiikka.Logiikka;
import chesstrainer.peliosat.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.*;
import javax.swing.border.*;
import javax.imageio.ImageIO;

public class GraafinenKayttis {

    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private final JButton[][] chessBoardSquares = new JButton[8][8];
    private final Image[][] chessPieceImages = new Image[2][6];
    private JPanel chessBoard;
    private final JComboBox valikko = new JComboBox(
            new Object[]{Loppupeli.DaamiJaKuningas, Loppupeli.TorniJaKuningas, 
                Loppupeli.KaksiTorniaJaKuningas, Loppupeli.RatsuJaLahettiJaKuningas,
            Loppupeli.KaksiLahettiaJaKuningas});
    private final JLabel message = new JLabel(
            "Valitse loppupeli");
    private static final String COLS = "ABCDEFGH";
    private Logiikka logiikka;
    private Pelilauta pelilauta;
    private JButton activeSquare = null;
    private Nappula siirrettava = null;
    private Nappula mK;
    private boolean isActive = true;

    public GraafinenKayttis(Pelilauta lauta, Logiikka logiikka) {
        initializeGui();
        this.pelilauta = lauta;
        this.logiikka = logiikka;
    }

    public GraafinenKayttis() {
    }

    public final void initializeGui() {
        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        Action newGameAction = new AbstractAction("Uusi") {

            @Override
            public void actionPerformed(ActionEvent e) {
                createImages();
                setupNewGame();
            }
        };
        tools.add(newGameAction);
        tools.addSeparator();
        //tools.add(new JButton("Resign")); // TODO - add functionality!
        tools.addSeparator();
        tools.add(message);
        tools.addSeparator();
        tools.add(valikko);

        gui.add(new JLabel("?"), BorderLayout.LINE_START);

        chessBoard = new JPanel(new GridLayout(0, 9)) {

            /**
             * Override the preferred size to return the largest it can, in a
             * square shape. Must (must, must) be added to a GridBagLayout as
             * the only component (it uses the parent as a guide to size) with
             * no GridBagConstaint (so it is centered).
             */
            @Override
            public final Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                Dimension prefSize = null;
                Component c = getParent();
                if (c == null) {
                    prefSize = new Dimension(
                            (int) d.getWidth(), (int) d.getHeight());
                } else if (c.getWidth() > d.getWidth()
                        && c.getHeight() > d.getHeight()) {
                    prefSize = c.getSize();
                } else {
                    prefSize = d;
                }
                int w = (int) prefSize.getWidth();
                int h = (int) prefSize.getHeight();
                // the smaller of the two sizes
                int s = (w > h ? h : w);
                return new Dimension(s, s);
            }
        };
        chessBoard.setBorder(new CompoundBorder(
                new EmptyBorder(8, 8, 8, 8),
                new LineBorder(Color.BLACK)
        ));
        // Set the BG to be ochre
        Color ochre = new Color(204, 119, 34);
        chessBoard.setBackground(ochre);
        JPanel boardConstrain = new JPanel(new GridBagLayout());
        boardConstrain.setBackground(ochre);
        boardConstrain.add(chessBoard);
        gui.add(boardConstrain);

        // create the chess board squares
        Insets buttonMargin = new Insets(0, 0, 0, 0);
        for (int ii = 0; ii < chessBoardSquares.length; ii++) {
            for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                // our chess pieces are 64x64 px in size, so we'll
                // 'fill this in' using a transparent icon..
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                if ((jj % 2 == 1 && ii % 2 == 1)
                        //) {
                        || (jj % 2 == 0 && ii % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.BLACK);
                }
                b.setName("" + (jj) + (8 - ii));
                b.addActionListener(new RuutuListener());
                chessBoardSquares[ii][jj] = b;

            }
        }

        /*
         * fill the chess board
         */
        chessBoard.add(new JLabel(""));
        // fill the top row
        for (int ii = 0; ii < 8; ii++) {
            chessBoard.add(
                    new JLabel(COLS.substring(ii, ii + 1),
                            SwingConstants.CENTER));
        }
        // fill the black non-pawn piece row
        for (int ii = 0; ii < 8; ii++) {
            for (int jj = 0; jj < 8; jj++) {
                switch (jj) {
                    case 0:
                        chessBoard.add(new JLabel("" + (9 - (ii + 1)),
                                SwingConstants.CENTER));
                    default:
                        chessBoard.add(chessBoardSquares[ii][jj]);
                }
            }
        }
    }

    public final JComponent getGui() {
        return gui;
    }

    private void createImages() {
        try {
            File file = new File("src/main/resources/memI0.png");
            BufferedImage bi = ImageIO.read(file);
            for (int ii = 0; ii < 2; ii++) {
                for (int jj = 0; jj < 6; jj++) {
                    chessPieceImages[ii][jj] = bi.getSubimage(
                            jj * 64, ii * 64, 64, 64);
                }
            }
        } catch (Exception e) {
            System.exit(1);
        }
    }

    /**
     * Valitun loppupelin mukaiset nappulat arvotaan laudalle
     */
    private void setupNewGame() {
        message.setText("");
        isActive = true;
        for (Nappula nappula : pelilauta.getNappulat()) {
            AsetaNappulaIkoni(nappula, false);
        }
        pelilauta.tyhjennaLauta();
        pelilauta.setNappulat(NappulaTehdas.LuoValkeat(Loppupeli.valueOf(valikko.getSelectedItem().toString())));
        mK = NappulaTehdas.LuoKuningas(Vari.Musta);
        pelilauta.addNappula(mK);

        logiikka.ArvoAlkuasema(pelilauta);
        for (Nappula nappula : pelilauta.getNappulat()) {
            AsetaNappulaIkoni(nappula, true);
        }
    }

    private JButton HaePainoRuutu(Sijainti sijainti) {
        return chessBoardSquares[7 - (sijainti.getNumero() - 1)][sijainti.getKirjain().getValue()];
    }

    private void AsetaNappulaIkoni(Nappula nappula, boolean lisaa) {

        ImageIcon ikoni = lisaa ? new ImageIcon(
                chessPieceImages[nappula.getVari().getValue()][nappula.getArvo().getValue()]) : null;
        Sijainti sijainti = nappula.getSijaintiRuutu().getSijainti();
        JButton square = HaePainoRuutu(sijainti);
        square.setIcon(ikoni);
    }

    private Tilanne SiirraMustanKunkkua() {

        pelilauta.TeeSiirronJalkeisetToimet();

        JButton lahtoRuutu = HaePainoRuutu(mK.getSijaintiRuutu().getSijainti());
        Tilanne tilanne = logiikka.SiirraMustaKunkku(mK);

        if (tilanne == Tilanne.OK) {
            lahtoRuutu.setIcon(null);
            AsetaNappulaIkoni(mK, true);
            pelilauta.TeeSiirronJalkeisetToimet();
        }
        return tilanne;
    }

    class RuutuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Object source = ae.getSource();
            if (!(source instanceof JButton) || !isActive) {
                return;
            }

            JButton clicked = (JButton) source;
            if (activeSquare != null && !activeSquare.equals(clicked)) {
                if (siirrettava != null && siirrettava.Liikkuu(haeKohderuutu(clicked))) {
                    clicked.setIcon(activeSquare.getIcon());
                    nollaaSiirtotapahtuma();
                    Tilanne tilanne = SiirraMustanKunkkua();
                    if (tilanne != Tilanne.OK) {
                        JOptionPane.showMessageDialog(null, tilanne + "!", "Lopputulos", JOptionPane.INFORMATION_MESSAGE);
                        message.setText("Valitse loppupeli");
                        isActive = false;
                    }

                } else {
                    activeSquare = null;
                }

            } else {
                asetaSiirrettava(clicked);
                if (siirrettava != null) {
                    activeSquare = clicked;
                }
            }
        }

        private void asetaSiirrettava(JButton painoruutu) {
            siirrettava = pelilauta.getNappula(muunnaSijainti(painoruutu.getName()));
        }

        private Sijainti muunnaSijainti(String nappulanNimi) {

            Kirjain kirjain = Kirjain.get(Integer.parseInt(nappulanNimi.substring(0, 1)));
            int numero = Integer.parseInt(nappulanNimi.substring(1, 2));
            return new Sijainti(kirjain, numero);
        }

        private Ruutu haeKohderuutu(JButton painoruutu) {
            return pelilauta.getRuutu(muunnaSijainti(painoruutu.getName()));
        }

        private void nollaaSiirtotapahtuma() {

            activeSquare.setIcon(null);
            activeSquare = null;
            siirrettava = null;
        }
    }
}
