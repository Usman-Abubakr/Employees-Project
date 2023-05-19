package com.sparta.rbf.employees_project2.jdbc.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

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

    public String uniqueAttributes() {
        return empNo + "_" + firstName + "_" + lastName + "_" + gender + "_" + birthDate + "_" + hireDate;
    }

    public boolean isValid() {
        return empNoIsValid() && firstNameIsValid() && lastNameIsValid() && genderIsValid() && birthDateIsValid() && hireDateIsValid();
    }

    private boolean empNoIsValid() {
        return empNo != null && empNo.matches("^\\d{1,8}$");
    }

    private boolean firstNameIsValid() {
        return firstName != null && firstName.matches("^[A-Za-z -]+$") && Character.isUpperCase(firstName.charAt(0));
    }

    private boolean lastNameIsValid() {
        return lastName != null && lastName.matches("^[A-Za-z -]+$") && Character.isUpperCase(lastName.charAt(0));
    }

    private boolean genderIsValid() {
        return gender != null && (gender.equals(Gender.M.toString()) || gender.equals(Gender.F.toString()));
    }

    private boolean birthDateIsValid() {
        if (birthDate == null) {
            return false;
        }

        try {
            LocalDate date = LocalDate.parse(birthDate);
            LocalDate minDate = LocalDate.of(1900, 1, 1);
            LocalDate currentDate = LocalDate.now();

            return date.isAfter(minDate) && date.isBefore(currentDate);
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private boolean hireDateIsValid() {
        if (hireDate == null || birthDate == null) {
            return false;
        }

        try {
            LocalDate hire = LocalDate.parse(hireDate);
            LocalDate birth = LocalDate.parse(birthDate);

            return hire.isAfter(birth);
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return empNo + ","
                + firstName + "," +
                lastName + "," +
                gender + "," +
                birthDate + "," +
                hireDate;
    }

    public int getEmpNoAsInt() {
        return Integer.parseInt(this.empNo);
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getGender() {
        return this.gender;
    }
    public String getBirthDate() {
        return this.birthDate;
    }
    public String getHireDate() {
        return this.hireDate;
    }
}