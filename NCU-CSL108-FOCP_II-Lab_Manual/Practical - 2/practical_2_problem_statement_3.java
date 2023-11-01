/*
Write a Java program to print following structure:
*
**
***
****
*****
******
*/

import java.util.Scanner;

/**
 * practical_2_problem_statement_3
 */

public class practical_2_problem_statement_3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // System.out.print("Enter the Number of Rows: ");
        // int n = sc.nextInt();

        int n = 6;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}