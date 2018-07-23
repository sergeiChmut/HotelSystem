package by.chmut.hotel.web.command.enums;

import by.chmut.hotel.web.command.Controller;
import by.chmut.hotel.web.command.impl.*;


public enum CommandType {
    HOME("Home", "pages/main.jspx", new DefaultController()),
    LOGIN("Login", "",  new LoginController()),
    LOGOUT("Logout", "", new LogoutController()),
    SEARCH("Search", "pages/search.jspx", new SearchController()),
    ADD_ACCOUNT("Add_account", "pages/autorization.jspx", new CustomerController()),
    CREATE_USER("Create_user","", new AddAccountController()),
    RESERVATION("Reservation", "pages/reservation.jspx", new ReservationController()),
    PAYMENT("Payment", "pages/payment.jspx", new PaymentController()),
    SETROOMID("SetRoomId", "", new SetIdController());

    private String pageName;
    private String pagePath;
    private Controller controller;

    CommandType(String pageName, String pagePath, Controller controller) {
        this.pageName = pageName;
        this.pagePath = pagePath;
        this.controller = controller;
    }

    public static CommandType selectCommand(String pageName) {
            for (CommandType type : CommandType.values()) {
                if (type.pageName.equalsIgnoreCase(pageName)) {
                    return type;
                }
            }
        return HOME;
    }

    public String getPageName() {
        return pageName;
    }


    public String getPagePath() {
        return pagePath;
    }

    public Controller getController() {
        return controller;
    }
}
