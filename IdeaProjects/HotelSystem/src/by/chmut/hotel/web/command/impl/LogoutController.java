package by.chmut.hotel.web.command.impl;

import by.chmut.hotel.web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutController implements Controller {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        session.removeAttribute("roomTemp");
        session.removeAttribute("checkIn");
        session.removeAttribute("checkOut");
        session.removeAttribute("totalSum");
        session.removeAttribute("errorMsg");
//        req.getSession().setAttribute("user", null);
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath+ "/frontController?pageName="+req.getSession().getAttribute("prevPage"));
    }
}
