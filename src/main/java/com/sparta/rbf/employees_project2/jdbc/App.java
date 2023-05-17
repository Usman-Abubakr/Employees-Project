package com.sparta.rbf.employees_project2.jdbc;

import com.sparta.rbf.employees_project2.jdbc.employee.Employee;
import com.sparta.rbf.employees_project2.jdbc.employee.EmployeeFormatter;
import com.sparta.rbf.employees_project2.jdbc.logging.LogSetup;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Logger;

public class App {
    public static final Logger logger = Logger.getLogger(App.class.getName());
    //('11001', '1960-01-01', 'Bob', 'Smith', 'M', '2023-05-12');
    public static void main(String[] args) {
        LogSetup.setup();

        EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionManager.createConnection());
        
        ResultSet employees = employeeDAO.getAllEmployees();
        EmployeeFormatter.populateEmployeeRepository(employees);
        for(Employee emp: EmployeeRepository.employees){
            System.out.println(emp.toString());
        }
        ConnectionManager.closeConnection();
    }
}
