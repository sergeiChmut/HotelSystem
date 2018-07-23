package by.chmut.hotel.web.command.impl;

import by.chmut.hotel.web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetIdController implements Controller {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int roomId = Integer.parseInt(req.getParameter("roomId"));
        req.getSession().setAttribute("roomId",roomId);
    }
}
