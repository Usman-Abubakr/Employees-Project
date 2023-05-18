package com.sparta.rbf.employees_project2.jdbc.jackson;

public class FilenameValidation {
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
        return fileExtension.equals("xml") || fileExtension.equals("json")||fileExtension.equals("csv");
    }

    public static String getFileExtension(String fileName) {
        String[] fileNameExtension = fileName.split("\\.");
        return fileNameExtension[fileNameExtension.length - 1];
    }

}
