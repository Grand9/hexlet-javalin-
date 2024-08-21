package org.example.hexlet.repository;

import org.example.hexlet.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static final List<User> USERS = new ArrayList<>();

    public static void save(User user) {
        USERS.add(user);
    }

    public static List<User> getEntities() {
        return new ArrayList<>(USERS);
    }
}
