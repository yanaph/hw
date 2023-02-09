package ua.fan.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.fan.entity.Client;
import ua.fan.repository.ClientRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryImpl extends AbstractHibernateRepository<Client> implements ClientRepository {
    private final String GET_CLIENTS_WITH_AMOUNT_OF_ORDERS_GREATER = "SELECT client_id FROM public.orders GROUP BY client_id HAVING COUNT(orders.order_id) > ?";
    private final String REMOVE_ALL_CLIENTS_YOUNGER_THAN = "DELETE FROM public.clients WHERE date_of_birth > ?";
    private final String GET_CLIENTS_WITH_SUM_OF_ORDERS_GREATER_AND_AMOUNT_OF_GOODS_IN_ORDER_GREATER = " SELECT client_id FROM orders WHERE order_id IN " +
            "(SELECT order_id from orders_goods GROUP BY order_id HAVING COUNT(goods_id) > ?) GROUP BY client_id HAVING SUM(total_price) > ?";

    protected void init() {
        aClass = Client.class;
    }

    @Override
    public List<Client> getClientsWithAmountOfOrdersGreater(int amount) {
        List<Client> clients = new ArrayList<>();
        List<String> resultList = ENTITY_MANAGER.createNativeQuery(GET_CLIENTS_WITH_AMOUNT_OF_ORDERS_GREATER)
                .setParameter(1, amount)
                .getResultList();
        resultList.forEach(s -> {
            clients.add(getById(s));
        });
        return clients;
    }

    @Override
    public int removeAllClientsYoungerThan(int age) {
        LocalDate youngest = LocalDate.now().minusYears(age);
        Session session = ENTITY_MANAGER.unwrap(Session.class);
        Transaction transaction = session.beginTransaction();
        int update = ENTITY_MANAGER.createNativeQuery(REMOVE_ALL_CLIENTS_YOUNGER_THAN)
                .setParameter(1, youngest)
                .executeUpdate();
        transaction.commit();
        return update;
    }

    @Override
    public List<Client> getClientsWithSumOfOrdersGreaterAndAmountOfGoodsInOrderGreater(int amountOfOrders, int goodsLimit) {
        List<Client> clients = new ArrayList<>();
        List<String> resultList = ENTITY_MANAGER.createNativeQuery(GET_CLIENTS_WITH_SUM_OF_ORDERS_GREATER_AND_AMOUNT_OF_GOODS_IN_ORDER_GREATER)
                .setParameter(1, goodsLimit)
                .setParameter(2, amountOfOrders)
                .getResultList();
        resultList.forEach(s -> {
            clients.add(getById(s));
        });
        return clients;
    }
}
