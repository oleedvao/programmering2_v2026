package no.hiof.oleedvao.lecture8;

import no.hiof.oleedvao.lecture8.model.BusDriver;
import no.hiof.oleedvao.lecture8.model.Carpenter;
import no.hiof.oleedvao.lecture8.model.Person;

public class Inheritence {
    public static void main(String[] args) {

        // Opprettelse av et Person-objekt. Dette fungerer som vi er vant til fra før.
        Person ola = new Person("Ola", "Nordmann", 20);
        System.out.println("Person: " + ola.getFirstName() + " " + ola.getLastName());

        /*
        Her oppretter vi et objekt av Carpenter. Merk at konstruktøren her tar verdier for firstName, lastName og
        age, i tillegg til numHousesBuilt.
         */
        Carpenter rudolf = new Carpenter("Rudolf", "Arnesen", 45, 3);
        /*
        Ettersom Carpenter-klassen aver fra Person har tilgang til all funksjonalitet vi vanligvis har
        i Person-objekter og verdiene for instansvariablene arvet fra Person har blitt satt av konstruktøren over.
         */
        System.out.println("Carpenter: " + rudolf.getFirstName() + " " + rudolf.getLastName());
        /*
        I tillegg til funksjonalitet som er arvet har vi selvfølgelig også tilgang til det som er unikt for denne
        klassen, altså det relatert til numHousesBuilt.
         */
        System.out.println("Carpenter has built " + rudolf.getNumHousesBuilt() + " houses.");

        /*
        Vi kan også endre på instansvariabler med settere som vanlig, inkludert de som er arvet.
         */
        rudolf.setLastName("Reinsdyr");
        System.out.println("Carpenter: " + rudolf.getFirstName() + " " + rudolf.getLastName());

        /*
        Arv forholdet går bare en vei. Carpenter arver fra Person og vil dermed også få Person sine egenskaper, men
        Person vil ikke få noen av egenskapene definert sine barne-klasser. Linjen under er derfor ikke gyldig og vil
        føre til en kompileringsfeil.
         */
        //ola.getNumHousesBuilt()

        /*
        Opprettelse av BussDriver-objekter, som også arver fra Person, er noe likt som ved Carpenter (firstName,
        lastName og age), men skiller seg med en unik fjerde paramter, route.
         */
        BusDriver bjarne = new BusDriver("Bjarne", "Bo", 55, "630 - Moss, Halden");
        /*
        Som med Carpenter har vi tilgang til alt et Person-objekt ville hatt, i tillegg til funksjonalitet rundt
        sin unike instansvariabel. Merk også at Carpenter- og BussDriver-objekter har ikke tilgang på hverandres
        unike instansvariabler og Person-objekter har heller ikke tilgang på disse. Arv er en enveisforhold
        hvor egenskaper arves fra foreldreklassen til barneklassen. Foreldreklassen vet ingenting om sine barne-klasser
        og barneklassene vet ingenting om hverandre.
         */
        System.out.println("Buss Driver: " + bjarne.getFirstName() + " " + bjarne.getLastName());
        System.out.println("Buss driver has route " + bjarne.getRoute());

        /*
        Se på hvordan metoden printDescription() er definert i Person. Ettersom både Carpenter og BussDriver arver
        fra Person, får alle barneklasser tilgang til denne metoden og dens funksjonalitet. En av hovedfordelene med å
        benytte arv er at vi kan gjenbruke funksjonalitet. Altså bare definere noe én gang, men gjenbruke det i andre
        klasser. Denne printDescription()-metoden ble definert i etterkant av at Carpenter og BussDriver ble definert
        og at disse arver fra Person. Likevel får begge tilgang til den nye metoden ved at vi definerer denne i
        foreldreklassen. bruk av toString()-metoden i kodeblokken under dette er imidlertid en bedre løsning.
        */
        System.out.println("\n---printDescription() results---");
        ola.printDescription();

        System.out.println();
        rudolf.printDescription();

        System.out.println();
        bjarne.printDescription();


        /*
        (Se også forelesning 9 slides)
        Vi ser her bruk av toString()-metode for de forskjellige objektene. Legg merke ved at vi ikke trenger å kalle
        metoden, men at Java automatisk antar at vi ønsker å benytte toString når vi skriver ut et objekt.
        Dette ...
            System.out.println(person);

        ... er altså en smidigere måte å skrive dette:

            System.out.println(person.toString())

        Merk at utskriftene nå vil være tilpasset de forskjellige objekttypene fordi vi har overridet toString() unikt
        for hver av dem.
         */
        System.out.println("\n--- toString() results---");
        System.out.println("-Person object-");
        System.out.println(ola); // Gir det samme som System.out.println(ola.toString());

        System.out.println("\n-Carpenter object-");
        System.out.println(rudolf);

        System.out.println("\nBusDriver object-");
        System.out.println(bjarne);

    }
}
