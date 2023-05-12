package com.sparta.rbf.employees_project;



import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class EmployeeFormatter {
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(dateStr, formatter);
        } catch (NumberFormatException | DateTimeParseException e) {
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
        if (genderStr.equals("M")||genderStr.equals("m")) {
            return Gender.MALE;
        } else if (genderStr.equals("F")||genderStr.equals("f")) {
            return Gender.FEMALE;
        }
        return Gender.OTHER;
    }

    public static NamePrefix strToNamePrefix(String namePrefixStr){
        return switch (namePrefixStr) {
            case "Mr." -> NamePrefix.Mr;
            case "Mrs." -> NamePrefix.Mrs;
            case "Ms." -> NamePrefix.Ms;
            case "Dr." -> NamePrefix.Dr;
            case "Drs." -> NamePrefix.Drs;
            case "Prof." -> NamePrefix.Prof;
            case "Hon." -> NamePrefix.Hon;
            default -> NamePrefix.Mx;
        };
    }



    public static Employee convertStringToEmployee(String employeeString) {
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
        ArrayList<Employee> employeeArrayList=new ArrayList<>();
        for(String employeeString:employeeArray){
            Employee newEmployee=convertStringToEmployee(employeeString);
            employeeArrayList.add(newEmployee);
        }
        return employeeArrayList;
    }

}
