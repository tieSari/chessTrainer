Automaattisten JUnit-testien lisäksi olen testannut ohjelman toiminnallisuutta pelaamalla läpi eri loppupelityyppejä. Olen tarkistanut, että matti, patti, 50 siirron sääntö ja suojaamattoman nappulan syönti  toimii oikein ja tarvittaessa korjannut koodia.

Nappulan vaikutusruutujen oikea hallinta tuotti eniten päänvaivaa. Uuden loppupelin alkaessa piti ymmärtää resetoida laudan nappulat, nappulaikonit sekä ruutujen shakit. Samoin jokaisella siirrolla saattaa olla vaikutusta muiden nappuloiden vaikutusalueisiin, mikä oli testattava huolella eri tilanteissa. Sitä varten laitoin konsolille tulostuksen kaikkien nappuloiden vaikutusruuduista joka siirron jälkeen.

Testasin myös kahden lähetin loppupelissä, että lähetit ovat aina eri värisillä ruuduilla arpomalla uuden peliaseman laudalle kymmeniä kertoja.
