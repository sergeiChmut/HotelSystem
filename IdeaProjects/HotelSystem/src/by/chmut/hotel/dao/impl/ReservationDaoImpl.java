package by.chmut.hotel.dao.impl;

import by.chmut.hotel.dao.AbstractDao;
import by.chmut.hotel.dao.ReservationDao;
import by.chmut.hotel.entities.Reservation;
import by.chmut.hotel.entities.Room;
import by.chmut.hotel.entities.User;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class ReservationDaoImpl extends AbstractDao implements ReservationDao {
    private static volatile ReservationDao INSTANCE = null;
    private static final String saveQuery = "INSERT INTO reservation (userId, date, roomId, checkIn, checkOut) " +
            "VALUES (?, now(),?,?,?)";
    private static final String getQuery = "SELECT * FROM reservation WHERE userId=?";
    private static final String updateQuery = "UPDATE reservation SET roomId=?, checkIn=?, checkOut=? WHERE userId=?";
    private static final String deleteQuery = "DELETE FROM reservation WHERE Id=?";


    public Reservation makeReservation(User user, Room room) throws SQLException {
        Reservation reservation = newReservation(user, room);
        PreparedStatement psReservation = prepareStatement(saveQuery, Statement.RETURN_GENERATED_KEYS);
        psReservation.setInt(1, user.getId());
        psReservation.setInt(2, room.getRoomNumber());
        psReservation.setDate(3, java.sql.Date.valueOf(room.getCheckIn()));
        psReservation.setDate(4, java.sql.Date.valueOf(room.getCheckOut()));
        psReservation.executeUpdate();
        ResultSet rs = psReservation.getGeneratedKeys();
        if (rs.next()) {
            reservation.setId(rs.getInt(1));
        }
        close(rs);
        return reservation;
    }

    private Reservation newReservation(User user, Room room) {
        Reservation reservation = new Reservation();
        reservation.setUserId(user.getId());
        reservation.setDate(LocalDate.now());
        reservation.setRoomId(room.getRoomNumber());
        reservation.setCheckIn(room.getCheckIn());
        reservation.setCheckOut(room.getCheckOut());
        return reservation;
    }

    private Reservation setFromResultSet(ResultSet rs) throws SQLException {
        Reservation reservation = new Reservation();
        reservation.setId(rs.getInt(1));
        reservation.setUserId(rs.getInt(2));
        reservation.setDate(rs.getDate(3).toLocalDate());
        reservation.setRoomId(rs.getInt(4));
        reservation.setCheckIn(rs.getDate(5).toLocalDate());
        reservation.setCheckOut(rs.getDate(6).toLocalDate());
        return reservation;
    }

    @Override
    public Reservation save(Reservation reservation) throws SQLException {
        return null;
    }

    @Override
    public Reservation get(Serializable id) throws SQLException {
        PreparedStatement psGetReservation = prepareStatement(getQuery);
        psGetReservation.setInt(1, (int) id);
        ResultSet rs = psGetReservation.executeQuery();
        return setFromResultSet(rs);
    }

    @Override
    public void update(Reservation reservation) throws SQLException {
        PreparedStatement psUpdateReservation = prepareStatement(updateQuery);
        psUpdateReservation.setInt(4, reservation.getUserId());
        psUpdateReservation.setInt(1, reservation.getRoomId());
        psUpdateReservation.setDate(2, java.sql.Date.valueOf(reservation.getCheckIn()));
        psUpdateReservation.setDate(3, java.sql.Date.valueOf(reservation.getCheckOut()));
        psUpdateReservation.executeUpdate();
    }

    @Override
    public int delete(Serializable id) throws SQLException {
        PreparedStatement psDelete = prepareStatement(deleteQuery);
        psDelete.setInt(1, (int) id);
        return psDelete.executeUpdate();
    }

    public static ReservationDao getInstance() {
        ReservationDao reservationDao = INSTANCE;
        if (reservationDao == null) {
            synchronized (ReservationDaoImpl.class) {
                reservationDao = INSTANCE;
                if (reservationDao == null) {
                    INSTANCE = reservationDao = new ReservationDaoImpl();
                }
            }
        }
        return reservationDao;
    }
}
