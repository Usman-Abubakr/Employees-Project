package com.sparta.rbf.employees_project2.jdbc.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sparta.rbf.employees_project2.jdbc.jackson.Employees;


import java.io.File;
import java.io.IOException;

public class MappingJSON implements JacksonMapping{
    @Override
    public void saveToFile(Employees employees, String fileName){
        ObjectMapper mapper=new ObjectMapper();
        mapper.registerModule(new JavaTimeModule()).configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/" + fileName),employees.getEmployees());
            System.out.println(String.format("File: %s, is saved in: src/main/resources/", fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
