package by.chmut.hotel.dao.impl;

import by.chmut.hotel.dao.AbstractDao;
import by.chmut.hotel.dao.RoomDao;
import by.chmut.hotel.entities.Room;


import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl extends AbstractDao implements RoomDao {
    private static volatile RoomDao INSTANCE = null;
    private static final String selectById = "SELECT * FROM Rooms WHERE roomNumber=?";
    private static final String selectAllRoom = "SELECT * FROM Rooms";
    private static final String selectOnDateAndBedType = "SELECT * FROM Rooms WHERE bedType>=? AND (?>=checkOut|?<=checkIn)";

    private static final String addRoom = "INSERT INTO Rooms (roomNumber, type, bedType, price, checkIn, checkOut, description) " +
            "VALUES (?,?,?,?, now(), now(),?)";
    private static final String updateRoom = "UPDATE Rooms SET type=?, bedType=?, price=?, checkIn=?, checkOut=?," +
            " description=? WHERE roomNumber=?";
//    private static final String updateRoomBedType = "UPDATE Rooms SET bedType=? WHERE roomNumber=?";
//    private static final String updateRoomPrice = "UPDATE Rooms SET price=? WHERE roomNumber=?";
//    private static final String updateRoomCheckIn = "UPDATE Rooms SET checkIn=? WHERE roomNumber=?";
//    private static final String updateRoomCheckOut = "UPDATE Rooms SET checkOut=? WHERE roomNumber=?";
//    private static final String updateRoomDescription = "UPDATE Rooms SET description=? WHERE roomNumber=?";

    private static final String deleteRoom = "DELETE FROM rooms WHERE roomNumber=?";

    private Room setRoomFromResultSet(ResultSet rs) throws SQLException {
        Room room = new Room();
        room.setRoomNumber(rs.getInt(1));
        room.setType(rs.getString(2));
        room.setBedType(rs.getInt(3));
        room.setPrice(rs.getDouble(4));
        room.setCheckIn(rs.getDate(5).toLocalDate());
        room.setCheckOut(rs.getDate(6).toLocalDate());
        room.setDescription(rs.getString(7));
        return room;
    }
    public List<Room> getAllRoom() throws SQLException {
        List<Room> list = new ArrayList<>();
        PreparedStatement psGetAll = prepareStatement(selectAllRoom);
        ResultSet rs = psGetAll.executeQuery();
        while (rs.next()) {
            list.add(setRoomFromResultSet(rs));
        }
        close(rs);
        return list;
    }
    public List<Room> getRoomOnDateAndBedType(int bedType, LocalDate checkIn, LocalDate checkOut) throws SQLException{
        List<Room> list = new ArrayList<>();
        PreparedStatement psSearchRoom = prepareStatement(selectOnDateAndBedType);
        psSearchRoom.setInt(1,bedType);
        psSearchRoom.setDate(2,java.sql.Date.valueOf(checkIn));
        psSearchRoom.setDate(3,java.sql.Date.valueOf(checkOut));
        ResultSet rs = psSearchRoom.executeQuery();
        while (rs.next()) {
            list.add(setRoomFromResultSet(rs));
        }
        close(rs);
        return list;
    }
//    public void setRoomType(Room room) throws SQLException {
//        PreparedStatement psUpdate = prepareStatement(updateRoomType);
//        psUpdate.setString(1,room.getType());
//        psUpdate.executeUpdate();
//    }
//    public void setRoomBedType(Room room) throws SQLException {
//        PreparedStatement psUpdate = prepareStatement(updateRoomBedType);
//        psUpdate.setInt(1,room.getBedType());
//        psUpdate.executeUpdate();
//    }
//    public void setRoomPrice(Room room) throws SQLException {
//        PreparedStatement psUpdate = prepareStatement(updateRoomPrice);
//        psUpdate.setDouble(1,room.getPrice());
//        psUpdate.executeUpdate();
//    }
//    public void setRoomCheckIn(Room room) throws SQLException {
//        PreparedStatement psUpdate = prepareStatement(updateRoomCheckIn);
//        psUpdate.setDate(1,java.sql.Date.valueOf(room.getCheckIn()));
//        psUpdate.executeUpdate();
//    }
//    public void setRoomCheckOut(Room room) throws SQLException {
//        PreparedStatement psUpdate = prepareStatement(updateRoomCheckOut);
//        psUpdate.setDate(1,java.sql.Date.valueOf(room.getCheckOut()));
//        psUpdate.executeUpdate();
//    }
//    public void setUpdateRoomDescription(Room room) throws SQLException {
//        PreparedStatement psUpdate = prepareStatement(updateRoomDescription);
//        psUpdate.executeUpdate();
//    }
    @Override
    public Room save(Room room) throws SQLException {
        PreparedStatement psSave = prepareStatement(addRoom);
        psSave.setInt(1,room.getRoomNumber());
        psSave.setString(2,room.getType());
        psSave.setInt(3,room.getBedType());
        psSave.setDouble(4,room.getPrice());
        psSave.setString(5,room.getDescription());
        psSave.executeUpdate();
        return room;
    }

    @Override
    public Room get(Serializable id) throws SQLException {
        PreparedStatement psGet = prepareStatement(selectById);
        psGet.setInt(1, (int)id);
        ResultSet rs = psGet.executeQuery();
        if (rs.next()) {
            return setRoomFromResultSet(rs);
        }
        close(rs);
        return null;
    }

    @Override
    public void update(Room room) throws SQLException {
        PreparedStatement psUpdate = prepareStatement(updateRoom);
        psUpdate.setInt(7,room.getRoomNumber());
        psUpdate.setString(1,room.getType());
        psUpdate.setInt(2,room.getBedType());
        psUpdate.setDouble(3,room.getPrice());
        psUpdate.setDate(4,java.sql.Date.valueOf(room.getCheckIn()));
        psUpdate.setDate(5,java.sql.Date.valueOf(room.getCheckOut()));
        psUpdate.setString(6,room.getDescription());
        psUpdate.executeUpdate();
    }

    @Override
    public int delete(Serializable id) throws SQLException {
        PreparedStatement psDelete = prepareStatement(deleteRoom);
        psDelete.setInt(1,(int)id);
        return psDelete.executeUpdate();
    }

    public static RoomDao getInstance() {
        RoomDao roomDao = INSTANCE;
        if (roomDao == null) {
            synchronized (UserDaoImpl.class) {
                roomDao = INSTANCE;
                if (roomDao == null) {
                    INSTANCE = roomDao = new RoomDaoImpl();
                }
            }
        }
        return roomDao;
    }


    
}
