package com.sparta.rbf.employees_project2.jdbc.file_input;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sparta.rbf.employees_project2.jdbc.employee.UncheckedEmployee;

import java.io.File;
import java.io.IOException;

public class ReadingXML implements FileReading{
    @Override
    public void getEmployeesFromFile() {
        File xmlFile = new File("src/main/resources/employees03.xml");
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        try  {
            UncheckedEmployee[] employees = xmlMapper.readValue(xmlFile, UncheckedEmployee[].class);

            for (UncheckedEmployee employee : employees) {
//                if (valid) {
//                    save to sql using createEmployee
//                } else {
//                    save to cvs using the function lanyas gonna make
//                }
                System.out.println(employee.toString());
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
