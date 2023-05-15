package com.sparta.rbf.employees_project.logging;

import com.sparta.rbf.employees_project.App;
import com.sparta.rbf.employees_project.binary_tree.EmployeeBinaryTree;
import com.sparta.rbf.employees_project.EmployeeFormatter;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LogSetup {
    public static void setup() {
        App.logger.setUseParentHandlers(false);
        EmployeeFormatter.logger.setUseParentHandlers(false);
        EmployeeBinaryTree.logger.setUseParentHandlers(false);

        App.logger.addHandler(FileHandlerConfig.getFileHandler());
        EmployeeFormatter.logger.addHandler(FileHandlerConfig.getFileHandler());
        EmployeeBinaryTree.logger.addHandler(FileHandlerConfig.getFileHandler());

        App.logger.setLevel(Level.INFO);
        EmployeeFormatter.logger.setLevel(Level.FINER);
        EmployeeBinaryTree.logger.setLevel(Level.FINER);


    }
}
