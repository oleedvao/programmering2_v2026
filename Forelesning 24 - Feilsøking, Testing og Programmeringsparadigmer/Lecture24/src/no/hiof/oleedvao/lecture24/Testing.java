package no.hiof.oleedvao.lecture24;

public class Testing {

    public static void main(String[] args) {
        roomTemperatureSensorTest();
    }

    /*
    Dette er en dedikert metode for å teste RoomTemperatureSensor. Testene er enkelt basert på å kjøre den relevante
    funksjonaliteten, her metoden .getStatus(), med forskjellige input-verdier sammenlignet med et forventede
    resultater. Hvis verdiene er like vet vi at scenariet, definert av input-verdien, håndteres riktig. Hvis verdiene er
    forskjellige indikerer dette at håndteringen er feil og må fikses.

    Merk også at tester typisk er enda mer utdypende enn eksemplet under. Andre verdier som kunne vært fornuftig å teste
    er
    - 24 - Grenseverdi mellom "Normal" og "Hot"
    - 34 og 35 - Grenseverdi mellom "Hot" og "Danger"
    - Et negativt tall - Logikken burde gi "Normal", men er dette egentlig fornuftig?
     */
    public static void roomTemperatureSensorTest() {

        System.out.println("Temp is 20 and result is 'Normal': " +
                RoomTemperatureSensor.getStatus(20).equals("Normal"));
        System.out.println("Temp is 30 and result is 'Hot': " +
                RoomTemperatureSensor.getStatus(30).equals("Hot"));
        System.out.println("Temp is 40 and result is 'Danger': " +
                RoomTemperatureSensor.getStatus(40).equals("Danger"));
        System.out.println("Temp is 25 and result is 'Hot': " +
                RoomTemperatureSensor.getStatus(25).equals("Hot"));

    }
}
