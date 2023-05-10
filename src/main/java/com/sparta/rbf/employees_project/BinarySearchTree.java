package com.sparta.rbf.employees_project;

import java.util.ArrayList;

public interface BinarySearchTree {
    Node getRootElement();
    void addElement(Employee employee);
    void populateTree(ArrayList<Employee> employees);
    ArrayList<Employee> findElement(String target);
    Node getLeftChild(Node node);
    Node getRightChild(Node node);
}
