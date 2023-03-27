package com.example.connectbd.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequetesBD {
    private static Connection getConnexion(){
        return DatabaseConnection.getConnection();
    }
    public static ResultSet getUser(String email, String password){
        Connection bd = getConnexion();
        String query = "SELECT * FROM utilisateurs WHERE mail=? AND pass=?";
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            statement = bd.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);
            resultSet = statement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
}
