package by.tms.lesson28.onl30.jsp.servants;

import by.tms.lesson28.onl30.jsp.interfaces.Reader;

public class UsersReader implements Reader {
    @Override
    public void read() {
        System.out.println("Reading users");
    }
}
