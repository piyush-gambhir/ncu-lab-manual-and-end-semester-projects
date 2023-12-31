-- Problem Statement
-- Consider the COMPANY database in Experiment 1 and execute the following queries:
-- 1)	Make a list of all project numbers for projects that involve an employee whose last name is ‘Smith’, either as a worker or as a manager of the department that controls the project.
-- 2)	Select the Essns of all employees who work on the same project and hours as some project that employee ‘John Smith’ (whose Ssn = ‘123456789’) works on.
-- 3)	Return the names of employees whose salary is greater than the salary of all the employees in department 5
-- 4)	Retrieve the name of each employee who has a dependent with the same first name and is the same sex as the employee
-- 5)	Retrieve the names of employees who have no dependents
-- 6)	List the names of managers who have at least one dependent using EXISTS and NOT EXISTS functions
-- 7)	Retrieve the name of each employee who works on all the projects controlled by department number 5 using EXISTS and NOT EXISTS functions
-- 8)	Retrieve the names of all employees who have two or more dependents
-- 9)	Retrieves the names of all employees who work on only one project

-- DROP DATABASE IF EXISTS EXPERIMENT_7;
DROP DATABASE IF EXISTS EXPERIMENT_7;

-- CREATING DATABASE
CREATE DATABASE EXPERIMENT_7;

-- USING DATABASE
USE EXPERIMENT_7;

-- CREATING TABLES
CREATE TABLE DEPARTMENT(
    Dname VARCHAR(30) NOT NULL,
    Dnumber INT NOT NULL,
    Mgr_ssn CHAR(9),
    Mgr_start_date DATE,
    PRIMARY KEY(Dnumber),
    UNIQUE(Dname)
);


CREATE TABLE EMPLOYEE(
    Fname VARCHAR(15) NOT NULL,
    Minit CHAR,
    Lname VARCHAR(15) NOT NULL,
    Ssn CHAR(9) NOT NULL,
    Bdate DATE,
    Address VARCHAR(30),
    Sex CHAR,
    Salary DECIMAL(10, 2),
    Super_ssn CHAR(9),
    Dno INT,
    PRIMARY KEY (Ssn),
    FOREIGN KEY (Super_ssn) REFERENCES EMPLOYEE(Ssn),
    FOREIGN KEY (Dno) REFERENCES DEPARTMENT(Dnumber)
);

ALTER TABLE DEPARTMENT
ADD FOREIGN KEY(Mgr_ssn) REFERENCES EMPLOYEE(Ssn);

CREATE TABLE DEPARTMENT_LOCATIONS(
    DNumber INT NOT NULL,
    DLocation VARCHAR(15) NOT NULL,
    PRIMARY KEY(DNumber, DLocation),
    FOREIGN KEY(DNumber) REFERENCES DEPARTMENT(Dnumber)
);

CREATE TABLE PROJECT(
    Pname VARCHAR(15) NOT NULL,
    Pnumber INT NOT NULL,
    Plocation VARCHAR(15),
    Dnum INT NOT NULL,
    PRIMARY KEY(Pnumber),
    UNIQUE(Pname),
    FOREIGN KEY(Dnum) REFERENCES DEPARTMENT(Dnumber)
);

CREATE TABLE WORKS_ON(
    Essn CHAR(9) NOT NULL,
    Pno INT NOT NULL,
    Hours DECIMAL(3, 1),
    PRIMARY KEY(Essn, Pno),
    FOREIGN KEY(Essn) REFERENCES EMPLOYEE(Ssn),
    FOREIGN KEY(Pno) REFERENCES PROJECT(Pnumber)
);

CREATE TABLE DEPENDENT(
    Essn CHAR(9) NOT NULL,
    Dependent_name VARCHAR(15) NOT NULL,
    Sex CHAR,
    Bdate DATE,
    Relationship VARCHAR(30),
    PRIMARY KEY(Essn, Dependent_name),
    FOREIGN KEY(Essn) REFERENCES EMPLOYEE(Ssn)
);

-- INSERTING DATA

INSERT INTO DEPARTMENT(Dname, Dnumber, Mgr_start_date, Mgr_ssn) VALUES('Research', 5, '1988-05-22', NULL);
INSERT INTO DEPARTMENT(Dname, Dnumber, Mgr_start_date, Mgr_ssn) VALUES('Administration', 4, '1995-01-01', NULL);
INSERT INTO DEPARTMENT(Dname, Dnumber, Mgr_start_date, Mgr_ssn) VALUES('Headquarters', 1, '1981-06-19', NULL);
INSERT INTO DEPARTMENT(Dname, Dnumber, Mgr_start_date, Mgr_ssn) VALUES('Software', 7, '1998-06-19', NULL);
INSERT INTO DEPARTMENT(Dname, Dnumber, Mgr_start_date, Mgr_ssn) VALUES('Services', 3, '1985-01-01', NULL);
INSERT INTO DEPARTMENT(Dname, Dnumber, Mgr_start_date, Mgr_ssn) VALUES('Finance', 8, '1995-01-01', NULL);
INSERT INTO DEPARTMENT(Dname, Dnumber, Mgr_start_date, Mgr_ssn) VALUES('Public Relations', 2, '1993-07-08', NULL);
INSERT INTO DEPARTMENT(Dname, Dnumber, Mgr_start_date, Mgr_ssn) VALUES('Production', 6, '1996-05-01', NULL);

INSERT INTO EMPLOYEE(Fname, Minit, Lname, Ssn, Bdate, Address, Sex, Salary, Super_ssn, Dno) VALUES('John', 'B', 'Smith', '123456789', '1965-01-09', '731 Fondren, Houston, TX', 'M', 30000.00, NULL, NULL);
INSERT INTO EMPLOYEE(Fname, Minit, Lname, Ssn, Bdate, Address, Sex, Salary, Super_ssn, Dno) VALUES('Franklin', 'T', 'Wong', '333445555', '1955-12-08', '638 Voss, Houston, TX', 'M', 40000.00, NULL, NULL);
INSERT INTO EMPLOYEE(Fname, Minit, Lname, Ssn, Bdate, Address, Sex, Salary, Super_ssn, Dno) VALUES('Alicia', 'J', 'Zelaya', '999887777', '1968-01-19', '3321 Castle, Spring, TX', 'F', 25000.00, NULL, NULL);
INSERT INTO EMPLOYEE(Fname, Minit, Lname, Ssn, Bdate, Address, Sex, Salary, Super_ssn, Dno) VALUES('Jennifer', 'S', 'Wallace', '987654321', '1941-06-20', '291 Berry, Bellaire, TX', 'F', 43000.00, NULL, NULL);
INSERT INTO EMPLOYEE(Fname, Minit, Lname, Ssn, Bdate, Address, Sex, Salary, Super_ssn, Dno) VALUES('Ramesh', 'K', 'Narayan', '666884444', '1962-09-15', '975 Fire Oak, Humble, TX', 'M', 38000.00, NULL, NULL);
INSERT INTO EMPLOYEE(Fname, Minit, Lname, Ssn, Bdate, Address, Sex, Salary, Super_ssn, Dno) VALUES('Joyce', 'A', 'English', '453453453', '1972-07-31', '5631 Rice, Houston, TX', 'F', 25000.00, NULL, NULL);
INSERT INTO EMPLOYEE(Fname, Minit, Lname, Ssn, Bdate, Address, Sex, Salary, Super_ssn, Dno) VALUES( 'Ahmad', 'V', 'Jabbar', '888665555', '1969-03-29', '980 Dallas, Houston, TX', 'M', 25000.00, NULL, NULL);
INSERT INTO EMPLOYEE(Fname, Minit, Lname, Ssn, Bdate, Address, Sex, Salary, Super_ssn, Dno) VALUES('James', 'E', 'Borg', '888664555', '1937-11-10', '450 Stone, Houston, TX', 'M', 55000.00, NULL, NULL);

UPDATE DEPARTMENT SET Mgr_ssn = '123456789' WHERE Dnumber = 5;
UPDATE DEPARTMENT SET Mgr_ssn = '333445555' WHERE Dnumber = 4;
UPDATE DEPARTMENT SET Mgr_ssn = '999887777' WHERE Dnumber = 1;
UPDATE DEPARTMENT SET Mgr_ssn = '987654321' WHERE Dnumber = 7;
UPDATE DEPARTMENT SET Mgr_ssn = '666884444' WHERE Dnumber = 3;
UPDATE DEPARTMENT SET Mgr_ssn = '453453453' WHERE Dnumber = 8;
UPDATE DEPARTMENT SET Mgr_ssn = '888664555' WHERE Dnumber = 2;
UPDATE DEPARTMENT SET Mgr_ssn = '888665555' WHERE Dnumber = 6;

UPDATE EMPLOYEE SET Super_ssn = '987654321', Dno = 7 WHERE Ssn = '123456789';
UPDATE EMPLOYEE SET Super_ssn = '987654321', Dno = 7 WHERE Ssn = '333445555';
UPDATE EMPLOYEE SET Super_ssn = '333445555', Dno = 5 WHERE Ssn = '999887777';
UPDATE EMPLOYEE SET Super_ssn = '333445555', Dno = 5 WHERE Ssn = '987654321';
UPDATE EMPLOYEE SET Super_ssn = '333445555', Dno = 5 WHERE Ssn = '666884444';
UPDATE EMPLOYEE SET Super_ssn = '453453453', Dno = 1 WHERE Ssn = '453453453';
UPDATE EMPLOYEE SET Super_ssn = '453453453', Dno = 1 WHERE Ssn = '888665555';
UPDATE EMPLOYEE SET Super_ssn = '453453453', Dno = 1 WHERE Ssn = '888664555';

INSERT INTO DEPARTMENT_LOCATIONS(DNumber, DLocation) VALUES(1, 'Stafford');
INSERT INTO DEPARTMENT_LOCATIONS(DNumber, DLocation) VALUES(1, 'Bellaire');
INSERT INTO DEPARTMENT_LOCATIONS(DNumber, DLocation) VALUES(2, 'Houston');
INSERT INTO DEPARTMENT_LOCATIONS(DNumber, DLocation) VALUES(2, 'Sugar Land');
INSERT INTO DEPARTMENT_LOCATIONS(DNumber, DLocation) VALUES(3, 'Bellaire');

INSERT INTO PROJECT(Pname, Pnumber, Plocation, Dnum) VALUES('ProductX', 1, 'Bellaire', 5);
INSERT INTO PROJECT(Pname, Pnumber, Plocation, Dnum) VALUES('ProductY', 2, 'Stafford', 5);
INSERT INTO PROJECT(Pname, Pnumber, Plocation, Dnum) VALUES('ProductZ', 3, 'Houston', 6);
INSERT INTO PROJECT(Pname, Pnumber, Plocation, Dnum) VALUES('Computerization', 10, 'Stafford', 1);
INSERT INTO PROJECT(Pname, Pnumber, Plocation, Dnum) VALUES('Reorganization', 20, 'Houston', 4);
INSERT INTO PROJECT(Pname, Pnumber, Plocation, Dnum) VALUES('Newbenefits', 30, 'Stafford', 4);

INSERT INTO WORKS_ON(Essn, Pno, Hours) VALUES('123456789', 1, 32.5);
INSERT INTO WORKS_ON(Essn, Pno, Hours) VALUES('333445555', 1, 7.5);
INSERT INTO WORKS_ON(Essn, Pno, Hours) VALUES('999887777', 2, 40.0);
INSERT INTO WORKS_ON(Essn, Pno, Hours) VALUES('987654321', 3, 20.0);
INSERT INTO WORKS_ON(Essn, Pno, Hours) VALUES('666884444', 10, 10.0);
INSERT INTO WORKS_ON(Essn, Pno, Hours) VALUES('453453453', 20, 30.0);

INSERT INTO DEPENDENT(Essn, Dependent_name, Sex, Bdate, Relationship) VALUES('123456789', 'John Smith', 'M', '1965-01-09', '731 Fondren, Houston, TX');
INSERT INTO DEPENDENT(Essn, Dependent_name, Sex, Bdate, Relationship) VALUES('333445555', 'Franklin Wong', 'M', '1955-12-08', '638 Voss, Houston, TX');
INSERT INTO DEPENDENT(Essn, Dependent_name, Sex, Bdate, Relationship) VALUES('999887777', 'Alicia Zelaya', 'F', '1968-01-19', '3321 Castle, Spring, TX');
INSERT INTO DEPENDENT(Essn, Dependent_name, Sex, Bdate, Relationship) VALUES('987654321', 'Jennifer Wallace', 'F', '1941-06-20', '291 Berry, Bellaire, TX');
INSERT INTO DEPENDENT(Essn,Dependent_name, Sex, Bdate, Relationship) VALUES('666884444', 'Ramesh Narayan', 'M', '1962-09-15', '975 Fire Oak, Humble, TX');
INSERT INTO DEPENDENT(Essn, Dependent_name, Sex, Bdate, Relationship) VALUES('453453453', 'Joyce English', 'F', '1972-07-31', '5631 Rice, Houston, TX');

-- Problem Statement Answers

-- 1)	Make a list of all project numbers for projects that involve an employee whose last name is ‘Smith’, either as a worker or as a manager of the department that controls the project.
SELECT DISTINCT Pnumber AS 'Project Number' 
FROM PROJECT
WHERE Dnum IN (SELECT Dnumber FROM DEPARTMENT WHERE Mgr_ssn IN (SELECT Ssn FROM EMPLOYEE WHERE Lname = 'Smith'))
OR Pnumber IN (SELECT Pno FROM WORKS_ON WHERE Essn IN (SELECT Ssn FROM EMPLOYEE WHERE Lname = 'Smith'));

-- 2)	Select the Essns of all employees who work on the same project and hours as some project that employee ‘John Smith’ (whose Ssn = ‘123456789’) works on.
SELECT DISTINCT Essn
FROM WORKS_ON
WHERE Pno IN (
    SELECT Pno
    FROM WORKS_ON
    WHERE Essn = '123456789'
)
AND Hours IN (
    SELECT Hours
    FROM WORKS_ON
    WHERE Essn = '123456789'
);

-- 3)	Return the names of employees whose salary is greater than the salary of all the employees in department 5
SELECT Fname, Lname 
FROM EMPLOYEE
WHERE Salary > ALL (
    SELECT Salary FROM EMPLOYEE
    WHERE Dno = 5
);

-- 4)	Retrieve the name of each employee who has a dependent with the same first name and is the same sex as the employee
SELECT Fname, Lname
FROM EMPLOYEE E
WHERE E.Ssn IN (SELECT Essn FROM DEPENDENT as D WHERE E.Fname = D.Dependent_name AND E.Sex = D.Sex);

-- 5)	Retrieve the names of employees who have no dependents
SELECT Fname, Lname 
FROM EMPLOYEE
WHERE Ssn NOT IN (
    SELECT Essn FROM DEPENDENT
);

-- 6)	List the names of managers who have at least one dependent using EXISTS and NOT EXISTS functions
SELECT Fname, Lname
FROM EMPLOYEE 
WHERE EXISTS (
    SELECT * FROM DEPENDENT
    WHERE Essn = Ssn
);

-- 7)	Retrieve the name of each employee who works on all the projects controlled by department number 5 using EXISTS and NOT EXISTS functions
SELECT Fname, Lname
FROM EMPLOYEE
WHERE NOT EXISTS (
    SELECT * FROM PROJECT
    WHERE Dnum = 5
    AND Pnumber NOT IN (
        SELECT Pno FROM WORKS_ON
        WHERE Essn = Ssn
    )
);


-- 8)	Retrieve the names of all employees who have two or more dependents
SELECT Fname, Lname
FROM EMPLOYEE
WHERE Ssn IN (
    SELECT Essn
    FROM DEPENDENT
    GROUP BY Essn
    HAVING COUNT(*) >= 2
);

-- 9)	Retrieves the names of all employees who work on only one project
SELECT Fname, Lname
FROM EMPLOYEE
WHERE Ssn IN (
    SELECT Essn
    FROM WORKS_ON
    GROUP BY Essn
    HAVING COUNT(*) = 1
);