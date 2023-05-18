package com.sparta.rbf.employees_project2.jdbc;

import com.sparta.rbf.employees_project2.jdbc.employee.Employee;

import java.util.ArrayList;

public class EmployeeRepository {
    public static final ArrayList<Employee> employees = new ArrayList<>();

    private EmployeeRepository() {
    }

    public static void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public static ArrayList<Employee> getAllEmployees() {
        return employees;
    }
}
