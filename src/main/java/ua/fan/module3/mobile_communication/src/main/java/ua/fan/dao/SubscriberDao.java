package ua.fan.dao;

import ua.fan.config.HibernateFactoryUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class SubscriberDao {
    protected final static EntityManager ENTITY_MANAGER = HibernateFactoryUtil.getEntityManager();

    public List<Object[]> getTop5SubscribersBySMS (){
        return ENTITY_MANAGER.createNativeQuery(
                        "SELECT CONCAT(subscriber.firstName, ' ', subscriber.lastName) as subscribersName, COUNT(activity.id) FROM subscriber \n" +
                                "INNER JOIN activity ON activity.subscriber_id = subscriber.id\n" +
                                "INNER JOIN activityType ON activityType.id = activity.activityType_id\n" +
                                "WHERE activityType.typeName = 'SMS'\n" +
                                "GROUP BY subscribersName\n" +
                                "ORDER BY COUNT(*) desc\n" +
                                "LIMIT 5;")
                .getResultList();
    }

    public List<Object[]> getTop5SubscribersByCall (){
        return ENTITY_MANAGER.createNativeQuery(
                        "SELECT CONCAT(subscriber.firstName, ' ', subscriber.lastName) as subscribersName, COUNT(activity.id) FROM subscriber \n" +
                                "INNER JOIN activity ON activity.subscriber_id = subscriber.id\n" +
                                "INNER JOIN activityType ON activityType.id = activity.activityType_id\n" +
                                "WHERE activityType.typeName = 'Call'\n" +
                                "GROUP BY subscribersName\n" +
                                "ORDER BY COUNT(*) desc\n" +
                                "LIMIT 5;")
                .getResultList();
    }

    public List<Object[]> getTop5SubscribersByInternet (){
        return ENTITY_MANAGER.createNativeQuery(
                        "SELECT CONCAT(subscriber.firstName, ' ', subscriber.lastName) as subscribersName, COUNT(activity.id) FROM subscriber \n" +
                                "INNER JOIN activity ON activity.subscriber_id = subscriber.id\n" +
                                "INNER JOIN activityType ON activityType.id = activity.activityType_id\n" +
                                "WHERE activityType.typeName = 'Internet'\n" +
                                "GROUP BY subscribersName\n" +
                                "ORDER BY COUNT(*) desc\n" +
                                "LIMIT 5;")
                .getResultList();
    }

}

