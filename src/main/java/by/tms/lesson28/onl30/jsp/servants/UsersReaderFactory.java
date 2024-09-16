package by.tms.lesson28.onl30.jsp.servants;

import by.tms.lesson28.onl30.jsp.interfaces.Reader;
import by.tms.lesson28.onl30.jsp.interfaces.ReaderFactory;

public class UsersReaderFactory implements ReaderFactory {
    @Override
    public Reader createReader() {
        return new UsersReader();
    }
}
