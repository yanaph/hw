package ua.fan.hw24.dao;

import ua.fan.hw24.entity.Device;
import ua.fan.hw24.entity.Factory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;


public class DeviceDao extends AbstractDao<Device> {
    @Override
    protected void init() {
        aClass = Device.class;
    }

    public void updateDeviceById(Device device, Integer id) {
        Device deviceToUpdate = ENTITY_MANAGER.find(Device.class, id);
        deviceToUpdate.setDescription(device.getDescription());
        deviceToUpdate.setFactory(device.getFactory());
        deviceToUpdate.setPrice(device.getPrice());
        deviceToUpdate.setType(device.getType());
        deviceToUpdate.setInStock(device.isInStock());
        deviceToUpdate.setModelName(device.getModelName());
        deviceToUpdate.setManufactureDate(device.getManufactureDate());
        ENTITY_MANAGER.merge(deviceToUpdate);
    }

    public List<Device> getAllDevicesOfCertainFactory(String factoryName) {
        final CriteriaBuilder criteriaBuilder = ENTITY_MANAGER.getCriteriaBuilder();
        final CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
        final Root<Device> deviceRoot = criteriaQuery.from(Device.class);
        Join<Device, Factory> factoryJoin = deviceRoot.join("factory");

        criteriaQuery.select(deviceRoot)
                .where(criteriaBuilder.equal(factoryJoin.get("name"), factoryName));
        Query query = ENTITY_MANAGER.createQuery(criteriaQuery);
        return query.getResultList();
    }

}