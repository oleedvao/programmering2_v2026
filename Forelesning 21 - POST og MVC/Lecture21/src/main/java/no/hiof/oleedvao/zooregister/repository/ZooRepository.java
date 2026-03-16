package no.hiof.oleedvao.zooregister.repository;

import no.hiof.oleedvao.zooregister.model.Animal;
import no.hiof.oleedvao.zooregister.model.Zoo;

import java.util.ArrayList;

public interface ZooRepository {

    Animal getMascot();
    ArrayList<Zoo> getAllZoos();
    Zoo getZooByName(String zooName);
    void addZoo(Zoo newZoo); // Nytt "krav" om at vi må ha en metode for å legge til en ny Zoo.
}
