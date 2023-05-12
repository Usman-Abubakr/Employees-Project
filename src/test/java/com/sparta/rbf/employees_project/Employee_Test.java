package com.sparta.rbf.employees_project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class Employee_Test {
    Employee employee1 = new Employee(123456, NamePrefix.MR, "John", 'P', "Smith",
            Gender.MALE, "johnsmith@gmail.com", LocalDate.of(1979,10,25),
            LocalDate.of(2021, 5,10), 44000);

    Employee employee2 = new Employee(987546, NamePrefix.MRS, "Emma", 'C', "Wood",
            Gender.FEMALE, "emmacwood@gmail.com", LocalDate.of(1999,8,22),
            LocalDate.of(2022,3,21), 30000);

    @Test
    @DisplayName("Check that a new Employee object can be created")
    void checkForEmployeeInstantiation() {
        Assertions.assertTrue(employee1 != null);
    }

    @Test
    @DisplayName("Check that two different Employee objects will be seen as not equal")
    void checkEmployeesNotEqual() {
        Assertions.assertNotEquals(employee1, employee2);
    }

}
