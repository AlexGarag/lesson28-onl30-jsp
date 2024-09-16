package by.tms.lesson28.onl30.jsp.servants;

import by.tms.lesson28.onl30.jsp.interfaces.FileReader;
import by.tms.lesson28.onl30.jsp.model.User;

import java.util.ArrayList;
import java.util.List;

public class PostsReader implements FileReader {

    @Override
    public List<User> read(String uuid) {
        System.out.println("Reading posts...");
        List<User> posts = new ArrayList<>();
        return posts;
    }
}
