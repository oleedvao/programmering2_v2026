package no.hiof.oleedvao.zooregister.model;

import java.time.LocalDate;

/*
Klasse for å representere dyr.
 */
public abstract class Animal {

    private final int id;
    private String name;
    private LocalDate birthDate;
    /*
    Vi legger her til en egen instansvariabel for dyreart. Dette kan virke litt redundandt da navnet på barneklasser
    egentlig allerede inneholder denne informasjonen. Grunnen til at det kan være fornuftig å ha en egen
    instansvariabel for arten er at frontenden ikke kan tyde slikt som klasse-navn uten videre når vi skal presentere
    dyrene senere.
     */
    private String species;

    private static int numAnimals = 0;

    public Animal(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;

        /*
        Benytter en statisk teller for å generere en unik id per dyr opprettet.
        Merk at dette ikke er en god måte å generere id-er i et reelt system. Man ville typisk heller latt databasen
        som lagrer dyrene generere disse id-ene når de legges til.
         */
        numAnimals++;
        id = 1000 + numAnimals;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
