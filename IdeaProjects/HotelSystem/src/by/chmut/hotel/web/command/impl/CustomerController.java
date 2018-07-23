package by.chmut.hotel.web.command.impl;

import by.chmut.hotel.services.UserService;
import by.chmut.hotel.services.impl.UserServiceImpl;
import by.chmut.hotel.web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.chmut.hotel.web.constant.Constants.MAIN_PAGE;

public class CustomerController implements Controller {
    private UserService userService =UserServiceImpl.getInstance();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        if (req.getSession().getAttribute("user") == null) {
            req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
            req.getSession().setAttribute("errorMsg", "");
        } else {
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/frontController?pageName=reservation");
        }
    }
}
