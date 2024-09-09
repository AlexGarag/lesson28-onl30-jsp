package by.tms.lesson28.onl30.jsp.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.*;
import static by.tms.lesson28.onl30.jsp.servants.MyLogger.logIn;
import static by.tms.lesson28.onl30.jsp.storage.UserStorage.loadLoginPasswordUsers;

@WebServlet(urlPatterns = HOME_PATH)
public class HomeServlet extends HttpServlet {
    private static final String SERVLET_NAME = "HomeServlet";


    public void init() {
        loadLoginPasswordUsers();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (IS_PERFORM_LOGGING) logIn(BEGINNING_WORK_MESSAGE_TEMPLATE.formatted(SERVLET_NAME));
        getServletContext().getRequestDispatcher(HOME_PAGE).forward(req, resp);
        if (IS_PERFORM_LOGGING) logIn(ENDING_WORK_MESSAGE_TEMPLATE.formatted(SERVLET_NAME));
    }
}
