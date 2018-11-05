# Alkalmazások fejlesztése nagybeadandó (2018/19 I. félév):
### Névjegy kezelő aplikáció (Bicsák Dániel és Keszthelyi Máté)

-- BCC - Business Card Collector --

#### 1.1. Feladat szöveges leírása:
> A feladat célja, hogy olyan szolgáltatást valósítson meg melyen keresztül a felhasználó böngészheti az adatbázisban található névjegykártyákat, gyűjtheti azokat a profiljához kapcsolódóan, kategória szerint rendezve.
A felhasználók véleményezhetik a névjegykártyákat, és a hozzájuk kapcsolódó szolgáltatást. A felhasználók olvashatják egymás kommentjeit.

#### A BCC működése: 
> Az alkalmazás profiljához kapcsolódóan (egyszerűen névjegyeket managelni, értékelni, és keresni) fontos törekedni az egyszerűségre. Az oldal használata regisztrációhoz kötött, bejelentkezés után lehet a funkcionalitást igénybe venni.
A bejelentkezést követően a user kereshet az adatbázisban található névjegyek közül, vagy kezelheti a saját névjegyeit.
A névjegy megtekintésekor minden esetben (legyen az a felhasználó által tárolt, vagy csak keresés eredményeképpen talált névjegy) lehetőség van értékelni a névjegyet (egy felhasználó egy névjegyet csak egyszer véleményezhet).

#### 1.2. Nem funkcionális követelmények:
	- Használhatósági követelmények:
        Legyen a felhasználó számára ergonomikus a webes frontend oldal
	Legyen az összes oldal 3 kattintáson keresztül elérhető
	
	- Megbízhatósági követelmények:
        A megfelelő jogkörrel rendelkező felhasználók, csak a megfelelő adatokhoz férjenek hozzá/legyenek képesek módosítani
	Az alkalmazás hiba esetén egyértelműen fedje el/kezelje le a problémát
	
	- Teljesítményi követelmények:
        Egy művelet se legyen 1500 ms-nál hosszabb
	Nagyméretű adatbázis esetén (táblánként 50 000 sor) is bírja a terhelést a szolgáltatás

#### 1.3. Funkcionális követelmények:
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

#### 1.4. Felhasználói történetek: 

  - A felhaszáló belép az oldalra a felhasználói nevével, és jelszavával. A jogosultsági köréhez megfelelő menüpontok, és funkciók jelennek meg a megjelenő oldalon.
  - A bejelentkezett felhasználó a "Keresés" menüponton belül rákeres a "vízvezetékszerelő" kategóriájú névjegyre, majd a "Hozzáadás a gyűjteményemhez" gombra kattintva rögzíti a profiljához a névjegyet.
  - A bejelentkezett felhasználó a "Kijelentkezés" gombra kattintva kijelentkezik a böngészőből.
      
#### 1.5. Jogosultsági körök (lentről felfelé tartalmazás - superuser tudja amit az alatta lévő kettő):
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
      
#### 1.6. Szakterületi fogalomjegyzék:
  - Névjegy: olyan információhalmaz, mely egységbezárja egy bizonyos szolgáltatást nyújtó cég/egyéni vállalkozó elérhetőségi adatait
  
  - Névjegyhez tartozó komment: a névjegyhez tartozó szolgáltatással kapcsolatos vélemény, visszajelzés

  - Szolgáltatás: azon tevékenység, melyet egy cég/egyéni vállalkozó nyújt megrendelésre


#### 2.1. Felhasznált technológiák:
	- Verziókezelő: Git
	- Backend keretrendszer: Spring Boot v2.0.5.
	- Building tool: Maven v4.0.0
	- Adatbázis: H2 InMemory database
	
#### 2.2. Fejlesztőkörnyezet: 
		- IntelliJ
		- RESTLET API tesztelő
  
#### 2.3. Adatbázis-terv:
![alt text](https://github.com/Regulus93/alkfejl-1819-1/develop/docs/db/db_diagram.png)

#### 2.4. Alkalmazott könyvtárstruktúra:
	
	A könyvtárstruktúra kialakításakor törekedtünk a kézenfekvő, minél kifejezőbb elnevezésekre, illetve az alkalmazás egyes részeinek csoportosítására.

	src/main/java mappa tartalma:
	
		- controller: Ez a package fogja össze a controllereket, melyek tartalmazzák a REST Endpointokat.
		
		- service: Ebben a mappában találhatóak a service-k, amiket a controllerek hívnak.
		
		- model: A service-k által történő híváskor a dao-k feladata az érintett entitások kezelése, melyeket a repository-k segítségével végeznek.
	
		- repository: Ebben a package-ben lévő interface-k feladata, hogy kiszolgálják a dao-kat azokkal az entitásokkal, melyekkel feladatot szeretnének végezni.
	
		- entity: Az adatbázistáblákra mappelni kívánt entitásokat tartalmazza ez a package.
		
		- enumtype: Azon típusoknak, melyek enum-okat tartalmaznak (jelen pillanatban ez csak a UserRole típust tartalmazza).
		
		- security: Az alkalmazás biztonsági beállításaival kapcsolatos konfigurációs osztályokat tartalmazza.
		
	src/main/resources mappa tartalma:
		
		- ez a mappa tartalmazza az alkalmazás indításakor lefutó "data.sql" import szkriptet, illetve az "application.properties" konfigurációs fájlt
	
#### 2.5. Végpontok:
	- Névjeggyel (BC) kapcsolatos végpontok:
		/BCC
			
			[GET] 	getAllBC
				Leírás: Összes BC lekérdezése
				Bemeneti paraméter: -
				Kimeneti paraméter: ResponseEntity a BC-kkel
				
			[GET] 	getBCById?bcId={bcId}
				Leírás: Adott ID-val rendelkező BC lekérdezése
				Bemeneti paraméter: BC azonosítója
				Kimeneti paraméter: ResponseEntity az adott BC-vel
				
			[GET] 	getFeedbacks/{bcId}
				Leírás: Adott ID-val rendelkező BC összes értékelésének lekérdezése
				Bemeneti paraméter: BC azonosítója
				Kimeneti paraméter: ResponseEntity az értékelésekkel
				
			[POST] 	user/createBC
				Leírás: Új BC létrehozása
				Bemeneti paraméter: BC JSON formátumban
				Kimeneti paraméter: ResponseEntity a létrehozott BC-vel
				
			[PUT] 	user/updateBC
				Leírás: BC frissítése
				Bemeneti paraméter: BC JSON formátumban
				Kimeneti paraméter: ResponseEntity a módosított BC-vel
				
			[DEL] 	user/deleteBC?bcId={bcId}
				Leírás: Adott ID-val rendelkező BC törlése
				Bemeneti paraméter: BC azonosítója
				Kimeneti paraméter: ResponseEntity a törölt BC-vel
				
			[POST] 	collectBC?bcId={bcId}
				Leírás: Adott ID-val rendelkező BC begyűjtése a felhasználó számára
				Bemeneti paraméter: BC azonosítója
				Kimeneti paraméter: ResponseEntity a begyűjtött BC-vel
				
			[POST] 	dropBC?bcId={bcId}
				Leírás: Adott ID-val rendelkező BC eldobása a felhasználótól
				Bemeneti paraméter: BC azonosítója
				Kimeneti paraméter ResponseEntity az eldobott BC-vel
				
			[POST] 	user/addFeedback
				Leírás: Vélemény hozzáadása
				Bemeneti paraméter: Vélemény (feedback) JSON formátumban
				Kimeneti paraméter: BC-hez hozzáfűzött vélemény ResponseEntity-ben
				
			[DEL] 	user/removeFeedback?id={feedbackId}
				Leírás: Feedback törlése
				Bemeneti paraméter: Vélemény azonosítója
				Kimeneti paraméter: törölt 
				
		/users
			
			[POST] register
				Leírás: Új felhasználó regisztrálása
				Bemeneti paraméter: Felhasználó JSON formátumban
				Kimeneti paraméter: ResponseEntity a létrehozott user-rel
			
			[GET] users
				Leírás: Összes DB-ben található felhasználó lekérdezése
				Bemeneti paraméter: -
				Kimeneti paraméter: összes felhasználó ResponseEntity-ben 
			
			[GET] getProfile
				Leírás: A felhasználó saját adatainak lekérdezése
				Bemeneti paraméter: -
				Kimeneti paraméter: User egy ResponseEntity-ben
			
			[PUT] updateProfile
				Leírás: A felhasználó saját adatainak módosítása
				Bemeneti paraméter: User JSON formátumban
				Kimeneti paraméter: módosított felhasználó ResponseEntity-ben
				
			[DEL] deleteUser?id={userId}
				Leírás: Felhasználó törlése
				Bemeneti paraméter: törölni kívánt felhasználó ID-ja
				Kimeneti paraméter: törölt felhasználó ResponseEntity-ben

			[PUT] superuser/changeUserRole
				Leírás: Felhasználói szerepkör módosítása
				Bemeneti paraméter: felhasználónév - szerepkör páros JSON formátumban
				Kimeneti paraméter: módosított felhasználó ResponseEntity-ben
				
Példa a getBCById endpoint működésére:
![alt text](https://github.com/Regulus93/alkfejl-1819-1/develop/docs/endpoints/szekvenciadiagram.png)