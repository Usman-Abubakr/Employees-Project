package com.sparta.mg.employees_project;

import java.io.IOException;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        try {
            String[] employees = EmployeeFactory.getEmployees(2);
            System.out.println(Arrays.toString(employees));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
