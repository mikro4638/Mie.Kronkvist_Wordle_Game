Wordle AI
Dette prosjektet er en implementering av en AI for Wordle-spillet, skrevet i Java. Wordle er et ordspill der målet er å gjette et skjult ord basert på tilbakemeldinger fra tidligere gjetninger. AI-en er designet for å minimere antall gjetninger ved å optimalisere valg av ord og tilpasse strategien basert på feedback fra spillet.

Om prosjektet
Dette prosjektet ble utviklet som en del av INF102 høst 2024 for å demonstrere min forståelse av Java-programmering, algoritmer og datastrukturer. AI-en er bygget med mål om å spille Wordle effektivt, ved å bruke ulike strategier for å redusere antall gjetninger til et minimum.

Arkitektur
Prosjektet følger et enkelt, modulært design, med fokus på å skille spilllogikken fra brukerinput og resultatmålinger. Det er implementert flere strategier for å finne ordet, hver med sitt unike sett av metoder og optimaliseringer.

FrequencyStrategy: Bruker frekvensanalyse av bokstaver for å gjøre informerte gjetninger basert på hvilke bokstaver som oftest forekommer i de gjenstående mulige ordene.
EliminateStrategy: Eliminerer ord som ikke kan være løsningen basert på tidligere tilbakemeldinger, for deretter å snevre inn søket etter det riktige ordet.
MyStrategy: Min egen strategi, som bygger videre på frekvensanalyse og eliminasjonsmetoder for å ytterligere redusere antall gjetninger og forbedre AI-ens ytelse.
Hovedklasser
WordleAIController: Styrer interaksjonen mellom AI-strategiene og spillets tilbakemeldinger.
FrequencyStrategy: Implementerer frekvensbaserte gjetninger.
EliminateStrategy: Implementerer eliminasjonsbaserte gjetninger.
MyStrategy: Min egen optimaliserte AI-strategi.
Ytelse
Ytelsen til AI-strategiene måles ved hjelp av AIPerformance-verktøyet, som tester hvor mange gjetninger AI-en trenger i gjennomsnitt for å vinne. Min AI, MyStrategy, oppnådde 3,550 gjennomsnittlige gjetninger med 200/200 seire, og en maksimal gjetning på 6 i det verste tilfellet.

Komme i gang
For å kjøre prosjektet må du ha Java installert (anbefalt versjon 11 eller nyere). Følg disse stegene for å bygge og kjøre prosjektet:

Klon prosjektet fra repositoriet.
Naviger til prosjektmappen.
Kjør følgende kommandoer for å bygge og starte AI-en:
bash
Kopier kode
mvn clean install
mvn exec:java -Dexec.mainClass="your.package.name.WordleMain"
Fremtidige forbedringer
Det er fremdeles rom for optimalisering. Videre arbeid kan inkludere mer avanserte datastrukturer som HashMaps, eller teknikker som bitmanipulasjon for å forbedre hastighet og effektivitet.
For students who get sucked in by the problem and do more than what we expect we can award up to 2 bonus points. So in theory it is possible to get 17/15 points on this assignment.

NB: Be sure to have polished all tasks before attempting to get the bonus points.
