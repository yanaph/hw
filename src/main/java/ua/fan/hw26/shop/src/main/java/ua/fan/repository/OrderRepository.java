package ua.fan.repository;

import ua.fan.entity.Order;

import java.util.List;

public interface OrderRepository extends GenericRepository<Order> {
    List<Order> getOrdersWithDiscount();
}
