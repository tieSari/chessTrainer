#Aiheen kuvaus 
Shakin loppupeliharjoitusohjelma. Ohjelmalla voi harjoitella sotilaattomia perusloppupelejä pelaamalla ohjelman mustaa kuningasta vastaan. Ohjelma tuntee shakkisäännöt. 

Peli päättyy joko mattiin, pattiin tai 50 siirron jälkeen. Peli päättyy myös, jos kuningas syö jonkin valkean upseerin niin, että laudalla ei ole enää matin tekoon riittävää materiaalia.

##Käyttäjät
Aloittelevat shakkiharrastajat, jotka osaavat shakkisäännöt.

##Käyttäjän toiminnot
käyttäjä voi valita alasvetovalikosta haluamansa loppupelin, esim. daami + kuningas vastaan kuningas, torni + kuningas vs. kuningas, lähettipari + kuningas vs. kuningas, lähetti, ratsu ja kuningas vastaan kuningas.

Ohjelma arpoo aloitusaseman käyttäjän painettua aloituspainiketta.

Shakkilaudan nappuloita siirretään klikkaamalla ensin nappulan lähtöruutua ja sitten kohderuutua. Käyttäjä pelaa valkeilla nappuloilla ja sovellus siirtää mustaa kuningasta valkean siirron jälkeen.

Jos nappulan yrittää siirtää laittomaan ruutuun, nappula ei siirry lähtöruudustaan. 

Ohjelma ilmoittaa pelin päättymisestä popup-ikkunan viestillä: MATTI, PATTI, SIIRROT TAYNNA tai EI MATTIIN RIITTÄVÄÄ MATERIAALIA.

##Lisätietoja
Ohjelma ei tunne tasapelisääntöä: peli päättyy tasan, jos sama asema on toistunut laudalla kolme kertaa.


#Rakenne
Sovellus koostuu Main-luokasta, joka käynnistää sovelluksen suorituksen, graafisesta käyttöliittymästä, pelinlaudan rakenneosista sekä ohjelmalogiikasta. Sovelluksessa on myös apuluokkia, kuten Sijainti ja Vari.
 
##Käyttöliittymä
Luo graafisen käyttöliittymän fyysiset osaset; laudan ja nappulat.
Saa pääohjelmalta parametrina Logiikka-olion sekä Pelilauta-olion ja välittää niille tiedot laudan tapahtumista.

##Logiikka
Logiikka-luokka vastaa alkuaseman arpomisesta sekä mustan kuninkaan siirroista ja pelitilanteen hallinnasta. 

##Pelilauta
Pelilauta-luokka luo loogisen laudan ruutuineen. Pelilauta koostuu 64 ruudusta, jotka on tallennettu kaksiulotteiseen taulukkoon. Pelilauta tuntee laudalla olevat nappulat.

##Ruutu
Pelilaudan yksittäinen ruutu tietää sijaintinsa, värinsä sekä mahdollisesti sillä sijaitsevan nappulan. Se tietää myös naapuriruutunsa.

##Nappula
Abstrakti yliluokka laudan nappulatyypeille. Nappula tietää arvonsa, sijaintiruutunsa laudalla sekä värinsä.






