package com.sparta.rbf.employees_project;
import com.sparta.rbf.employees_project.binary_tree.*;
import com.sparta.rbf.employees_project.employee.*;
import com.sparta.rbf.employees_project.logging.LogSetup;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class App {
    public static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        LogSetup.setup();
        Logger logger = LogManager.getLogManager().getLogger(App.class.getName());

        String[] employeeArray = loadEmployees();

        ArrayList<Employee> employeeArrayList = EmployeeFormatter.convertArrayToList(employeeArray);

        EmployeeBinaryTree employeeBST = populateTree(employeeArrayList);

        // add employee with the same last name as first employee for duplication demonstration
        Employee employee1 = new Employee(123456, NamePrefix.MR, "John", 'P', employeeArrayList.get(0).getLastName(),
                Gender.MALE, "randomemail@gmail.com", LocalDate.of(1979,10,25),
                LocalDate.of(2021, 5,10), 44000);
        employeeBST.addElement(employee1);

        String choice;
        do {
            choice = menuItems();
            switch(choice) {
                case "1":
                    logger.log(Level.INFO, "User pressed \"Search employee\".");
                    searchData(employeeBST);
                    break;
                case "2":
                    logger.log(Level.INFO, "User pressed \"Sample employee data\".");
                    printSampleData(employeeArrayList, employeeBST);
                    break;
                case "0":
                    logger.log(Level.INFO, "User pressed \"Quit\"");
                    break;
                default:
                    choice = menuItems();
            }
        }
        while (!choice.equals("0"));
    }

    private static void searchData(EmployeeBinaryTree employeeBST) {
        System.out.println("\nEnter a last name to search: ");
        logger.log(Level.INFO, "Prompted user to search for a last name.");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("\nSearching for: " + name);
        List<Employee> resultingEmployees = employeeBST.findEmployeesByLastName(name);
        for (Employee employee : resultingEmployees) {
            logger.log(Level.INFO, "Found employee: " + employee.toString());
            System.out.println("Found: " + employee.toString());
        }
    }

    private static void printSampleData(ArrayList<Employee> employeeArrayList, EmployeeBinaryTree employeeBST) {
        for (int i = 0; i < 2; i++) {
            System.out.println("\nSearching for: " + employeeArrayList.get(i).getLastName());
            List<Employee> resultingEmployees = employeeBST.findEmployeesByLastName(employeeArrayList.get(i).getLastName());
            for (Employee employee : resultingEmployees) {
                System.out.println("Found: " + employee.toString());
            }
        }
    }

    private static String menuItems() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nPlease select one of the below options"
                + "\n(1) Search employee"
                + "\n(2) Sample employee data"
                + "\n(0) Quit");
        System.out.print("Choice: ");
        return input.nextLine();
    }

    private static EmployeeBinaryTree populateTree(ArrayList<Employee> employeeArrayList) {
        System.out.println("Populating binary tree...");
        EmployeeBinaryTree employeeBST = new EmployeeBinaryTree();
        employeeBST.populateTree(employeeArrayList);
        System.out.println("Populating Complete");
        return employeeBST;
    }

    private static String[] loadEmployees() {
        System.out.println("Loading 1000 employees from the csv file...");
        logger.log(Level.CONFIG,"Loading employees from CSV file...");
        String[] employeeArray = EmployeeFormatter.getNumEmployees(1000);
        System.out.println("Loading Complete");
        logger.log(Level.CONFIG,"Finished loading employee data.");
        return employeeArray;

    }
}
