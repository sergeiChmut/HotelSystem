package by.chmut.hotel.web.command.impl;

import by.chmut.hotel.services.RoomService;
import by.chmut.hotel.services.impl.RoomServiceImpl;
import by.chmut.hotel.web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.chmut.hotel.web.constant.Constants.MAIN_PAGE;

public class DefaultController implements Controller {
    private RoomService roomService =RoomServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getSession().setAttribute("rooms", roomService.getAllRoom());
//        req.getSession().setAttribute("path", req.getRequestURI());

        req.getRequestDispatcher(MAIN_PAGE).forward(req,resp);
//        String pagePath = (String) req.getSession().getAttribute("pagePath");
    }
}
