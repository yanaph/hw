package ua.fan.dao;

import ua.fan.config.HibernateFactoryUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ActivityTypeDao {
    protected final static EntityManager ENTITY_MANAGER = HibernateFactoryUtil.getEntityManager();

    public List<Object[]> getMostPopularActivity(){
        return ENTITY_MANAGER.createNativeQuery(
                        "SELECT activityType.typeName,  COUNT(*) FROM activity \n" +
                                "INNER JOIN activityType ON activityType.id = activity.activityType_id \n" +
                                "GROUP BY activityType.typeName \n" +
                                "ORDER BY COUNT(*) desc LIMIT 1;")
                .getResultList();

    }
}
