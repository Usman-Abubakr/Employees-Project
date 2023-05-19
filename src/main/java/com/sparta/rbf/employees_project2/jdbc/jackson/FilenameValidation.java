package com.sparta.rbf.employees_project2.jdbc.jackson;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FileNameValidation {

    public static String createFileName(String fileExtension, String filename) {
        return filename + "." + fileExtension;
    }

    public static String getFileName() {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd_HHmmss");
        String defaultName = "export_" + now.format(formatDateTime);
        String input = "";

        System.out.println("Enter the file name you would like, otherwise press [Enter] to use a default name (" + defaultName + "):");
        input = scanner.nextLine();

        if (input.equals("")) {
            input = defaultName;
        }
        return removeIllegalCharacters(input);
    }


    public static String removeIllegalCharacters(String input) {
        return input.replaceAll("[\\.\\\\/:*?\"<>|]", "_");
    }
    public static boolean isFileExtensionValid(String fileExtension){
        return fileExtension.equals("xml") || fileExtension.equals("json");

    }

    public static String getFileExtensionScan() throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        System.out.println("Enter the file extension you would like to use: (json / xml) ");
        input = scanner.nextLine();
        if (!isFileExtensionValidForMapping(input.toLowerCase())) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public static boolean isFileExtensionValidForMapping(String fileExtension) {
        return fileExtension.equals("xml") || fileExtension.equals("json");
    }

}
