package ua.fan.hw24.dao;

import ua.fan.hw24.entity.Device;
import ua.fan.hw24.entity.Factory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

public class FactoryDao extends AbstractDao<Factory> {
    @Override
    protected void init() {
        aClass = Factory.class;
    }

    public List<Object[]> getTotalInfoAboutEachFactory(){
        final CriteriaBuilder criteriaBuilder = ENTITY_MANAGER.getCriteriaBuilder();
        final CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
        final Root<Device> deviceRoot = criteriaQuery.from(Device.class);
        Join<Device, Factory> factoryJoin = deviceRoot.join("factory");

        criteriaQuery.multiselect(
                factoryJoin.get("name"),
                criteriaBuilder.count(deviceRoot.get("id")),
                criteriaBuilder.sum(deviceRoot.get("price")));

        criteriaQuery.groupBy(factoryJoin.get("name"));
        Query query = ENTITY_MANAGER.createQuery(criteriaQuery);
        return query.getResultList();
    }
}