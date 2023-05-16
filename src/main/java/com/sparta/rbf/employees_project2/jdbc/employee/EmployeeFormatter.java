package com.sparta.rbf.employees_project2.jdbc.employee;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeFormatter {
    public static final Logger logger = Logger.getLogger(EmployeeFormatter.class.getName());
    public static LocalDate strToLocalDate(String dateStr){
        logger.log(Level.FINE, "Converting date String: " + dateStr + " to LocalDate format.");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(dateStr, formatter);
        } catch (NumberFormatException | DateTimeParseException e) {
            logger.log(Level.FINER,"Caught invalid input when formatting date: " + dateStr);
            String[] dateStrSplit = dateStr.split("-");
            int[] dateInt = new int[3];
            for (int i = 0; i < dateStrSplit.length; i++) {
                dateInt[i] = Integer.parseInt(dateStrSplit[i]);
            }
            localDate = LocalDate.of(dateInt[2], dateInt[0], dateInt[1]);//yyyy/M/d
        }
        return localDate;
    }

    public static Gender strToGender(String genderStr) {
        logger.log(Level.FINE,"Converting gender String " + genderStr + " to Gender type format.");
        if (genderStr.equals("M")||genderStr.equals("m")) {
            return Gender.MALE;
        } else if (genderStr.equals("F")||genderStr.equals("f")) {
            return Gender.FEMALE;
        }
        logger.log(Level.FINER,"Invalid/Unspecified gender. Defaulted to other.");
        return Gender.OTHER;//will throw an exception and a method to handle invalid entries
    }





    public static ArrayList<Employee> resultSetToArrayList(ResultSet resultSet) {
        logger.log(Level.CONFIG, "Converting resultSet to Employee object.");
        ArrayList<Employee> employees = new ArrayList<>();

        try {
            while (resultSet.next()) {
                int empNo=resultSet.getInt(1);
                LocalDate birthDate = strToLocalDate(resultSet.getString(2));
                String firstName = resultSet.getString(3);
                String lastName = resultSet.getString(4);
                Gender gender = strToGender(resultSet.getString(5));
                LocalDate hireDate = strToLocalDate(resultSet.getString(6));
                Employee employee = new Employee(empNo,firstName,lastName,gender,birthDate,hireDate);
                employees.add(employee);//possible use of employeecollection class
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

}