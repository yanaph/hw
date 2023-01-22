package ua.fan.dao;

import ua.fan.config.HibernateFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

abstract class AbstractDao<T>{
    protected Class<T> aClass;
    protected static final EntityManager ENTITY_MANAGER = HibernateFactoryUtil.getEntityManager();

    public AbstractDao() {
        init();
    }

    protected abstract void init();

    public void save(T value) {
        final EntityTransaction transaction = ENTITY_MANAGER.getTransaction();
        transaction.begin();
        ENTITY_MANAGER.persist(value);
        ENTITY_MANAGER.flush();
        transaction.commit();
    }

    public T getById(Integer id) {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<T> query = criteriaBuilder.createQuery(aClass);
        final Root<T> from = query.from(aClass);
        query.select(from).where(criteriaBuilder.equal(from.get("id"), id));
        return entityManager.createQuery(query).getSingleResult();
    }

    public List<T> getAll() {
        final CriteriaBuilder criteriaBuilder = ENTITY_MANAGER.getCriteriaBuilder();
        final CriteriaQuery<T> query = criteriaBuilder.createQuery(aClass);
        final Root<T> from = query.from(aClass);
        query.select(from);
        return ENTITY_MANAGER.createQuery(query).getResultList();
    }
}
