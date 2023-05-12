package com.sparta.rbf.employees_project.logging;

import com.sparta.rbf.employees_project.App;
import com.sparta.rbf.employees_project.BinarySearchTree;
import com.sparta.rbf.employees_project.EmployeeFormatter;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LogSetup {
    public static final LogManager logManager = LogManager.getLogManager();

    public static void setup() {

        logManager.addLogger(Logger.getLogger(App.class.getName()));
        logManager.addLogger(Logger.getLogger(EmployeeFormatter.class.getName()));
        logManager.addLogger(Logger.getLogger(BinarySearchTree.class.getName()));

        Logger appClassLogger = logManager.getLogger(App.class.getName());
        Logger employeeFormatterClassLogger = logManager.getLogger(EmployeeFormatter.class.getName());
        Logger binarySearchTreeClassLogger = logManager.getLogger(BinarySearchTree.class.getName());

        appClassLogger.addHandler(FileHandlerConfig.getFileHandler());
        employeeFormatterClassLogger.addHandler(FileHandlerConfig.getFileHandler());
        binarySearchTreeClassLogger.addHandler(FileHandlerConfig.getFileHandler());

    }
}
