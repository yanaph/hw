package ua.fan.hw23.utils;

import ua.fan.hw23.dao.AbstractDao;
import ua.fan.hw23.dao.DeviceDao;
import ua.fan.hw23.dao.FactoryDao;
import ua.fan.hw23.entity.Device;
import ua.fan.hw23.entity.Factory;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DeviceManufactureUtil {

    static final List<Factory> factories = factoryGenerator();
    static final List<Device> devices = deviceGenerator();


    private static List<Factory> factoryGenerator() {
        List<Factory> factoryList = new ArrayList<>();
        factoryList.add(new Factory(1, "Apple", "USA"));
        factoryList.add(new Factory(2, "Nokia", "Finland"));
        factoryList.add(new Factory(3, "Samsung", "Korea"));
        factoryList.add(new Factory(4, "Xiaomi", "China"));
        return factoryList;
    }

    private static List<Device> deviceGenerator() {
        List<Device> deviceList = new ArrayList<>();
        deviceList.add(new Device("Phone", "Galaxy S21", 499, LocalDate.now(), "Featuring 8K resolution that impresses", true, factories.get(2).getId()));
        deviceList.add(new Device("Phone", "13 Pro", 1299, LocalDate.now(), "Huge camera upgrades.", true, factories.get(0).getId()));
        deviceList.add(new Device("Phone", "3310", 59, LocalDate.now(), "Nokia 3310 takes the iconic silhouette of the original and reimagines it for 2017.", true, factories.get(1).getId()));
        deviceList.add(new Device("Earphones", "Buds Live", 75, LocalDate.now(), "Galaxy Buds Live comes with an iconic shape and ergonomic design", true, factories.get(2).getId()));
        deviceList.add(new Device("Earphones", "Airpods Pro", 214, LocalDate.now(), "Active noise cancellation for immersive sound.", false, factories.get(0).getId()));
        deviceList.add(new Device("Watches", "Smart Band 6", 32, LocalDate.now(), "Sleep breathing quality tracking ", true, factories.get(3).getId()));
        deviceList.add(new Device("Watches", "Series 7", 417, LocalDate.now(), "Apple Watch Series 7 features the largest, most advanced display yet, breakthrough health innovations, and is the most durable Apple Watch ever.", false, factories.get(0).getId()));
        deviceList.add(new Device("Laptop", "PureBook Pro", 539, LocalDate.now(), "The Nokia PureBook Pro offers all round comfort and ease-of-use with a large touchpad, backlit keyboard, and fingerprint reader.", true, factories.get(1).getId()));
        deviceList.add(new Device("Laptop", "MacBook Pro", 1449, LocalDate.now(), "Our most powerful notebooks", true, factories.get(0).getId()));
        deviceList.add(new Device("Laptop", "Book Pro 360", 1399, LocalDate.now(), "Samsung Galaxy Book Pro 360 33,78 cm (13,3 Zoll) Notebook (Intel Core Prozessor i5, 8 GB RAM, 256 GB SSD, Windows 10 Home)", true, factories.get(2).getId()));
        return deviceList;
    }

    public static void saveFactoryToDataBase() throws SQLException {
        String sql = "INSERT INTO factories (" +
                "factory_id, name, country) values (?, ?, ?)";
        for (Factory factory : factories) {
            final PreparedStatement statement = AbstractDao.getPreparedStatement(sql);
            statement.setInt(1, factory.getId());
            statement.setString(2, factory.getName());
            statement.setString(3, factory.getCountry());
            statement.executeUpdate();
            statement.close();
        }
    }

    public static void saveDeviceToDataBase() throws SQLException {
        String sql = "INSERT INTO devices (" +
                "type, model, price, manufacture_date, description, in_stock, factory_id)" +
                "values (?, ?, ?, ?, ?, ?, ?)";
        for (Device device : devices) {
            final PreparedStatement statement = AbstractDao.getPreparedStatement(sql);
            statement.setString(1, device.getType());
            statement.setString(2, device.getModelName());
            statement.setDouble(3, device.getPrice());
            statement.setDate(4, Date.valueOf(device.getManufactureDate()));
            statement.setString(5, device.getDescription());
            statement.setBoolean(6, device.getInStock());
            statement.setInt(7, device.getFactoryId());
            statement.executeUpdate();
            statement.close();
        }
    }

    public static Factory getFactoryById(Integer id) throws SQLException {
        final String sql = "SELECT * FROM factories WHERE factory_id = ?";
        final PreparedStatement preparedStatement = AbstractDao.getPreparedStatement(sql);
        preparedStatement.setInt(1, id);
        final ResultSet resultSet = preparedStatement.executeQuery();
        Optional<Factory> resultFactory = resultSet.next() ? Optional.of(FactoryDao.mapToObjectFactory(resultSet)) : Optional.empty();
        return resultFactory.get();
    }

    public static Device getDeviceById(Integer id) throws SQLException {
        final String sql = "SELECT * FROM devices where device_id = ?";
        final PreparedStatement preparedStatement = AbstractDao.getPreparedStatement(sql);
        preparedStatement.setInt(1, id);

        final ResultSet resultSet = preparedStatement.executeQuery();
        Optional<Device> resultDevice = resultSet.next() ? Optional.of(DeviceDao.mapToObjectDevice(resultSet)) : Optional.empty();
        return resultDevice.get();
    }

    public static void updateDeviceById(Device device, Integer id) throws SQLException {
        final String sql = "UPDATE devices SET type = ?, model = ?, price = ?, manufacture_date = ?, description = ?, " +
                "in_stock = ?, factory_id = ? where device_id = ?";
        final PreparedStatement statement = AbstractDao.getPreparedStatement(sql);
        statement.setString(1, device.getType());
        statement.setString(2, device.getModelName());
        statement.setInt(3, device.getPrice());
        statement.setDate(4, Date.valueOf(device.getManufactureDate()));
        statement.setString(5, device.getDescription());
        statement.setBoolean(6, device.getInStock());
        statement.setInt(7, device.getFactoryId());
        statement.setInt(8, id);
        statement.executeUpdate();
        statement.close();
        System.out.println("Device's details were successfully updated! Now they are: \n" + getDeviceById(id));
    }

    public static void deleteDeviceById(Integer id) throws SQLException {
        final String sql = "DELETE FROM devices WHERE device_id = ?";
        final PreparedStatement statement = AbstractDao.getPreparedStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
        System.out.println("Device was successfully deleted!");
    }

    public static List<Device> getDevicesByFactoryName(String factoryName) throws SQLException {
        final String sql = "SELECT * FROM factories INNER JOIN devices ON devices.factory_id = factories.factory_id WHERE name = ?";
        final PreparedStatement preparedStatement = AbstractDao.getPreparedStatement(sql);
        preparedStatement.setString(1, factoryName);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Device> deviceArrayList = new ArrayList<>();
        while (resultSet.next()){
            deviceArrayList.add(
                    new Device(resultSet.getString("type"),
                    resultSet.getString("model"),
                    resultSet.getInt("price"),
                    resultSet.getDate("manufacture_date").toLocalDate(),
                    resultSet.getString("description"),
                    resultSet.getBoolean("in_stock"),
                    resultSet.getInt("factory_id")));
        }
        return deviceArrayList;
    }

    public static List<Object[]> getTotalDeviceInfoByFactories() throws SQLException {
        String sqlQuery = "SELECT factories.name, COUNT(devices.device_id) AS device_amount, SUM(price) AS summary_price FROM factories INNER JOIN devices USING (factory_id) GROUP BY factories.name";
        PreparedStatement preparedStatement = AbstractDao.getPreparedStatement(sqlQuery);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Object[]> statistics = new ArrayList<>();
        while (resultSet.next()) {
            statistics.add(
                    new Object[]{resultSet.getString("name"),
                            resultSet.getInt("device_amount"),
                            resultSet.getInt("summary_price")}
            );
        }
        return statistics;
    }


}
