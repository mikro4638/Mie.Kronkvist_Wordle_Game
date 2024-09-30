Wordle AI
Dette prosjektet er en implementering av en AI for Wordle-spillet skrevet i Java. Wordle er et populært ordspill der spilleren skal gjette et skjult ord ved hjelp av tilbakemeldinger på tidligere gjetninger. Målet med dette prosjektet er å utvikle en effektiv AI som kan spille Wordle og minimere antall gjetninger for å finne det riktige ordet.

Om prosjektet
Dette Wordle-prosjektet ble utviklet som en del av INF102 høst 2024 for å demonstrere min forståelse av algoritmer, Java-programmering, og datastrukturer. Spesielt fokuserer det på å optimalisere AI-en til å finne svaret med færrest mulig gjetninger. Prosjektet inkluderer flere strategier som er implementert og testet mot hverandre for å vurdere ytelse og effektivitet.

Arkitektur
Prosjektet er strukturert i flere klasser og følger prinsipper for god programvareutvikling, som å skille spilllogikken fra brukerinput og resultatmålinger.

Hovedkomponenter:
FrequencyStrategy: Bruker frekvensanalyse av bokstaver i gjenværende ord for å gjøre informerte gjetninger.
EliminateStrategy: Eliminerer ord fra listen over mulige løsninger basert på tilbakemeldinger fra tidligere gjetninger.
MyStrategy: En AI jeg har utviklet, som forbedrer de tidligere strategiene og minimerer antall gjetninger gjennom en optimaliseringsalgoritme.
Ytelse
AI-ens ytelse måles ved hjelp av AIPerformance-verktøyet, som tester antall gjetninger og suksessraten for hver strategi over et sett med 200 spill. Min personlige AI-strategi, MyStrategy, oppnådde en gjennomsnittlig gjetning på 3,550 med 200/200 seire, og en maksimal gjetning på 6 i det verste tilfellet.

Komme i gang
For å kjøre prosjektet, må du ha Java installert på din maskin. Det anbefales å bruke versjon 11 eller nyere.

Klon prosjektet fra repositoriet, naviger til prosjektmappen, og kjør følgende kommandoer for å bygge og kjøre AI-testene:

bash
Kopier kode
mvn clean install
mvn exec:java -Dexec.mainClass="your.package.name.WordleMain"
Fremtidige forbedringer
Det er fremdeles rom for ytterligere optimalisering av AI-strategien, spesielt ved å redusere antall gjetninger i komplekse spill. Mulige fremtidige forbedringer inkluderer bruk av mer avanserte datastrukturer som HashMaps og bitmanipulasjon for å akselerere prosesseringshastigheten.
For Task 4 it is possible to introduce concepts beyond what is expected from INF102.
For students who get sucked in by the problem and do more than what we expect we can award up to 2 bonus points. So in theory it is possible to get 17/15 points on this assignment.

NB: Be sure to have polished all tasks before attempting to get the bonus points.
