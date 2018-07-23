package by.chmut.hotel.web.command.impl;

import by.chmut.hotel.entities.Reservation;
import by.chmut.hotel.entities.Room;
import by.chmut.hotel.entities.User;
import by.chmut.hotel.services.ReservationService;
import by.chmut.hotel.services.impl.ReservationServiceImpl;
import by.chmut.hotel.web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static by.chmut.hotel.web.constant.Constants.MAIN_PAGE;

public class PaymentController implements Controller {
    private ReservationService reservationService = ReservationServiceImpl.getInstance();


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        // Create reservation
        if (("1234567890".equals(req.getParameter("payment")))&&(session.getAttribute("roomTemp") != null)&&
                session.getAttribute("user") != null) {
            List<Room> rooms = (List<Room>) session.getAttribute("roomTemp");
            User user = (User) session.getAttribute("user");
            int userId = (int) user.getId();
            for (Room room:rooms) {
                Reservation reservation = new Reservation();
                reservation.setUserId(userId);
                reservation.setRoomId(room.getId());
                reservation.setDate(LocalDate.now());
                reservationService.save(reservation);
            }
            // Remove attribute
            session.removeAttribute("roomTemp");
            session.removeAttribute("checkIn");
            session.removeAttribute("checkOut");
            session.removeAttribute("totalSum");
            // Set success )))
            session.setAttribute("success","yes!");
        }
        // set payment
        String numCard = req.getParameter("numCard");
        String nameCard = req.getParameter("nameCard");
        String cvc2 = req.getParameter("cvc2");
        if ((numCard!=null)&&(nameCard!=null)&&(cvc2!=null)) {
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath+ "/frontController?pageName=payment&payment=1234567890");
        } else {

            req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
        }
    }
}
