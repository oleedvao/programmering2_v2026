package no.hiof.oleedvao.lecture24;

/*
Vi demonstrerer her teknikken rekursjon. Rekursjon er en kodeteknikk som kan oppnå iterativ funksjonalitet uten bruk av
løkker. Spesifikt handler rekursjon om at vi skriver metoder som internt kaller seg selv Dette er typisk benyttet i
funksjonell programmering, men kan også benyttes i algoritme-programmering for elegante løsninger. Dere vil trolig lære
mer om dette i kurset Algoritmer og Datastrukturer.
 */
public class Recursion {

    public static void main(String[] args) {

        int[] numbers = {1,3,3,7};

        printRecursively(numbers, 0);

        System.out.println("\nSum: " + sumRecursively(numbers, 0));

    }

    /*
    Rekursiv metode for å summere alle tallene i en array. Merk at vi også tar et tall for å representere indexen vi
    skal summere fra som parameter. Dette er viktig for den rekursive funksjonaliteten.
     */
    public static int sumRecursively(int[] numbers, int index) {

        /*
        Vi definerrer her sluttbetingelsen for den iterative logikken, samt en generell kontroll for at indexen er
        gyldig.
         */
        if (index < 0 || index >= numbers.length) {
            return 0;
        }

        int number = numbers[index];

        /*
        Vi summerer her sammen tallet på den nåværende indexen med summen av resten av arrayen (oppnådd ved å kalle
        metoden på nytt internt men med neste index som utgangspunkt - index+1).
        Dette vil medføre at samme metode-logikk vil utføres for neste tall, og som igjen vil summeres med resten av
        arrayen fra det tallet igjen. Dette vil iterativt forsette inntil sluttbetingelsen er nådd (index utenfor
        arrayens lengde) og hvor alle tallene slås sammen til slutt.
         */
        int sum = number + sumRecursively(numbers, index+1);
        return sum;

    }

    /*
    Rekursiv metode for å printe alle tallene i en array. erk at vi også tar et tall for å representere indexen vi
    skal printe fra som parameter. Dette er viktig for den rekursive funksjonaliteten
     */
    public static void printRecursively(int[] numbers, int index) {

        /*
        Vi definerrer her sluttbetingelsen for den iterative logikken, samt en generell kontroll for at indexen er
        gyldig.
         */
        if (index < 0 || index >= numbers.length) {
            return; // For en void-metode vil return bare avbryte kjøringen av metoden.
        }

        /*
        Skriver ut det nåværende tallet basert på index.
         */
        int number = numbers[index];
        System.out.print(number + ", ");

        /*
        Skriver ut neste tall ved å kalle samme metodelogikk på nytt (rekursivt) fra index+1. Dette vil i praksis
        medføre at vi stegvis skriver ut hvert tall helt til sluttbetingelsen er oppnådd og den iterative logikken vil
        avbrytes.
         */
        printRecursively(numbers, index+1);

    }
}
