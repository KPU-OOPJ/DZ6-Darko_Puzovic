**Kreirati aplikaciju koji će imati korisnički interfejs kao što je dato na slici i sledeću funkcionalnost:**

-	Javnu klasu Regija koja može da bude serijalizovana i ima:
-	Privatni atribut naziv.
-	Privatni atribut natalitet koji predstavlja ukupan broj novorođene dece od prethodnog popisa.
-	Privatni atribut mortalitet koji predstavlja ukupan broj umrlih ljudi od prethodnog popisa.
-	Privatni atribut migracioniSaldo koji predstavlja promenu broja stanovnika zbog migracija (odseljavanje, doseljavanje, u pitanju je ceo broj).
-	Odgovarajuće javne get i set metode za ove atribute. Nedozvoljene vrednosti za atribut naziv su null i svi Stringovi koji imaju manje od dva slova, natalitet i mortalitet moraju biti veći od nule. U slučaju unosa nedozvoljenih vrednosti, baciti izuzetak klase DemografijaException sa odg. porukom.
-	Redefinisanu toString metodu klase Object koja vraća String sa svim podacima o opštini uz odgovarajuću poruku, ali je potrebno u String ubaciti i podatak o promeni broja stanovnika koji se izračunava po formuli PROMENA = NATALITET – MORTALITET + MIGRACIONI SALDO.Pritiskom na dugme Dodaj se obavlja akcija dodavanje elemenata u listu,
-	Javnu klasu DemografijaException kao neproveravani izuzetak (nasl.RuntimeException) koja ima javni konstruktor koji kao parametar prima poruku greške i poziva odgovarajući konstruktor nadklase prosleđujući mu parametar.
-	Klasa RegijeGUI bi trebalo da sadrži privatni atribut regioni koji predstavlja listu objekata klase Region. Odmah inicijalizovati listu.
-	Kada se pritisne dugme “Obriši”, briše se sadržaj svih polja za unos i editora za tekst.
-	Kada se pritisne dugme “Sačuvaj”, svi podaci o regijama iz liste se upisuju (serijalizuju) u dva fajla: “rastuće_regije.txt” i “umiruće_regije.txt” i to u zavisnosti od promene broja stanovnika koja se izračunava po formuli PROMENA = NATALITET – MORTALITET + MIGRACIONI SALDO. One regije gde je promena broja stanovnika veća od nule treba serijalizovati u prvi fajl, a ostale u drugi.
-	Kada se pritisne dugme “Dodaj”, preuzimaju se podaci o regiji iz polja za unos, i nova regija se unosi u listu. Unošenje se vrši samo ako u listi već ne postoji ista regija i to tako da se sačuva opadajući poredak liste prema natalitetu. Ako u listi već postoji ista regija, ili ako je nastao neki izuzetak u toku unosa podataka ili prevaranja u odgovarajući tip itd., potrebno je u editoru ispisati reč “GREŠKA”.

![5](https://scontent.fbeg6-1.fna.fbcdn.net/v/t1.15752-9/96627692_988097178274547_5496882514754535424_n.png?_nc_cat=110&_nc_sid=b96e70&_nc_eui2=AeEz3DUnAXu7joT-6hJ1gZK3x_Ctbi7Z-8XH8K1uLtn7xcE3WXJDEM7W1Podp4oEfg0&_nc_ohc=ZVCOy-9OlzcAX-3tzCZ&_nc_ht=scontent.fbeg6-1.fna&oh=2b5fd468eb14e88d20e1b0f7309fbdbf&oe=5EDCBCDB)
