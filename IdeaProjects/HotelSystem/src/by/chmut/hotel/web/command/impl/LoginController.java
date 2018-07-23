package by.chmut.hotel.web.command.impl;

import by.chmut.hotel.entities.User;
import by.chmut.hotel.services.UserService;
import by.chmut.hotel.services.impl.UserServiceImpl;
import by.chmut.hotel.web.command.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.chmut.hotel.web.constant.Constants.MAIN_PAGE;

public class LoginController implements Controller {
    private UserService userService =UserServiceImpl.getInstance();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("uname");
        String password = req.getParameter("psw");
        if (login==null || password==null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
            dispatcher.forward(req, resp);
            return;
        }
        User user = userService.getUserByLogin(login);
        String contextPath = req.getContextPath();
        if (user != null && password.equals(user.getPassword())) {
            req.getSession().setAttribute("user", user);
            req.getSession().setAttribute("errorMsg", "");
            resp.sendRedirect(contextPath+ "/frontController?pageName="+req.getSession().getAttribute("prevPage"));
        } else {
            req.getSession().setAttribute("errorMsg", "errorLog");
            resp.sendRedirect(contextPath + "/frontController?pageName=add_account");
        }
    }
}
