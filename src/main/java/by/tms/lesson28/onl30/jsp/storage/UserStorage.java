package by.tms.lesson28.onl30.jsp.storage;

import by.tms.lesson28.onl30.jsp.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.*;
import static by.tms.lesson28.onl30.jsp.servants.FileProcessor.readFile;
import static by.tms.lesson28.onl30.jsp.servants.MyLogger.logIn;

public class UserStorage {
    private static final String LOAD_FROM_FILE_USERS = "LoadUserStorage";
    private static final List<User> users = new ArrayList<>();

    public static void loadLoginPasswordUsers() {
        if (IS_PERFORM_LOGGING) logIn(BEGINNING_WORK_MESSAGE_TEMPLATE.formatted(LOAD_FROM_FILE_USERS));
        String[] loginPasswordUsersArray = readFile(USERS_CSV_FILE).split(LF);
        for (String loginPasswordUserString : loginPasswordUsersArray) {
            String[] loginPasswordUser = loginPasswordUserString.split(SEPARATOR);
            users.add(new User(loginPasswordUser[0], loginPasswordUser[1], loginPasswordUser[2], loginPasswordUser[3]));
        }
        if (IS_PERFORM_LOGGING) logIn(ENDING_WORK_MESSAGE_TEMPLATE.formatted(LOAD_FROM_FILE_USERS));
    }

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
