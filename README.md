# Employees-Project

## Contributing

### Setting up development project

1. Clone from remote to local: `git clone https://github.com/Usman-Abubakr/Employees-Project.git`
2. Change to dev branch: `git checkout --track origin/dev`

### Adding features

1. Update local: `git pull`
2. Change to dev branch: `git checkout origin/dev`
3. Create new feature branch: `git checkout -b <branch-name>`
4. Push to remote feature branch (will create the new remote branch): `git push -u origin <branch-name>`
5. Add commits `git add .` `git commit -m ""` and follow step 4 to push to remote.
6. Let team know a feature is ready to merge with dev branch.
7. Create new branch for each new features.

### Updating feature branch from dev branch

1. Switch to dev branch: git `git checkout dev`
2. Update branch: `git pull`
3. Switch to feature branch: `git checkout <branch-name>`
4. Merging dev to feature branch:`git merge origin/dev`
5. Push update to remote feature branch `git push <remote-name> <branch-name>`

 ####  OR 

1. Push feature branch to remote feature branch `git push <remote-name> <branch-name>`
2. Use GitHub to merge from dev branch.




## Project 1

### About

Developed by team Rootbeer Float, shortened to RBF.

The application loads employee data from a CVS file to creates a binary tree that allows the user to search for employee's in a time efficient manner.


### Requirements

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




## Project 2

### About

Developed by the SQuirreLs, also known as The SQL Squirrels.

The application loads employee data from a variety of source files and inserts them into a MySQL database.


### Requirements

##### Phase 1

- Download and install the Employees database for MySQL - [see this installation guide](https://dev.mysql.com/doc/employee/en/employees-installation.html)
- Read from the ```employees``` table in the database using appropriate SQL
- Each record should be used to create a new object of a suitable class and these objects added to a suitable collection
- Implement the [Data Access Object](https://www.oracle.com/java/technologies/data-access-object.html) pattern for accessing the database and the [Data Transfer Object](https://www.baeldung.com/java-dto-pattern) pattern to decouple the database access part of the program from the front end
- Remember to close connections to the database as soon as they have been finished with

##### Phase 2

- Using ```Jackson``` object serialization, [```ObjectMapper```](https://fasterxml.github.io/jackson-databind/javadoc/2.13/com/fasterxml/jackson/databind/ObjectMapper.html), write a method that stores all the employees who worked in a chosen department during a specific period in a ```JSON```-formatted file
    - You will need to use the ```department``` and ```dept_emp``` tables, following relationships to figure our which employees are in which department during the required period
- Similarly, write a method that stores the employees of the chosen & time period in XML using ```Jackson```'s ```XML``` serialization features, [```XMLMapper```](https://github.com/FasterXML/jackson-dataformat-xml)
- Allow the user to choose the file name, using a ```Scanner``` to get the user input
- The program should polymorphically write the data in the appropriate format depending on the file extension, using the [Factory Method](https://refactoring.guru/design-patterns/factory-method) design pattern

##### Phase 3

- Given a ```.csv```, ```.json``` or ```.xml``` file containing new employees, add this to the database table
- This should be done polymorphically, based on the file extension
- Any corrupt or duplicated data should be added to a separate collection for further analysis - corrupt or duplicated values should be displayed to the user for review
- Valid data should be written to the database
- Sample files are provided, which may contain data errors
    - ```employees01.csv```
    - ```employees02.json```
    - ```employees03.xml```
- Validation rules
    - ```emp_no``` should be only digits up to 8 characters
    - dates should be ```YYYY-MM-DD```
    - dates should be in the past
    - ```birth_date``` should be after 1900-01-01
    - ```hire_date``` should be more recent than ```birth_date```
    - names should only contain alpha chars, spaces and hyphens and should begin with a capital letter
