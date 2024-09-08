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

import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.LOGIN_PAGE;
import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.SLAGE;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {

    private final UserStorage users = new UserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        Optional<User> byUserName = users.findByLogin(login);
        if (byUserName.isPresent()) {
            User user = byUserName.get();
            if (user.getPassword().equals(password)) {
                req.getSession().setAttribute("currentUser", user);
                resp.sendRedirect(SLAGE);
            } else {
                req.setAttribute("message", "Wrong password!");
                req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
            }
        } else {
            req.setAttribute("message", "User not found!");
            req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
        }
    }
}