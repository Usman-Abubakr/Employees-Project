package com.sparta.rbf.employees_project;

import com.sparta.rbf.employees_project.employee.Employee;
import com.sparta.rbf.employees_project.employee.Gender;
import com.sparta.rbf.employees_project.employee.NamePrefix;
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

    @Test
    @DisplayName("Check that retrieving an Employee's details return the correct values")
    void checkForDetails() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(123456, employee1.getEmpID()),
                () -> Assertions.assertEquals(NamePrefix.MR, employee1.getNamePrefix()),
                () -> Assertions.assertEquals("John", employee1.getFirstName()),
                () -> Assertions.assertEquals('P', employee1.getMiddleInitial()),
                () -> Assertions.assertEquals("Smith", employee1.getLastName()),
                () -> Assertions.assertEquals(Gender.MALE, employee1.getGender()),
                () -> Assertions.assertEquals("johnsmith@gmail.com", employee1.getEmail()),
                () -> Assertions.assertEquals(LocalDate.of(1979,10,25), employee1.getDateOfBirth()),
                () -> Assertions.assertEquals(LocalDate.of(2021, 5,10), employee1.getDateOfJoining()),
                () -> Assertions.assertEquals(44000, employee1.getSalary())
        );
    }


}
