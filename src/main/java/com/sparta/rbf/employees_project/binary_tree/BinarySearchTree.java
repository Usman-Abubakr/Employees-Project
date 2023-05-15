package com.sparta.rbf.employees_project.binary_tree;

import com.sparta.rbf.employees_project.employee.Employee;

import java.util.ArrayList;

public interface BinarySearchTree {
    EmployeeBinaryTree.Node getRootElement();
    void addElement(Employee employee);
    void populateTree(ArrayList<Employee> employees);
    EmployeeBinaryTree.Node getLeftChild(EmployeeBinaryTree.Node node);
    EmployeeBinaryTree.Node getRightChild(EmployeeBinaryTree.Node node);
}
