package no.hiof.oleedvao.zooregister;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.vue.VueComponent;
import no.hiof.oleedvao.zooregister.controller.ZooController;
import no.hiof.oleedvao.zooregister.model.Zoo;
import no.hiof.oleedvao.zooregister.repository.ZooDummyRepository;
import no.hiof.oleedvao.zooregister.repository.ZooRepository;
import org.jetbrains.annotations.NotNull;

public class Application {
    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            config.staticFiles.enableWebjars();
            config.vue.vueInstanceNameInJs = "app";
        }).start(1337);

        ZooRepository zooRepository = new ZooDummyRepository();

        /*
        Vi oppretter her et objekt av en ZooController. Dette objektet er det vi nå vil benytte for å utføre logikk i
        applikasjonen, altså typisk ved API kall. Ved å benytte dette objektet unngår vi altså å skrive
        logikk direkte i Application-klassen slik at Application bare er en konfigurasjon av webapplikasjonen.
        Det er typisk lurt å gjøre slike typer "ansvarsskille" i større applikasjoner.
        Merk at vi sender med zooRepository via konstruktør slik at controlleren vil benytte denne for å håndere
        dataene i systemet, slik vi i tidligere forelesninger har gjort direkte i Application-klassen.
         */
        ZooController zooController = new ZooController(zooRepository);

        // --- API ---
        /*
        Vi har her definert et API-endepunkt for å legge til en ny dyrepark. Merk at denne er definert med app.post()
        i stedet for app.get(). Dette betyr at endepunktet bare tar imot POST-forespørsler, som er
        litt forskjellig fra GET-forespørsler. Spesifikt; GET-forespørsler sender med data som path-parameter, altså
        via URL'en, mens POST-forespørsler sender med data som parametere som er "gjemt" inne i forespørselen og kalles
        form-parametere. Så lenge vi vet hva form-parameterene heter kan vi hente dem ut med Context sin
        .formParam()-metode. Form-parameterene blir definert i frontend. Se eventuelt add-zoo.vue
        og/eller add-zoo-v2.vue for hvordan dette blir gjort.

        En tommelfingerregel for bruk av GET vs. POST er: Hvis du bare skal hente data eller en side, bruk GET, hvis
        du skal gjøre noe annet eller mer, for eksempel opprette data, endre data, slette data eller lignende, bruk
        POST.
         */
        app.post("/api/add-zoo", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                 /*
                Vi kaller her ZooController sin metode addZoo() for å utføre API-logikken for dette kallet.
                Se metodedefinisjonen for denne for å se logikken.
                 */
                zooController.addZoo(context);
            }
        });


        /*
        Gets one zoo specified by path paramter and returns result in JSON.
         */
        app.get("/api/zoo/{zoo-name}", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                /*
                Vi kaller her ZooController sin metode addZooByName() for å utføre API-logikken for dette kallet.
                Se metodedefinisjonen for denne for å se logikken.
                 */
                zooController.getZooByName(context);
            }
        });


        /*
        Gets all zoos and returns the result in JSON.
         */
        app.get("/api/all-zoos", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                /*
                Vi kaller her ZooController sin metode getAllZoos() for å utføre API-logikken for dette kallet.
                Se metodedefinisjonen for denne for å se logikken.
                 */
                zooController.getAllZoos(context);
            }
        });

        /*
        Gets the systems mascot (Animal) and return result in JSON.
         */
        app.get("/api/mascot", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                /*
                Vi kaller her ZooController sin metode getMascot() for å utføre API-logikken for dette kallet.
                Se metodedefinisjonen for denne for å se logikken.
                 */
                zooController.getMascot(context);
            }
        });


        // --- Pages ---
        /*
        View for the applications home page.
         */
        app.get("/", new VueComponent("home-page"));

        /*
        View for displaying all zoos.
         */
        app.get("/all-zoos", new VueComponent("zoos-overview"));

        /*
        View for displaying one zoo based on path parameter.
         */
        app.get("/zoo/{zoo-name}", new VueComponent("zoo-detail"));

        /*
        Endepunkt for frontend-side for opprettelse av en ny Zoo via html-form.
         */
        app.get("/add-zoo", new VueComponent("add-zoo"));
        app.get("/add-zoo", new VueComponent("add-zoo-v2"));


        app.get("/other-page", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                context.result("Hello from the other page!");
            }
        });

        app.get("/some-page/page-in-page", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                context.result("This is a sub-page");
            }
        });

    }
}
