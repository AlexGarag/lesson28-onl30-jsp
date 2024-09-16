package by.tms.lesson28.onl30.jsp.servlets;

import by.tms.lesson28.onl30.jsp.interfaces.FileSaver;
import by.tms.lesson28.onl30.jsp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.*;
import static by.tms.lesson28.onl30.jsp.servants.MyLogger.logIn;

@WebServlet(urlPatterns = REGISTRATION_PATH)
@MultipartConfig
public class UserRegistrationServlet extends HttpServlet {
    private static final String SERVLET_GET_NAME = "DoGetUserRegistrationServlet";
    private static final String SERVLET_POST_NAME = "DoPostUserRegistrationServlet";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (IS_PERFORM_LOGGING) logIn(BEGINNING_WORK_MESSAGE_TEMPLATE.formatted(SERVLET_GET_NAME));
        getServletContext().getRequestDispatcher(REGISTRATION_PAGE).forward(req, resp);
        if (IS_PERFORM_LOGGING) logIn(ENDING_WORK_MESSAGE_TEMPLATE.formatted(SERVLET_GET_NAME));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        if (IS_PERFORM_LOGGING) logIn(BEGINNING_WORK_MESSAGE_TEMPLATE.formatted(SERVLET_POST_NAME));
        String nameUser = req.getParameter(NAME_USER_PARAMETER);
        String loginUser = req.getParameter(LOGIN_USER_PARAMETER);
        String passwordUser = req.getParameter(PASSWORD_USER_PARAMETER);
        Part avatarUser = req.getPart("avatar");
        byte[] avatarUserBytes = avatarUser.getInputStream().readAllBytes();
        User user = new User(nameUser, loginUser, passwordUser);
        FileSaver fileUsersSaver = new by.tms.lesson28.onl30.jsp.servants.FileSaver();
        fileUsersSaver.save(user);
        resp.sendRedirect("/");
        if (IS_PERFORM_LOGGING) logIn(ENDING_WORK_MESSAGE_TEMPLATE.formatted(SERVLET_POST_NAME));
    }
}
