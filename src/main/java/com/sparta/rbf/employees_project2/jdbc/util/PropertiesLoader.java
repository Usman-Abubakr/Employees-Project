package com.sparta.rbf.employees_project2.jdbc.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
    public static Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
