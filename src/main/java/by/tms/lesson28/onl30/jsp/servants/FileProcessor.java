package by.tms.lesson28.onl30.jsp.servants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.*;
import static by.tms.lesson28.onl30.jsp.servants.MyLogger.logIn;

public class FileProcessor {

    public static void saveUser(String uuidUser, String nameUser, String loginUser, String password) {
        ZonedDateTime dateTime = ZonedDateTime.now(ZoneOffset.UTC);
        String lineFileCsv = String.format(USERS_CSV_FORMAT_TEMPLATE,
                uuidUser,
                nameUser,
                loginUser,
                password);
        Thread saveUser = new Thread(() -> {
            try {
                Files.write(Paths.get(USERS_CSV_FILE), lineFileCsv.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException ex) {
                logIn(ERROR_TEMPLATE.formatted(ERROR_IO_FILE_TEMPLATE.formatted(USERS_CSV_FILE)));
            }
        });
        saveUser.start();
    }

    public static String readFile(String nameFile) {
        String historyString = null;
        try {
            historyString = Files.readString(Paths.get(nameFile));
        } catch (IOException ex) {
            logIn(ERROR_TEMPLATE.formatted(ERROR_IO_FILE_TEMPLATE.formatted(nameFile)));
        }
        return historyString;
    }
}