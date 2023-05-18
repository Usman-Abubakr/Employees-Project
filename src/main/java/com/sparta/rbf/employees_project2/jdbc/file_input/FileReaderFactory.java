package com.sparta.rbf.employees_project2.jdbc.file_input;

import static com.sparta.rbf.employees_project2.jdbc.App.getFileName;
import static com.sparta.rbf.employees_project2.jdbc.jackson.FileFactory.*;
import static com.sparta.rbf.employees_project2.jdbc.jackson.FileValidation.*;

public class FileReaderFactory {
    public void readFile(String filename){
        String fileName = getFileName();
        String fileExtension = getFileExtension(fileName).toLowerCase();
        if (isFileNameValid(fileName)&&isFileExtensionValid(fileExtension)) {
            getFileReader(filename, fileExtension);
//            getMapper(fileExtension, fileName, employees);
        } else {
            System.out.println("File name is invalid");
        }
    }

    public static void getFileReader(String filename, String fileExtension){

    }

}
