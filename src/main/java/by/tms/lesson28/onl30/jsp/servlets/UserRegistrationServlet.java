package by.tms.lesson28.onl30.jsp.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.*;
import static by.tms.lesson28.onl30.jsp.servants.MyLogger.logIn;

@WebServlet(urlPatterns = "/user/reg")
public class UserRegistrationServlet extends HttpServlet {
    private static final String SERVLET_NAME = "UserRegistrationServlet";
//    private static final String FIRST_OPERAND_PARAMETER = "num1";
//    private static final String SECOND_OPERAND_PARAMETER = "num2";
//    private static final String TYPE_OPERATION_PARAMETER = "type";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (IS_PERFORM_LOGGING) logIn(MESSAGE_BEGINNING_WORK_TEMPLATE.formatted(SERVLET_NAME));
        super.doGet(req, resp);

        if (IS_PERFORM_LOGGING) logIn(MESSAGE_ENDING_WORK_TEMPLATE.formatted(SERVLET_NAME));
    }
}
