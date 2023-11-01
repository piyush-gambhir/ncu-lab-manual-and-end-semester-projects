/*
Write a Java program to find the maximum and minimum value of an array.
Definition of Done:
DoD 1:  The program should ask the user to enter the elements of the array.
DoD 2: The program should display the maximum and minimum elements of the array.
*/

import java.util.Scanner;

/**
 * practical_3_problem_statement_1
 */

public class practical_3_problem_statement_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter the Number of Elemnts You Wish to Enter: ");
        int n = sc.nextInt();

        int[] arr = new int[n]; // Defining an Array of Size n

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the Value of Element" + i + " of Array: ");
            arr[i] = sc.nextInt();
        }

        int min = arr[0];

        for (int i = 0; i < n; i++) {
            if (arr[0] > arr[i]) {
                min = arr[i];
            }
        }

        int max = arr[0];

        for (int i = 0; i < n; i++) {
            if (arr[0] < arr[i]) {
                max = arr[i];
            }
        }

        System.out.println("\nThe Maximum Element in the Array: " + max);
        System.out.println("The Minimum Element in the Array: " + min);
    }
}
