package by.chmut.hotel.dao;

import by.chmut.hotel.entities.User;

import java.sql.SQLException;

public interface UserDao extends Dao<User> {
    public User getUserByLogin(String login) throws SQLException;
}
