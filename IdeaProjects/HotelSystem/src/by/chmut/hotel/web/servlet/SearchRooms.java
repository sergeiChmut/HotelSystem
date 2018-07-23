package by.chmut.hotel.web.servlet;

import by.chmut.hotel.entities.Room;
import by.chmut.hotel.services.RoomService;
import by.chmut.hotel.services.impl.RoomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/search")
public class SearchRooms extends HttpServlet {
    private RoomService roomService = RoomServiceImpl.getInstance();
    private List<Room> rooms;
    private int bedType;
    private  LocalDate checkIn;
    private  LocalDate checkOut;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        bedType = 1;
//        checkIn = LocalDate.parse("2018-07-07");
//        checkOut = LocalDate.parse("2018-07-12");
//        if (req.getParameter("bedType") != null) {
//            bedType = Integer.parseInt(req.getParameter("bedType"));
//        }
//        if (req.getParameter("checkIn") != null) {
//            checkIn = LocalDate.parse(req.getParameter("checkIn"));
//        }
//        if (req.getParameter("checkOut") != null) {
//            checkOut = LocalDate.parse(req.getParameter("checkOut"));
//        }
//        rooms = roomService.getRoomOnDateAndBedType(bedType, checkIn, checkOut);
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding("UTF-8");
//        PrintWriter writer = resp.getWriter();
//
//        writer.write("<html><head><style>" +
//                "table {" +
//                "    font-family: arial, sans-serif;" +
//                "    border-collapse: collapse;" +
//                "    width: 100%;}" +
//                "td, th {" +
//                "    border: 1px solid #dddddd;" +
//                "    text-align: left;" +
//                "    padding: 8px;}" +
//                "tr:nth-child(even) {" +
//                "    background-color: #dddddd;}" +
//                "</style>" +
//                "</head>");
//        writer.write("<body><form method=\"post\" action=\"search\">Количество персон:<br><input type=\"text\" name=\"bedType\"/> <br><br>");
//        writer.write("Дата заезда : <br><input type=\"text\" name=\"checkIn\"/><br><br>");
//        writer.write("Дата отъезда : <br><input type=\"text\" name=\"checkOut\"/><br><br>");
//        writer.write("<input type=\"submit\" value=\"Поиск\"></form><br><br><h1> Список доступных номеров </h1>");
//        writer.write("<table><tr><th>№</th><th>Тип номера</th><th class=\"text-right\">Кол-во персон</th><th>Описание</th><th>Цена, руб.</th></tr>");
//        int num = 1;
//        for (Room room : rooms) {
//            writer.write("<tr><td>" + num + "</td><td>" + room.getType() + "</td><td class=\"text-right\">" + room.getBedType() + "</td><td>" + room.getDescription() +
//                    "</td><td>" + room.getPrice() + "</td></tr>");
//            num++;
//        }
//        writer.write("</table></body></html>");
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        boolean noParameter = false;
//        Enumeration<String> parameterNames = req.getParameterNames();
//        while (parameterNames.hasMoreElements()) {
//            if ((parameterNames.nextElement().equals("bedType") & (parameterNames.equals("checkIn")) & (parameterNames.equals("checkOut")))) {
//                noParameter = true;
//            }
//
//            parameterNames.nextElement();
//        }
//        int bedType = 1;
//        LocalDate checkIn = LocalDate.parse("2018-07-07");
//        LocalDate checkOut = LocalDate.parse("2018-07-12");
//        if (!(req.getParameter("bedType").isEmpty())&(!req.getParameter("checkIn").isEmpty())&(!req.getParameter("checkOut").isEmpty())) {
//            bedType = Integer.parseInt(req.getParameter("bedType"));
//            checkIn = LocalDate.parse(req.getParameter("checkIn"));
//            checkOut = LocalDate.parse(req.getParameter("checkOut"));
//            rooms = roomService.getRoomOnDateAndBedType(bedType, checkIn, checkOut);
//        } else {
//            rooms = roomService.getAllRoom();
//        }
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding("UTF-8");
//        PrintWriter writer = resp.getWriter();
//        writer.write("<html><head><style>" +
//                "table {" +
//                "    font-family: arial, sans-serif;" +
//                "    border-collapse: collapse;" +
//                "    width: 100%;}" +
//                "td, th {" +
//                "    border: 1px solid #dddddd;" +
//                "    text-align: left;" +
//                "    padding: 8px;}" +
//                "tr:nth-child(even) {" +
//                "    background-color: #dddddd;}" +
//                "</style>" +
//                "</head>" +
//                "<body><h1> Список доступных номеров </h1>");
//        writer.write("<table><tr><th>№</th><th>Тип номера</th><th  class=\"text-right\">Кол-во персон</th><th>Описание</th><th>Цена, руб.</th></tr>");
//        int num = 1;
//        for (Room room : rooms) {
//            writer.write("<tr><td>" + num + "</td><td>" + room.getType() + "</td><td  class=\"text-right\">" + room.getBedType() + "</td><td>" + room.getDescription() +
//                    "</td><td>" + room.getPrice() + "</td></tr>");
//            num++;
//        }
//        writer.write("</table></body></html>");
//
    }
}
