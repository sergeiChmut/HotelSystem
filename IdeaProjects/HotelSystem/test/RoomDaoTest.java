import by.chmut.hotel.database.ConnectionManager;
import by.chmut.hotel.dao.RoomDao;
import by.chmut.hotel.dao.impl.RoomDaoImpl;
import by.chmut.hotel.entities.Room;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class RoomDaoTest {
    private RoomDao roomDao = RoomDaoImpl.getInstance();

    public void initData() {}

    @Test
    public void fullTest() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        connection.setAutoCommit(true);
        int beforeSave = roomDao.getAllRoom().size();
        Room newRoom = roomDao.save(new Room(25,"Люкс",2,125.9,LocalDate.now(),
                LocalDate.now().plusDays(5), "as"));
        int afterSave = roomDao.getAllRoom().size();
        Assert.assertNotSame(beforeSave, afterSave);

//        connection.rollback();


        newRoom.setType("as");
        roomDao.update(newRoom);

        Room updatedRoom = roomDao.get(newRoom.getRoomNumber());
        Assert.assertEquals("Метод update не корректен","as", updatedRoom.getType());
        newRoom.setBedType(2);
        roomDao.update(newRoom);

        updatedRoom = roomDao.get(newRoom.getRoomNumber());
        Assert.assertEquals("Метод update не корректен",2, updatedRoom.getBedType());
        newRoom.setPrice(129.9);
        roomDao.update(newRoom);

        updatedRoom = roomDao.get(newRoom.getRoomNumber());
        Assert.assertEquals(129.9,129.9, 0);
        newRoom.setCheckIn(LocalDate.parse("2018-12-10"));
        roomDao.update(newRoom);

        updatedRoom = roomDao.get(newRoom.getRoomNumber());
        Assert.assertEquals("Метод update не корректен",LocalDate.parse("2018-12-10"), updatedRoom.getCheckIn());

        newRoom.setCheckOut(LocalDate.parse("2018-12-12"));
        roomDao.update(newRoom);

        updatedRoom = roomDao.get(newRoom.getRoomNumber());
        Assert.assertEquals("Метод update не корректен",LocalDate.parse("2018-12-12"), updatedRoom.getCheckOut());

        List<Room> rooms = roomDao.getRoomOnDateAndBedType(2, LocalDate.parse("2018-12-14"), LocalDate.parse("2018-12-16"));
        Assert.assertNotNull(rooms);

        roomDao.delete(newRoom.getRoomNumber());

        afterSave = roomDao.getAllRoom().size();
        Assert.assertEquals(beforeSave, afterSave);

    }


}
