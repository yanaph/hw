package ua.fan;

import ua.fan.entity.Client;
import ua.fan.entity.Goods;
import ua.fan.entity.Order;
import ua.fan.repository.ClientRepository;
import ua.fan.repository.GoodsRepository;
import ua.fan.repository.OrderRepository;
import ua.fan.repository.jdbc.ClientRepositoryImpl;
import ua.fan.repository.jdbc.GoodsRepositoryImpl;
import ua.fan.repository.jdbc.OrderRepositoryImpl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class JdbcRunner {
    private static final ClientRepository clientRepository = new ClientRepositoryImpl();
    private static final GoodsRepository goodsRepository = new GoodsRepositoryImpl();
    private static final OrderRepository orderRepository = new OrderRepositoryImpl(goodsRepository, clientRepository);

    public static void main(String[] args) throws SQLException {
//        Client client = createAndSaveClient();
//        clientRepository.getAll().forEach(System.out::println);
//        Goods goods = createAndSaveGoods();
//        goodsRepository.getAll().forEach(System.out::println);
//        Order order = createAndSaveOrder(client, goods);
//        orderRepository.getAll().forEach(System.out::println);
//        System.out.println("method");
//        clientRepository.getClientsWithAmountOfOrdersGreater(0);

        System.out.println("-------> CLIENTS");
        Client client = createAndSaveClient("Mike", "Watson", LocalDate.of(2003, 10, 22));
        Client client1 = createAndSaveClient("Eric", "Watson", LocalDate.of(1998, 10, 01));
        Client client2 = createAndSaveClient("Max", "Watson", LocalDate.of(2005, 10, 01));
        clientRepository.getAll().forEach(System.out::println);
        System.out.println("-------> GOODS");
        Goods goods = createAndSaveGoods(19.99, "Snickers", "Chocolate Bar");
        Goods goods1 = createAndSaveGoods(17.99, "Mars", "Chocolate Bar");
        goodsRepository.getAll().forEach(System.out::println);
        System.out.println("-------> ORDERS");
        Order order = createAndSaveOrder(client, List.of(goods), 0);
        Order order1 = createAndSaveOrder(client1, List.of(goods, goods1), 10);
        orderRepository.getAll().forEach(System.out::println);

        System.out.println("--> CLIENTS WITH AMOUNT OF ORDERS > 1");
        clientRepository.getClientsWithAmountOfOrdersGreater(1).forEach(System.out::println);
        System.out.println("--> REMOVE ALL CLIENTS YOUNGER THAN 18");
        System.out.println(clientRepository.removeAllClientsYoungerThan(18) + " clients were deleted. Clients left:");
        clientRepository.getAll().forEach(System.out::println);
        System.out.println("--> CLIENTS WITH SUM > 20 AND GOODS AMOUNT IN ORDER > 1");
        clientRepository.getClientsWithSumOfOrdersGreaterAndAmountOfGoodsInOrderGreater(20,1).forEach(System.out::println);
        System.out.println("--> ORDERS WITH DISCOUNT:");
        orderRepository.getOrdersWithDiscount().forEach(System.out::println);
    }

    private static Client createAndSaveClient(String firstName, String lastName, LocalDate dateOfBirt) throws SQLException {
        Client client = new Client(UUID.randomUUID().toString(), firstName, lastName, dateOfBirt, Collections.emptyList());
        clientRepository.save(client);
        List<Client> clientList = clientRepository.getAll();
        client = clientList.get(clientList.size() - 1);
        return client;
    }

    private static Goods createAndSaveGoods(Double price, String title, String category) throws SQLException {
        Goods goods = new Goods(UUID.randomUUID().toString(), BigDecimal.valueOf(price), title, category, List.of());
        goodsRepository.save(goods);
        List<Goods> goodsList = goodsRepository.getAll();
        return goodsList.get(goodsList.size() - 1);
    }

    private static Order createAndSaveOrder(Client client, List<Goods> goods, Integer discount) throws SQLException {
        Order order = new Order(client,goods, LocalDateTime.now(), discount);
        order.setId(UUID.randomUUID().toString());
        order.setGoods(goods);
        orderRepository.save(order);
        List<Order> orderList = orderRepository.getAll();
        return orderList.get(orderList.size() - 1);
    }
}
