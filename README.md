# DiningPhilosophers

## Problem filozofa

Petero filozofa u tišini sjedi za okruglim stolom. 
Ispred svakog filozofa nalazi se njegov tanjur sa špagetima. 
Po jedna vilica smještena je između svaka dva susjedna filozofa.
Svaki filozof neko vrijeme razmišlja, pa zatim neko vrijeme jede. 
Filozof može početi jesti jedino ako su mu dostupne obje vilice kraj tanjura.
Kada je gotov, filozof spušta obje vilice natrag na stol (svaku s jedne strane svog tanjura) i tada one postaju dostupne drugim filozofima koji žele početi jesti.

Zanima nas kako osmisliti proces (algoritam) jedenja i razmišljanja takav da niti jedan filozof ne ostane vječno gladan – dakle takav da filozofi u teoriji vječno alterniraju između jedenja i razmišljanja. 
Pretpostavljamo neograničene količine špageta na stolu, te da filozofi ne znaju međusobno kada je tko gladan, a kada želi razmišljati. 


## Opis rješenja problema za paralelni sustav

Problem filozofa koji ručaju predstavlja poopćenje problema međusobnog isključivanja. 

Osim što imamo više procesa odnosno dretvi, također imamo i više dijeljenih resursa. 
Jedan proces (dretva) u svojoj kritičnoj sekciji koristi samo neke od resursa. 
Jedan resurs potreban je samo nekim procesima (dretvama). 
Više procesa (dretvi) smije istovremeno izvoditi svoje kritične sekcije ako nisu u konfliktu u pogledu korištenja resursa. 

Filozofi sjedaju za stol i počinju razmišljati. 
Kada je filozof gladan, pokuša uzeti lijevu vilicu. 

Ako lijeva vilica nije slobodna filozof se vraća natrag razmišljanju.
Ako je dostupna uzima ju i pokušava uzeti desnu vilicu. 

Ako desna vilica nije dostupna filozof spušta natrag lijevu vilicu na stol i vraća se razmišljanju.
Ako je desna vilica dostupna, filozof ju podiže i kreće jesti. 
Kada je gotov spušta desnu pa lijevu vilicu.

Filozofe poistovjećujemo s dretvama.
Vilice poistovjećujemo s resursima koje dretve koriste.

Funkcije: 

Razmišljaj – dretva spava neko nasumično vrijeme

Jedi – dretva spava neko nasumično vrijeme	

Pokupi vilicu –  pokušavaj zaključati resurs određeno vrijeme

Spusti vilicu – otključaj resurs	

Očito je algoritam implementacija jednog paralelnog sustava obzirom da dretve međusobno ne komuniciraju preko komunikacijske mreže nego preko zajedničke memorije (radimo sa poljem dretvi i poljem resursa). 

Do deadlocka ne dolazi jer filozofi spuštaju lijevu vilicu natrag na stol ako u određenom vremenu ne dobiju pristup desnoj vilici i zato jer su vremena jedenja i razmišljanja nasumična.

