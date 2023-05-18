package com.sparta.rbf.employees_project2.jdbc.jackson;

import com.sparta.rbf.employees_project2.jdbc.jackson.Employees;

public interface JacksonMapping {

    public void saveToFile(Employees employees, String fileName);
}
