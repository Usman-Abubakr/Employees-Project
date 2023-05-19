package com.sparta.rbf.employees_project2.jdbc;

import com.sparta.rbf.employees_project2.jdbc.employee.Employee;
import com.sparta.rbf.employees_project2.jdbc.employee.EmployeeFormatter;
import com.sparta.rbf.employees_project2.jdbc.employee.Gender;
import com.sparta.rbf.employees_project2.jdbc.jackson.Employees;
import com.sparta.rbf.employees_project2.jdbc.jackson.FileWriterFactory;
import com.sparta.rbf.employees_project2.jdbc.logging.LogSetup;

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
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

//        LoadEmployees();

        LoadDepartments();

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
        int departmentChoice;
        do {
            departmentChoice = getDepartmentMenuItems();
            System.out.println("\nDepartment chosen: " + convertNumberToDepartmentName(departmentChoice) + "\n");

            //Check if department id exists
            if (!convertNumberToDepartmentName(departmentChoice).equals("Department not found.")) {
                String startDate = getDate("start");
                String endDate = getDate("end");

                if (isStartDateBeforeEndDate(startDate, endDate)) {
                    getEmployeeData(startDate, endDate, convertNumberToDepartmentId(departmentChoice));
                }
            }
        }
        while (departmentChoice != 0);
    }

    private static void LoadEmployees() {
        EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionManager.createConnection());
        ResultSet employees = employeeDAO.getAllEmployees();

        EmployeeFormatter.populateEmployeeRepository(employees);
        for(Employee emp: EmployeeRepository.employees){
            System.out.println(emp.toString());
        }
        ConnectionManager.closeConnection();
    }

    private static void LoadDepartments() {
        EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionManager.createConnection());
        ResultSet departments = employeeDAO.getAllDepartments();
        try {
            while (departments.next()) {
                String departmentId = departments.getString(1);
                String departmentName = departments.getString(2);

                Department department = new Department(departmentId,departmentName);
                DepartmentRepository.addDepartment(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConnectionManager.closeConnection();
    }

    private static void getEmployeeData(String startDate, String endDate, String departmentId) {
        System.out.println("\nLooking for employees in " + departmentId + " department, from " + startDate + " to " + endDate);

        EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionManager.createConnection());
        ResultSet employeesResultSet = employeeDAO.getAllEmployeesInDepartmentWithinDates(departmentId, startDate, endDate);

        ArrayList<Employee> arrayList = EmployeeFormatter.resultSetToArrayList(employeesResultSet);
        Employees employees = new Employees(arrayList);
        try {
            FileWriterFactory.createFile(employees);
        }
        catch (FileNotFoundException e) {
            System.out.println("File input incorrect");
        }
        ConnectionManager.closeConnection();
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

    private static int getDepartmentMenuItems() {
        Scanner input = new Scanner(System.in);

        for(Department dept: DepartmentRepository.departments){
            System.out.println("(" + convertDepartmentIdToNumbers(dept.getDepartmentId()) + ") " + dept.getDepartmentName());
        }

        System.out.print("------------------------"
                + "\n(0) Return to main menu"
                +"\n\nChoice: ");
        return input.nextInt();
    }

    private static int convertDepartmentIdToNumbers(String departmentId) {
        return Integer.parseInt(departmentId.replaceFirst("^\\D*(0*)", ""));
    }

    private static String convertNumberToDepartmentId(int number) {
        return String.format("d%03d", number);
    }

    private static String convertNumberToDepartmentName(int number) {
        for(Department dept: DepartmentRepository.departments){
            if (dept.getDepartmentId().equals(convertNumberToDepartmentId(number))) {
                return dept.getDepartmentName();
            }
        }
        return "Department not found.";
    }
}
