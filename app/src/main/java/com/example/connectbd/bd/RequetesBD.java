package com.example.connectbd.bd;

import com.example.connectbd.todo.ListTask;
import com.example.connectbd.todo.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RequetesBD {
    private static Connection getConnexion(){
        return DatabaseConnection.getConnection();
    }
    public static ResultSet getUser(String email, String password){
        Connection bd = getConnexion();
        String query = "SELECT * FROM utilisateurs WHERE pseudo=? AND pass=?";
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
    public static void setTasks(String pseudo){
        Connection bd = getConnexion();
        String query = "SELECT * FROM task WHERE pseudo=? ";
        PreparedStatement statement = null;
        ResultSet resultSet;
        ArrayList<Task> t = new ArrayList<>() ;
        try {
            statement = bd.prepareStatement(query);
            statement.setString(1, pseudo);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                t.add(new Task(resultSet.getString(1),resultSet.getString(2)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(!t.isEmpty()){
            ListTask.setTasks(t);
        }
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
           return false;
        }
        return true;
    }

    public static Boolean insertTASK(String titre, String desc, String pseudo) {
        Connection bd = getConnexion();
        String query = "INSERT INTO task VALUES(?,?,?)";
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            statement = bd.prepareStatement(query);
            statement.setString(1, titre);
            statement.setString(2, desc);
            statement.setString(3, pseudo);
            statement.executeUpdate();

        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public static void deleteTask(String Titre,String pseudo) {
        Connection bd = getConnexion();
        String query = "DELETE FROM task WHERE titre=? AND pseudo=?";
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            statement = bd.prepareStatement(query);
            statement.setString(1, Titre);
            statement.setString(2, pseudo);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

