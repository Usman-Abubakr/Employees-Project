package com.sparta.rbf.employees_project2.jackson;

//import com.sparta.rbf.employees_project2.jdbc.jackson.FilenameValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileNameValidationTest {
//    @ParameterizedTest
//    @ValueSource(strings = {"xml", "json", "csv"})
//    @DisplayName("Check that files with the correct extension are accepted")
//    void checkCorrectFileExtensions(String input) {
//        Assertions.assertTrue(FilenameValidation.isFileExtensionValid(input));
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"doc", "docx", "txt", "pdf", "latex", ""})
//    @DisplayName("Check that files with an incorrect extension aren't accepted")
//    void checkIncorrectFileExtensions(String input) {
//        Assertions.assertFalse(FilenameValidation.isFileExtensionValid(input));
//    }
//
//
//    @ParameterizedTest
//    @ValueSource(strings = {"employee_data.xml", "employees1.json", "EMPLOYEE-DATA.json", "rAnD0m-3MpL0y33_d4t4.csv"})
//    @DisplayName("Check that files that have valid names are accepted")
//    void checkValidFileNames(String input) {
//        Assertions.assertTrue(FilenameValidation.isFileNameValid(input));
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"employee.data.xml", "data/employee.xml", "c:/documents/data/employees", ""})
//    @DisplayName("Check that files that have invalid names aren't accepted")
//    void checkInvalidFileNames(String input) {
//        Assertions.assertFalse(FilenameValidation.isFileNameValid(input));
//    }
//
//    @Test
//    @DisplayName("Check that extensions can be retrieved for valid files")
//    void checkFileExtensions() {
//        Assertions.assertAll(
//                () -> assertEquals("xml", FilenameValidation.getFileExtension("employee_data.xml")),
//                () -> assertEquals("json", FilenameValidation.getFileExtension("employee_data.json")),
//                () -> assertEquals("csv", FilenameValidation.getFileExtension("employee_data.csv"))
//        );
//    }
}
