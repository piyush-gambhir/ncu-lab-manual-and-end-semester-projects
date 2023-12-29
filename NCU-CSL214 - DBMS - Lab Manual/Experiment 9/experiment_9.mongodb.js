// Experiment 9:

// Problem Statement:
// 1)	Create a COMPANY database with the following collections:
//     •	Employee with fields Emp ID, Ename, Age, Mobile, Email, Address, Dno
//     •	Department with fields Dnumber, Dname, Dlocation
//     •	Project with fields Pname, Pnumber, Plocation, ControlDept
// 2)	Insert 5 documents in each collection using different versions of “Insert” command.
// 3)	Select all documents in a collection.
// 4)	Retrieve the details of all projects that are being run in department number 50.
// 5)	Retrieve the details of the first project that is being run in department number 50 in formatted manner.
// 6)	Return the formatted/structured project details of all projects in department number “5” and project name as “ProductZ”.
// 7)	Return the project details (including project name, project number and department number and excluding project location and default primary key) of all projects with department number “5” or project name as “ProductZ”.
// 8)	Return the formatted/structured project details of all projects with department number less than “10” and project name as “ProductZ” or project location as “Delhi”.

// Dropping the 'Company' database
use("Company");
db.dropDatabase();

// create a database named 'Company'
use("Company");

// create the collection employee
db.createCollection("Employee")

// create the collection Department
db.createCollection("Department")

// create the collection employee
db.createCollection("Project")


// insert data into the Employee collection using insertOne()
db.Employee.insertOne({
  "Emp ID": 1,
  Ename: "John Smith",
  Age: 30,
  Mobile: "9876543210",
  Email: "john.smith@email.com",
  Address: "123 Main St",
  Dno: 10,
});

// insert data into the Employee collection using insertMany()
db.Employee.insertMany([
  {
    "Emp ID": 2,
    Ename: "Jane Doe",
    Age: 25,
    Mobile: "9876543211",
    Email: "jane.doe@email.com",
    Address: "456 1st St",
    Dno: 2,
  },
  {
    "Emp ID": 3,
    Ename: "Bob Johnson",
    Age: 45,
    Mobile: "9876543212",
    Email: "bob.johnson@email.com",
    Address: "789 2nd St",
    Dno: 3,
  },
  {
    "Emp ID": 4,
    Ename: "Sarah Lee",
    Age: 35,
    Mobile: "9876543213",
    Email: "sarah.lee@email.com",
    Address: "1010 3rd St",
    Dno: 4,
  },
  {
    "Emp ID": 5,
    Ename: "Tommy Nguyen",
    Age: 28,
    Mobile: "9876543214",
    Email: "tommy.nguyen@email.com",
    Address: "1111 4th St",
    Dno: 5,
  },
]);

// insert data into the Department collection using insertOne()
db.Department.insertOne({
  Dnumber: 20,
  Dname: "Sales",
  Dlocation: "Delhi",
});

// insert data into the Department collection using insertMany()
db.Department.insertMany([
  {
    Dnumber: 30,
    Dname: "Marketing",
    Dlocation: "Chicago",
  },
  {
    Dnumber: 40,
    Dname: "Human Resources",
    Dlocation: "Houston",
  },
  {
    Dnumber: 50,
    Dname: "Finance",
    Dlocation: "Delhi",
  },
  {
    Dnumber: 60,
    Dname: "IT",
    Dlocation: "New York",
  },
]);

// insert data into the Project collection using insertOne()
db.Project.insertOne({
  Pname: "Project 1",
  Pnumber: 1,
  Plocation: "Delhi",
  ControlDept: 50,
});

// insert data into the Project collection using insertMany()
db.Project.insertMany([
  {
    Pname: "Project 2",
    Pnumber: 2,
    Plocation: "Chicago",
    ControlDept: 2,
  },
  {
    Pname: "Project 3",
    Pnumber: 3,
    Plocation: "Houston",
    ControlDept: 50,
  },
  {
    Pname: "Project 4",
    Pnumber: 4,
    Plocation: "Delhi",
    ControlDept: 5,
  },
  {
    Pname: "ProductZ",
    Pnumber: 5,
    Plocation: "New York",
    ControlDept: 5,
  },
]);

// Select all documents from the 'Employee' collection
db.Employee.find();

// select all the documents from 'Department' collection
db.Department.find();

// select all the documents from 'Project' collection
db.Project.find();

// retrieve the details of all projects that are being run in department number 50
db.Project.find({ ControlDept: 50 });

// retrieve the details of the first project that is being run in department number 50 in formatted manner
db.Project.find({ ControlDept: 50 }).pretty();

// return the formatted/structured project details of all projects in department number “5” and project name as “ProductZ”
db.Project.find({ ControlDept: 5, Pname: "ProductZ" }).pretty();

// return the project details (including project name, project number and department number and excluding project location and default primary key) of all projects with department number “5” or project name as “ProductZ”
db.Project.find(
  { $or: [{ ControlDept: 5 }, { Pname: "ProductZ" }] },
  { Pname: 1, Pnumber: 1, ControlDept: 1, _id: 0 }
);

// return the formatted/structured project details of all projects with department number less than “10” and project name as “ProductZ” or project location as “Delhi”
db.Project.find({
  $and: [
    { ControlDept: { $lt: 10 } }, { $or: [{ Pname: "ProductZ" }, { Plocation: "Delhi" }] },
  ],
}).pretty();
