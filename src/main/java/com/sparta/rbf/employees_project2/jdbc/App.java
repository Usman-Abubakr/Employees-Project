package com.sparta.rbf.employees_project2.jdbc;

import com.sparta.rbf.employees_project2.jdbc.employee.Employee;
import com.sparta.rbf.employees_project2.jdbc.employee.EmployeeFormatter;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

public class App {
    //('11001', '1960-01-01', 'Bob', 'Smith', 'M', '2023-05-12');
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionManager.createConnection());
        
        ResultSet employees = employeeDAO.getAllEmployees();
        ArrayList<Employee> employeeArrayList = EmployeeFormatter.resultSetToArrayList(employees);
        for(Employee emp: employeeArrayList){
            System.out.println(emp.toString());
        }
        ConnectionManager.closeConnection();
    }
}
