package com.sparta.rbf.employees_project2.jdbc;

import com.sparta.rbf.employees_project2.jdbc.util.SQLQueries;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

//Create
//Read
//Update
//Delete
public class EmployeeDAO {
    public static final Logger logger = Logger.getLogger(EmployeeDAO.class.getName());
    private final Connection connection;
    private Statement statement;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Failed to create statement.");
            throw new RuntimeException(e);
        }
    }

    public ResultSet getAllEmployees() {
        try {
            ResultSet resultSet = statement.executeQuery(SQLQueries.SELECT_ALL);
            logger.log(Level.INFO, "Retrieved all employees from database.");
            return resultSet;
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Failed to retrieve employees from database.");
            e.printStackTrace();
        }
        return null;
    }

    public void createEmployee(int empNo, Date birthDate, String firstName, String lastName, String gender, Date hireDate) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.CREATE);
            preparedStatement.setInt(1, empNo);
            preparedStatement.setDate(2, birthDate);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, lastName);
            preparedStatement.setString(5, gender);
            preparedStatement.setDate(6, hireDate);
            preparedStatement.executeUpdate();
            logger.log(Level.INFO, "Added an employee to the database.");
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Failed to add employee to database.");
            e.printStackTrace();
        }
    }
}
