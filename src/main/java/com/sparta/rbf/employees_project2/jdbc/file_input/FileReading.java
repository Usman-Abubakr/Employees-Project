package com.sparta.rbf.employees_project2.jdbc.file_input;

public interface FileReading {
    String filesDirectory = "src/main/resources/";
    void getEmployeesFromFile(String fileName);
}
