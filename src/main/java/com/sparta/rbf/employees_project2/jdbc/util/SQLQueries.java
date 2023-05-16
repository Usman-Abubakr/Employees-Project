package com.sparta.rbf.employees_project2.jdbc.util;

public interface SQLQueries {
    String SELECT_ALL = "SELECT * from employees.employees";
    String CREATE = "INSERT INTO `employees`.`employees` (`emp_no`, `birth_date`, `first_name`, `last_name`, `gender`, `hire_date`) VALUES (?,?,?,?,?,?)";
}
