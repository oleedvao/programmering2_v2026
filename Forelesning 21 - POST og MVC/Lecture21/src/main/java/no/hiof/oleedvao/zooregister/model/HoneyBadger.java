package no.hiof.oleedvao.zooregister.model;

import java.time.LocalDate;

public class HoneyBadger extends Animal {

    private int numSnakesEaten = 0;

    public HoneyBadger(String name, LocalDate birthDate) {
        super(name, birthDate);
        this.setSpecies("Honey Badger");
    }

    public int getNumSnakesEaten() {
        return numSnakesEaten;
    }

    public void setNumSnakesEaten(int numSnakesEaten) {
        this.numSnakesEaten = numSnakesEaten;
    }

    public void eatASnake() {
        numSnakesEaten++;
    }
}
