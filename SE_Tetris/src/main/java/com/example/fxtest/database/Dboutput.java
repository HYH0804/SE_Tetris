/*package com.example.fxtest.database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbOutput {
    //데이터 베이스에서 ranking스키마를 만들고 name과 score를 저장한 값을 가져오는 내용
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String DB_USER = "your_database_username";
    private static final String DB_PASSWORD = "your_database_password";

    public static List<String> getData() {
        List<String> data = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement()) {
            String query = "SELECT name, score FROM ranking ORDER BY score DESC LIMIT 10";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int score = resultSet.getInt("score");
                data.add(name + ": " + score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
}

