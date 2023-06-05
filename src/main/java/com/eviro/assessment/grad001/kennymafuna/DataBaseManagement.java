package com.eviro.assessment.grad001.kennymafuna;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class DataBaseManagement {
    public static class DatabaseConnection {
        private static final String DB_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
        private static final String DB_USER = "sa";
        private static final String DB_PASSWORD = "";

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }
    }

    public static class TableManagement {
        public void createTable(Connection connection) {
            try (Statement statement = connection.createStatement()) {
                String sql = "CREATE TABLE AccountProfile (" +
                        "id INT PRIMARY KEY AUTO_INCREMENT," +
                        "account_holder_name VARCHAR(100)," +
                        "account_holder_surname VARCHAR(100)," +
                        "http_image_link VARCHAR(200)" +
                        ")";
                statement.executeUpdate(sql);
                System.out.println("Table created successfully!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public void insertIntoTable(Connection connection, List<Map<String, String>> entries) throws SQLException {
            String sql = "INSERT INTO AccountProfile (account_holder_name, account_holder_surname, http_image_link) VALUES (?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                for (Map<String, String> entry : entries) {
                    statement.setString(1, entry.get("name"));
                    statement.setString(2, entry.get("surname"));
                    statement.setString(3, entry.get("imageLink"));
                    statement.executeUpdate();
                }
            }
        }
    }
}
