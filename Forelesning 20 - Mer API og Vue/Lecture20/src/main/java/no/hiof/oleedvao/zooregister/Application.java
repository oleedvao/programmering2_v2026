package no.hiof.oleedvao.zooregister;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import no.hiof.oleedvao.zooregister.repository.ZooDummyRepository;
import no.hiof.oleedvao.zooregister.repository.ZooRepository;
import org.jetbrains.annotations.NotNull;

public class Application {
    public static void main(String[] args) {

        Javalin app = Javalin.create().start(1337);

        ZooRepository zooRepository = new ZooDummyRepository();

        // --- API ---
        app.get("/api/zoo/{zoo-name}", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                String zooName = context.pathParam("zoo-name");
                context.result("The zoo name is " + zooName);
            }
        });


        app.get("/api/all-zoos", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
               context.json(zooRepository.getAllZoos());
            }
        });

        app.get("/api/mascot", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                context.json(zooRepository.getMascot());
            }
        });


        // --- Pages ---
        app.get("/", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                context.result("Hello, Javalin!");
            }
        });

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
