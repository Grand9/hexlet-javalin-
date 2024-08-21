package org.example.hexlet;

import exercise.dto.courses.BuildCoursePage;
import exercise.dto.users.BuildUserPage;
import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import io.javalin.validation.ValidationException;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;

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

        // Маршрут для тестирования шаблона test.jte
        app.get("/test", ctx -> {
            var testData = new TestData("Hello, JTE!");
            ctx.render("test.jte", model("testData", testData));
        });

        // Форма создания пользователя
        app.get(NamedRoutes.buildUserPath(), ctx -> {
            var page = new BuildUserPage();
            ctx.render("users/build.jte", model("page", page));
        });

        // Обработка формы создания пользователя с валидацией
        app.post(NamedRoutes.usersPath(), ctx -> {
            var name = ctx.formParam("name");
            var email = ctx.formParam("email");

            try {
                var passwordConfirmation = ctx.formParam("passwordConfirmation");
                var password = ctx.formParamAsClass("password", String.class)
                        .check(value -> value.equals(passwordConfirmation), "Пароли не совпадают")
                        .check(value -> value.length() > 6, "У пароля недостаточная длина")
                        .get();
                var user = new User(name, email, password);
                UserRepository.save(user);
                ctx.redirect(NamedRoutes.usersPath());
            } catch (ValidationException e) {
                var page = new BuildUserPage(name, email, e.getErrors());
                ctx.render("users/build.jte", model("page", page));
            }
        });

        // Просмотр пользователя по ID
        app.get(NamedRoutes.userPath(1L), ctx -> { // Пример использования с конкретным ID
            var id = ctx.pathParamAsClass("id", Long.class).get();
            User user = USERS.stream()
                    .filter(u -> id.equals(u.getId()))
                    .findFirst()
                    .orElseThrow(() -> new NotFoundResponse("User not found"));

            ctx.render("show.jte", model("user", user));
        });

        // Просмотр списка пользователей
        app.get(NamedRoutes.usersPath(), ctx -> ctx.render("members.jte", model("users", USERS)));

        // Главная страница
        app.get("/", ctx -> ctx.render("index.jte"));

        // Обработка формы создания курса с валидацией
        app.post(NamedRoutes.coursesPath(), ctx -> {
            var name = ctx.formParam("name");
            var description = ctx.formParam("description");

            try {
                name = ctx.formParamAsClass("name", String.class)
                        .check(value -> value.length() > 2, "Название курса должно быть длиннее 2 символов")
                        .get();
                description = ctx.formParamAsClass("description", String.class)
                        .check(value -> value.length() > 10, "Описание курса должно быть длиннее 10 символов")
                        .get();
                var course = new Course(name, description);
                CourseRepository.save(course);
                ctx.redirect(NamedRoutes.coursesPath());
            } catch (ValidationException e) {
                var page = new BuildCoursePage(name, description, e.getErrors());
                ctx.render("courses/build.jte", model("page", page));
            }
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}