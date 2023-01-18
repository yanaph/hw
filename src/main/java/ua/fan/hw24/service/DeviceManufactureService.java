package ua.fan.hw24.service;

import ua.fan.hw24.dao.DeviceDao;
import ua.fan.hw24.dao.FactoryDao;
import ua.fan.hw24.entity.Device;
import ua.fan.hw24.entity.Factory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeviceManufactureService {
    private final FactoryService factoryService = new FactoryService();
    private final FactoryDao factoryDao = new FactoryDao();
    private final DeviceService deviceService = new DeviceService();
    private final DeviceDao deviceDao = new DeviceDao();

    public void createDeviceManufacture() {
        final List<Factory> factories = createListOfFactories();

        final Factory appleFactory = factories.get(0);
        final Device device = deviceService.createDevice("phone", "13 Pro",
                "Huge camera upgrades", true, appleFactory);
        final Device device2 = deviceService.createDevice("earphones", "Airpods Pro",
                "Active noise cancellation for immersive sound.", true, appleFactory);
        final Device device3 = deviceService.createDevice("watches", "Series 7",
                "Features the largest, most advanced display yet", true, appleFactory);
        final Device device4 = deviceService.createDevice("laptop", "MacBook Pro",
                "Our most powerful notebooks", true, appleFactory);

        final Factory nokiaFactory = factories.get(1);
        final Device device5 = deviceService.createDevice("phone", "3310",
                "Takes an iconic silhouette", false, nokiaFactory);
        final Device device6 = deviceService.createDevice("laptop", "PureBook Pro",
                "Offers all round comfort and ease-of-use with a large touchpad", true, nokiaFactory);

        final Factory samsungFactory = factories.get(2);
        final Device device7 = deviceService.createDevice("phone", "Galaxy S21",
                "Featuring 8K resolution that impresses", true, samsungFactory);
        final Device device8 = deviceService.createDevice("earphones", "Buds Live",
                "Iconic shape and ergonomic design", true, samsungFactory);

        final Factory xiaomiFactory = factories.get(3);
        final Device device9 = deviceService.createDevice("laptop", "Book Pro 360",
                "Intel Core Processor i5, 8 GB RAM, 256 GB SSD, Windows 10 Home", true, xiaomiFactory);
        final Device device10 = deviceService.createDevice("watches", "Smart Band 6",
                "Sleep breathing quality tracking ", true, xiaomiFactory);

        final Set<Device> appleDevices = new HashSet<>();
        appleDevices.add(device);
        appleDevices.add(device2);
        appleDevices.add(device3);
        appleDevices.add(device4);
        appleFactory.setDevices(appleDevices);

        final Set<Device> nokiaDevices = new HashSet<>();
        nokiaDevices.add(device5);
        nokiaDevices.add(device6);
        nokiaFactory.setDevices(nokiaDevices);

        final Set<Device> samsungDevices = new HashSet<>();
        samsungDevices.add(device7);
        samsungDevices.add(device8);
        samsungFactory.setDevices(samsungDevices);

        final Set<Device> xiaomiDevices = new HashSet<>();
        xiaomiDevices.add(device9);
        xiaomiDevices.add(device10);
        xiaomiFactory.setDevices(xiaomiDevices);

        for (Factory factory : factories) {
            factoryDao.save(factory);
        }

    }

    private List<Factory> createListOfFactories() {
        final Factory appleFactory = factoryService.createFactory("Apple");
        final Factory nokiaFactory = factoryService.createFactory("Nokia");
        final Factory samsungFactory = factoryService.createFactory("Samsung");
        final Factory xiaomiFactory = factoryService.createFactory("Xiaomi");
        return Arrays.asList(appleFactory, nokiaFactory, samsungFactory, xiaomiFactory);
    }

    public void print() {

        System.out.println("---> GETTING 2nd FACTORY FROM TABLE");
        System.out.println(getFactoryInfo(factoryDao.getById(2)));

        System.out.println("---> GETTING 2nd DEVICE FROM TABLE");
        System.out.println(getDeviceInfo(deviceDao.getById(2)));

        System.out.println("---> DOUBLING PRICE OF THE 2nd ELEMENT...");
        deviceDao.doubleDevicePrice(2);
        System.out.println(getDeviceInfo(deviceDao.getById(2)));

        System.out.println("---> DELETING 2nd DEVICE FROM TABLE");
        deviceDao.deleteById(2);

        System.out.println("---> GETTING ALL DATA FROM FACTORY TABLE");
        factoryDao.getAll().forEach(factory -> System.out.println(getFactoryInfo(factory)));

        System.out.println("---> GETTING ALL DEVICES OF CERTAIN FACTORY");
        deviceDao.getAllDevicesOfCertainFactory("Nokia").forEach(device -> System.out.print(getDeviceInfo(device)));

        System.out.println("---> GETTING TOTAL DEVICE INFO ABOUT EACH FACTORY");
        factoryDao.getTotalInfoAboutEachFactory().forEach(factory ->
                System.out.printf("Factory: %s%n Device count: %s%n Total price:  %s%n%n",
                        factory[0], factory[1], factory[2]));
    }


    private String getFactoryInfo(Factory factory) {
        return String.format("Factory ID: %s%n Name: %s%n Country: %s%n",
                factory.getId(), factory.getName(), factory.getCountry());
    }

    private String getDeviceInfo(Device device) {
        return String.format("Device ID: %s%n Type: %s%n Model: %s%n Factory: %s%n " +
                        "Price: %s€%n Date: %s%n In stock: %s%n Description: %s%n%n",
                device.getId(), device.getType(), device.getModelName(), device.getFactory().getName(),
                device.getPrice(), device.getManufactureDate().toLocalDate(), device.isInStock() ? "yes" : "no", device.getDescription());
    }
}
