







import java.util.Scanner;

class Area {
    double length;
    double breadth;

    public Area(double l, double b) {
        length = l;
        breadth = b;
    }

    public double returnArea() {
        return length * breadth;
    }
}

public class practical_4_problem_statement_3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Length of the Rectangle: ");
        double length = sc.nextDouble();
        System.out.print("Enter Breadth of the Rectangle: ");
        double breadth = sc.nextDouble();

        Area rectangle = new Area(length, breadth);

        System.out.println("\nArea of the Rectangle = " + rectangle.returnArea());
    }
}