package com.sparta.rbf.employees_project2.jdbc;

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

    public void getAllUsers() {
        try {
            ResultSet resultSet = statement.executeQuery(SQLQueries.SELECT_ALL);
            while (resultSet.next()) {
                System.out.print(
                        resultSet.getInt(1) + " " +
                                resultSet.getString(2) + " " +
                                resultSet.getString(3) + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
