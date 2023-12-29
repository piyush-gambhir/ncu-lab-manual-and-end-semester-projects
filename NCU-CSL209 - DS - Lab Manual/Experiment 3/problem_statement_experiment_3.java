/*

Problem Statement:
Write a program to read numbers in an integer array of size 5 and display the following:
• Sum of all the elements
• Sum of alternate elements in the array
• Second highest element in the array

*/

import java.util.Scanner;

/**
 * problem_statement
 */
public class problem_statement_experiment_3 {

    // Method enterArrayElements(int[] arr)
    // Method for taking input for array elements
    public static void enterArrayElements(int[] arr) {
        Scanner sc = new Scanner(System.in);

        System.out.println("""
                ====================================
                Enter Array Elements
                ====================================
                """);
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter the Value of Array Element " + (i + 1) + ": ");
            int temp = sc.nextInt();
            arr[i] = temp;
        }
        sc.close();
    }

    // Method printArrayElements(int[] arr)
    // Method for printing array elements
    public static void printArrayElements(int[] arr) {
        System.out.print("""
                ====================================
                Printing Array Elements
                ====================================
                """);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Value of Array Element " + (i + 1) + ": " + arr[i]);
        }
    }

    // Method printAlternateArrayElements(int[] arr)
    // Method for printing alternate array elements
    public static void printAlternateArrayElements(int[] arr) {
        System.out.println("""
                ====================================
                Printing Alternatet Array Elements
                ====================================
                """);
        for (int i = 0; i < arr.length; i = i + 2) {
            System.out.println("Value of Array Element " + (i + 1) + ": " + arr[i]);
        }
    }

    // Method getLargestElement(int[] arr)
    // Method to get largest value in the array
    public static int getLargestElement(int[] arr) {
        int largestElement = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largestElement) {
                largestElement = arr[i];
            }
        }
        return largestElement;
    }

    // methodgetSecondLargestElement(int[] arr)
    // Method to get second largest value i the array
    public static int getSecondLargestElemnt(int[] arr) {
        int secondLargestElement = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == getLargestElement(arr)) {
                continue;
            } else if (arr[i] > secondLargestElement) {
                secondLargestElement = arr[i];
            }
        }
        return secondLargestElement;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of The Array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("\n");
        enterArrayElements(arr);

        System.out.println("\n");
        printArrayElements(arr);

        System.out.println("\n");
        printAlternateArrayElements(arr);

        System.out.println("\n");
        System.out.println("Second Largest Value in the Array = " + getSecondLargestElemnt(arr));

    }
}