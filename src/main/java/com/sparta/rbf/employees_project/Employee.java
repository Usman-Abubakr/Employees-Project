package com.sparta.rbf.employees_project;


import java.time.LocalDate;
import java.util.Date;

public class Employee {
    private int empID;
    private NamePrefix namePrefix;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private Gender gender;
    private String email;
    private LocalDate dateOfBirth;
    private LocalDate dateOfJoining;
    private int salary;

    public Employee(int empID, NamePrefix namePrefix, String firstName, char middleInitial, String lastName,
                    Gender gender, String email, LocalDate dateOfBirth, LocalDate dateOfJoining, int salary) {
        this.empID = empID;
        this.namePrefix = namePrefix;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
    }

    public int getEmpID() {
        return empID;
    }

    public NamePrefix getNamePrefix() {
        return namePrefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public char getMiddleInitial() {
        return middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public int getSalary() {
        return salary;
    }
}
