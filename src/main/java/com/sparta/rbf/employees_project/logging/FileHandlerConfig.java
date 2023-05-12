package com.sparta.rbf.employees_project.logging;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

public class FileHandlerConfig {
    public static FileHandler getFileHandler() {
        FileHandler fileHandler = null;

        try {
            fileHandler = new FileHandler("src/main/logs/logFile.log", false);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileHandler;
    }
}
