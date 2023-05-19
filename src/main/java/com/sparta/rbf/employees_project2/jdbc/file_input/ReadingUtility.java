package com.sparta.rbf.employees_project2.jdbc.file_input;

import com.sparta.rbf.employees_project2.jdbc.CSVFileWriter;
import com.sparta.rbf.employees_project2.jdbc.ConnectionManager;
import com.sparta.rbf.employees_project2.jdbc.EmployeeDAO;
import com.sparta.rbf.employees_project2.jdbc.employee.UncheckedEmployee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReadingUtility {
    public static List<UncheckedEmployee> getDuplicates(final List<UncheckedEmployee> employeeList) {
        return getDuplicatesMap(employeeList).values().stream()
                .filter(duplicates -> duplicates.size() > 1)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public static Map<String, List<UncheckedEmployee>> getDuplicatesMap(List<UncheckedEmployee> employeeList) {
        return employeeList.stream().collect(Collectors.groupingBy(UncheckedEmployee::uniqueAttributes));
    }

    public static List<UncheckedEmployee> removeDuplicates(UncheckedEmployee[] employees, List<UncheckedEmployee> duplicateEmployees, String fileName) {
        List<UncheckedEmployee> uniqueEmployees = new ArrayList<>();
        for (UncheckedEmployee employee : employees) {
            if (!duplicateEmployees.contains(employee)) {
                uniqueEmployees.add(employee);
            } else {
                    CSVFileWriter.writeToCSV(employee, fileName);
                // call write to csv, this will write the duplicates employees
            }
        }
        return uniqueEmployees;
    }

    public static void insertValidEmployeesIntoDatabase(List<UncheckedEmployee> uniqueEmployees, String fileName) {
        EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionManager.createConnection());
        for (UncheckedEmployee employee : uniqueEmployees) {
            if (employee.isValid()) {
                employeeDAO.createEmployee(employee.getEmpNoAsInt(), employee.getBirthDate(), employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getHireDate());
            } else {
                CSVFileWriter.writeToCSV(employee, fileName);
                // call write to csv, this will write the corrupted employees
            }
        }
        ConnectionManager.closeConnection();
    }
}
