package com.sparta.rbf.employees_project;
import com.sparta.rbf.employees_project.binary_tree.*;
import com.sparta.rbf.employees_project.employee.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Loading 1000 employees from the csv file...");
        String[] employeeArray = EmployeeFormatter.getNumEmployees(1000);
        System.out.println("Loading Complete");
        ArrayList<Employee> employeeArrayList = EmployeeFormatter.convertArrayToList(employeeArray);
        System.out.println("Populating binary tree...");
        EmployeeBinaryTree employeeBST = new EmployeeBinaryTree();
        employeeBST.populateTree(employeeArrayList);
        System.out.println("Populating Complete");
        for (int i = 0; i < 2; i++) {
            System.out.println("Searching for: " + employeeArrayList.get(i).getLastName());
            List<Employee> resultingEmployees = employeeBST.findEmployeesByLastName(employeeArrayList.get(i).getLastName());
            for (Employee employee : resultingEmployees) {
                System.out.println("Found: " + employee.employeeToString());
            }
        }
        System.out.println("Searching for: a");
        List<Employee> resultingEmployees = employeeBST.findEmployeesByLastName("a");
        System.out.println("Found: ");
        for (Employee employee : resultingEmployees) {
            System.out.println(employee.employeeToString());
        }

    }
}
