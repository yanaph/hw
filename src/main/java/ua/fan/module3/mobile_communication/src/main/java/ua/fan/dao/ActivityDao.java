package ua.fan.dao;

import ua.fan.config.HibernateFactoryUtil;
import ua.fan.entity.Activity;

import javax.persistence.EntityManager;
import java.util.List;

public class ActivityDao {
    protected final static EntityManager ENTITY_MANAGER = HibernateFactoryUtil.getEntityManager();

    public List<Activity> getSMSyByText(String text) {
        return ENTITY_MANAGER.createNativeQuery(
                        "SELECT * FROM activity \n" +
                                "INNER JOIN activityType ON activityType.id = activity.activityType_id\n" +
                                "WHERE LOWER(activityText) LIKE ? AND activityType.typeName = 'SMS'", Activity.class)
                .setParameter(1, "%" + text.toLowerCase() + "%")
                .getResultList();
    }
}
