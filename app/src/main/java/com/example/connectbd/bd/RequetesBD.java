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

    public static Boolean insertUser(String email, String pseudo, String password) {
        Connection bd = getConnexion();
        String query = "INSERT INTO utilisateurs VALUES(?,?,?)";
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            statement = bd.prepareStatement(query);
            statement.setString(1, password);
            statement.setString(2, pseudo);
            statement.setString(3, email);
           statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
    }

