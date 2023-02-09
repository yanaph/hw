package ua.fan.repository.jdbc;

import ua.fan.entity.Client;
import ua.fan.repository.ClientRepository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ClientRepositoryImpl extends AbstractJDBCRepository implements ClientRepository {
    private final String CREATE_USER_SQL = "INSERT INTO public.clients (client_id, first_name, last_name, date_of_birth) VALUES (?,?,?,?)";
    private final String SELECT_ALL_CLIENTS_SQL = "SELECT * FROM public.clients";
    private final String SELECT_CLIENT_BY_ID_SQL = "SELECT * FROM public.clients WHERE client_id = ?";
    private final String GET_CLIENTS_WITH_AMOUNT_OF_ORDERS_GREATER = "SELECT client_id FROM public.orders GROUP BY client_id HAVING COUNT(orders.order_id) > ?";
    private final String REMOVE_ALL_CLIENTS_YOUNGER_THAN = "DELETE FROM public.clients WHERE date_of_birth > ?";
    private final String GET_CLIENTS_WITH_SUM_OF_ORDERS_GREATER_AND_AMOUNT_OF_GOODS_IN_ORDER_GREATER = " SELECT client_id FROM orders WHERE order_id IN " +
            "(SELECT order_id from orders_goods GROUP BY order_id HAVING COUNT(goods_id) > ?) GROUP BY client_id HAVING SUM(total_price) > ?";
    @Override
    public Client getById(String id) {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_CLIENT_BY_ID_SQL)) {
            statement.setString(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractClientFromResultSet(resultSet);
                }
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_CLIENTS_SQL)) {
            while (resultSet.next()) {
                clients.add(extractClientFromResultSet(resultSet));
            }
            return clients;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Client client) {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_USER_SQL)) {
            statement.setString(1, client.getId());
            statement.setString(2, client.getFirstName());
            statement.setString(3, client.getLastName());
            statement.setDate(4, Date.valueOf(client.getDateOfBirth()));
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Client extractClientFromResultSet(ResultSet resultSet) throws SQLException {
        Client client = new Client();
        client.setId(resultSet.getString("client_id"));
        client.setFirstName(resultSet.getString("first_name"));
        client.setLastName(resultSet.getString("last_name"));
        client.setDateOfBirth(resultSet.getDate("date_of_birth").toLocalDate());
        return client;
    }

    @Override
    public List<Client> getClientsWithAmountOfOrdersGreater(int amount) {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(GET_CLIENTS_WITH_AMOUNT_OF_ORDERS_GREATER)) {
            statement.setInt(1, amount);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    clients.add(getById(resultSet.getString("client_id")));
                }
                return clients;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int removeAllClientsYoungerThan(int age) {
        LocalDate youngest = LocalDate.now().minusYears(age);
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(REMOVE_ALL_CLIENTS_YOUNGER_THAN)) {
            statement.setDate(1, Date.valueOf(youngest));
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Client> getClientsWithSumOfOrdersGreaterAndAmountOfGoodsInOrderGreater(int amountOfOrders, int goodsLimit) {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(GET_CLIENTS_WITH_SUM_OF_ORDERS_GREATER_AND_AMOUNT_OF_GOODS_IN_ORDER_GREATER)) {
            statement.setInt(1, goodsLimit);
            statement.setInt(2, amountOfOrders);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    clients.add(getById(resultSet.getString("client_id")));
                }
                return clients;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
