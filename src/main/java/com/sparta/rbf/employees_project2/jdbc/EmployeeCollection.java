package com.sparta.rbf.employees_project2.jdbc;

import java.util.ArrayList;
import java.util.List;

public class EmployeeCollection {
    private List<Employee> employees;

    public EmployeeCollection() {
        employees = new ArrayList<Employee>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
}
