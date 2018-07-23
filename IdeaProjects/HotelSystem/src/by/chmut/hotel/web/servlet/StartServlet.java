package by.chmut.hotel.web.servlet;

import by.chmut.hotel.services.RoomService;
import by.chmut.hotel.services.impl.RoomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/start")

public class StartServlet extends HttpServlet {
    private RoomService roomService = RoomServiceImpl.getInstance();
    String MAIN_PAGE ="/WEB-INF/jsp/template.jspx";


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("rooms", roomService.getAllRoom());
        req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
    }
}
