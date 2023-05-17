package com.sparta.rbf.employees_project2.jdbc.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesLoader {
    public static final Logger logger = Logger.getLogger(PropertiesLoader.class.getName());
    public static Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/database.properties"));
            logger.log(Level.CONFIG, "Loaded properties for database connection.");
        } catch (IOException e) {
            logger.log(Level.WARNING, "Cannot load properties for database connection!");
            e.printStackTrace();
        }
        return properties;
    }
}
