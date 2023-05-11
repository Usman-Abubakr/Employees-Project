package com.sparta.rbf.employees_project;

import java.util.Date;

public class Employee {
    private int empID;
    private NamePrefix namePrefix;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private Gender gender;
    private String email;
    private Date dateOfBirth;
    private Date dateOfJoining;
    private int salary;

    public String getLastName() {
        return this.lastName;
    }
}
