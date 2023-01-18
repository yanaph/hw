package ua.fan.hw24.service;

import ua.fan.hw24.entity.Device;
import ua.fan.hw24.entity.Factory;

import java.util.Random;

public class DeviceService {
    private final static Random RANDOM = new Random();

    public Device createDevice(String type,String modelName, String description, boolean inStock, Factory factory) {
        return new Device(type, modelName, RANDOM.nextInt(1000), description, inStock, factory);
    }
}
