package com.sparta.rbf.employees_project;

public class Node {
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
