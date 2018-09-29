# Alkalmazások fejlesztése nagybeadandó (2018/19 I. félév):
### Névjegy kezelő aplikáció (Bicsák Dániel és Keszthelyi Máté)

-- BCC - Business Card Collector --

#### 1. Feladat szöveges leírása:
> A feladat célja, hogy olyan szolgáltatást valósítson meg melyen keresztül a felhasználó böngészheti az adatbázisban található névjegykártyákat, gyűjtheti azokat a profiljához kapcsolódóan, kategória szerint rendezve.
A felhasználók véleményezhetik a névjegykártyákat, és a hozzájuk kapcsolódó szolgáltatást. A felhasználók olvashatják egymás kommentjeit.

#### A BCC működése: 
> Az alkalmazás profiljához kapcsolódóan (egyszerűen névjegyeket managelni, értékelni, és keresni) fontos törekedni az egyszerűségre. Az oldal használata regisztrációhoz kötött, bejelentkezés után lehet a funkcionalitást igénybe venni.
A bejelentkezést követően a user kereshet az adatbázisban található névjegyek közül, vagy kezelheti a saját névjegyeit.
A névjegy megtekintésekor minden esetben (legyen az a felhasználó által tárolt, vagy csak keresés eredményeképpen talált névjegy) lehetőség van értékelni a névjegyet (egy felhasználó egy névjegyet csak egyszer véleményezhet).

#### 2. Nem funkcionális követelmények:
	- Használhatósági követelmények:
        Legyen a felhasználó számára ergonomikus a webes frontend oldal
	Legyen az összes oldal 3 kattintáson keresztül elérhető
	
	- Megbízhatósági követelmények:
        A megfelelő jogkörrel rendelkező felhasználók, csak a megfelelő adatokhoz férjenek hozzá/legyenek képesek módosítani
	Az alkalmazás hiba esetén egyértelműen fedje el/kezelje le a problémát
	
	- Teljesítményi követelmények:
        Egy művelet se legyen 1500 ms-nál hosszabb
	Nagyméretű adatbázis esetén (táblánként 50 000 sor) is bírja a terhelést a szolgáltatás

#### 3. Funkcionális követelmények:
	- Regisztráció:
        Teljes név, felhasználói név, e-mail és születési dátum megadásával.
	- Bejelentkezés:
        Felhasználói név és jelszó megadásával.
	- Névjegyek keresése:
        A névjegyek szűrése azok attribútumjai alapján.
	- Névjegyek kommentelése:
        Kommenteket fűzhet a névjegyhez.
	- Névjegyek értékelése:
		Egy 5ös skálán értékelheti a felhasználó az adott névjegyet.
	- Profilhoz névjegykártyák hozzáadása/eltávolítása:
		Lehetőség a névjegykártyák managelésére profil szinten

#### 4. Felhasználói történetek: 

  - A felhaszáló belép az oldalra a felhasználói nevével, és jelszavával. A jogosultsági köréhez megfelelő menüpontok, és funkciók jelennek meg a megjelenő oldalon.
  - A bejelentkezett felhasználó a "Keresés" menüponton belül rákeres a "vízvezetékszerelő" kategóriájú névjegyre, majd a "Hozzáadás a gyűjteményemhez" gombra kattintva rögzíti a profiljához a névjegyet.
  - A bejelentkezett felhasználó a "Kijelentkezés" gombra kattintva kijelentkezik a böngészőből.
      
#### 5. Jogosultsági körök (lentről felfelé tartalmazás - superuser tudja amit az alatta lévő kettő):
  - Superuser:
      - Felhasználók kezelése
  - Adminsztrátor:
      - Névjegyek kezelése (CRUD műveletekkel)
      - Névjegyekhez tartozó kommentek moderálása
  - Felhasználó:
      - Új privát névjegy létrehozása
      - Névjegyek profilszintű kezelése
      - Névjegy kommentelése
      - Névjegyek keresése
      - Névjegyek kategorizálása
      - Saját névjegyek törlése
      
#### 6. Szakterületi fogalomjegyzék:
  - Névjegy: olyan információhalmaz, mely egységbezárja egy bizonyos szolgáltatást nyújtó cég/egyéni vállalkozó elérhetőségi adatait
  
  - Névjegyhez tartozó komment: a névjegyhez tartozó szolgáltatással kapcsolatos vélemény, visszajelzés

  - Szolgáltatás: azon tevékenység, melyet egy cég/egyéni vállalkozó nyújt megrendelésre

#### 7. Adatbázis-terv:
