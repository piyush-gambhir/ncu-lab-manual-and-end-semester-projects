/*
Print the sum, difference and product of two complex numbers by creating a class named 'Complex' with separate methods for each operation whose real and imaginary parts are entered by the user.
*/

/**
 * practical_4_problem_statement_4
 */

import java.util.Scanner;

class Complex {
    int real;
    int imaginary;

    public Complex() {

    }

    public Complex(int r, int i) {
        real = r;
        imaginary = i;
    }

    public void PrintComplexNumber(int real, int imaginary) {
        System.out.print(real + " + " + imaginary + "i");
    }

    public void AddComplex(Complex c1, Complex c2) {
        Complex temp_complex = new Complex();

        temp_complex.real = c1.real + c2.real;
        temp_complex.imaginary = c1.imaginary + c2.imaginary;

        System.out.print("\nSum of Complex Numbers: ");
        PrintComplexNumber(temp_complex.real, temp_complex.imaginary);
    }

    public void SubtractComplex(Complex c1, Complex c2) {
        Complex temp_complex = new Complex();

        temp_complex.real = c1.real - c2.real;
        temp_complex.imaginary = c1.imaginary - c2.imaginary;
        System.out.print("\nDifference of Complex Numbers: ");
        PrintComplexNumber(temp_complex.real, temp_complex.imaginary);
    }

    public void MultiplyComplex(Complex c1, Complex c2) {
        Complex temp_complex = new Complex();

        temp_complex.real = (c1.real * c2.real - c1.imaginary * c2.imaginary);
        temp_complex.imaginary = (c1.real * c2.imaginary + c1.imaginary * c2.real);

        System.out.print("\nProduct of Complex Numbers: ");
        PrintComplexNumber(temp_complex.real, temp_complex.imaginary);
    }
}

public class practical_4_problem_statement_4 {

    public static void main(String[] args) {

        Complex comp = new Complex();

        Scanner sc = new Scanner(System.in);

        System.out.println("\n\nEnter the Values For First Complex Number.");
        System.out.print("\nEnter Real Part of Complex Number: ");
        int rl1 = sc.nextInt();
        System.out.print("Enter Imaginary Part of Complex Number: ");
        int img1 = sc.nextInt();

        Complex c1 = new Complex(rl1, img1);
        System.out.print("\nComplex Number: ");
        comp.PrintComplexNumber(rl1, img1);

        System.out.println("\n\nEnter the Values For Second Complex Number.");
        System.out.print("\nEnter Real Part of Complex Number: ");
        int rl2 = sc.nextInt();
        System.out.print("Enter Imaginary Part of Complex Number: ");
        int img2 = sc.nextInt();

        Complex c2 = new Complex(rl2, img2);
        System.out.print("\nComplex Number: ");
        comp.PrintComplexNumber(rl2, img2);

        while (true) {
            System.out.println("\n");
            System.out.println("""
                    1. Enter 1 to Add Complex Numbers.
                    2. Enter 2 to Subtract Complex Numbers.
                    3. Enter 3 to Multiply Complex Numbers.
                    4. Enter 4 to Exit the Program.
                    """);

            System.out.print("\nEnter Your Choice: ");
            int user_input = sc.nextInt();

            if (user_input == 1) {
                comp.AddComplex(c1, c2);
            } else if (user_input == 2) {
                comp.SubtractComplex(c1, c2);
            } else if (user_input == 3) {
                comp.MultiplyComplex(c1, c2);
            } else if (user_input == 4) {
                break;
            } else {
                System.out.println("Invalid Input!");
            }

        }
    }
}