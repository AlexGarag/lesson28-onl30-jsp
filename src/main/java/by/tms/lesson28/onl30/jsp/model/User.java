package by.tms.lesson28.onl30.jsp.model;

import java.util.UUID;

import static by.tms.lesson28.onl30.jsp.servants.FileProcessor.writeUsers;

public class User {
    String uuidUser;
    String nameUser;
    String loginUser;
    String passwordUser;

    public User(String name, String login, String password) {
        this.uuidUser = UUID.randomUUID().toString();
        this.nameUser = name;
        this.loginUser = login;
        this.passwordUser = password;
        writeUsers(uuidUser, nameUser, loginUser, passwordUser);
    }

    public String getUuidUser() {
        return uuidUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public String getPassword() {
        return passwordUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public void setPassword(String password) {
        this.passwordUser = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + nameUser + '\'' +
                ", password='" + passwordUser + '\'' +
                '}';
    }
}
