package org.example.hexlet.controller;

import exercise.dto.users.BuildUserPage;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import org.example.hexlet.NamedRoutes;

import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;
import io.javalin.validation.ValidationException;

import static io.javalin.rendering.template.TemplateUtil.model;

public class UsersController {

    public static void index(Context ctx) {
        var users = UserRepository.getEntities();
        String flash = ctx.consumeSessionAttribute("flash");
        var page = new UsersPage(users);
        page.setFlash(flash);
        ctx.render("users/index.jte", model("page", page));
    }


    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("User not found"));
        var page = new UserPage(user);
        ctx.render("users/show.jte", model("page", page));
    }

    public static void build(Context ctx) {
        ctx.render("users/build.jte");
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");

        try {
            var passwordConfirmation = ctx.formParam("passwordConfirmation");
            var validatedPassword = ctx.formParamAsClass("password", String.class)
                    .check(value -> value.equals(passwordConfirmation), "Passwords do not match")
                    .check(value -> value.length() > 6, "Password is too short")
                    .get();
            var user = new User(name, email, validatedPassword);
            UserRepository.save(user);
            ctx.sessionAttribute("flash", "User successfully created!");
            ctx.redirect(NamedRoutes.usersPath());
        } catch (ValidationException e) {
            var page = new BuildUserPage(name, email, e.getErrors());
            ctx.render("users/build.jte", model("page", page));
        }
    }


    public static void edit(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("User not found"));
        var page = new UserPage(user);
        ctx.render("users/edit.jte", model("page", page));
    }

    public static void update(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("User not found"));

        var name = ctx.formParam("name");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");

        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        UserRepository.save(user);
        ctx.sessionAttribute("flash", "User successfully updated!");
        ctx.redirect(NamedRoutes.usersPath());
    }


    public static void destroy(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        UserRepository.delete(id);
        ctx.redirect(NamedRoutes.usersPath());
    }
}
