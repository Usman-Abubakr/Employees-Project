package com.sparta.rbf.employees_project;



import com.sparta.rbf.employees_project.employee.Employee;
import com.sparta.rbf.employees_project.employee.Gender;
import com.sparta.rbf.employees_project.employee.NamePrefix;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeFormatter {
    public static final Logger logger = Logger.getLogger(EmployeeFormatter.class.getName());
    /*
        get employee string array from EmployeeFactory.getEmployees(n),
        feed array by index into a method that separates each string array into employee string
        separate employee string into array of employee details
        convert string details into appropriate data types
        feed data types into constructor
     */
    public static String[] getNumEmployees(int num){
        try {
            return EmployeeFactory.getEmployees(num); //needs to be in try catch for IllegalArgumentException
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String[] getDetailsStr(String employeeStr){
        return employeeStr.split(",");
    }

    public static LocalDate strToLocalDate(String dateStr){
        logger.log(Level.FINE, "Converting date String: " + dateStr + " to LocalDate format.");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(dateStr, formatter);
        } catch (NumberFormatException | DateTimeParseException e) {
            logger.log(Level.FINER,"Caught invalid input when formatting date: " + dateStr);
            String[] dateStrSplit = dateStr.split("/");
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
        return Gender.OTHER;
    }

    public static NamePrefix strToNamePrefix(String namePrefixStr){
        logger.log(Level.FINE, "Converting name prefix String " + namePrefixStr + " to NamePrefix type format.");
        return switch (namePrefixStr) {
            case "Mr." -> NamePrefix.MR;
            case "Mrs." -> NamePrefix.MRS;
            case "Ms." -> NamePrefix.MS;
            case "Dr." -> NamePrefix.DR;
            case "Drs." -> NamePrefix.DRS;
            case "Prof." -> NamePrefix.PROF;
            case "Hon." -> NamePrefix.HON;
            default -> NamePrefix.MX;
        };
    }



    public static Employee convertStringToEmployee(String employeeString) {
        logger.log(Level.CONFIG, "Converting employee String to Employee object.");
        String[] employeeDetails=getDetailsStr(employeeString);
        int empID = Integer.parseInt(employeeDetails[0]);
        NamePrefix namePrefix = strToNamePrefix(employeeDetails[1]);
        String firstName = employeeDetails[2];
        char middleInitial = employeeDetails[3].charAt(0);
        String lastName = employeeDetails[4];
        Gender gender = strToGender(employeeDetails[5]);
        String email = employeeDetails[6];
        LocalDate dateOfBirth = strToLocalDate(employeeDetails[7]);
        LocalDate dateOfJoining = strToLocalDate(employeeDetails[8]);
        int salary = Integer.parseInt(employeeDetails[9]);

        return new Employee(empID, namePrefix, firstName, middleInitial, lastName, gender, email, dateOfBirth, dateOfJoining, salary);
    }
    public static ArrayList<Employee> convertArrayToList(String[] employeeArray) {
        logger.log(Level.CONFIG, "Converting Employee Array to List.");
        ArrayList<Employee> employeeArrayList=new ArrayList<>();
        for(String employeeString:employeeArray){
            Employee newEmployee=convertStringToEmployee(employeeString);
            employeeArrayList.add(newEmployee);
        }
        return employeeArrayList;
    }

}
