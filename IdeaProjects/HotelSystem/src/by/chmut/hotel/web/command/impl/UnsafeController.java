package by.chmut.hotel.web.command.impl;

import by.chmut.hotel.web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.chmut.hotel.web.constant.Constants.MAIN_PAGE;

public class UnsafeController implements Controller {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher(MAIN_PAGE).forward(req,resp);
    }
}
