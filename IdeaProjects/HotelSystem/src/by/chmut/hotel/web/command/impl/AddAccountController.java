package by.chmut.hotel.web.command.impl;

import by.chmut.hotel.entities.User;
import by.chmut.hotel.services.UserService;
import by.chmut.hotel.services.impl.UserServiceImpl;
import by.chmut.hotel.web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddAccountController implements Controller {
    private UserService userService = UserServiceImpl.getInstance();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        User user = userService.addUser(req.getParameter("login"),req.getParameter("password"),req.getParameter("firstName"),req.getParameter("lastName"),
                req.getParameter("email"), req.getParameter("phone"), req.getParameter("country"),req.getParameter("city"),
                req.getParameter("address"), req.getParameter("zip"));
        String contextPath = req.getContextPath();
        if (user == null) {
            req.getSession().setAttribute("errorMsg","haveuser");
            resp.sendRedirect(contextPath + "/frontController?pageName=add_account");
        } else {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect(contextPath + "/frontController?pageName=reservation");
        }
    }
}
