package com.sparta.rbf.employees_project2.jdbc.file_input;

import java.util.Scanner;

public class FilenameValidatorForImports {
    public static String getFileName(){
        System.out.println("Enter the file name you would like to use: ");
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
    }

    public static boolean isFileNameValid(String filename) {
        String regex_pattern = "^[^~)('!*<>:;,?\"*|/]+$";
        boolean hasValidChars = filename.matches(regex_pattern);
        int count = 0;
        for (char c : filename.toCharArray()) {
            if (c == '.') {
                count++;
            }
        }
        return hasValidChars && count == 1;
    }
    public static String getFileExtension(String fileName) {
        String[] fileNameExtension = fileName.split("\\.");
        return fileNameExtension[fileNameExtension.length - 1];
    }
    public static boolean isFileExtensionValid(String fileExtension) {
        return fileExtension.equals("xml") || fileExtension.equals("json")||fileExtension.equals("csv");
    }

}
