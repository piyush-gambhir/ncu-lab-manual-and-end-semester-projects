/*
Write a program that takes two integers (values to be given within the program) and displays the output of the following operators: addition, subtraction, multiplication, division and modulus.
Definition of Done:
DoD 1: Assign two numbers to two variables.
DoD2: Use separate variables to store the results.
*/

import java.util.Scanner;

/**
 * practical_1_problem_statement_1
 */
public class practical_1_problem_statement_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter Number 1: ");
        int a = sc.nextInt();
        System.out.print("Enter Number 2: ");
        int b = sc.nextInt();

        int sum = a + b;
        int sub = a - b;
        int mul = a * b;
        int div = a / b;
        int mod = a % b;

        
        System.out.println("\n\n");
        System.out.println("Addition         :   " + a + " + " + b + " = " + sum);
        System.out.println("Subttraction     :   " + a + " - " + b + " = " + sub);
        System.out.println("Multiplication   :   " + a + " x " + b + " = " + mul);
        System.out.println("Division         :   " + a + " / " + b + " = " + div);
        System.out.println("Modulus          :   " + a + " % " + b + " = " + mod);
        System.out.println("\n\n");
    }
}
