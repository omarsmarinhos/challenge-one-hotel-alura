package com.omarinhos.hotel.alura.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost:3306/hotel_alura";
    private static final String USER = "root";
    private static final String PASS = "root";
    
    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(URL, USER, PASS);
        }
        return connection;
    }
}