package org.example.hexlet.repository;

import org.example.hexlet.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private static final List<User> USERS = new ArrayList<>();

    public static void save(User user) {
        USERS.add(user);
    }

    public static List<User> getEntities() {
        return new ArrayList<>(USERS);
    }

    // Метод для поиска пользователя по id
    public static Optional<User> find(Long id) {
        return USERS.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    // Метод для удаления пользователя по id
    public static void delete(Long id) {
        USERS.removeIf(user -> user.getId().equals(id));
    }
}
