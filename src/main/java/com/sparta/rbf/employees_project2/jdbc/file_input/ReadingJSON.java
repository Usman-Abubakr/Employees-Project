package com.sparta.rbf.employees_project2.jdbc.file_input;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sparta.rbf.employees_project2.jdbc.employee.UncheckedEmployee;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ReadingJSON implements FileReading {
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
