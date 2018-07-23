package by.chmut.hotel.web.servlet;

import by.chmut.hotel.web.command.enums.CommandType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/frontController")
public class FrontController extends HttpServlet {
    private String pageName;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageName = req.getParameter("pageName");
        if (pageName == null || pageName.isEmpty()) {
            pageName = "home";
        }
        HttpSession session = req.getSession();
        //        String name2= req.getRequestURI();
//        if (pageName == null || pageName.isEmpty()) {
//            command = CommandType.selectCommand(name2);
//            pageName = "home";
//        } else {
//        }
//        req.getSession().setAttribute("name2",name2);
        CommandType command = CommandType.selectCommand(pageName);
        session.setAttribute("pagePath",command.getPagePath());
        req.setAttribute("title",command.getPageName());
        command.getController().execute(req,resp);
        session.setAttribute("prevPage",pageName);

    }
}
