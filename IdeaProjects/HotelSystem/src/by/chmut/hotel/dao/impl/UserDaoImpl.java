package by.chmut.hotel.dao.impl;

import by.chmut.hotel.dao.AbstractDao;
import by.chmut.hotel.dao.UserDao;
import by.chmut.hotel.entities.User;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoImpl extends AbstractDao implements UserDao {
    private static volatile UserDao INSTANCE = null;
    private static final String selectUserByLogin = "SELECT * FROM users WHERE login=?";
    private static final String selectUserById = "SELECT * FROM users WHERE id=?";
    private static final String addUser = "INSERT INTO users (login, password, name, lastname, country, address," +
            "city, zip, telephone) VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String updateUser = "UPDATE users SET name=?, lastname=?, country=?, address=?," +
            "city=?, zip=?, telephone=? WHERE id=?)";
    private static final String deleteUser = "DELETE FROM users WHERE id=?";

    public User getUserByLogin(String login) throws SQLException {
        PreparedStatement ps = prepareStatement(selectUserByLogin);
        ps.setString(1,login);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return setUserFromResultSet(rs);
        }
        close(rs);
        return null;
    }
    private User setUserFromResultSet(ResultSet rs) throws SQLException{
        User user = new User();
        user.setId(rs.getInt(1));
        user.setLogin(rs.getString(2));
        user.setPassword(rs.getString(3));
        user.setName(rs.getString(4));
        user.setLastname(rs.getString(5));
        user.setCountry(rs.getString(6));
        user.setAddress(rs.getString(7));
        user.setCity(rs.getString(8));
        user.setZip(rs.getString(9));
        user.setTelephone(rs.getString(10));
        return user;
    }
    @Override
    public User save(User user) throws SQLException {
        PreparedStatement psSave = prepareStatement(addUser,Statement.RETURN_GENERATED_KEYS);
        psSave.setString(1,user.getLogin());
        psSave.setString(2,user.getPassword());
        psSave.setString(3,user.getName());
        psSave.setString(4,user.getLastname());
        psSave.setString(5,user.getCountry());
        psSave.setString(6,user.getAddress());
        psSave.setString(7,user.getCity());
        psSave.setString(8,user.getZip());
        psSave.setString(9,user.getTelephone());
        psSave.executeUpdate();
        ResultSet rs = psSave.getGeneratedKeys();
        if (rs.next()) {
            user.setId(rs.getInt(1));
        }
        close(rs);
        return user;
    }

    @Override
    public User get(Serializable id) throws SQLException {
        PreparedStatement psGet = prepareStatement(selectUserById);
        psGet.setInt(1, (int)id);
        ResultSet rs = psGet.executeQuery();
        if (rs.next()) {
            return setUserFromResultSet(rs);
        }
        close(rs);
        return null;
    }

    @Override
    public void update(User user) throws SQLException {
        PreparedStatement psUpdate = prepareStatement(updateUser);
        psUpdate.setInt(8,user.getId());
        psUpdate.setString(1,user.getName());
        psUpdate.setString(2,user.getLastname());
        psUpdate.setString(3,user.getCountry());
        psUpdate.setString(4,user.getAddress());
        psUpdate.setString(5,user.getCity());
        psUpdate.setString(6,user.getZip());
        psUpdate.setString(7,user.getTelephone());
        psUpdate.executeUpdate();
    }

    @Override
    public int delete(Serializable id) throws SQLException {
        PreparedStatement psDelete = prepareStatement(deleteUser);
        psDelete.setInt(1,(int)id);
        return psDelete.executeUpdate();
    }

    public static UserDao getInstance() {
        UserDao userDao = INSTANCE;
        if (userDao == null) {
            synchronized (UserDaoImpl.class) {
                userDao = INSTANCE;
                if (userDao == null) {
                    INSTANCE = userDao = new UserDaoImpl();
                }
            }
        }

        return userDao;
    }
}
