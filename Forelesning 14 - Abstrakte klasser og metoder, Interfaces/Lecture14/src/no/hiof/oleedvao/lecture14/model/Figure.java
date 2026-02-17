package no.hiof.oleedvao.lecture14.model;

import no.hiof.oleedvao.lecture14.interfaces.Drawable;

/*
Figure er her satt til å være abstract. Dette vil forhindre direkte opprettelse av Figure-objekter, men vi vil
fremdeles kunne arve fra denne klassen. Å sette Figure til å være abstract er her fornuftig fordi denne klassen bare
benyttes til å samle informasjon som er felles for alle spesifikke typer figurer. Vi har ikke noe behov for å opprette
generelle figurer.

Vi kan også se at Figure implementerer to interfaces. Drawable, som vi selv har definert, og Comparable som er et
interface som følger med i Java.
Merk at når vi implementerer et interface vil vi vanligvis bli påtvunget til å implementere interfacets abstrakte
metoder direkte i denne klassen, men siden Figure her er abstract, kan vi velge om metodene implementeres her eller
i barneklassene. Spesifikt implementerer vi getDrawing() fra Drawable i barneklassene, mens compareTo() fra Comparable
implementeres her.
 */
public abstract class Figure implements Drawable, Comparable<Figure> {
    private String color;

    public Figure(String color) {
        this.color = color;
    }

    /*
    circumference() og area() er abstract metoder. Dette betyr at disse ikke har noen implementert kodekropp.
    En forutsetning for å definere abstract metoder er at disse må defineres innenfor en abstract klasse (eller i et
    interface). Effekten av abstract metoder i en abstract klasse er at alle barneklasser av den abstrakte klassen
    MÅ implementere kodekroppen for disse abstrakte metodene via overriding. (Se Rectangle og Circle.)

    Abstrakte metoder er nyttig i tilfeller hvor man vet om metoder som vil være felles for alle underklasser, men hvor
    implementasjonen vil være forskjellig. For eksempel vet vi at alle figurer har en omkrets og areal, men hvordan
    disse er implementert er unikt for hver spesifikk type figur. Dermed er det fornuftig å definere metodene for disse
    som abstract for å tvinge alle underklasser til å implementere beregningen av omkrets og areal unikt.
     */
    public abstract double circumference();
    public abstract double area();

    /*
    compareTo() fra interfacet Comparable blir her implementert. Denne metoden skal returnere en int-verdi for å
    representere hvilket objekt som er størst.
    1: this er størst
    -1: this er minst
    0: this og otherFigure er like store
     */
    @Override
    public int compareTo(Figure otherFigure) {
        /*
        Double.compare() kan hjelpe oss med å sammenligne double-verdier, og med resultatet vi forventer med
        compareTo().
         */
        return Double.compare(this.area(), otherFigure.area());
    }

    @Override
    public String toString() {
        return "Color: " + color +
                "\nArea: " + area() +
                "\nCircumference: " + circumference();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
