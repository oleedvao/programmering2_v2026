package no.hiof.oleedvao.lecture9;

import no.hiof.oleedvao.lecture9.model.BusDriver;
import no.hiof.oleedvao.lecture9.model.Carpenter;
import no.hiof.oleedvao.lecture9.model.CarpenterApprentice;
import no.hiof.oleedvao.lecture9.model.Person;

import java.time.LocalDate;

public class Inheritence {
    public static void main(String[] args) {

        Person ola = new Person("Ola", "Nordmann", 20);
        System.out.println("Person: " + ola.getFirstName() + " " + ola.getLastName());

        Carpenter rudolf = new Carpenter("Rudolf", "Arnesen", 45, 3);
        System.out.println("Carpenter: " + rudolf.getFirstName() + " " + rudolf.getLastName());
        System.out.println("Carpenter has built " + rudolf.getNumHousesBuilt() + " houses.");

        rudolf.setLastName("Reinsdyr");
        System.out.println("Carpenter: " + rudolf.getFirstName() + " " + rudolf.getLastName());

        BusDriver bjarne = new BusDriver("Bjarne", "Bo", 55, "630 - Moss, Halden");
        System.out.println("Buss Driver: " + bjarne.getFirstName() + " " + bjarne.getLastName());
        System.out.println("Buss driver has route " + bjarne.getRoute());

        /*
        Vi oppretter her et par LocalDate-objekter. Disse opprettese på en litt spesiell måte ved å benytte metoder
        gjennom klassen:

            ... = LocalDate.<metode>

        Ikke tenk på mye på hvordan dette funker for nå. Vi går gjennom konseptene dette er basert på i en senere
        forelesning, men legg merke ved at vi kan opprette objekter av disse som under
         */
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.of(2027, 6, 15);

        /*
        Vi oppretter her et objekt av CarpenterApprentice som er en barneklasse av Carpenter. Vi kan da se at dette
        objektet arver alle egenskaper fra både Carpenter (direkte foreldreklasse), men også Person (foreldreklassen sin
        foreldreklasse.
         */
        CarpenterApprentice jon = new CarpenterApprentice(
                "Jon",
                "Då",
                21,
                0,
                startDate,
                endDate
        );
        System.out.println("Carpenter apprentice: " + jon.getFirstName() + " " +
                jon.getLastName());
        System.out.println("Carpenter apprentice num houses built: " + jon.getNumHousesBuilt());
        System.out.println("Carpenter apprentice training period: " +
                jon.getTrainingStartDate() + " - " + jon.getTrainingEndDate());

        /*
        System.out.println("\n---printDescription() results---");
        ola.printDescription();

        System.out.println();
        rudolf.printDescription();

        System.out.println();
        bjarne.printDescription();

        System.out.println();
        jon.printDescription();
         */


        /*
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
        System.out.println(ola); // Gir det akkurat samme som System.out.println(ola.toString());

        System.out.println("\n-Carpenter object-");
        System.out.println(rudolf);

        System.out.println("\n-BusDriver object-");
        System.out.println(bjarne);

        System.out.println("\n-CarpenterApprentice object-");
        System.out.println(jon);



    }
}
