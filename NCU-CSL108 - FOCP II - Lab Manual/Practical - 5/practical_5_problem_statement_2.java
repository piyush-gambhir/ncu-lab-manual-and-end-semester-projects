






















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