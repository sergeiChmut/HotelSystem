package by.chmut.hotel.web.command.impl;

import by.chmut.hotel.entities.Reservation;
import by.chmut.hotel.entities.Room;
import by.chmut.hotel.entities.User;
import by.chmut.hotel.services.ReservationService;
import by.chmut.hotel.services.RoomService;
import by.chmut.hotel.services.impl.ReservationServiceImpl;
import by.chmut.hotel.services.impl.RoomServiceImpl;
import by.chmut.hotel.web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static by.chmut.hotel.web.constant.Constants.MAIN_PAGE;

public class ReservationController implements Controller {
    private RoomService roomService = RoomServiceImpl.getInstance();
    private ReservationService reservationService = ReservationServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        double totalSum;
        User user = (User) session.getAttribute("user");
        // search - if user user has paid reservation - set to session
        if (user != null) {
            List<Reservation> lastReservations = reservationService.getByUserId(user.getId());
            if (!lastReservations.isEmpty()) {
                List<Room> paidRooms = new ArrayList<>();
                for (Reservation reservation : lastReservations) {
                    paidRooms.add(roomService.get(reservation.getRoomId()));
                }
                session.setAttribute("paidRooms", paidRooms);
            }
        }
        if (session.getAttribute("totalSum") != null) {
            totalSum = (Double) session.getAttribute("totalSum");
        } else {
            totalSum = 0;
            session.setAttribute("totalSum", totalSum);
        }
        // Add room
        List<Room> roomTemp = new ArrayList<>();
        if (session.getAttribute("roomTemp") != null) {
            roomTemp = (List<Room>) session.getAttribute("roomTemp");
        }
        if ((session.getAttribute("roomId") != null) && (req.getParameter("delete") == null)) {
            int roomId = (Integer) session.getAttribute("roomId");
            session.removeAttribute("roomId");
            Room room = roomService.get(roomId);
            room.setCheckIn((LocalDate) req.getSession().getAttribute("checkIn"));
            room.setCheckOut((LocalDate) req.getSession().getAttribute("checkOut"));
            roomTemp.add(room);
            totalSum = (Double) session.getAttribute("totalSum") + room.getPrice();
            session.setAttribute("totalSum", totalSum);
            session.setAttribute("roomTemp", roomTemp);
        }
        // Remove room
        if (req.getParameter("delete") != null) {
            int delIndex = -1;
            for (int i = 0; i < roomTemp.size(); i++) {
                Room room = roomTemp.get(i);
                if (room.getId() == (int) (session.getAttribute("roomId"))) {
                    delIndex = i;
                    totalSum = (Double) session.getAttribute("totalSum") - room.getPrice();
                    session.setAttribute("totalSum", totalSum);
                    session.removeAttribute("roomId");
                }
            }
            if (delIndex != -1) {
                roomTemp.remove(delIndex);
                session.setAttribute("roomTemp", roomTemp);
            }
        }
        if (roomTemp.isEmpty()) {
            req.setAttribute("emptyMsg", "reserv.emptyList");
        }
        req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
    }

}
