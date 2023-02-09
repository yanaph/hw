package ua.fan.repository;

import java.sql.SQLException;
import java.util.List;

public interface GenericRepository<T> {
    T getById(String id) throws SQLException;

    List<T> getAll() throws SQLException;

    void save(T client) throws SQLException;
}
