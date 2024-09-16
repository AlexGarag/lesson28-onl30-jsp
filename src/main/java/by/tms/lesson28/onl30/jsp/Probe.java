package by.tms.lesson28.onl30.jsp;

import by.tms.lesson28.onl30.jsp.interfaces.FileReader;
import by.tms.lesson28.onl30.jsp.interfaces.ReaderFactory;
import by.tms.lesson28.onl30.jsp.model.User;

import java.util.ArrayList;
import java.util.List;

import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.POSTS;
import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.USERS;
import static by.tms.lesson28.onl30.jsp.interfaces.ReaderFactory.createReaderFactory;

public class Probe {
    public static void main(String[] args) {
//        loadLoginPasswordUsers();

        List<User> entity = new ArrayList<>();
        ReaderFactory readerFactory = createReaderFactory(POSTS);
        FileReader reader = readerFactory.createReader();
        entity = (List<User>) reader.readRowOwner("0cdb37b3-75ab-4b65-bce6-09d3c4985578");
        int i = 0;
//        ReaderFactory readerFactory1 = createReaderFactory(USERS);
//        Reader reader1 = readerFactory1.createReader();
//        reader1.read();
    }

}
