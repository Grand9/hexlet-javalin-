package org.example.hexlet;

public final class NamedRoutes {

    public static String sessionsPath() {
        return "/sessions";
    }

    public static String sessionsBuildPath() {
        return "/sessions/build";
    }

    // Пользователи
    public static String usersPath() {
        return "/users";
    }

    public static String userPath(String id) {
        return "/users/" + id;
    }

    public static String buildUserPath() {
        return "/users/build";
    }

    // Курсы
    public static String coursesPath() {
        return "/courses";
    }

    public static String coursePath(String id) {
        return "/courses/" + id;
    }

    public static String buildCoursePath() {
        return "/courses/build";
    }
}
