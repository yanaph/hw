package ua.fan.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateFactoryUtil {
    private static EntityManager entityManager;

    public static void init() {
        final EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("persistence");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            init();
        }
        return entityManager;
    }
}