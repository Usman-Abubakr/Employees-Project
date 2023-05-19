package com.sparta.rbf.employees_project2.jdbc.file_input;

import com.sparta.rbf.employees_project2.jdbc.employee.UncheckedEmployee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadingCSV implements FileReading{//method taken from EmployeeFactory.java in employee_project
    public static final Logger logger = Logger.getLogger(ReadingCSV.class.getName());
    @Override
    public void getEmployeesFromFile(String fileName) {
        String filePath="src/main/resources/"+fileName;
        File file = new File(filePath);
        try(BufferedReader reader=new BufferedReader(new FileReader(file))) {
            String employeeLine;
            while((employeeLine=reader.readLine())!=null){
                String[] splitEmployeeLine = employeeLine.split(",");
                System.out.println(employeeLine);
                UncheckedEmployee uncheckedEmployee=new UncheckedEmployee();
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
