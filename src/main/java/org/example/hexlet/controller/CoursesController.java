package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.model.Course;
import org.example.hexlet.repository.CourseRepository;
import static io.javalin.rendering.template.TemplateUtil.model;

public class CoursesController {

    public static void index(Context ctx) {
        var courses = CourseRepository.getEntities();
        ctx.render("courses/index.jte", model("courses", courses));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Course not found"));
        ctx.render("courses/show.jte", model("course", course));
    }

    public static void build(Context ctx) {
        ctx.render("courses/build.jte");
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var description = ctx.formParam("description");
        var course = new Course(name, description);
        CourseRepository.save(course);
        ctx.redirect(NamedRoutes.coursesPath());
    }

    public static void edit(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Course not found"));
        ctx.render("courses/edit.jte", model("course", course));
    }

    public static void update(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Course not found"));

        course.setName(ctx.formParam("name"));
        course.setDescription(ctx.formParam("description"));
        CourseRepository.save(course);
        ctx.redirect(NamedRoutes.coursesPath());
    }

    public static void destroy(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        CourseRepository.delete(id);
        ctx.redirect(NamedRoutes.coursesPath());
    }
}
