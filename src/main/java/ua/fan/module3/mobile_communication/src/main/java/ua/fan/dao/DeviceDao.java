package ua.fan.dao;

import ua.fan.config.HibernateFactoryUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class DeviceDao {
    protected final static EntityManager ENTITY_MANAGER = HibernateFactoryUtil.getEntityManager();

    public List<Object[]> getMostPopularDevice(){
        return ENTITY_MANAGER.createNativeQuery("SELECT device.modelName, COUNT(*) FROM subscriber \n" +
                "INNER JOIN device ON device.id = subscriber.device_id\n" +
                "INNER JOIN deviceType ON deviceType.id = device.deviceType_id \n" +
                "GROUP BY device.modelName\n" +
                "ORDER BY COUNT(*) desc\n" +
                "LIMIT 1;")
                .getResultList();
    }
}
