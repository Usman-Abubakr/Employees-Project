package com.sparta.rbf.employees_project;

import com.sparta.rbf.employees_project.logging.LogSetup;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    public static void main(String[] args) {
        try {
            String[] employees = EmployeeFactory.getEmployees(2);
            System.out.println(Arrays.toString(employees));

            logger.log(Level.INFO, "Employees have been printed");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        EmployeeBinaryTree employeeBST = new EmployeeBinaryTree();
//        employeeBST.populateTree(employees);

    }
}
