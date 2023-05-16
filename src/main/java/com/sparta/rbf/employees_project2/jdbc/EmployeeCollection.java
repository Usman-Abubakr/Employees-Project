package com.sparta.rbf.employees_project2.jdbc;
import com.sparta.rbf.employees_project.employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeCollection {
    public ArrayList<Employee> employees;

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
