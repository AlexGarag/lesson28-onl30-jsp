package by.tms.lesson28.onl30.jsp.interfaces;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.ERROR_IO_FILE_TEMPLATE;
import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.ERROR_TEMPLATE;
import static by.tms.lesson28.onl30.jsp.servants.MyLogger.logIn;

public interface FileReader {
    List<?> read();                     // формирует Список из ВСЕХ строк
    List<?> readRow(String uuid);       // формирует Список только из строк, принадлежащих Сущности с UUID=uuid
    List<?> readRowsOwner(String uuid); // формирует Список только из строк, принадлежащих Владельцу с UUID=uuid

    static Optional<String> readFile(String nameFile) {
        try {
            return Optional.ofNullable(Files.readString(Paths.get(nameFile)));
        } catch (IOException ex) {
            logIn(ERROR_TEMPLATE.formatted(ERROR_IO_FILE_TEMPLATE.formatted(nameFile)));
            return Optional.empty();
        }
    }
}