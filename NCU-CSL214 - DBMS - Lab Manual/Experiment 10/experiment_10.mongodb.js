// Experiment 9:

// Problem Statement:
// Create a database with the following collections:
// Project
// Possible Fields:
//  •	Project Name (Pname)
//  •	Project Number (Pnumber)
//  •	Department Number in which project is being run (Dnum)
//  •	Project Locations (Plocation)
//    	Plocation can be an array of multiple locations (or)
//    	Plocation can be a composite field with sub-fields – city, state, country
// Department
// Possible Fields:
//  •	Department Number (Dno)
//  •	Department Name (Dname)
//  •	Department Manager (Dmanager)

// Execute the following queries:
// 1)	Insert multiple documents (2-3) together in the Project collection with atleast 1 project location as a composite attribute
// 2)	Write the “Select * from Project” equivalent query in MongoDB.
// 3)	Write a MongoDB query to update the project location of all projects to “Pune” and department number to “20” with project name “ProjectX”.
// 4)	Write a MongoDB query to delete all the documents of collection “Project” with department number “4”.
// 5)	Write a MongoDB query to retrieve the project details of all projects with project location as “Delhi” and “Mumbai” both assuming the following documents exist.
//    { "_id" : ObjectId("5cc7fe36e37496f1a5e7e268"),"Pname" : "ProductK", "Pnumber" : 45,"Plocation" : ["Delhi","Mumbai","Pune"], "Dnum" : 3}
//    { "_id" : ObjectId("5cc7fe36e37496f1a5e7e268"),"Pname" : "ProductT", "Pnumber" : 56,"Plocation" : ["Delhi","Mumbai"], "Dnum" : 15}
//    { "_id" : ObjectId("5cc7fe36e37496f1a5e7e268"),"Pname" : "ProductU", "Pnumber" : 5,"Plocation" : "Delhi", "Dnum" : 6}
//    { "_id" : ObjectId("5cc7fe36e37496f1a5e7e268"),"Pname" : "ProductL", "Pnumber" : 4,"Plocation" : "Mumbai", "Dnum" : 7}
// 6)	Write a MongoDB query creating a One to Many Relation between a document of “Project” Collection and “Department” Collection.
// 7)	Write a MongoDB query to retrieve the project details  project name, department number, department name and department manager of projects with department manager (for department in which the project is being run) as “ABC”.

// Dropping the 'Company' database
use("Company");
db.dropDatabase();

// create a database named 'Company'
use("Company");
db.dropDatabase();

// create a collection 'Project
db.createCollection("Project");

// create a collection 'Department
db.createCollection("Department");

// insert data into the Project collection using insertOne()
db.Project.insertOne({
  Pname: "ProjectY",
  Pnumber: 2,
  Plocation: [
    {
      city: "Mumbai",
      state: "Maharashtra",
      country: "India",
    },
    {
      city: "Delhi",
      state: "Delhi",
      country: "India",
    },
    {
      city: "Bangalore",
      state: "Karnataka",
      country: "India",
    },
  ],
});

// insert data into the Project collection using insertMany()
db.Project.insertMany([
  {
    Pname: "ProjectX",
    Pnumber: 1,
    Plocation: [
      {
        city: "Mumbai",
        state: "Maharashtra",
        country: "India",
      },
      {
        city: "Delhi",
        state: "Delhi",
        country: "India",
      },
      {
        city: "Bangalore",
        state: "Karnataka",
        country: "India",
      },
    ],
  },
  {
    Pname: "ProjectZ",
    Pnumber: 3,
    Plocation: [
      {
        city: "Mumbai",
        state: "Maharashtra",
        country: "India",
      },
      {
        city: "Delhi",
        state: "Delhi",
        country: "India",
      },
      {
        city: "Bangalore",
        state: "Karnataka",
        country: "India",
      },
    ],
  },
]);

// insert data into the Department collection using insertOne()
db.Department.insertOne({
  Dno: 1,
  Dname: "DepartmentX",
  Dmanager: "ABC",
});

// insert data into the Department collection using insertMany()
db.Department.insertMany([
  {
    Dno: 2,
    Dname: "DepartmentY",
    Dmanager: "DEF",
  },
  {
    Dno: 3,
    Dname: "DepartmentZ",
    Dmanager: "GHI",
  },
]);

// 2)	Write the “Select * from Project” equivalent query in MongoDB.
db.Project.find({});

// 3)	Write a MongoDB query to update the project location of all projects to “Pune” and department number to “20” with project name “ProjectX”.
db.Project.updateMany(
  { Pname: "ProjectX" },
  {
    $set: {
      Plocation: "Pune",
      Dnum: 20,
    },
  }
);

// 4)	Write a MongoDB query to delete all the documents of collection “Project” with department number “4”.
db.Project.deleteMany({ Dnum: 4 });

// 5)	Write a MongoDB query to retrieve the project details of all projects with project location as “Delhi” and “Mumbai” both assuming the following documents exist.
db.Project.find({
  Plocation: {
    $all: ["Delhi", "Mumbai"],
  },
});

// 6)	Write a MongoDB query creating a One to Many Relation between a document of “Project” Collection and “Department” Collection.
db.Project.updateMany(
  { Pname: "ProjectX" },
  {
    $set: {
      Dnum: 1,
    },
  }
);

// 7)	Write a MongoDB query to retrieve the project details  project name, department number, department name and department manager of projects with department manager (for department in which the project is being run) as “ABC”.

