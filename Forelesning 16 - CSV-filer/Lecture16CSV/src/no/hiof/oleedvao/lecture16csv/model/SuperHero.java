package no.hiof.oleedvao.lecture16csv.model;

/*
Klasse som representerer superhelt som en datatype
 */
public class SuperHero {

    private String name;
    private String secretIdentity;

    public SuperHero(String name, String secretIdentity) {
        this.name = name;
        this.secretIdentity = secretIdentity;
    }

    @Override
    public String toString() {
        return "Superhero name: " + name + " - Secret identity: " + secretIdentity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecretIdentity() {
        return secretIdentity;
    }

    public void setSecretIdentity(String secretIdentity) {
        this.secretIdentity = secretIdentity;
    }
}
