package ua.fan.hw24;

import ua.fan.hw24.service.DeviceManufactureService;
import ua.fan.hw24.config.HibernateFactoryUtil;

public class Main {
    private static final DeviceManufactureService deviceManufactureService = new DeviceManufactureService();

    public static void main(String[] args) {
        HibernateFactoryUtil.init();
        deviceManufactureService.createDeviceManufacture();
        deviceManufactureService.print();

    }
}
