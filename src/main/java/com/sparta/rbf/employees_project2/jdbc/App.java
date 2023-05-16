package com.sparta.rbf.employees_project2.jdbc;

import java.sql.Date;
import java.sql.ResultSet;

public class App {
    //('11001', '1960-01-01', 'Bob', 'Smith', 'M', '2023-05-12');
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionManager.createConnection());

      employeeDAO.createEmployee(
              999999,
              new Date(1960,01,01),
              "Bob",
              "Smith",
              "M",
              new Date(2023,05,12));

        ResultSet employees = employeeDAO.getAllEmployees();
        ConnectionManager.closeConnection();
    }
}
