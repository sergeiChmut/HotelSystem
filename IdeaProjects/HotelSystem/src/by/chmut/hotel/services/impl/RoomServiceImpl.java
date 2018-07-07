package by.chmut.hotel.services.impl;

import by.chmut.hotel.dao.RoomDao;
import by.chmut.hotel.dao.impl.RoomDaoImpl;
import by.chmut.hotel.entities.Room;
import by.chmut.hotel.services.RoomService;
import by.chmut.hotel.services.ServiceException;

import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class RoomServiceImpl extends AbstractService implements RoomService {
    private RoomDao roomDao = RoomDaoImpl.getInstance();
    @Override
    public Room save(Room room) {
        try {
            startTransaction();
            room = roomDao.save(room);
            commit();
        } catch (SQLException e) {
            throw new ServiceException("Error creating Item with");
        }
        return room;
    }

    @Override
    public Room get(Serializable id) {
        return null;
    }

    @Override
    public void update(Room room) {

    }

    @Override
    public int delete(Serializable id) {
        return 0;
    }

    @Override
    public Room getRoomOnDateAndBedType(int bedType, LocalDate checkIn, LocalDate checkOut) {
        return null;
    }

    @Override
    public List<Room> getAllRoom() {
        return null;
    }
}
