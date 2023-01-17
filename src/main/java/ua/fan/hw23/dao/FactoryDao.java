package ua.fan.hw23.dao;

import ua.fan.hw23.entity.Factory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FactoryDao {
    public static Factory mapToObjectFactory(ResultSet resultSet) throws SQLException {
        final Factory factory = new Factory();
        factory.setId(resultSet.getInt("factory_id"));
        factory.setName(resultSet.getString("name"));
        factory.setCountry(resultSet.getString("country"));
        return factory;
    }
}
