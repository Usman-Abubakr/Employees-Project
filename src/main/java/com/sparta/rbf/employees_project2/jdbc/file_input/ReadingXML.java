package com.sparta.rbf.employees_project2.jdbc.file_input;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sparta.rbf.employees_project2.jdbc.CSVFileWriter;
import com.sparta.rbf.employees_project2.jdbc.ConnectionManager;
import com.sparta.rbf.employees_project2.jdbc.EmployeeDAO;
import com.sparta.rbf.employees_project2.jdbc.employee.UncheckedEmployee;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;


public class ReadingXML implements FileReading{
    @Override
    public void getEmployeesFromFile(String fileName) {
        File xmlFile = new File("src/main/resources/employees03.xml");
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        try  {
            UncheckedEmployee[] employees = xmlMapper.readValue(xmlFile, UncheckedEmployee[].class);

            List<UncheckedEmployee> uniqueEmployees = new ArrayList<>();
            List<UncheckedEmployee> duplicateEmployees = getDuplicates(Arrays.asList(employees));

            for (UncheckedEmployee employee : employees) {
                if (!duplicateEmployees.contains(employee)) {
                    uniqueEmployees.add(employee);
                } else {
//                    CSVFileWriter.writeToCSV(employee, "");
                    // call write to csv, this will write the duplicates employees
                }
            }

            EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionManager.createConnection());
            for (UncheckedEmployee employee : uniqueEmployees) {
                if (employee.isValid()) {
                    employeeDAO.createEmployee(employee.getEmpNoAsInt(), employee.getBirthDate(), employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getHireDate());
                    System.out.println(employee);
                } else {
                    // call write to csv, this will write the corrupted employees
                }
            }
            ConnectionManager.closeConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<UncheckedEmployee> getDuplicates(final List<UncheckedEmployee> employeeList) {
        return getDuplicatesMap(employeeList).values().stream()
                .filter(duplicates -> duplicates.size() > 1)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private static Map<String, List<UncheckedEmployee>> getDuplicatesMap(List<UncheckedEmployee> employeeList) {
        return employeeList.stream().collect(Collectors.groupingBy(UncheckedEmployee::uniqueAttributes));
    }
}
