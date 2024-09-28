package com.bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/BookStoreDB";
    private static final String USER = "root";
    private static final String PASSWORD = "Divija@#2704";

    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database: " + URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
