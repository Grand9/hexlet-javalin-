package org.example.hexlet.util;

public class NamedRoutes {
    public static String carsPath() {
        return "/cars";
    }

    public static String carPath(Long id) {
        return "/cars/" + id;
    }

    public static String postsPath() {
        return "/posts";
    }

    public static String postPath(Long id) {
        return "/posts/" + id;
    }

    // Добавьте другие маршруты, если необходимо
}
