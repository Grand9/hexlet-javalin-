package org.example.hexlet;

import exercise.dto.MainPage;
import org.example.hexlet.controller.SessionsController;

import io.javalin.Javalin;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/", ctx -> {
            var page = new MainPage(ctx.sessionAttribute("currentUser"));
            ctx.render("index.jte", model("page", page));
        });

        app.get("/sessions/build", SessionsController::build);
        app.post("/sessions", SessionsController::create);
        app.delete("/sessions", SessionsController::destroy);

        app.start(7070);
    }
}
