package com.sparta.rbf.employees_project;

import java.util.ArrayList;
import java.util.List;

public class EmployeeBinaryTree {
    private Node root;

    public EmployeeBinaryTree() {
        this.root = null;
    }

    public void addElement(Employee employee) {
        Node newNode = new Node(employee);

        if (root == null) {
            root = newNode;
            return;
        }

        Node currentNode = root;
        while (true) {
            int comparison = employee.getLastName().compareTo(currentNode.getEmployee().getLastName());
            if (comparison < 0) {
                if (currentNode.getLeftChild() == null) {
                    currentNode.setLeftChild(newNode);
                    return;
                } else {
                    currentNode = currentNode.getLeftChild();
                }
            } else {
                if (currentNode.getRightChild() == null) {
                    currentNode.setRightChild(newNode);
                    return;
                } else {
                    currentNode = currentNode.getRightChild();
                }
            }
        }
    }

    public void populateTree(ArrayList<Employee> employees) {
        for (Employee employee : employees) {
            addElement(employee);
        }
    }

    public List<Employee> findEmployeesByLastName(String lastName) {
        List<Employee> employees = new ArrayList<>();
        findEmployeesByLastName(root, lastName, employees, false);
        return employees;
    }

    private void findEmployeesByLastName(Node node, String lastName, List<Employee> result, boolean found) {
        if (node == null) {
            return;
        }

        int comparison = lastName.compareTo(node.getEmployee().getLastName());
        if (comparison == 0) {
            result.add(node.getEmployee());
            found = true;
        } else if (found) {
            return;
        }

        findEmployeesByLastName(node.getLeftChild(), lastName, result, found);
        findEmployeesByLastName(node.getRightChild(), lastName, result, found);
    }
}
