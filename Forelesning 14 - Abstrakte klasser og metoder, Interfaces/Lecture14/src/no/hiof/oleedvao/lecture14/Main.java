package no.hiof.oleedvao.lecture14;

import no.hiof.oleedvao.lecture14.interfaces.Drawable;
import no.hiof.oleedvao.lecture14.model.Circle;
import no.hiof.oleedvao.lecture14.model.Figure;
import no.hiof.oleedvao.lecture14.model.Person;
import no.hiof.oleedvao.lecture14.model.Rectangle;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        /*
        Vi kan ikke opprette objekter av en abstract klasse, men vi kan opprette objekter av en abstract klasse sine
        barneklasser.
         */
        //Figure figure = new Figure("Blue");
        Rectangle rectangle = new Rectangle("Blue", 5, 4);
        Circle circle = new Circle("Green", 7);

        System.out.println("---Rectangle---");
        System.out.println(rectangle);

        System.out.println("\n---Circle---");
        System.out.println(circle);

        System.out.println("\n---Rectangle Drawing---");
        System.out.println(rectangle.getDrawing());

        System.out.println("\n---Circle Drawing---");
        System.out.println(circle.getDrawing());

        System.out.println("\n---Person Drawing---");
        Person person = new Person();
        System.out.println(person.getDrawing());

        /*
        Vi kan ikke opprette objekter av interfaces direkte, men vi kan benytte polymorfisme med interfaces.
        Altså kan vi opprette variabler eller lister med et interface som datatype. I slike variabler/lister kan vi bare
        sette inn objekter av klasser som har implementert det gjeldende interfacet, og vi vil bare ha tilgang til
        funksjonalitet som er definert i dette interfacet.
         */
        Drawable drawable = new Rectangle("Yellow", 13, 4);
        System.out.println("\n---Drawable drawing---");
        System.out.println(drawable.getDrawing());

        /*
        Comparable interfacet påkrever implementasjon av metoden compareTo() under ser vi hvordan kall på denne metoden
        gir forskjellige verdier og hvordan disse skal tolkes.
         */
        System.out.println("\n---Compare to---");
        System.out.println("rectangle.compareTo(circle) -- Rectangle is 'smaller': " + rectangle.compareTo(circle));
        System.out.println("circle.compareTo(rectangle) -- Circle is 'bigger': " + circle.compareTo(rectangle));
        System.out.println("circle.compareTo(circle) -- Same size: " + circle.compareTo(circle));

        /*
        Ettersom Figure har implementert Comparable-interfacet kan vi nå benytte Collections.sort() for å sortere en
        liste med Figure-objekter.
         */
        ArrayList<Figure> figureList = new ArrayList<>();
        figureList.add(circle);
        figureList.add(rectangle);
        figureList.add(new Circle("Cyan", 0.4));

        System.out.println("\n---Unsorted list---");
        for (Figure figure : figureList) {
            System.out.println(figure);
            System.out.println();
        }

        Collections.sort(figureList);

        System.out.println("\n---Sorted list---");
        for (Figure figure : figureList) {
            System.out.println(figure);
            System.out.println();
        }


    }
}
