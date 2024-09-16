package by.tms.lesson28.onl30.jsp.servants;

import by.tms.lesson28.onl30.jsp.interfaces.FileSaver;
import by.tms.lesson28.onl30.jsp.model.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.*;
import static by.tms.lesson28.onl30.jsp.servants.MyLogger.logIn;

public class Saver implements FileSaver {
// todo имплементировать поля сущностей User, Post, Comment, Reaction, Subscription
    @Override
    public void save(Object object) {
        String file;
        String rowText;
        if (object instanceof User user) {
            rowText = String.format(USERS_CSV_FORMAT_TEMPLATE,
                    user.getUuidUser(),
                    user.getNameUser(),
                    user.getPassword());
            file = USERS_CSV_FILE;
        } else if (object instanceof User post) {
            rowText = String.format(USERS_CSV_FORMAT_TEMPLATE,    // todo поменять константу и поля!
                    post.getUuidUser(),
                    post.getNameUser(),
                    post.getPassword());
            file = USERS_CSV_FILE;    // todo поменять константу!
        } else if (object instanceof User comment) {
            rowText = String.format(USERS_CSV_FORMAT_TEMPLATE,    // todo поменять константу и поля!
                    comment.getUuidUser(),
                    comment.getNameUser(),
                    comment.getPassword());
            file = USERS_CSV_FILE;    // todo поменять константу!
        } else if (object instanceof User reaction) {
            rowText = String.format(USERS_CSV_FORMAT_TEMPLATE,    // todo поменять константу и поля!
                    reaction.getUuidUser(),
                    reaction.getNameUser(),
                    reaction.getPassword());
            file = USERS_CSV_FILE;    // todo поменять константу!
        } else if (object instanceof User subscription) {
            rowText = String.format(USERS_CSV_FORMAT_TEMPLATE,    // todo поменять константу и поля!
                    subscription.getUuidUser(),
                    subscription.getNameUser(),
                    subscription.getPassword());
            file = USERS_CSV_FILE;    // todo поменять константу!
        } else {
            // todo сделать запись в Лог, что переданный объект не подлежит сохранению (бросить Исключение?)
            return;
        }
        threadSave(file, rowText);
    }

    private void threadSave(String file, String rowText) { // todo перенести в FileSaver?
        Thread saveThread = new Thread(() -> {
            try {
                Files.write(Paths.get(file), rowText.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException ex) {
                logIn(ERROR_TEMPLATE.formatted(ERROR_IO_FILE_TEMPLATE.formatted(file)));
            }
        });
        saveThread.start();
    }
}
