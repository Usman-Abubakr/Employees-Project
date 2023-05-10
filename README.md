# Employees-Project

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


Test - Chamara
Test - Usman


## Setting up development project

1. Clone from remote to local: `git clone https://github.com/Usman-Abubakr/Employees-Project.git`
2. Change to dev branch: `git checkout --track origin/dev`

## Adding features

1. Update local: `git pull`
2. Change to dev branch: `git checkout origin/dev`
3. Create new feature branch: `git checkout -b <branch-name>`
4. Push to remote feature branch (will create the new remote branch): `git push -u origin <branch-name>`
5. Add commits `git add .` `git commit -m ""` and follow step 4 to push to remote.
6. Let team know a feature is ready to merge with dev branch.
7. Create new branch for each new features.

## Updating feature branch from dev branch

1. Switch to dev branch: git `git checkout dev`
2. Update branch: `git pull`
3. Switch to dev branch: `git checkout <branch-name>`
4. Merging dev to feature branch:`git merge origin/dev`
5. Push update to remote feature branch`git push <remote-name> <branch-name>`
