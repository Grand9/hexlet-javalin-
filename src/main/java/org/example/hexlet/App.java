package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.controller.UsersController;
import org.example.hexlet.controller.CoursesController;

public final class App {
    public static Javalin getApp() {
        var app = Javalin.create(config -> {
            config.fileRenderer(new JavalinJte());
        });

        // Пользовательские маршруты
        app.get(NamedRoutes.usersPath(), UsersController::index);
        app.get(NamedRoutes.userPath(":id"), UsersController::show);
        app.get(NamedRoutes.buildUserPath(), UsersController::build);
        app.post(NamedRoutes.usersPath(), UsersController::create);
        app.get(NamedRoutes.userPath(":id/edit"), UsersController::edit);
        app.patch(NamedRoutes.userPath(":id"), UsersController::update);
        app.delete(NamedRoutes.userPath(":id"), UsersController::destroy);

        // Курсовые маршруты
        app.get(NamedRoutes.coursesPath(), CoursesController::index);
        app.get(NamedRoutes.coursePath(":id"), CoursesController::show);
        app.get(NamedRoutes.buildCoursePath(), CoursesController::build);
        app.post(NamedRoutes.coursesPath(), CoursesController::create);
        app.get(NamedRoutes.coursePath(":id/edit"), CoursesController::edit);
        app.patch(NamedRoutes.coursePath(":id"), CoursesController::update);
        app.delete(NamedRoutes.coursePath(":id"), CoursesController::destroy);

        // Главная страница
        app.get("/", ctx -> ctx.render("index.jte"));

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
