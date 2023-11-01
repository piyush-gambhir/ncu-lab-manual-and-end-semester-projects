/*
Write a Java Program to count even and odd numbers in an array.
Definition of Done
DoD 1: The program should ask the user to enter the elements of the array.
DoD 2: Even elements will be stored in EvenArray[] and odd elements will be stored in oddArray[].
DoD 3: Display all three arrays along with their length.

*/

import java.util.Scanner;

/**
 * practical_3_problem_statement_3
 */

public class practical_3_problem_statement_3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter the Number of Elements You Want to Enter: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("\n");

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the Value of Element " + (i + 1) + " of Array: ");
            arr[i] = sc.nextInt();
        }

        System.out.print("\nElements of the Array are: ");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\nLength of the Array is: " + arr.length);

        int count_even = 0;
        int count_odd = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                count_even++;
            } else {
                count_odd++;
            }
        }

        int[] EvenArray = new int[count_even];
        int[] OddArray = new int[count_odd];

        int counter_even = 0;
        int counter_odd = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                EvenArray[counter_even] = arr[i];
                counter_even++;
            } else {
                OddArray[counter_odd] = arr[i];
                counter_odd++;
            }
        }

        System.out.print("\n\nElements of the Even Array are: ");
        for (int i = 0; i < EvenArray.length; i++) {
            System.out.print(EvenArray[i] + " ");
        }
        System.out.print("\nLength of the Array is: " + EvenArray.length);

        System.out.print("\n\nElements of the Odd Array are: ");
        for (int i = 0; i < OddArray.length; i++) {
            System.out.print(OddArray[i] + " ");
        }
        System.out.print("\nLength of the Array is: " + OddArray.length);

    }
}