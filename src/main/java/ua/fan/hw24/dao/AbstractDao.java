package ua.fan.hw24.dao;

import ua.fan.hw24.config.HibernateFactoryUtil;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

abstract class AbstractDao<T> {
    protected Class<T> aClass;

    public AbstractDao() {
        init();
    }

    protected abstract void init();
    protected final static EntityManager ENTITY_MANAGER = HibernateFactoryUtil.getEntityManager();

    public void save(T value) {
        final EntityTransaction transaction = ENTITY_MANAGER.getTransaction();
        transaction.begin();
        ENTITY_MANAGER.persist(value);
        ENTITY_MANAGER.flush();
        transaction.commit();
    }

    public T getById(Integer id) {
        final CriteriaBuilder criteriaBuilder = ENTITY_MANAGER.getCriteriaBuilder();
        final CriteriaQuery<T> query = criteriaBuilder.createQuery(aClass);
        final Root<T> from = query.from(aClass);
        query.select(from);
        query.where(criteriaBuilder.equal(from.get("id"), id));
        return ENTITY_MANAGER.createQuery(query).getSingleResult();
    }

    public List<T> getAll() {
        final CriteriaBuilder criteriaBuilder = ENTITY_MANAGER.getCriteriaBuilder();
        final CriteriaQuery<T> query = criteriaBuilder.createQuery(aClass);
        final Root<T> entity = query.from(aClass);
        query.select(entity);
        return ENTITY_MANAGER.createQuery(query).getResultList();
    }


    public void deleteById(Integer id) {
        final EntityTransaction transaction = ENTITY_MANAGER.getTransaction();
        T value = getById(id);
        transaction.begin();
        ENTITY_MANAGER.remove(value);
        ENTITY_MANAGER.flush();
        transaction.commit();
    }
}
