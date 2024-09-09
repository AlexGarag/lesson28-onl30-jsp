package by.tms.lesson28.onl30.jsp.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.*;
import static by.tms.lesson28.onl30.jsp.servants.MyLogger.logIn;

public class UserLogoutServlet extends HttpServlet {
    private static final String SERVLET_GET_NAME = "DoGetUserLogoutServlet";
    private static final String SERVLET_POST_NAME = "DoPostUserLogoutServlet";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (IS_PERFORM_LOGGING) logIn(BEGINNING_WORK_MESSAGE_TEMPLATE.formatted(SERVLET_GET_NAME));
        super.doGet(req, resp);
        if (IS_PERFORM_LOGGING) logIn(ENDING_WORK_MESSAGE_TEMPLATE.formatted(SERVLET_GET_NAME));
    }
}
