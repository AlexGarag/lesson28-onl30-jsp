package by.tms.lesson28.onl30.jsp.servlets;

import by.tms.lesson28.onl30.jsp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.*;
import static by.tms.lesson28.onl30.jsp.servants.MyLogger.logIn;

@WebServlet(urlPatterns = "/user/registration")
public class UserRegistrationServlet extends HttpServlet {
    private static final String SERVLET_GET_NAME = "DoGetUserRegistrationServlet";
    private static final String SERVLET_POST_NAME = "DoPostUserRegistrationServlet";
//    private static final String FIRST_OPERAND_PARAMETER = "num1";
//    private static final String SECOND_OPERAND_PARAMETER = "num2";
//    private static final String TYPE_OPERATION_PARAMETER = "type";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (IS_PERFORM_LOGGING) logIn(BEGINNING_WORK_MESSAGE_TEMPLATE.formatted(SERVLET_GET_NAME));
        getServletContext().getRequestDispatcher(REGISTRATION_PAGE).forward(req, resp);
        if (IS_PERFORM_LOGGING) logIn(ENDING_WORK_MESSAGE_TEMPLATE.formatted(SERVLET_GET_NAME));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (IS_PERFORM_LOGGING) logIn(BEGINNING_WORK_MESSAGE_TEMPLATE.formatted(SERVLET_POST_NAME));
        String nameUser = req.getParameter("name");
        String loginUser = req.getParameter("login");
        String passwordUser = req.getParameter("password");
        User user = new User(nameUser, loginUser, passwordUser);
        resp.sendRedirect("/");
        if (IS_PERFORM_LOGGING) logIn(ENDING_WORK_MESSAGE_TEMPLATE.formatted(SERVLET_POST_NAME));
    }
}
