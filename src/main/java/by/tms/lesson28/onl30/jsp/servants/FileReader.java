package by.tms.lesson28.onl30.jsp.servants;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.ERROR_IO_FILE_TEMPLATE;
import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.ERROR_TEMPLATE;
import static by.tms.lesson28.onl30.jsp.servants.MyLogger.logIn;

public class FileReader/* implements Reader*/ {

//    @Override
    public Option read(String file) {




        return null; // todo
    }

    private Optional<String> readFile(String file) {
        String historyString = null;
        try {
            historyString = Files.readString(Paths.get(file));
        } catch (IOException ex) {
            logIn(ERROR_TEMPLATE.formatted(ERROR_IO_FILE_TEMPLATE.formatted(file)));
        }
        return Optional.of(historyString);
    }

//    public Optional<User> getUser(String name) {
//        for (User user : users) {
//            if (user.getName().orElse("").equals(name)) {
//                return Optional.of(user);
//            }
//        }
//        return Optional.empty();
//    }
}
