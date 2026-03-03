package no.hiof.oleedvao.zooregister.model;

import java.util.ArrayList;

public class Zoo {

    private String name;
    private ArrayList<Animal> allAnimals = new ArrayList<>();

    public Zoo(String name) {
        this.name = name;
    }

    public ArrayList<Animal> getAllAnimals() {
        return new ArrayList<>(allAnimals);
    }

    public void addAnimal(Animal animal) {
        allAnimals.add(animal);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
