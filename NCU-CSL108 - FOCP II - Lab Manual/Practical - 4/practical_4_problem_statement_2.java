/*
Write a program to print the area and perimeter of a triangle having sides of 3, 4 and 5 units by creating a class named 'Triangle' without any parameter in its constructor.
*/

/**
 * practical_4_problem_statement_2
 */

import java.math.*;

class Triangle {
    double a;
    double b;
    double c;

    public double area() {
        double s = ((a + b + c) / 2);
        return s * Math.pow((s * (s - a) * (s - b) * (s - c)), (1 / 2));
    }
    public double perimeter(){
        return a+b+c;
    }
}

public class practical_4_problem_statement_2 {

    public static void main(String[] args) {

        Triangle triangle = new Triangle();
        
        triangle.a = 5;
        triangle.b = 4;
        triangle.c = 3;
        
        System.out.println("Area of the Triangle = " + triangle.area());
        System.out.println("Perimeter of the Triangle = " + triangle.perimeter());

    }
}