package by.chmut.hotel.dao;


import by.chmut.hotel.entities.Reservation;
import by.chmut.hotel.entities.Room;
import by.chmut.hotel.entities.User;

import java.sql.SQLException;

public interface ReservationDao extends Dao<Reservation> {
    public Reservation makeReservation(User user, Room room) throws SQLException;
}
