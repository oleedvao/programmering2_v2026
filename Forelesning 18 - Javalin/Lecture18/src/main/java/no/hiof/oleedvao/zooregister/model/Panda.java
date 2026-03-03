package no.hiof.oleedvao.zooregister.model;

import java.time.LocalDate;

public class Panda extends Animal {

    private String kungFuBelt;

    public Panda(String name, LocalDate birthDate, String kungFuBelt) {
        super(name, birthDate);
        this.setSpecies("Panda"); // Vi lar klassen definere species på en standardisert måte.

        this.kungFuBelt = kungFuBelt;
    }

    public String getKungFuBelt() {
        return kungFuBelt;
    }

    public void setKungFuBelt(String kungFuBelt) {
        this.kungFuBelt = kungFuBelt;
    }
}
