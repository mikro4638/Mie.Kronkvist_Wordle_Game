# Wordle AI

Dette prosjektet er en implementering av en AI for Wordle-spillet, skrevet i Java. Wordle er et ordspill hvor spilleren må gjette et skjult ord basert på tilbakemeldinger fra tidligere gjetninger. AI-en er designet for å optimalisere valg av ord og minimere antall gjetninger for å finne riktig ord.

## Om prosjektet

Dette Wordle AI-prosjektet er utviklet som en oppgave i INF102 høst 2024 for å demonstrere min forståelse av Java-programmering, algoritmer og datastrukturer. AI-en bruker flere ulike strategier for å effektivt gjette det riktige ordet i færrest mulig gjetninger.

### Arkitektur

Prosjektet er strukturert i flere moduler som hver representerer en unik strategi for å gjette ordet:

- **FrequencyStrategy**: Bruker frekvensanalyse av bokstaver for å gjøre informerte gjetninger basert på hvilke bokstaver som forekommer oftest i de gjenstående ordene.
- **EliminateStrategy**: Fjerner ord som ikke kan være løsningen basert på tilbakemeldinger fra tidligere gjetninger, og snevrer dermed inn søket etter riktig ord.
- **MyStrategy**: Min egen strategi som bygger på frekvensanalyse og eliminasjon for å ytterligere forbedre ytelsen og redusere antall gjetninger.

### Hovedklasser

- **WordleAIController**: Håndterer interaksjonen mellom strategiene og spillet.
- **FrequencyStrategy**: Implementerer en frekvensbasert strategi.
- **EliminateStrategy**: Implementerer en eliminasjonsbasert strategi.
- **MyStrategy**: Min optimaliserte AI-strategi, designet for å minimere antall gjetninger.

## Komme i gang

For å kjøre prosjektet trenger du å ha Java (anbefalt versjon 11 eller nyere) installert på datamaskinen. Du kan også bruke Maven for å bygge og kjøre prosjektet.

1. Klon prosjektet og naviger til prosjektmappen.
2. Kjør følgende kommandoer for å bygge og starte prosjektet:

# Wordle AI

Dette prosjektet er en implementering av en AI for Wordle-spillet, skrevet i Java. Wordle er et ordspill hvor spilleren må gjette et skjult ord basert på tilbakemeldinger fra tidligere gjetninger. AI-en er designet for å optimalisere valg av ord og minimere antall gjetninger for å finne riktig ord.

## Om prosjektet

Dette Wordle AI-prosjektet er utviklet som en oppgave i INF102 høst 2024 for å demonstrere min forståelse av Java-programmering, algoritmer og datastrukturer. AI-en bruker flere ulike strategier for å effektivt gjette det riktige ordet i færrest mulig gjetninger.

### Arkitektur

Prosjektet er strukturert i flere moduler som hver representerer en unik strategi for å gjette ordet:

- **FrequencyStrategy**: Bruker frekvensanalyse av bokstaver for å gjøre informerte gjetninger basert på hvilke bokstaver som forekommer oftest i de gjenstående ordene.
- **EliminateStrategy**: Fjerner ord som ikke kan være løsningen basert på tilbakemeldinger fra tidligere gjetninger, og snevrer dermed inn søket etter riktig ord.
- **MyStrategy**: Min egen strategi som bygger på frekvensanalyse og eliminasjon for å ytterligere forbedre ytelsen og redusere antall gjetninger.

### Hovedklasser

- **WordleAIController**: Håndterer interaksjonen mellom strategiene og spillet.
- **FrequencyStrategy**: Implementerer en frekvensbasert strategi.
- **EliminateStrategy**: Implementerer en eliminasjonsbasert strategi.
- **MyStrategy**: Min optimaliserte AI-strategi, designet for å minimere antall gjetninger.

## Komme i gang

For å kjøre prosjektet trenger du å ha Java (anbefalt versjon 11 eller nyere) installert på datamaskinen. Du kan også bruke Maven for å bygge og kjøre prosjektet.

1. Klon prosjektet og naviger til prosjektmappen.
2. Kjør følgende kommandoer for å bygge og starte prosjektet:

