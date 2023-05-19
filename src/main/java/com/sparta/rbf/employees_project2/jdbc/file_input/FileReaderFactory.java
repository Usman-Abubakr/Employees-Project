package com.sparta.rbf.employees_project2.jdbc.file_input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.sparta.rbf.employees_project2.jdbc.App.getFileName;

import static com.sparta.rbf.employees_project2.jdbc.file_input.FilenameValidatorForImports.isFileExtensionValid;
import static com.sparta.rbf.employees_project2.jdbc.file_input.FilenameValidatorForImports.isFileNameValid;




public class FileReaderFactory {
    public static final Logger logger = Logger.getLogger(FileReaderFactory.class.getName());

    public void readFile() throws FileNotFoundException{
        String fileName = FilenameValidatorForImports.getFileName();
        String fileExtension = FilenameValidatorForImports.getFileExtension(fileName).toLowerCase();
        if (isFileNameValid(fileName)&&isFileExtensionValid(fileExtension)){
          FileReading fileReading= getFileReader(fileName, fileExtension);
          fileReading.getEmployeesFromFile(fileName);
        } else {
            throw new FileNotFoundException();
        }
    }

    public  FileReading getFileReader(String filename, String fileExtension){
        if(fileExtension.equals("csv")){
           return new ReadingCSV();
        } else if (fileExtension.equals("json")) {
            return new ReadingJSON();
        }
            return new ReadingXML();

    }

}
