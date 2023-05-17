package com.sparta.rbf.employees_project2.jdbc;

import com.sparta.rbf.employees_project2.jdbc.employee.Employee;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeRepository {
    public static final Logger logger = Logger.getLogger(EmployeeRepository.class.getName());

    public static final ArrayList<Employee> employees = new ArrayList<>();

    private EmployeeRepository() {
    }

    public static void addEmployee(Employee employee) {

        employees.add(employee);
        //logger.log(Level.INFO, employee.toString() + " added to repository.");
    }

    public static ArrayList<Employee> getAllEmployees() {
        logger.log(Level.INFO, "Retrieved all employees from repository.");
        return employees;
    }
}
