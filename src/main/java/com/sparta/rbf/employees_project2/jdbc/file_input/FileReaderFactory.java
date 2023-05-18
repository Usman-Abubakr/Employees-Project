package com.sparta.rbf.employees_project2.jdbc.file_input;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.sparta.rbf.employees_project2.jdbc.App.getFileName;
import static com.sparta.rbf.employees_project2.jdbc.jackson.FilenameValidation.*;

public class FileReaderFactory {
    public static final Logger logger = Logger.getLogger(FileReaderFactory.class.getName());

    public void readFile(String filename) throws FileNotFoundException{
        String fileName = getFileName();
        String fileExtension = getFileExtension(fileName).toLowerCase();
        if (isFileNameValid(fileName)&&isFileExtensionValid(fileExtension)) {
            getFileReader(filename, fileExtension);
        } else {
            throw new FileNotFoundException();
        }
    }

    public static void getFileReader(String filename, String fileExtension){
        if(fileExtension.equals("csv")){
            new ReadingCSV();
        } else if (fileExtension.equals("json")) {
            new ReadingJSON();
        } else if (fileExtension.equals("xml")) {
            new ReadingXML();
        }
    }

}
