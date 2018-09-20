# Alkalmazások fejlesztése nagybeadandó (2018/19 I. félév):
### Névjegy kezelő aplikáció (Bicsák Dániel és Keszthelyi Máté)

#### 1. Feladat szöveges leírása:
> A feladat célja, hogy olyan szolgáltatást valósítson meg melyen keresztül a felhasználó böngészhet (vagy akár gyűjthet a profiljához kapcsolódóan) mindenféle kategóriájú cég/egyéni vállalkozó névjegykártyáját. A felhasználók más felhasználók kommentjeit olvashatják a névjegykártyához tartozó értékeléseket/kommenteket.

#### A névjegy kezelő működése: /*Névjegy kezelő helyett az app neve*/
> Az alkalmazás profiljához kapcsolódóan (egyszerűen névjegyeket managelni, értékelni, és keresni) fontos törekedni az egyszerűségre. Az oldal használata regisztrációhoz kötött, bejelentkezés után lehet a funkcionalitást igénybe venni.
A bejelentkezést követően a user kereshet az adatbázisban található névjegyek közül, vagy kezelheti a saját névjegyeit.
A névjegy megtekintésekor minden esetben (legyen az a felhasználó által tárolt, vagy csak keresés eredményeképpen talált névjegy) lehetőség van értékelni a névjegyet (egy felhasználó egy névjegyet csak egyszer véleményezhet).

#### 2. Nem funkcionális követelmények:
	-topic:
	description
	-topic:
	description

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

#### 4. Felhasználói történetek: /*Ezt a szekciót majd tervezzük meg/találd ki*/

  - Keresés:
      A felhasználó névjegyeket kereshet szűrők, kulcsszavak beállításával.
  - Saját névjegyek kezelése:
      A felhasználó a saját elmentett névjegyeit törölheti, frissítheti.
  - Értékelés:
      A publikus névjegyek értékelhetők, 5-ös skálán értékelheti egy felhasználó a névjegyet.
      
#### 5. Jogosultsági körök (lentről felfelé tartalmazás - superuser tudja amit az alatta lévő kettő):
  - Superuser:
      - Felhasználók kezelése
	  - Adatbázisban lévő névjegyek kezelése
  - Adminsztrátor:
      - Filmek kezelése (CRUD műveletekkel)
      - Publikus megjegyzések moderálása
  - Felhasználó:
      - Új privát névjegy létrehozása
      - Névjegy kezelése
      - Névjegy kommentelése
      - Névjegyek keresése
      - Névjegyek csoportosítása
      - Saját névjegyek törlése
      
#### 6. Adatbázis-terv:

![alt text](https://github.com/Regulus93/alkfejl-movierent/blob/master/docs/database_plan.png) /*Majd megcsináljuk*/
