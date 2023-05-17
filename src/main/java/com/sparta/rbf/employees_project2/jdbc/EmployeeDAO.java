package com.sparta.rbf.employees_project2.jdbc;

import com.sparta.rbf.employees_project2.jdbc.util.SQLQueries;

import java.sql.*;

//Create
//Read
//Update
//Delete
public class EmployeeDAO {
    private final Connection connection;
    private Statement statement;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getAllEmployees() {
        try {
            ResultSet resultSet = statement.executeQuery(SQLQueries.SELECT_ALL);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getAllEmployeesInDepartmentWithinDates(String department, String dateFrom, String dateTo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.SELECT_EMPLOYEES_IN_DEPARTMENT_WITHIN_DATES);
            preparedStatement.setString(1, department);
            preparedStatement.setString(2, dateFrom);
            preparedStatement.setString(3, dateTo);
            preparedStatement.setString(4, dateFrom);
            preparedStatement.setString(5, dateTo);
            preparedStatement.setString(6, dateFrom);
            preparedStatement.setString(7, dateTo);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void createEmployee(int empNo, String birthDate, String firstName, String lastName, String gender, String hireDate) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.CREATE);
            preparedStatement.setInt(1, empNo);
            preparedStatement.setString(2, birthDate);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, lastName);
            preparedStatement.setString(5, gender);
            preparedStatement.setString(6, hireDate);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
