package com.sparta.rbf.employees_project2.jdbc.logging;

import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LogSetup {
    public static void setup() {
        LogManager logManager = LogManager.getLogManager();
        logManager.reset();  // resets so that no loggers output to the console by default

        Logger rootLogger = Logger.getLogger("");
        rootLogger.addHandler(FileHandlerConfig.getFileHandler());
        rootLogger.setLevel(Level.FINEST);
    }

}
