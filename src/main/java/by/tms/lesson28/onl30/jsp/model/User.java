package by.tms.lesson28.onl30.jsp.model;

import java.util.UUID;

import static by.tms.lesson28.onl30.jsp.servants.FileProcessor.saveUser;

public class User {
    private String uuidUser;
    private String nameUser;
    private String loginUser;
    private String passwordUser;
    private byte[] avatarUser;

    public User(String name, String login, String password, byte[] image) {
        this.uuidUser = UUID.randomUUID().toString();
        this.nameUser = name;
// todo закрыть пароль хэш-функцией
        this.loginUser = login;
        this.passwordUser = password;
        this.avatarUser = image;
//        saveUser(uuidUser, nameUser, loginUser, passwordUser, avatarUser);
    }

    public User(String uuid, String name, String login, String password, byte[] image) {
        this.uuidUser = uuid;
        this.nameUser = name;
        this.loginUser = login;
        this.passwordUser = password;
        this.avatarUser = image;
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

    public byte[] getAvatarUser() {
        return avatarUser;
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
                "uuidUser='" + uuidUser + "\', " +
                "nameUser='" + nameUser + "\', " +
                "loginUser='" + loginUser + "\', " +
                "passwordUser='" + passwordUser + "\'" + '}';
    }
}
