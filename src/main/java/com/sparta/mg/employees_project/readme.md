## Requirements

- *Add the provided factory class, ```EmployeeFactory.java```, to a suitable package within your project*
- *Add the provided sample data file, ```employees.csv```, to the ```src/main/resources``` folder in your project*
- Call ```EmployeeFactory.getEmployees(n)``` to generate an array of random employee data of size ```n``` (```1 <= n <= 1000```)
- Employee data is provided as an array of ```String```s, returned from ```getEmployees()```, each ```String``` representing
    - ```emp_no``` (up to 8 digits)
    - ```birth_date``` (```YYYY-MM-DD```, ```ISO 8601``` calendar date format)
    - ```first_name``` (alpha characters and spaces only)
    - ```last_name``` (alpha characters and spaces only)
    - ```gender``` (single character)
    - ```hire_date``` (```YYYY-MM-DD```)
- The values for the employee data will be separated by commas within the ```String```
    - For example, ```"1234567,1995-01-23,Teagan,Griffith,F,2012-04-12"```
- Convert each element in the array into an ```Employee``` object, having created a suitable class, and store it in a ```List``` using a suitable concrete type
- Once the provided data have been stored in a ```List```, convert the ```List``` to a binary tree using a class you've created for this purpose (using ```last_name``` as the key)
- Use a nested class to represent a node in the tree
- The tree should allow for multiple employees with the same ```last_name```
- Allow the user to search for a specific employee by ```last_name```