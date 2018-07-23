package by.chmut.hotel.web.command.enums;

import by.chmut.hotel.web.command.Controller;
import by.chmut.hotel.web.command.impl.*;


public enum CommandType {
    HOME("Home", "pages/main.jspx", "/hotel/main", new DefaultController()),
    LOGIN("Login", "", "/hotel/login", new LoginController()),
    LOGOUT("Logout", "", "/hotel/login", new LogoutController()),
    SEARCH("Search", "pages/search.jspx", "/hotel/search", new SearchController()),
    ADD_ACCOUNT("Add_account", "pages/autorization.jspx", "/hotel/customer", new CustomerController()),
    CREATE_USER("Create_user","","" , new AddAccountController()),
    RESERVATION("Reservation", "pages/reservation.jspx", "/hotel/reservation", new ReservationController()),
    PAYMENT("Payment", "pages/payment.jspx", "/hotel/payment", new PaymentController()),
    SETROOMID("SetRoomId", "", "", new SetIdController()),
    UNSAFE("Unsafe", "pages/unsafe.jspx", "/hotel/unsafe", new UnsafeController());

    private String pageName;
    private String pagePath;
    private String contextPath;
    private Controller controller;

    CommandType(String pageName, String pagePath, String contextPath, Controller controller) {
        this.pageName = pageName;
        this.pagePath = pagePath;
        this.contextPath = contextPath;
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
