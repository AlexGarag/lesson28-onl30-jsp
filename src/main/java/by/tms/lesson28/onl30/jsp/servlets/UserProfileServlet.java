package by.tms.lesson28.onl30.jsp.servlets;

import by.tms.lesson28.onl30.jsp.model.User;
import by.tms.lesson28.onl30.jsp.storage.UserStorage;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Optional;

import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.*;
import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.BEGINNING_WORK_MESSAGE_TEMPLATE;
import static by.tms.lesson28.onl30.jsp.servants.MyLogger.logIn;

@WebServlet(urlPatterns = PROFILE_PATH)
public class UserProfileServlet extends HttpServlet {
    private static final String SERVLET_GET_NAME = "DoGetUserProfileServlet";
    private static final String SERVLET_POST_NAME = "DoPostUserProfileServlet";
    private final UserStorage users = new UserStorage();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        if (IS_PERFORM_LOGGING) logIn(BEGINNING_WORK_MESSAGE_TEMPLATE.formatted(SERVLET_GET_NAME));
        String userLogin = req.getParameter("login");
        Optional<User> byLogin = users.findByLogin(userLogin);
        if (byLogin.isPresent()) {
            User user = byLogin.get();
            req.setAttribute("user",user);
        }
        getServletContext().getRequestDispatcher("/pages/profile.jsp");
        if (IS_PERFORM_LOGGING) logIn(ENDING_WORK_MESSAGE_TEMPLATE.formatted(SERVLET_GET_NAME));
    }
}
