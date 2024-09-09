package by.tms.lesson28.onl30.jsp.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.tms.lesson28.onl30.jsp.everything.KeeperConstants.*;

@WebFilter(urlPatterns = {LOGIN_PATH, REGISTRATION_PATH})
public class SecurityFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getSession().getAttribute(CURRENT_USER_ATTRIBUTE) == null) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect(HOME_PATH);
        }
    }
}
