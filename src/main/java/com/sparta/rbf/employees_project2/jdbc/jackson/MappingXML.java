package com.sparta.rbf.employees_project2.jdbc.jackson;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sparta.rbf.employees_project2.jdbc.jackson.Employees;


import java.io.File;
import java.io.IOException;

import com.sparta.rbf.employees_project2.jdbc.jackson.Employees;


public class MappingXML implements JacksonMapping{
    @Override
    public void saveToFile(Employees employees, String fileName){
        try {
            XmlMapper mapper=new XmlMapper();
            mapper.registerModule(new JavaTimeModule()).configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/"+fileName), employees);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
