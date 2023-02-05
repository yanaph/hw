package ua.fan.hw23;

import ua.fan.hw23.dao.AbstractDao;
import ua.fan.hw23.entity.Device;
import ua.fan.hw23.utils.DeviceManufactureUtil;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.printf("%n----> Creating and saving tables into database: ");
        AbstractDao.createTable();
        DeviceManufactureUtil.saveFactoryToDataBase();
        DeviceManufactureUtil.saveDeviceToDataBase();
        System.out.printf("%n----> Getting device by index 3: %n%s%n", DeviceManufactureUtil.getDeviceById(3));
        System.out.printf("%n----> Getting factory by index 1: %n%s%n", DeviceManufactureUtil.getFactoryById(2));
        System.out.printf("%n----> Changing device's info (by index 3): %n");
        Device updateDevice = new Device("Laptop", "Book Pro", 1599, LocalDate.now(),
                "Samsung Galaxy Book Pro 360 33,78 cm (13,3 Zoll) Notebook (Intel Core Prozessor i5, 8 GB RAM, 256 GB SSD, Windows 1",
                true, 1);
        DeviceManufactureUtil.updateDeviceById(updateDevice, 3);
        System.out.printf("%n----> Deleting device by index 3:%n");
        DeviceManufactureUtil.deleteDeviceById(3);
        System.out.printf("%n----> Getting devices by factory Samsung:%n");
        List<Device> devices = DeviceManufactureUtil.getDevicesByFactoryName("Samsung");
        devices.forEach(System.out::println);
        System.out.printf("%n----> Getting total device info grouped by factories:%n");
        List<Object[]> infoByFactories = DeviceManufactureUtil.getTotalDeviceInfoByFactories();
        infoByFactories.forEach(objects -> {
            for (Object obj: objects) {
                System.out.println(obj);
            }
        });
    }
}
