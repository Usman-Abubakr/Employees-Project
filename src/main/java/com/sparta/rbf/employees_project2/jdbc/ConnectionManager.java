package com.sparta.rbf.employees_project2.jdbc;

import com.sparta.rbf.employees_project2.jdbc.util.PropertiesLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionManager {
    public static final Logger logger = Logger.getLogger(ConnectionManager.class.getName());
    private static Connection connection;
    public static Connection createConnection() {
        Properties properties = PropertiesLoader.getProperties();
        String url = properties.getProperty("url");
        String userName = properties.getProperty("userName");
        String password = properties.getProperty("password");

        try {
            connection = DriverManager.getConnection(url,userName,password);
            logger.log(Level.CONFIG, "Established connection to database.");
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Connection to database failed.");
            e.printStackTrace();
        }
        return connection;
    }
    public static void closeConnection() {
        try {
            connection.close();
            logger.log(Level.CONFIG, "Connection to database closed.");
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Failed to close database connection.");
            e.printStackTrace();
        }
    }
}
