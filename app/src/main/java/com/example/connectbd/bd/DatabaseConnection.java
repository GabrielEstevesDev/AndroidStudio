package com.example.connectbd.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String url = "jdbc:mysql://192.168.0.30:3306/androidbd";
    private static final String user ="android";
    private static final String password ="";
    private static Connection connection;
    static {
        DatabaseConnection bd = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    protected static Connection getConnection() {
        return connection;
    }

    protected static void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
        connection = null;
    }
}

