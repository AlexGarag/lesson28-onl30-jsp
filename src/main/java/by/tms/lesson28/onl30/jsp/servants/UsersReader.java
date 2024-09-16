package by.tms.lesson28.onl30.jsp.servants;

import by.tms.lesson28.onl30.jsp.interfaces.FileReader;
import by.tms.lesson28.onl30.jsp.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.*;

public class UsersReader implements FileReader {

    @Override
    public List<User> read(String uuid) {
        List<User> users = new ArrayList<>();
        Optional<String> fileString = FileReader.readFile(USERS_CSV_FILE);
        if (fileString.isPresent()) {
            String[] setRow = fileString.get().split(LF);
            for (String row : setRow) {
                String[] setWords = row.split(SEPARATOR);
                if (setWords[0].equals(uuid)) {
                    users.add(new User(setWords[0], setWords[1], setWords[2], setWords[3]));
                }
            }
        }
        return users;
    }
}
