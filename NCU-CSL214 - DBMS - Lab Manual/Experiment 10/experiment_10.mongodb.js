































use("Company");
db.dropDatabase();


use("Company");
db.dropDatabase();


db.createCollection("Project");


db.createCollection("Department");


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


db.Department.insertOne({
  Dno: 1,
  Dname: "DepartmentX",
  Dmanager: "ABC",
});


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


db.Project.find({});


db.Project.updateMany(
  { Pname: "ProjectX" },
  {
    $set: {
      Plocation: "Pune",
      Dnum: 20,
    },
  }
);


db.Project.deleteMany({ Dnum: 4 });


db.Project.find({
  Plocation: {
    $all: ["Delhi", "Mumbai"],
  },
});


db.Project.updateMany(
  { Pname: "ProjectX" },
  {
    $set: {
      Dnum: 1,
    },
  }
);
