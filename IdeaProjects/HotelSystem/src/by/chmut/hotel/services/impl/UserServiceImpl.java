package by.chmut.hotel.services.impl;

import by.chmut.hotel.dao.UserDao;
import by.chmut.hotel.dao.impl.UserDaoImpl;
import by.chmut.hotel.entities.User;
import by.chmut.hotel.services.UserService;

import java.sql.SQLException;

public class UserServiceImpl extends AbstractService implements UserService {
    private UserDao userDao = UserDaoImpl.getInstance();
    private static volatile UserService INSTANCE;
    @Override
    public User getUserByLogin(String login) {
        try {
            startTransaction();
            User user = userDao.getUserByLogin(login);
            commit();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User addUser(String login, String password, String name, String lastName, String email, String phone, String country,
                        String city, String address, String zip) {
        try {
            startTransaction();
            User user = userDao.getUserByLogin(login);
            if (user == null) {
                user = new User(login, password, name, lastName, "user", email, phone, country, city, address, zip);
                user = userDao.save(user);
            } else {
                user = null;
            }
            commit();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static UserService getInstance() {
        UserService userService = INSTANCE;
        if (userService == null) {
            synchronized (UserServiceImpl.class) {
                userService = INSTANCE;
                if (userService == null) {
                    INSTANCE = userService = new UserServiceImpl();
                }
            }
        }
        return userService;
    }
}
