package by.chmut.hotel.services.impl;

import by.chmut.hotel.database.ConnectionManager;
import by.chmut.hotel.database.DbManagerException;

import java.sql.SQLException;

import static by.chmut.hotel.database.ConnectionManager.getConnection;

public abstract class AbstractService {

    public void startTransaction() throws SQLException {
        getConnection().setAutoCommit(false);
    }

    public void commit() throws SQLException {
        getConnection().commit();
    }
    public void rollback() {
        try {
            getConnection().rollback();
        } catch (SQLException e) {
            throw new DbManagerException("rollback error");
        }
    }
}
