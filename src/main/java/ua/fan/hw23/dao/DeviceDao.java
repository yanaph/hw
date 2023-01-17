package ua.fan.hw23.dao;

import ua.fan.hw23.entity.Device;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeviceDao {
    public static Device mapToObjectDevice(final ResultSet resultSet) throws SQLException {
        final Device device = new Device();
        device.setId(resultSet.getInt("device_id"));
        device.setType(resultSet.getString("type"));
        device.setModelName(resultSet.getString("model"));
        device.setPrice(resultSet.getInt("price"));
        device.setManufactureDate(resultSet.getDate("manufacture_date").toLocalDate());
        device.setDescription(resultSet.getString("description"));
        device.setInStock(resultSet.getBoolean("in_stock"));
        device.setFactoryId(resultSet.getInt("factory_Id"));
        return device;
    }
}
