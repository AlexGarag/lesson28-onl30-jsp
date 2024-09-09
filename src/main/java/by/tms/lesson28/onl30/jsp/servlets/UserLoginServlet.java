package by.tms.lesson28.onl30.jsp.servlets;

import by.tms.lesson28.onl30.jsp.model.User;
import by.tms.lesson28.onl30.jsp.storage.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.*;
import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.BEGINNING_WORK_MESSAGE_TEMPLATE;
import static by.tms.lesson28.onl30.jsp.servants.MyLogger.logIn;

@WebServlet(urlPatterns = LOGIN_PATH)
public class UserLoginServlet extends HttpServlet {
    private static final String SERVLET_GET_NAME = "DoGetUserLoginServlet";
    private static final String SERVLET_POST_NAME = "DoPostUserLoginServlet";
    private static final String LOGIN_USER = "login";
    private static final String PASSWORD_USER = "password";
    private static final String PASSWORD_PROBLEM = "Wrong password!";
    private static final String USER_PROBLEM = "Еhe user's login was not found!";
    private final UserStorage users = new UserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (IS_PERFORM_LOGGING) logIn(BEGINNING_WORK_MESSAGE_TEMPLATE.formatted(SERVLET_GET_NAME));
        getServletContext().getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
        if (IS_PERFORM_LOGGING) logIn(ENDING_WORK_MESSAGE_TEMPLATE.formatted(SERVLET_GET_NAME));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (IS_PERFORM_LOGGING) logIn(BEGINNING_WORK_MESSAGE_TEMPLATE.formatted(SERVLET_POST_NAME));
        String login = req.getParameter(LOGIN_USER);
        String password = req.getParameter(PASSWORD_USER);

        Optional<User> byUserName = users.findByLogin(login);
        if (byUserName.isPresent()) {
            User user = byUserName.get();
            if (user.getPassword().equals(password)) {
                req.getSession().setAttribute("currentUser", user);
                resp.sendRedirect(SLAGE);
            } else {
                req.setAttribute("message", PASSWORD_PROBLEM);
                req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
            }
        } else {
            req.setAttribute("message", USER_PROBLEM);
            req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
        }
        if (IS_PERFORM_LOGGING) logIn(ENDING_WORK_MESSAGE_TEMPLATE.formatted(SERVLET_GET_NAME));
    }
}