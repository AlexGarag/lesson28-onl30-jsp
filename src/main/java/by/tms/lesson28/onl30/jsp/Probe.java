package by.tms.lesson28.onl30.jsp;

import by.tms.lesson28.onl30.jsp.interfaces.Reader;
import by.tms.lesson28.onl30.jsp.interfaces.ReaderFactory;

import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.POSTS;
import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.USERS;
import static by.tms.lesson28.onl30.jsp.interfaces.ReaderFactory.createReaderFactory;

public class Probe {
    public static void main(String[] args) {
//        loadLoginPasswordUsers();

        ReaderFactory readerFactory = createReaderFactory(POSTS);
        Reader reader = readerFactory.createReader();
        reader.read();
        ReaderFactory readerFactory1 = createReaderFactory(USERS);
        Reader reader1 = readerFactory1.createReader();
        reader1.read();
    }

}
