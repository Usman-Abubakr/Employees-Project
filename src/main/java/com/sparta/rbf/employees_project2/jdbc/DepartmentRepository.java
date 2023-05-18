package com.sparta.rbf.employees_project2.jdbc;

import com.sparta.rbf.employees_project2.jdbc.employee.Employee;

import java.util.ArrayList;
import java.util.logging.Logger;

public class DepartmentRepository {
    public static final Logger logger = Logger.getLogger(DepartmentRepository.class.getName());

    public static final ArrayList<Department> departments = new ArrayList<>();

    private DepartmentRepository() {
    }


    public static ArrayList<Department> getAllDepartments() {
        return departments;
    }
}
