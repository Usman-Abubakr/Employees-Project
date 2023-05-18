package com.sparta.rbf.employees_project2.jdbc.jackson;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.sparta.rbf.employees_project2.jdbc.employee.Employee;

import java.util.ArrayList;

public class Employees {//wrapper class
    @JacksonXmlElementWrapper(useWrapping = false)
    ArrayList<Employee> employee;

    public Employees(ArrayList<Employee> employees) {
        this.employee = employees;
    }

    public ArrayList<Employee> getEmployees() {
        return employee;
    }
}
