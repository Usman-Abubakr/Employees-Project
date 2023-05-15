package com.sparta.rbf.employees_project.binary_tree;

import com.sparta.rbf.employees_project.employee.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeBinaryTree {
    public static final Logger logger = Logger.getLogger(EmployeeBinaryTree.class.getName());
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
        logger.log(Level.FINE,  "Entered for loop to populate tree.");
        for (Employee employee : employees) {
            addElement(employee);
            logger.log(Level.FINER, "Added employee element: " + employee.toString());
        }
    }

    public List<Employee> findEmployeesByLastName(String lastName) {
        logger.log(Level.INFO, "Attempting to find employees with surname: " + lastName);
        List<Employee> employees = new ArrayList<>();
        findEmployeesByLastName(root, lastName, employees);
        return employees;
    }

    private void findEmployeesByLastName(Node node, String lastName, List<Employee> result) {
        if (node == null) {
            return;
        }

        int comparison = lastName.compareTo(node.getEmployee().getLastName());
        if (comparison == 0) {
            result.add(node.getEmployee());
        }

        findEmployeesByLastName(node.getLeftChild(), lastName, result);
        findEmployeesByLastName(node.getRightChild(), lastName, result);
    }
}
