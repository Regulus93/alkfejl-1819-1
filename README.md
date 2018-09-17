# Alkalmazások fejlesztése nagybeadandó (2018/19 I. félév):
### Névjegy kezelő aplikáció (Bicsák Dániel és Keszthelyi Máté)

#### 1. Feladat szöveges leírása:
> A feladat célja névjegyek kezelése. Lehetőség van a programban névjegyeket létrehozni, csoportosítani, frissíteni, törölni és keresni. /*TODO: Kiegészíteni*/

#### A névjegy kezelő működése: /*Névjegy kezelő helyett az app neve*/
> Bejelentkezés után láthatja a felhasználó a csoportjait, ezekben az elmentett névjegyeket. Egy-egy névjegyre kattintva frissítheti azt. Megjegyzéseket is fűzhet a névjegyhez, vagy e-mailes értesítést is állíthat be /*A tiédben is volt, gondolom követelmény. Jó így?*/.

#### 2. Funkcionális követelmények:
	- Regisztráció:
        Teljes név, felhasználói név, e-mail és születési dátum megadásával.
	- Bejelentkezés:
        Felhasználói név és jelszó megadásával.
	- Névjegyek keresése:
        A névjegyek szűrése azok attribútumjai alapján.
	- Névjegyek összehasonlítása:
        Két névjegy attribútumjainak megjelenítése egymás mellé két hasábban.
	- Névjegyek kommentelése:
        Kommenteket fűzhet a névjegyhez.
	- Emailes értesítés:
	Értesítést kérhet például születésnap előtt, vagy egyéni időpontban a névjegyről.

#### 3. Felhasználói történetek: /*Ezt a szekciót majd tervezzük meg/találd ki*/

  - Kölcsönzés:
      A felhasználó filmet (filmeket) kiválasztva jelzi a foglalási kérelmét. Erről kap egy megerősítő e-mailt melyben található link 3 óráig érvényes. Amennyiben érvényesíti a foglalását (kifizeti) akkor megkapja a hozzáférést a filmhez e-mailben.
  - Hosszabbítás:
      A felhasználó a rendeléseim menüpont alatt kiválasztja az adott filmet és a hosszabbítani kívánt időtartamot. Ezután megnyomja az aktiválódott "Hosszabbít" gombot. Ezután fizetnie kell.
  - Fizetés:
      Fizetést kezelő oldalra irányít. A formot ki kell tölteni valid információval, ezután kap egy e-mailt a sikerességéről.
      
#### 4. Jogosultsági körök (lentről felfelé tartalmazás - superuser tudja amit az alatta lévő kettő):
  - Superuser:
      - Felhasználók kezelése
  - Adminsztrátor:
      - Filmek kezelése (CRUD műveletekkel)
      - Publikus megjegyzések moderálása
  - Felhasználó:
      - Új privát névjegy létrehozása
      - Névjegy megosztása
      - Névjegy kommentelése
      - Névjegyek összehasonlítása /*Van értelme? Más ötlet?*/
      - Névjegyek keresése
      - Névjegyek csoportosítása
      - Saját névjegyek törlése
      
#### 5. Adatbázis-terv:

![alt text](https://github.com/Regulus93/alkfejl-movierent/blob/master/docs/database_plan.png) /*Majd megcsináljuk*/
