package com.sparta.rbf.employees_project2.jdbc.file_input;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.sparta.rbf.employees_project2.jdbc.file_input.FilenameValidatorForImports.*;
import static com.sparta.rbf.employees_project2.jdbc.jackson.FilenameValidation.getFileExtension;

public class FileReaderFactory {
    public static final Logger logger = Logger.getLogger(FileReaderFactory.class.getName());

    public void readFile() throws IllegalArgumentException {
        String fileName = getFileName();
        String fileExtension = getFileExtension(fileName).toLowerCase();
        if (isFileNameValid(fileName) && isFileExtensionValid(fileExtension)) {
            FileReading fileReader=getFileReader(fileExtension);
            fileReader.getEmployeesFromFile(fileName);
            logger.log(Level.INFO,fileName+"has been created");
        } else {
            logger.log(Level.WARNING, fileName+"cannot be used");
            throw new IllegalArgumentException();
        }
    }
    public static String createCorruptFileName(String fileName) {
        String[] fileNameSplit = fileName.split("\\.");
        String dateAndTime = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date());
        dateAndTime = dateAndTime.replaceAll("/", "-");
        dateAndTime = dateAndTime.replaceAll(" ", "_");
        dateAndTime = dateAndTime.replaceAll(":", "-");
        return fileNameSplit[0] + "_corruptedData_" + dateAndTime + ".csv";
    }

    public static FileReading getFileReader(String fileExtension) {
        if (fileExtension.equals("csv")) {
            return new ReadingCSV();
        } else if (fileExtension.equals("json")) {
            return new ReadingJSON();
        }

        return new ReadingXML();
    }
}
