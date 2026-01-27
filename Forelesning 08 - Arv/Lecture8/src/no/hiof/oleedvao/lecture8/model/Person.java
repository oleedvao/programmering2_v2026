package no.hiof.oleedvao.lecture8.model;

/*
Klassen Person er hovedsakelig definert likt som vi har gjort i tidligere forelesninger, med private instansvariabler,
gettere og settere og en konstruktør.

(Se også forelesning 9 slides) Merk også at alle klasser underforstått arver fra en predifinert klasse kalt Object.
Altså er klassedefinisjonen under i praksis det samme som
    public class Person extends Object {...}
Dette medfører at alle klasser arver en del egenskaper, slik som blant annet toString()-metoden.
 */
public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

   /*
  (Se også forelesning 9 slides)
   Overriding er å omdefinere en arvet metode slik at den kan tilpasses den aktuelle klassen.
   Dette kan vi gjøre ved å definere den arvede metoden på nytt med samme datatype og navn. Vi kan også benytte
   @Override for å kontrollere at metoden overrides på riktig måte.

   Her overrider vi metoden toString(), som tilhører og er arvet fra Object-klassen. Alle klasser i Java arver
   underforstått fra denne Object-klassen.

   toString() benyttes til å få en tekstlig representasjon av et objekt, så når vi overrider toString() i en klasse
   kan vi konseptuelt si at vi tilpasser hvordan objekter av denne klassen skal bli representert i tekstlig format.
   Under benytter vi dette til å definere en generell beskrivelse av en "person".
   Merk også at alle Barneklasser av Person vil arve denne implementasjonen som utgangspunkt, med mindre de igjen
   overrider den.
   */
    @Override
    public String toString() {
        return "First name: " + firstName +
                "\nLast name: " + lastName +
                "\nAge: " + age;
    }

    /*
    Hvis vi ønsker å definere en ny metode for Person, vil denne også bli tilgjengelig for alle barneklasser.
    Her gjør vi dette ved å definere en metode som skriver ut en beskrivelse basert på egenskapene til Person.
    Dette er imidlertid litt unødvendig ettersom at toString() eksisterer, men er inkludert for å illustrere poenget.
    */
    public void printDescription() {
        System.out.println(
                "First name: " + firstName +
                "\nLast name: " + lastName +
                "\nAge: " + age
        );
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
