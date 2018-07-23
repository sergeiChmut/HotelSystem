package by.chmut.hotel.services.impl;

import by.chmut.hotel.dao.ReservationDao;
import by.chmut.hotel.dao.impl.ReservationDaoImpl;
import by.chmut.hotel.entities.Reservation;
import by.chmut.hotel.services.ReservationService;
import by.chmut.hotel.services.ServiceException;

import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ReservationServiceImpl extends AbstractService implements ReservationService {

    private ReservationDao reservationDao = ReservationDaoImpl.getInstance();
    private static volatile ReservationService INSTANCE;

    @Override
    public Reservation save(Reservation reservation) {
        try {
            startTransaction();
            reservation = reservationDao.save(reservation);
            commit();
        } catch (SQLException e) {
            throw new ServiceException("Error creating Item with");
        }
        return reservation;
    }

    @Override
    public Reservation get(Serializable id) {
        try {
            startTransaction();
            Reservation reservation = reservationDao.get(id);
            commit();
            return reservation;
        } catch (SQLException e) {
            throw new ServiceException("Error get Room with");
        }
    }

    @Override
    public void update(Reservation reservation) {
        try {
            startTransaction();
            reservationDao.update(reservation);
            commit();
        } catch (SQLException e) {
            throw new ServiceException("Error update Room with");
        }
    }

    @Override
    public int delete(Serializable id) {
        try {
            startTransaction();
            int rows = reservationDao.delete(id);
            commit();
            return rows;
        } catch (SQLException e) {
            throw new ServiceException("Error delete Room with");
        }
    }

    @Override
    public List<Reservation> getByUserId(Serializable userId) {
        try {
            startTransaction();
            List<Reservation> reservations = reservationDao.getByUserId(userId);
            commit();
            return reservations;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Reservation> getByDate(LocalDate startDate, LocalDate endDate) {
        return null;
    }
    public static ReservationService getInstance() {
        ReservationService reservationService = INSTANCE;
        if (reservationService == null) {
            synchronized (ReservationServiceImpl.class) {
                reservationService = INSTANCE;
                if (reservationService == null) {
                    INSTANCE = reservationService = new ReservationServiceImpl();
                }
            }
        }
        return reservationService;
    }


}
