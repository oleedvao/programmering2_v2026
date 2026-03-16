package no.hiof.oleedvao.zooregister.controller;

import io.javalin.http.Context;
import no.hiof.oleedvao.zooregister.model.Zoo;
import no.hiof.oleedvao.zooregister.repository.ZooRepository;

public class ZooController {

    private ZooRepository zooRepository;

    public ZooController(ZooRepository zooRepository) {
        this.zooRepository = zooRepository;
    }

    public void addZoo(Context context) {

        String zooName = context.formParam("zoo-name");

        Zoo createdZoo = new Zoo(zooName);

        zooRepository.addZoo(createdZoo);

        /*
        Hvis vi benytter vue-komponenten add-zoo kan vi benytte .redirect() for å redirigere brukeren til en annen
        side etter logikken er fullført. Men siden dette eksemplet benytter add-zoo-v2, som gjør redirigeringen internt,
        kan denne linjen være utelatt.
         */
        //context.redirect("/all-zoos");
    }

    /*
    API-logikk for å hente en dyrepark basert på navn. Se API-endepunktet "/api/zoo/{zoo-name}" i Application-klassen
    for hvor denne benyttes i praksis.
     */
    public void getZooByName(Context context) {
        String zooName = context.pathParam("zoo-name");

        Zoo fetchedZoo = zooRepository.getZooByName(zooName);

        if (fetchedZoo != null) {
            context.json(fetchedZoo);
        }
        else {
            context.result("Could not find zoo with name " + zooName);
        }
    }

    /*
    API-logikk for å hente alle dyreparker. Se API-endepunktet "/api/all-zoos" i Application-klassen
    for hvor denne benyttes i praksis.
     */
    public void getAllZoos(Context context) {
        context.json(zooRepository.getAllZoos());
    }

    /*
    API-logikk for å hente systemets maskot. Se API-endepunktet "/api/mascot" i Application-klassen
    for hvor denne benyttes i praksis.
     */
    public void getMascot(Context context) {
        context.json(zooRepository.getMascot());
    }

}
