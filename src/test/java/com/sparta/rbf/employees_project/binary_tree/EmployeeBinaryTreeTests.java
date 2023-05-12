package com.sparta.rbf.employees_project.binary_tree;

import com.sparta.rbf.employees_project.employee.Employee;
import com.sparta.rbf.employees_project.employee.Gender;
import com.sparta.rbf.employees_project.employee.NamePrefix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class EmployeeBinaryTreeTests {

    Employee employee1 = new Employee(123456, NamePrefix.Mr, "John", 'P', "Smith",
            Gender.MALE, "johnsmith@gmail.com", LocalDate.of(1979,10,25),
            LocalDate.of(2021, 5,10), 44000);

    Employee employee2 = new Employee(987546, NamePrefix.Mrs, "Emma", 'C', "Wood",
            Gender.FEMALE, "emmacwood@gmail.com", LocalDate.of(1999,8,22),
            LocalDate.of(2022,3,21), 30000);

    EmployeeBinaryTree.Node node1 = new EmployeeBinaryTree.Node(employee1);

    EmployeeBinaryTree.Node node2 = new EmployeeBinaryTree.Node(employee1);


    @Test
    @DisplayName("Check that a new Node object can be created.")
    void checkForNewNode() {
        Assertions.assertTrue(node1 != null);
    }

    @Test
    @DisplayName("Check that a node can return an employee stored.")
    void checkForEmployeeReturn() {
        Assertions.assertTrue(node1.getEmployee() != null);
    }

    @Test
    @DisplayName("Check that the node returns the correct employee.")
    void checkForCorrectEmployeeReturn() {
        Assertions.assertEquals(employee1, node1.getEmployee());
    }

    @Test
    @DisplayName("Check that a left child node can be inserted into node.")
    void checkForLeftChildInsert() {
        node1.setLeftChild(node2);
        Assertions.assertTrue(node1.getLeftChild() != null);
    }

    @Test
    @DisplayName("Check that a right child node can be inserted into node.")
    void checkForRightChildInsert() {
        node1.setRightChild(node2);
        Assertions.assertTrue(node1.getRightChild() != null);
    }

    @Test
    @DisplayName("Check that left child node is returned.")
    void checkForLeftChildReturn() {
        node1.setLeftChild(node2);
        Assertions.assertEquals(node2, node1.getLeftChild());
    }

    @Test
    @DisplayName("Check that right child node is returned.")
    void checkForRightChildReturn() {
        node1.setRightChild(node2);
        Assertions.assertEquals(node2, node1.getRightChild());
    }

}
