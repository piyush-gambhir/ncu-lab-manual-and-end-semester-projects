









abstract class Shape {

    abstract double RectangleArea(double l, double b);

    abstract double SquareArea(double s);

    abstract double CircleArea(double r);

}

class Area extends Shape {

    double RectangleArea(double length, double breadth) {
        return length * breadth;
    }

    double SquareArea(double side) {
        return side * side;
    }

    double CircleArea(double radius) {
        return Math.PI * radius * radius;
    }
}

public class practical_6_problem_statement_3 {

    public static void main(String[] args) {

        Area a = new Area();

        System.out.println("Area of Rectangle: " + a.RectangleArea(5, 7));
        System.out.println("Area of Square: " + a.SquareArea(6));
        System.out.println("Area of Circle: " + a.CircleArea(8));

    }
}