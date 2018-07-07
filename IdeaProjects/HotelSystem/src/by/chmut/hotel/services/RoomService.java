package by.chmut.hotel.services;

import by.chmut.hotel.entities.Room;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface RoomService {

    Room save(Room room);

    Room get(Serializable id);

    void update(Room room);

    int delete(Serializable id);

    Room getRoomOnDateAndBedType(int bedType, LocalDate checkIn, LocalDate checkOut);

    List<Room> getAllRoom();
}
