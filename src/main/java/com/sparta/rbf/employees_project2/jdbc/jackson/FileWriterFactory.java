package com.sparta.rbf.employees_project2.jdbc.jackson;

import java.io.FileNotFoundException;
import java.util.logging.Logger;

import static com.sparta.rbf.employees_project2.jdbc.App.getFileName;
import static com.sparta.rbf.employees_project2.jdbc.jackson.FilenameValidation.*;

public class FileWriterFactory {
    /*
    create a new class called FileValidation, move all filename validator methods to this new class
     */
    public static final Logger logger = Logger.getLogger(FileWriterFactory.class.getName());

    public static void createFile(Employees employees) throws FileNotFoundException {
        String fileName = getFileName();
        String fileExtension = getFileExtension(fileName).toLowerCase();
        if (isFileNameValid(fileName) && isFileExtensionValid(fileExtension)) {
            getMapper(fileExtension, fileName, employees);
        } else {
            throw new FileNotFoundException();
        }
    }

    public static void getMapper(String fileExtension, String fileName, Employees employees) {
        if (fileExtension.equals("json")) {
            new MappingJSON().saveToFile(employees, fileName);
        } else if (fileExtension.equals("xml")) {
            new MappingXML().saveToFile(employees, fileName);
        }
    }

}