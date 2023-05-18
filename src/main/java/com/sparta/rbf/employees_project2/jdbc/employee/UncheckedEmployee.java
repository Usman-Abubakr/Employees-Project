package com.sparta.rbf.employees_project2.jdbc.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.time.LocalDate;

@JacksonXmlRootElement(localName = "employee")
public class UncheckedEmployee {
    @JacksonXmlProperty(localName = "emp_no")
    @JsonProperty("emp_no")
    private String empNo;

    @JacksonXmlProperty(localName = "first_name")
    @JsonProperty("first_name")
    private String firstName;

    @JacksonXmlProperty(localName = "last_name")
    @JsonProperty("last_name")
    private String lastName;

    @JacksonXmlProperty(localName = "gender")
    private String gender;

    @JacksonXmlProperty(localName = "birth_date")
    @JsonProperty("birth_date")
    private String birthDate;

    @JacksonXmlProperty(localName = "hire_date")
    @JsonProperty("hire_date")
    private String hireDate;

    // Default constructor
    public UncheckedEmployee() {
    }

    @Override
    public String toString() {
        return "Employee ID: " + empNo
                + ", Firstname: " + firstName
                + ", Lastname: " + lastName
                + ", Gender: " + gender
                + ", Date of birth: " + birthDate
                + ", Hire Date: " + hireDate;
    }
}