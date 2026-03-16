package no.hiof.oleedvao.zooregister;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.vue.VueComponent;
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

        // --- API ---

        /*
        Gets one zoo specified by path paramter and returns result in JSON.
         */
        app.get("/api/zoo/{zoo-name}", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                String zooName = context.pathParam("zoo-name");

                Zoo fetchedZoo = zooRepository.getZooByName(zooName);

                if (fetchedZoo != null) {
                    context.json(fetchedZoo);
                }
                else {
                    context.result("Could not find zoo with name " + zooName);
                }

            }
        });


        /*
        Gets all zoos and returns the result in JSON.
         */
        app.get("/api/all-zoos", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
               context.json(zooRepository.getAllZoos());
            }
        });

        /*
        Gets the systems mascot (Animal) and return result in JSON.
         */
        app.get("/api/mascot", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                context.json(zooRepository.getMascot());
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
