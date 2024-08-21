package org.example.hexlet;

public class NamedRoutes {

    // Маршрут для формы создания пользователя
    public static String buildUserPath() {
        return "/users/build";
    }

    // Маршрут для обработки формы создания пользователя
    public static String usersPath() {
        return "/users";
    }

    // Маршрут для просмотра пользователя по ID
    public static String userPath(Long id) {
        return "/users/" + id;
    }

    // Маршрут для создания курса
    public static String coursesPath() {
        return "/courses";
    }

    // Маршрут для формы создания курса
    public static String buildCoursePath() {
        return "/courses/build";
    }
}
