package by.chmut.hotel.web.command.impl;

import by.chmut.hotel.entities.Room;
import by.chmut.hotel.services.RoomService;
import by.chmut.hotel.services.impl.RoomServiceImpl;
import by.chmut.hotel.web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static by.chmut.hotel.web.constant.Constants.MAIN_PAGE;

public class SearchController implements Controller {
    private RoomService roomService = RoomServiceImpl.getInstance();


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String bedType = req.getParameter("bedtype");
        String checkIn = req.getParameter("checkin");
        String checkOut = req.getParameter("checkout");
        LocalDate checkInDate;
        LocalDate checkOutDate;
        int bedTypeInt;
        List<Room> rooms = new ArrayList<>();
        if (bedType == null||checkIn==null||checkOut==null) {
            rooms = roomService.getAllRoom();
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            checkInDate = LocalDate.parse(checkIn,formatter);
            checkOutDate = LocalDate.parse(checkOut,formatter);
            bedTypeInt = Integer.parseInt(bedType);
            req.getSession().setAttribute("checkIn",checkInDate);
            req.getSession().setAttribute("checkOut",checkOutDate);
            rooms = roomService.getRoomOnDateAndBedType(bedTypeInt,
                    checkInDate, checkOutDate);
        }
        req.getSession().setAttribute("rooms", rooms);
        req.getRequestDispatcher(MAIN_PAGE).forward(req,resp);


    }
}
