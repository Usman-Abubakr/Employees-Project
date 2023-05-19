package com.sparta.rbf.employees_project2.jdbc.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

import static com.sparta.rbf.employees_project2.jdbc.App.getFileName;
import static com.sparta.rbf.employees_project2.jdbc.jackson.FileNameValidation.getFileExtension;
import static com.sparta.rbf.employees_project2.jdbc.jackson.FileNameValidation.*;

public class FileWriterFactory {
    /*
    create a new class called FileValidation, move all filename validator methods to this new class
     */
    public static final Logger logger = Logger.getLogger(FileWriterFactory.class.getName());

    public static void createFile(Employees employees) throws FileNotFoundException {
        String fileExtension = getFileExtension();
        String fileName=createFileName(fileExtension, FileNameValidation.getFileName());
        ObjectMapper mapper=getMapper(fileExtension);
        FileWriterFactory.saveToFile(mapper, employees,fileName);
    }

    private static boolean isFileExtensionValid(String fileExtension) {
        return false;
    }

    public static void getMapper(String fileExtension, String fileName, Employees employees) {
        if (fileExtension.equals("json")) {
            new MappingJSON().saveToFile(employees, fileName);
        } else if (fileExtension.equals("xml")) {
            new MappingXML().saveToFile(employees, fileName);
        }
    }


    public static ObjectMapper getMapper(String fileExtension) {
        if(fileExtension.equals("xml")) {
            return new XmlMapper();
        } else {
            return new ObjectMapper();
        }
    }

    public static <T extends ObjectMapper> void saveToFile(T objectMapper, Employees employees, String fileName) {
        objectMapper.registerModule(new JavaTimeModule()).configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/" + fileName),employees.getEmployees());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
