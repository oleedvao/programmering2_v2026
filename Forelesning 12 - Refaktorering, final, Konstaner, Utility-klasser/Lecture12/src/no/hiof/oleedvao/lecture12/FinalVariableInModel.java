package no.hiof.oleedvao.lecture12;

import no.hiof.oleedvao.lecture12.model.Person;

public class FinalVariableInModel {
    public static void main(String[] args) {
        System.out.println("---final instance variable---");
        /*
        Vi ser at uansett hvordan vi oppretter ett objekt av Person-klassen, må i initialisere birthNumber ettersom
        dette er påkrevd av java. Altså at birthNumber må bli satt som en del av alle alternative konstruktører som
        klassen har. Det samme vil i effekt gjelde for eventuelle barneklasser som må benytte foreldreklassens
        konstruktør.

        Vi ser også at vi bare kan hente verdien for final variabelen, da java ikke tillater at vi setter en ny verdi
        for slike variabler og dermed ikke har lov til å opprette noen setter.
         */
        Person person = new Person("12345678910");
        System.out.println("Birth number (set with parameter): " + person.getBirthNumber());

        Person person2 = new Person("Ola", "Nordmann", 5);
        System.out.println("Birth number 2 (standard value in constructor): " + person2.getBirthNumber());
    }
}
