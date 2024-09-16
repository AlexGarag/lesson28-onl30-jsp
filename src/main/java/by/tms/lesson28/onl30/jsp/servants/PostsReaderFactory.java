package by.tms.lesson28.onl30.jsp.servants;

import by.tms.lesson28.onl30.jsp.interfaces.FileReader;
import by.tms.lesson28.onl30.jsp.interfaces.ReaderFactory;

public class PostsReaderFactory implements ReaderFactory {
    @Override
    public FileReader createReader() {
        return new PostsReader();
    }
}
