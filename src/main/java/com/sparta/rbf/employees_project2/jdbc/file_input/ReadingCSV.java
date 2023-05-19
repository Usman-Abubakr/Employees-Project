package com.sparta.rbf.employees_project2.jdbc.file_input;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sparta.rbf.employees_project2.jdbc.employee.UncheckedEmployee;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ReadingCSV implements FileReading{//method taken from EmployeeFactory.java in employee_project
    // returns an array containing numEmployees Strings, each representing an Employee as a row from the CSV file
    // 1 <= numEmployees <= 1000
    // may throw IOExceptions, which need to be dealt with in the client code
    // employees.csv should be in the src/main/resources folder in the project
//    public static String[] getEmployeesFromFile(int numEmployees) throws IOException {
//        if (numEmployees < 1 || numEmployees > 1000)
//            throw new IllegalArgumentException("Argument 'numEmployees' must be between 1 and 1000");
//        String employeeLine;
//        List<String> result = new ArrayList<>();
//        BufferedReader f = new BufferedReader(new FileReader("src/main/resources/employees.csv"));
//        // read all the records from the file and add them to the list
//        f.readLine();
//        while ((employeeLine = f.readLine()) != null)
//            result.add(employeeLine);
//        // randomise
//        Collections.shuffle(result);
//        // return the first numEmployees values as an array
//        return result.subList(0,numEmployees).toArray(new String[0]);
//    }

    @Override
    public void getEmployeesFromFile(String fileName) {
        File jsonFile = new File(filesDirectory + fileName);
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.registerModule(new JavaTimeModule());
        try  {
            UncheckedEmployee[] employees = jsonMapper.readValue(jsonFile, UncheckedEmployee[].class);
            List<UncheckedEmployee> duplicateEmployees = ReadingUtility.getDuplicates(Arrays.asList(employees));
            List<UncheckedEmployee> uniqueEmployees = ReadingUtility.removeDuplicates(employees, duplicateEmployees, fileName);
            ReadingUtility.insertValidEmployeesIntoDatabase(uniqueEmployees, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
