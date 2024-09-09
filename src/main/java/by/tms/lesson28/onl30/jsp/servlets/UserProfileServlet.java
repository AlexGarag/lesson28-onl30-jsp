package by.tms.lesson28.onl30.jsp.servlets;

import by.tms.lesson28.onl30.jsp.model.User;
import by.tms.lesson28.onl30.jsp.storage.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.*;
import static by.tms.lesson28.onl30.jsp.servants.MyLogger.logIn;

@WebServlet(urlPatterns = PROFILE_PATH)
public class UserProfileServlet extends HttpServlet {
    private static final String SERVLET_GET_NAME = "DoGetUserProfileServlet";
    private final UserStorage users = new UserStorage();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (IS_PERFORM_LOGGING) logIn(BEGINNING_WORK_MESSAGE_TEMPLATE.formatted(SERVLET_GET_NAME));
        String userLogin = req.getParameter(LOGIN_USER_PARAMETER);
        Optional<User> byLogin = users.findByLogin(userLogin);
        if (byLogin.isPresent()) {
            User user = byLogin.get();
            String avatarString = Base64.getEncoder().encodeToString(user.getAvatarUser());
            req.setAttribute(USER_PARAMETER,user);
            req.setAttribute("avatar",avatarString);
        }
        getServletContext().getRequestDispatcher(PROFILE_PAGE).forward(req, resp);
        if (IS_PERFORM_LOGGING) logIn(ENDING_WORK_MESSAGE_TEMPLATE.formatted(SERVLET_GET_NAME));
    }
}
