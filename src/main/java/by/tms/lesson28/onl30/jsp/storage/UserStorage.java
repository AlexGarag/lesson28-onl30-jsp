package by.tms.lesson28.onl30.jsp.storage;

import by.tms.lesson28.onl30.jsp.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserStorage {
    private static final List<User> users = new ArrayList<>();

    public void add(User user) {
        users.add(user);
    }

    public void remove(User user) {}

    public Optional<User> findByLogin(String login) {
        for (User user : users) {
            if (user.getLoginUser().equals(login)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public List<User> getUsers() {
        return new ArrayList<>(users);
    }
}
