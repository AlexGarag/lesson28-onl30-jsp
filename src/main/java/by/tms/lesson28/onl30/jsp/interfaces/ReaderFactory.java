package by.tms.lesson28.onl30.jsp.interfaces;

import by.tms.lesson28.onl30.jsp.servants.PostsReaderFactory;
import by.tms.lesson28.onl30.jsp.servants.UsersReaderFactory;

import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.POSTS_CSV_FILE;
import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.USERS_CSV_FILE;

public interface ReaderFactory {
    Reader createReader();

    static ReaderFactory createReaderFactory(String nameFile) {
        if (USERS_CSV_FILE.contains(nameFile)) {
            return new UsersReaderFactory();
        } else if (POSTS_CSV_FILE.contains(nameFile)) {
            return new PostsReaderFactory();
        } else {
            throw new RuntimeException("'" + nameFile + "' is not a valid nameFile"); // todo доработать!
        }
    }
}
