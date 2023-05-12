package com.sparta.rbf.employees_project;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeFormatterTest {

    @ParameterizedTest
    @ValueSource(strings={"647173,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,04/04/1980,1/19/2012,123681","784160,Dr.,Corey,A,Jackman,M,corey.jackman@gmail.com,04/12/1959,6/29/1984,57616"})
    @DisplayName("Test if employee strings are appropriately converted to arrays")
    void checkStrSplit(String str){
        Assertions.assertTrue(EmployeeFormatter.getDetailsStr(str).getClass().isArray());
    }
    @ParameterizedTest
    @ValueSource(strings={"1/19/2012","12/2/1984","6/4/2022","07/02/2023"})
    @DisplayName("Test if strings are appropriately converted to LocalDate")
    void checkLocalDate(String str){
        LocalDate localDate = LocalDate.now();
        Assertions.assertEquals(localDate.getClass(),EmployeeFormatter.strToLocalDate(str).getClass());
    }

    @ParameterizedTest
    @ValueSource(strings={"M","m"})
    @DisplayName("Test if M or m is appropriately converted to gender enum")
    void checkMale(String gender){
        Assertions.assertEquals(Gender.MALE,EmployeeFormatter.strToGender(gender));
    }

    @ParameterizedTest
    @ValueSource(strings={"F","f"})
    @DisplayName("Test if F or f is appropriately converted to gender enum")
    void checkFemale(String gender){
        Assertions.assertEquals(Gender.FEMALE,EmployeeFormatter.strToGender(gender));
    }

    @ParameterizedTest
    @ValueSource(strings={"A","G","Z"})
    @DisplayName("Test if F is appropriately converted to gender enum")
    void checkGender(String letter){
        Assertions.assertEquals(Gender.OTHER,EmployeeFormatter.strToGender(letter));
    }

    @Test
    @DisplayName("Test if the correct name prefix is returned")
    void checkNamePrefix(){
        Assertions.assertAll(
                ()->Assertions.assertEquals(NamePrefix.Mr,EmployeeFormatter.strToNamePrefix("Mr.")),
                ()->Assertions.assertEquals(NamePrefix.Mrs,EmployeeFormatter.strToNamePrefix("Mrs.")),
                ()->Assertions.assertEquals(NamePrefix.Ms,EmployeeFormatter.strToNamePrefix("Ms.")),
                ()->Assertions.assertEquals(NamePrefix.Dr,EmployeeFormatter.strToNamePrefix("Dr.")),
                ()->Assertions.assertEquals(NamePrefix.Drs,EmployeeFormatter.strToNamePrefix("Drs.")),
                ()->Assertions.assertEquals(NamePrefix.Prof,EmployeeFormatter.strToNamePrefix("Prof.")),
                ()->Assertions.assertEquals(NamePrefix.Hon,EmployeeFormatter.strToNamePrefix("Hon."))
                );
    }

    Employee employee1 = new Employee(123456, NamePrefix.Mr, "John", 'P', "Smith",
            Gender.MALE, "johnsmith@gmail.com", LocalDate.of(1979,10,25),
            LocalDate.of(2021, 5,10), 44000);
    String employee1Str = "123456,Mr.,John,P,Smith,M,johnsmith@gmail.com,10/25/1979,5/10/2021,44000";

    @ParameterizedTest
    @ValueSource(strings={"647173,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,04/04/1980,1/19/2012,123681","784160,Dr.,Corey,A,Jackman,M,corey.jackman@gmail.com,04/12/1959,6/29/1984,57616"})
    @DisplayName("Test if object of type Employee is returned, given an array of Strings")
    void checkReturnEmployee(String s){
        Assertions.assertEquals(employee1.getClass(),EmployeeFormatter.convertStringToEmployee(s).getClass()
        );
    }

    @Test
    @DisplayName("Test if object of type Employee is returned with correct details")
    void checkEmployee(){
        Employee actualEmployee=EmployeeFormatter.convertStringToEmployee(employee1Str);
        Assertions.assertAll(
                ()-> Assertions.assertEquals(employee1.getEmpID(), actualEmployee.getEmpID()),
                ()-> Assertions.assertEquals(employee1.getNamePrefix(), actualEmployee.getNamePrefix()),
                ()-> Assertions.assertEquals(employee1.getFirstName(), actualEmployee.getFirstName()),
                ()-> Assertions.assertEquals(employee1.getMiddleInitial(), actualEmployee.getMiddleInitial()),
                ()-> Assertions.assertEquals(employee1.getLastName(), actualEmployee.getLastName()),
                ()-> Assertions.assertEquals(employee1.getGender(), actualEmployee.getGender()),
                ()-> Assertions.assertEquals(employee1.getEmail(), actualEmployee.getEmail()),
                ()-> Assertions.assertEquals(employee1.getDateOfBirth(), actualEmployee.getDateOfBirth()),
                ()-> Assertions.assertEquals(employee1.getDateOfJoining(), actualEmployee.getDateOfJoining()),
                ()-> Assertions.assertEquals(employee1.getSalary(), actualEmployee.getSalary())
        );
    }

    @Test
    @DisplayName("Test if Arraylist is returned")
    void checkIfArrayList(){
        String[] employeeArray=EmployeeFormatter.getNumEmployees(10);
        ArrayList<Employee> employeeArrayList=new ArrayList<>();
        employeeArrayList.add(employee1);
        Assertions.assertEquals(employeeArrayList.getClass(),EmployeeFormatter.convertArrayToList(employeeArray).getClass());
    }






}
