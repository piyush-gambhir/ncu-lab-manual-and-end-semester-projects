/*
Create three classes:
Class Vehicle: Vehicle Class will contain a display() function, which will say "This is a Vehicle".
Class Car: Car Class will derive the Vehicle Class and overwrite its display() function. it will say "This is a Car".
Class Bike:Bike Class will derive the Vehicle Class and overwrite its display() function. it will say "This is a Bike".

Write an application that reads an Integer N, which will denote the number of tyres in the vehicle. You have to create an object of the appropriate class according to the value of N and use it display( function.

If N = 2, Create a Bike Object.
If N = 4, Create a Car Object.

Create a Vehicle Object, otherwise.

Definition of Done:
DoD 1: Each class definition is stored in its own .java file.
DoD 2: Switch statement is used for identifying the appropriate class for which the object is 
to be invoked.
*/

/**
 * practical_5_problem_statement_2
 */

import java.util.Scanner;

class Vehicle {
    void Display() {
        System.out.println("This is a Vehicle");
    }
}

class Car extends Vehicle {
    void Display() {
        System.out.println("This is a Car");
    }
}

class Bike extends Vehicle {
    void Display() {
        System.out.println("This is a Bike");
    }
}

public class practical_5_problem_statement_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Number of Wheels: ");
        int N = sc.nextInt();

        switch (N) {
            case 2:
                Bike B1 = new Bike();
                B1.Display();
                break;
            case 4:
                Car C1 = new Car();
                C1.Display();
                break;
            default:
                System.out.println("Invalid Input!");
                break;
        }
    }
}