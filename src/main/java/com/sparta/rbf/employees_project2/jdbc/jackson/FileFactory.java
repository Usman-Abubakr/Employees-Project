package com.sparta.rbf.employees_project2.jdbc.jackson;

import com.sparta.rbf.employees_project2.jdbc.jackson.Employees;

import java.util.Scanner;

public class FileFactory {
    public static void createFile(Employees employees) {
        String fileName = getFileName();
        String fileExtension = getFileExtension(fileName).toLowerCase();
        if (isFileNameValid(fileName)&&isFileExtensionValid(fileExtension)) {
            getMapper(fileExtension, fileName, employees);
        } else {
            System.out.println("File name is invalid");
        }
    }
    public static String getFileName(){
        System.out.println("Enter the file name you would like to use: ");
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
    }

    public static boolean isFileNameValid(String filename) {
        String regex_pattern = "^[A-za-z0-9.-]{1,255}$";
        boolean hasValidChars = filename.matches(regex_pattern);
        int count = 0;

        for (char c : filename.toCharArray()) {
            if (c == '.') {
                count++;
            }
        }
        return hasValidChars && count == 1;
    }

    public static boolean isFileExtensionValid(String fileExtension) {
        return fileExtension.equals("xml") || fileExtension.equals("json");
    }

    public static String getFileExtension(String fileName) {
        String[] fileNameExtension = fileName.split("\\.");
        return fileNameExtension[fileNameExtension.length - 1];
    }

    public static void getMapper(String fileExtension, String fileName, Employees employees) {
        if (fileExtension.equals("json")) {
            new MappingJSON().saveToFile(employees,fileName);
        } else if (fileExtension.equals("xml")) {
            new MappingXML().saveToFile(employees,fileName);
        } else {
            System.out.println("File type is invalid");
        }
    }

}
