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
                UncheckedEmployee uncheckedEmployee = new UncheckedEmployee();
//                employees.add(uncheckedEmployee)
                //assign values with setters from hussein

               /* if(uncheckedEmployee is corrupt)
                        CSVFileWriter.writeToCSV(uncheckedEmployee,filename);
                  else
                        add to EmployeeRepository.addEmployees
                */
            }
            /*
                while read line isnt null
                readline->
                    if validation isnt passed
                    send to csv writer
             */
            reader.close();
        } catch (IOException e) {
            logger.log(Level.WARNING,"Corrupt records cannot read from employees01.csv");
        }
    }
}
