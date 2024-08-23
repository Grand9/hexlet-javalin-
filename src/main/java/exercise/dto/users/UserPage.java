package exercise.dto.users;

import org.example.hexlet.model.User;

public class UserPage {
    private final User user;

    public UserPage(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
