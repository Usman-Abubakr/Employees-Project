package com.sparta.rbf.employees_project2.jdbc.logging;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

public class FileHandlerConfig {
    private static FileHandler fileHandler;
    public static FileHandler getFileHandler() {
        if(fileHandler == null) {
            try {
                fileHandler = new FileHandler("src/main/logs/employees_project2/logFile.log", false);
                fileHandler.setLevel(Level.ALL);
                fileHandler.setFormatter(new SimpleFormatter());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return fileHandler;
    }
}

