package ru.leventel8.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/myfirstdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e){
            System.err.println("Неудалось загрузить класс драйвера!");
        }

        try(Connection connection = DriverManager.getConnection(URL, USERNAME,PASSWORD); Statement statement = connection.createStatement()){
            ResultSet res = statement.executeQuery("select * from users;");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
