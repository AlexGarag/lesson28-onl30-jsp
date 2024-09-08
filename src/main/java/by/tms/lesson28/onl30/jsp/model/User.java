package by.tms.lesson28.onl30.jsp.model;

import java.util.UUID;

import static by.tms.lesson28.onl30.jsp.servants.FileProcessor.writeUsers;

public class User {
    String uuidUser;
    String nameUser;
    String password;

    public User(String name, String password) {
        this.uuidUser = UUID.randomUUID().toString();
        this.nameUser = name;
        this.password = password;
        writeUsers(uuidUser, nameUser, password);
    }

    public String getUuidUser() {
        return uuidUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + nameUser + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
