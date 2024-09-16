package by.tms.lesson28.onl30.jsp.servants;

import by.tms.lesson28.onl30.jsp.interfaces.FileReader;
import by.tms.lesson28.onl30.jsp.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.*;

public class PostsReader implements FileReader {
    @Override
    public List<?> read() {                         // формирует Список из ВСЕХ строк
        return List.of();       // todo
    }

    @Override
    public List<?> readRow(String uuid) {           // формирует Список только из строк, принадлежащих Сущности с UUID=uuid
        return List.of();       // todo
    }

    @Override
    public List<User> readRowOwner(String uuid) {   // формирует Список только из строк, принадлежащих Владельцу с UUID=uuid
        List<User> posts = new ArrayList<>();
        Optional<String> fileString = FileReader.readFile(POSTS_CSV_FILE);
        if (fileString.isPresent()) {
            String[] setRow = fileString.get().split(LF);
            for (String row : setRow) {
                String[] setWords = row.split(SEPARATOR);
                if (setWords[1].equals(uuid)) { // отбираем Посты, принадлежащие Владельцу с UUID=uuid
                    posts.add(new User(setWords[0], setWords[1], setWords[2], setWords[3]));
                }
            }
        }
        return posts;
    }
}