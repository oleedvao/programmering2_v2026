package no.hiof.oleedvao.lecture14.model;

public class Rectangle extends Figure {

    private double length;
    private double width;

    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    /*
    getDrawing() må implementeres her ettersom denne klassens foreldreklasse, Figure, implementerer interfacet Drawable
    som inneholder denne metoden som en abstrakt metode.
     */
    @Override
    public String getDrawing() {
        return "------" +
                "\n|    |" +
                "\n-----";
    }

    /*
    circumference() og area() må her implementeres ettersom denne klassens foreldreklasse, Figure, har definert disse
    som abstrakte metoder.
     */
    @Override
    public double circumference() {
        return 2 * length + 2 * width;
    }

    @Override
    public double area() {
        return length * width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
