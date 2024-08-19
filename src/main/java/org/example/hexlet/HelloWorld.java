package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;


import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            // Укажите путь к директории шаблонов
            config.fileRenderer(new JavalinJte());
        });

        app.get("/courses", ctx -> {
            var courses = List.of(
                    new Course(1L, "Java Basics", "Introduction to Java programming"),
                    new Course(2L, "Advanced Java", "Deep dive into Java features"),
                    new Course(3L, "Web Development", "Building web applications with Java")
            );
            var header = "Курсы по программированию";
            var page = new CoursesPage(courses, header);
            ctx.render("index.jte", model("page", page));
        });

        app.get("/courses/:id", ctx -> {
            var courseId = Long.parseLong(ctx.pathParam("id"));
            var course = new Course(courseId, "Пример курса", "Описание курса для ID " + courseId);
            ctx.render("show.jte", model("course", course));
        });

        app.start(7070);
    }
}
