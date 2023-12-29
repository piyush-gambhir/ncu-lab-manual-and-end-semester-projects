/*
Write a Java program to solve quadratic equations (use if, else if and else).
Definition of Done:
DoD 1: The program asks the values of coefficients of a quadratic equation.
DoD 2: The program should display the roots or an appropriate message.
*/

import java.util.Scanner;

/**
 * practical_2_problem_statement_1
 */
public class practical_2_problem_statement_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter the Values of Coefficients of the Quadratic Equation: ax^2 + bx + c = 0");

        System.out.print("\nEnter tha Value of a: ");
        int a = sc.nextInt();
        System.out.print("Enter tha Value of b: ");
        int b = sc.nextInt();
        System.out.print("Enter tha Value of c: ");
        int c = sc.nextInt();

        System.out.println("\nThe Quaratic Equation : " + a + "x^2 + " + b + "x + " + c + " = 0");

        int D = b * b - 4 * a * c;

        if (D > 0) {
            System.out.println("\nThe Quadratic Equation Has Real Roots.");
        } else if (D < 0) {
            System.out.println("\nThe Quadratic Equation Has Imaginary Roots.");
        } else if (D == 0) {
            System.out.println("\nThe Quadratic Equation Has Real and Equal Roots.");
        }
        
    }
}