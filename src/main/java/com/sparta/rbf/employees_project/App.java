package com.sparta.rbf.employees_project;
import com.sparta.rbf.employees_project.binary_tree.*;
import com.sparta.rbf.employees_project.employee.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String[] employeeArray = loadEmployees();

        ArrayList<Employee> employeeArrayList = EmployeeFormatter.convertArrayToList(employeeArray);

        EmployeeBinaryTree employeeBST = populateTree(employeeArrayList);

//        employeeBST.addElement(employeeArrayList.get(0));

        String choice;
        do {
            choice = menuItems();
            switch(choice) {
                case "1":
                    searchData(employeeBST);
                    break;
                case "2":
                    printSampleData(employeeArrayList, employeeBST);
                    break;
                case "0":
                    break;
                default:
                    choice = menuItems();
            }
        }
        while (!choice.equals("0"));
    }

    private static void searchData(EmployeeBinaryTree employeeBST) {
        System.out.println("\nEnter a last name to search: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("\nSearching for: " + name);
        List<Employee> resultingEmployees = employeeBST.findEmployeesByLastName(name);
        for (Employee employee : resultingEmployees) {
            System.out.println("Found: " + employee.employeeToString());
        }
    }

    private static void printSampleData(ArrayList<Employee> employeeArrayList, EmployeeBinaryTree employeeBST) {
        for (int i = 0; i < 2; i++) {
            System.out.println("\nSearching for: " + employeeArrayList.get(i).getLastName());
            List<Employee> resultingEmployees = employeeBST.findEmployeesByLastName(employeeArrayList.get(i).getLastName());
            for (Employee employee : resultingEmployees) {
                System.out.println("Found: " + employee.employeeToString());
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
        String[] employeeArray = EmployeeFormatter.getNumEmployees(1000);
        System.out.println("Loading Complete");
        return employeeArray;
    }
}
