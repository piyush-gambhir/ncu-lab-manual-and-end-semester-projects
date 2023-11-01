/*
Write a Java program to find the index of an array element in an array of size 10. The program should not use any function other than main ( ) functions.
Definition of Done:
DoD 1: The program should ask the user to enter the elements of the array.
DoD 2: The program should ask the user to enter a number to search.
DoD 3: The program should display the elements of the array entered.
DoD 4: The program should display the index of the number if the item is present or display -1 of the element is not present.
*/

import java.util.Scanner;

/**
 * practical_3_problem_statement_2
 */

public class practical_3_problem_statement_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 10;
        int[] arr = new int[n];

        System.out.println("\n\n");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the Value of Element " + (i + 1) + " of Array: ");
            arr[i] = sc.nextInt();
        }

        System.out.print("\nElements of the Array are: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.print("\n\nEnter the Number You Want to Search: ");
        int num = sc.nextInt();

        for (int i = 0; i < n; i++) {
            if (arr[i] == num) {
                System.out.println("The Index of the Element Entered in the Array: " + i);
                System.out.println();
            }
        }
    }
}