package ua.fan.hw23.dao;

import java.sql.*;

public class AbstractDao {
    private static final String CONNECTION_URL = "jdbc:postgresql://localhost:5432/DeviceManufacturing";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "root";

    private static Statement getStatement() throws SQLException {
        Connection connection = getMyConnection();
        return connection.createStatement();
    }

    private static Connection getMyConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTION_URL, USER_NAME, PASSWORD);
    }

    public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
        Connection connection = getMyConnection();
        return connection.prepareStatement(sql);
    }

    public static void createTable() throws SQLException {
        String deviceTable = "CREATE TABLE IF NOT EXISTS devices (" +
                "Device_id serial not Null," +
                "Type varchar(250) not Null," +
                "Model varchar(250) not Null," +
                "Price Integer not Null," +
                "Manufacture_date date NOT NULL, " +
                "Description text not Null," +
                "In_stock boolean not Null," +
                "Factory_id INTEGER not Null," +
                "PRIMARY KEY (Device_id)," +
                "FOREIGN KEY (Factory_id) REFERENCES factories(Factory_id))";

        String factoryTable = "CREATE TABLE IF NOT EXISTS factories (" +
                "Factory_id serial not Null," +
                "Name varchar(250) not Null," +
                "Country varchar(250) not Null," +
                "PRIMARY KEY (Factory_id))";

        Statement statement = getStatement();
        statement.executeUpdate(factoryTable);
        statement.executeUpdate(deviceTable);
        System.out.println("Tables were successfully created in database!");
    }
}
