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
    private static volatile RoomService INSTANCE;
    @Override
    public Room save(Room room) {
        try {
            startTransaction();
            room = roomDao.save(room);
            commit();
        } catch (SQLException e) {
            throw new ServiceException("Error creating Room with");
        }
        return room;
    }

    @Override
    public Room get(Serializable id) {
        try {
            startTransaction();
            Room room = roomDao.get(id);
            commit();
            return room;
        } catch (SQLException e) {
            throw new ServiceException("Error get Room with");
        }
    }

    @Override
    public void update(Room room) {
        try {
            startTransaction();
            roomDao.update(room);
            commit();
        } catch (SQLException e) {
            throw new ServiceException("Error update Room with");
        }
    }

    @Override
    public int delete(Serializable id) {
        try {
            startTransaction();
            int rows = roomDao.delete(id);
            commit();
            return rows;
        } catch (SQLException e) {
            throw new ServiceException("Error delete Room with");
        }
    }

    @Override
    public List<Room> getRoomOnDateAndBedType(int bedType, LocalDate checkIn, LocalDate checkOut) {
        try {
            startTransaction();
            List<Room> room = roomDao.getRoomOnDateAndBedType(bedType,checkIn,checkOut);
            commit();
            return room;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Room> getAllRoom() {
        try {
            startTransaction();
            List<Room> room = roomDao.getAllRoom();
            commit();
            return room;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    public static RoomService getInstance() {
        RoomService roomService = INSTANCE;
        if (roomService == null) {
            synchronized (RoomServiceImpl.class) {
                roomService = INSTANCE;
                if (roomService == null) {
                    INSTANCE = roomService = new RoomServiceImpl();
                }
            }
        }
        return roomService;
    }
}
