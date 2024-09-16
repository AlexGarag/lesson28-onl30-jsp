package by.tms.lesson28.onl30.jsp.servants;

import by.tms.lesson28.onl30.jsp.interfaces.FileReader;
import by.tms.lesson28.onl30.jsp.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.*;
// todo везде USER исправить на Post
public class PostsReader implements FileReader {
    @Override
    public List<User> read() {                         // формирует Список из ВСЕХ строк
        List<User> posts = new ArrayList<>();
        Optional<String> fileString = FileReader.readFile(POSTS_CSV_FILE);
        if (fileString.isPresent()) {
            String[] setRow = fileString.get().split(LF);
            for (String row : setRow) {
                String[] setWords = row.split(SEPARATOR);
                posts.add(new User(setWords[0], setWords[1], setWords[2], setWords[3]));
            }
        }
        return posts;
    }

    @Override
    public List<User> readRow(String uuid) {           // формирует Список только из строк, принадлежащих Сущности с UUID=uuid
        List<User> posts = new ArrayList<>();
        Optional<String> fileString = FileReader.readFile(POSTS_CSV_FILE);
        if (fileString.isPresent()) {
            String[] setRow = fileString.get().split(LF);
            for (String row : setRow) {
                String[] setWords = row.split(SEPARATOR);
                if (setWords[0].equals(uuid)) { // отбираем конкретный пост с UUID=uuid
                    posts.add(new User(setWords[0], setWords[1], setWords[2], setWords[3]));
                }
            }
        }
        return posts;
    }

    @Override
    public List<User> readRowsOwner(String uuid) {   // формирует Список только из строк, принадлежащих Владельцу с UUID=uuid
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