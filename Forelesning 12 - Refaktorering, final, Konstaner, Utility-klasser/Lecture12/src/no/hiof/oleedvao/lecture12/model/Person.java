package no.hiof.oleedvao.lecture12.model;

public class Person {
    protected String firstName;
    protected String lastName;
    protected int age;
    private final String birthNumber;

    /*
    Variabelen under er satt til final. Dette vil definere at variabelens verdi bare skal settes én gang.
    Dette vil også bli kontrollert av Java, både at vi ikke setter inn noen ny verdi og at den blir initialisert.
    Fordelen med å gjøre dette overfor å bare restrihere variabelens tilgang via gettere og settere er at vi da
    helt tydelig gir beskjed til Java og eventuelle andre programmerere om at denne variabelen ikke skal modifiseres.
    */
    private static int numPersons = 0;

    /*
    Hvis vi har en final variabel må disse enten initialiseres direkte ved deklarasjon, eller bli satt i samtlige
    av tilgjengelige konstruktører, enten via parameter eller som en del av kodekroppen.
    */
    public Person(String birthNumber) {
        this.birthNumber = birthNumber;
    }

    /*
    Hvis vi har en final variabel må disse enten initialiseres direkte ved deklarasjon, eller bli satt i samtlige
    av tilgjengelige konstruktører, enten via parameter eller som en del av kodekroppen.
    */
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        /*
        Her settes fødselsnummeret til en standardverdi. Dette er i bunn å grunn en dårlig håndtering fordi verdien
        for et fødselsnummer burde settes unikt for hver person. En god øvelse kan være å i stedet endre parameterene
        i denne konstruktøren og fikse opp i alle de problemene som oppstår i andre klasser (barneklasser som er
        avhengig av konstruktøren og tilfeller hvor konstrukøren er blitt benyttet for å opprette objekter).
        Likevel illustrer dette at vi også kan sette en final variabel til en standardverdi, dersom vi ønsker, så lenge
        verdien blir satt i alle konstruktører.
         */
        birthNumber = "10987654321";

        numPersons++;
    }

    /*
    Vi kan fint hente ut verdien for en final instansvariabel via gettere ...
     */
    public String getBirthNumber() {
        return birthNumber;
    }
    /*
    ... men vi kan ikke opprette eller benytte settere på final variabler ettersom Java ikke tillater at vi oppdaterer
    en final-variablers verdier etter de er blitt satt.

    public void setBirthNumber(String birthNumber) {
        this.birthNumber = birthNumber;
    }
     */

    public static int getNumPersons() {
        return numPersons;
    }

    public void compareAgeTo(Person otherPerson) {
        if (this.age > otherPerson.age) {
            System.out.println(this.firstName + " " + this.lastName + " is older");
        }
        else if (this.age < otherPerson.age) {
            System.out.println(otherPerson.firstName + " " + otherPerson.lastName +
                    " is older");
        }
        else {
            System.out.println("The persons are the same age");
        }
    }

    @Override
    public String toString() {
        return "First name: " + firstName +
                "\nLast name: " + lastName +
                "\nAge: " + age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
