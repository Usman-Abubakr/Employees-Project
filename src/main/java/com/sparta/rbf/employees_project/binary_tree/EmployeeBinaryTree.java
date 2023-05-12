package com.sparta.rbf.employees_project.binary_tree;

import com.sparta.rbf.employees_project.employee.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeBinaryTree {
    public static class Node {
        private Employee employee;
        private Node leftChild = null;
        private Node rightChild = null;

        public Node(Employee employee) {
            this.employee = employee;
        }

        public Employee getEmployee() {
            return this.employee;
        }

        public Node getLeftChild() {
            return this.leftChild;
        }

        public Node getRightChild() {
            return this.rightChild;
        }

        public void setLeftChild(Node node) {
            this.leftChild = node;
        }

        public void setRightChild(Node node) {
            this.rightChild = node;
        }
    }
    private Node root;

    public EmployeeBinaryTree() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public boolean isRootNull(Node node) {
        if (root == null) {
            root = node;
            return true;
        }
        return false;
    }

    public void addElement(Employee employee) {
        Node newNode = new Node(employee);

        if (isRootNull(newNode)) {
            return;
        }

        Node currentNode = root;
        while (true) {
            int comparison = employee.getLastName().compareTo(currentNode.getEmployee().getLastName());
            if (comparison < 0) {
                //change
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
