package com.sparta.rbf.employees_project2.jdbc.file_input;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sparta.rbf.employees_project2.jdbc.employee.UncheckedEmployee;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.sparta.rbf.employees_project2.jdbc.employee.UncheckedEmployee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadingCSV implements FileReading{
    public static final Logger logger = Logger.getLogger(ReadingCSV.class.getName());
    @Override
    public void getEmployeesFromFile(String fileName) {
        File file = new File(filesDirectory + fileName);
        List<UncheckedEmployee> employees = new ArrayList<UncheckedEmployee>();

        try(BufferedReader reader=new BufferedReader(new FileReader(file))) {
            String employeeLine;
            while((employeeLine=reader.readLine())!=null){
                String[] splitEmployeeLine = employeeLine.split(",");
                UncheckedEmployee uncheckedEmployee = new UncheckedEmployee(splitEmployeeLine[0], splitEmployeeLine[1], splitEmployeeLine[2], splitEmployeeLine[3], splitEmployeeLine[4], splitEmployeeLine[5]);
                employees.add(uncheckedEmployee);
            }
            List<UncheckedEmployee> duplicateEmployees = ReadingUtility.getDuplicates(employees);
            UncheckedEmployee[] employeesArray = employees.toArray(new UncheckedEmployee[0]);
            List<UncheckedEmployee> uniqueEmployees = ReadingUtility.removeDuplicates(employeesArray, duplicateEmployees, fileName);
            ReadingUtility.insertValidEmployeesIntoDatabase(uniqueEmployees, fileName);
            reader.close();
        } catch (IOException e) {
            logger.log(Level.WARNING,"Corrupt records cannot read from employees01.csv");
        }
    }
}
