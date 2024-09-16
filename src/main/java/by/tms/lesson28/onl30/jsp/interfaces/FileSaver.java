package by.tms.lesson28.onl30.jsp.interfaces;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.ERROR_IO_FILE_TEMPLATE;
import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.ERROR_TEMPLATE;
import static by.tms.lesson28.onl30.jsp.servants.MyLogger.logIn;

public interface FileSaver {
    void save(Object object);

    static void threadSave(String file, String rowText) {
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
