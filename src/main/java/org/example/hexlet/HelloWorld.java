package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> config.bundledPlugins.enableDevLogging());

        // Обработчик для маршрута "/"
        app.get("/", ctx -> ctx.result("Hello World"));

        // Обработчик для маршрута "/hello"
        app.get("/hello", ctx -> {
            String name = ctx.queryParam("name"); // Получаем параметр name или используем значение "World" по умолчанию
            ctx.result("Hello, " + name + "!"); // Формируем и отправляем приветствие
        });

        // Обработчик для маршрута /courses/{id}
        app.get("/courses/{id}", ctx -> ctx.result("Course ID: " + ctx.pathParam("id")));

        // Обработчик для маршрута /users/{id}
        app.get("/users/{id}", ctx -> ctx.result("User ID: " + ctx.pathParam("id")));

        // Обработчик для маршрута /users/{id}/post/{postId}
        app.get("/users/{id}/post/{postId}", ctx -> {
            var userId = ctx.pathParam("id");
            var postId = ctx.pathParam("postId");
            ctx.result("User ID: " + userId + " Post ID: " + postId);
        });

        // Стартуем веб-сервер
        app.start(7070);
    }
}
