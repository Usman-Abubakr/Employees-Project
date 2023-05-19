package com.sparta.rbf.employees_project2.jdbc;

import com.sparta.rbf.employees_project2.jdbc.employee.Employee;
import com.sparta.rbf.employees_project2.jdbc.employee.EmployeeFormatter;
import com.sparta.rbf.employees_project2.jdbc.file_input.FileReaderFactory;
import com.sparta.rbf.employees_project2.jdbc.logging.LogSetup;
import com.sparta.rbf.employees_project2.jdbc.file_input.ReadingXML;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static final Logger logger = Logger.getLogger(App.class.getName());
    //('11001', '1960-01-01', 'Bob', 'Smith', 'M', '2023-05-12');
    public static void main(String[] args) {
        LogSetup.setup();

        LoadEmployees();

        mainMenuLoop();
    }

    private static void mainMenuLoop() {
        String choice;
        do {
            choice = getMainMenuItems();
            switch (choice) {
                case "1" -> {
                    logger.log(Level.INFO, "User selected \"Search employee from department\".");
                    employeeDepartmentMenuLoop();
                }
                case "2" -> logger.log(Level.INFO, "User selected \"Import employees from file\".");
                case "0" -> logger.log(Level.INFO, "User selected \"Quit\"");
                default -> choice = getMainMenuItems();
            }
        }
        while (!choice.equals("0"));
    }
    public static String getFileName(){
        System.out.println("Enter the file name you would like to use: ");
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void employeeDepartmentMenuLoop() {
        String departmentChoice;
        do {
            departmentChoice = getDepartmentMenuItems();
            System.out.println("\nDepartment chosen: " + convertChoiceToDepartmentName(departmentChoice));
            if (departmentChoice.equals("1")
                    || departmentChoice.equals("2")
                    || departmentChoice.equals("3")
                    || departmentChoice.equals("4")
                    || departmentChoice.equals("5")
                    || departmentChoice.equals("6")
                    || departmentChoice.equals("7")
                    || departmentChoice.equals("8")
                    || departmentChoice.equals("9")) {
                String startDate = getDate("start");
                String endDate = getDate("end");

                if (isStartDateBeforeEndDate(startDate, endDate)) {
                    getEmployeeData(startDate, endDate, convertChoiceToDepartmentId(departmentChoice));
                }
            }
        }
        while (!departmentChoice.equals("0"));
    }

    private static void LoadEmployees() {
        EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionManager.createConnection());
        ResultSet employees = employeeDAO.getAllEmployees();
        ConnectionManager.closeConnection();

        EmployeeFormatter.populateEmployeeRepository(employees);
        for(Employee emp: EmployeeRepository.employees){
            System.out.println(emp.toString());
        }
    }

    private static void getEmployeeData(String startDate, String endDate, String departmentId) {
        System.out.println("\nLooking for employees in " + departmentId + " department, from " + startDate + " to " + endDate);


    }

    private static String getDate(String startOrEndDate) {
        Scanner input = new Scanner(System.in);

        System.out.println("\nEnter " + startOrEndDate + " date in format YYYY-MM-DD:");
        String date = input.nextLine();

        if (!isDateValid(date)) {
            date = getDate(startOrEndDate);
        }

        return date;
    }

    private static Boolean isDateValid(String date) {
        try {
            LocalDate localDate = LocalDate.parse(date);
            return true;

//            LocalDate today = LocalDate.now();
//            if (today.isAfter(localDate)) {
//                return true;
//            }
//            else {
//                System.out.println("Need a date from the past");
//                return false;
//            }
        }
        catch (Exception e) {
            System.out.println("Date not valid");
            return false;
        }
    }

    private static Boolean isStartDateBeforeEndDate(String startDate, String endDate) {
        try {
            LocalDate localStartDate = LocalDate.parse(startDate);
            LocalDate localEndDate = LocalDate.parse(endDate);
            if (localEndDate.isAfter(localStartDate)) {
                return true;
            }
            else {
                System.out.println("Employee cannot have a end date before starting.");
                return false;
            }
        }
        catch (Exception e) {
            System.out.println("Error checking start and end date.");
            return false;
        }
    }

    private static String convertChoiceToDepartmentName(String departmentChoice) {
        return switch (departmentChoice) {
            case "1" -> "Marketing";
            case "2" -> "Finance";
            case "3" -> "Human Resources";
            case "4" -> "Production";
            case "5" -> "Development";
            case "6" -> "Quality Management";
            case "7" -> "Sales";
            case "8" -> "Research";
            case "9" -> "Customer Service";
            default -> "Department not found";
        };
    }

    private static String convertChoiceToDepartmentId(String departmentChoice) {
        return switch (departmentChoice) {
            case "1" -> "d001";
            case "2" -> "d002";
            case "3" -> "d003";
            case "4" -> "d004";
            case "5" -> "d005";
            case "6" -> "d006";
            case "7" -> "d007";
            case "8" -> "d008";
            case "9" -> "d009";
            default -> "Department not found";
        };
    }

    private static String getMainMenuItems() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nPlease select one of the below options:"
                + "\n(1) Get employees from a department within a specified time frame"
                + "\n(2) Import employees from file"
                + "\n-----------------------------------------------------------------"
                + "\n(0) Quit"
                + "\n");
        System.out.print("Choice: ");
        return input.nextLine();
    }

    private static String getDepartmentMenuItems() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nEnter a department number:"
                + "\n(1) Marketing"
                + "\n(2) Finance"
                + "\n(3) Human Resources"
                + "\n(4) Production"
                + "\n(5) Development"
                + "\n(6) Quality Management"
                + "\n(7) Sales"
                + "\n(8) Research"
                + "\n(9) Customer Service"
                + "\n------------------------"
                + "\n(0) Return to main menu"
                + "\n");
        System.out.print("Choice: ");
        return input.nextLine();
    }
}
