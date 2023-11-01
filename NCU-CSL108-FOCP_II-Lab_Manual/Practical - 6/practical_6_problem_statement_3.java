/*

We have to calculate the area of a rectangle, a square and a circle. Create an abstract class 'Shape' with three abstract methods namely 'RectangleArea' taking two parameters, 'SquareArea' and 'CircleArea' taking one parameter each. The parameters of 'RectangleArea' are its length and breadth, that of 'SquareArea' is its side and that of 'CircleArea' is its radius. Now create another class 'Area' containing all the three methods 'RectangleArea', 'SquareArea' and 'CircleArea' for printing the area of rectangle, square and circle respectively. Create an object of class 'Area' and call all the three methods.

*/

/**
 * practical_6_problem_statement_3
 */

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