package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;

import java.util.ArrayList;
import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public final class App {

    private static final List<User> USERS = new ArrayList<>();

    static {
        USERS.add(new User(1L, "John Doe", "john.doe@example.com", "password123"));
        USERS.add(new User(2L, "Jane Doe", "jane.doe@example.com", "password123"));
    }

    public static Javalin getApp() {
        var app = Javalin.create(config -> {
            config.fileRenderer(new JavalinJte());
        });

        // Добавьте маршрут для тестирования шаблона test.jte
        app.get("/test", ctx -> {
            var testData = new TestData("Hello, JTE!");
            ctx.render("test.jte", model("testData", testData));
        });

        // Обработка формы для создания пользователей
        app.get("/users/build", ctx -> {
            ctx.render("users/build.jte");
        });

        app.post("/users", ctx -> {
            var name = ctx.formParam("name").trim();
            var email = ctx.formParam("email").trim().toLowerCase();
            var password = ctx.formParam("password");
            var passwordConfirmation = ctx.formParam("passwordConfirmation");

            if (!password.equals(passwordConfirmation)) {
                ctx.status(400);
                ctx.result("Пароли не совпадают");
                return;
            }

            var newId = USERS.size() + 1L;
            var user = new User(newId, name, email, password);
            USERS.add(user);
            ctx.redirect("/users");
        });

        // Просмотр пользователя по ID
        app.get("/users/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            User user = USERS.stream()
                    .filter(u -> id.equals(u.getId()))
                    .findFirst()
                    .orElseThrow(() -> new NotFoundResponse("User not found"));

            ctx.render("show.jte", model("user", user));
        });

        // Просмотр списка пользователей
        app.get("/users", ctx -> ctx.render("members.jte", model("users", USERS)));

        // Главная страница
        app.get("/", ctx -> ctx.render("index.jte"));

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
