















use("Company");
db.dropDatabase();


use("Company");


db.createCollection("Employee")


db.createCollection("Department")


db.createCollection("Project")



db.Employee.insertOne({
  "Emp ID": 1,
  Ename: "John Smith",
  Age: 30,
  Mobile: "9876543210",
  Email: "john.smith@email.com",
  Address: "123 Main St",
  Dno: 10,
});


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


db.Department.insertOne({
  Dnumber: 20,
  Dname: "Sales",
  Dlocation: "Delhi",
});


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


db.Project.insertOne({
  Pname: "Project 1",
  Pnumber: 1,
  Plocation: "Delhi",
  ControlDept: 50,
});


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


db.Employee.find();


db.Department.find();


db.Project.find();


db.Project.find({ ControlDept: 50 });


db.Project.find({ ControlDept: 50 }).pretty();


db.Project.find({ ControlDept: 5, Pname: "ProductZ" }).pretty();


db.Project.find(
  { $or: [{ ControlDept: 5 }, { Pname: "ProductZ" }] },
  { Pname: 1, Pnumber: 1, ControlDept: 1, _id: 0 }
);


db.Project.find({
  $and: [
    { ControlDept: { $lt: 10 } }, { $or: [{ Pname: "ProductZ" }, { Plocation: "Delhi" }] },
  ],
}).pretty();
