package ua.fan.repository.hibernate;

import ua.fan.entity.Order;
import ua.fan.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl extends AbstractHibernateRepository<Order> implements OrderRepository {
    protected void init() {
        aClass = Order.class;
    }

    @Override
    public List<Order> getOrdersWithDiscount() {
        List<Order> orders = new ArrayList<>();
        String getOrdersWithDiscountSQL = "SELECT order_id FROM orders WHERE discount > 0";
        List<String> resultList = ENTITY_MANAGER.createNativeQuery(getOrdersWithDiscountSQL)
                .getResultList();
        resultList.forEach(s -> orders.add(getById(s)));
        return orders;
    }
}