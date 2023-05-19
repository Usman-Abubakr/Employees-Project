package com.sparta.rbf.employees_project2.jdbc.util;

public interface SQLQueries {
    String SELECT_ALL = "SELECT * from employees.employees;";
    String CREATE = "INSERT INTO `employees`.`employees` (`emp_no`, `birth_date`, `first_name`, `last_name`, `gender`, `hire_date`) VALUES (?,?,?,?,?,?);";
    String SELECT_EMPLOYEES_IN_DEPARTMENT_WITHIN_DATES = "SELECT e.* FROM employees.employees e INNER JOIN employees.dept_emp de ON e.emp_no = de.emp_no WHERE de.dept_no = ? AND (de.from_date BETWEEN ? AND ? OR de.to_date BETWEEN ? AND ? OR (de.from_date <= ? AND de.to_date >= ?));";
    String SELECT_ALL_DEPARTMENTS = "SELECT * FROM employees.departments ORDER BY dept_no ASC;";
}
