package no.hiof.oleedvao.lecture14.model;

import no.hiof.oleedvao.lecture14.interfaces.Drawable;

/*
Person implementerer her Drawable, slik at den kan "tegnes"
 */
public class Person implements Drawable {

    @Override
    public String getDrawing() {
        return " 0 " +
                "\n/|\\" +
                "\n/ \\";
    }
}
