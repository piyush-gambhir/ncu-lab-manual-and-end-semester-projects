/*
 * Problem Statement:
 * Create an array of integer with size n. Return the difference between the largest and the smallest value inside that array.
 */

import java.util.Scanner;

/**
 * problem_statement
 */
public class problem_statement_experiment_1 {

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

    // Method getLargestElement(int[] arr)
    // Method to get largest value in the array
    public static int getLargestElemnt(int[] arr) {
        int largestElement = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largestElement) {
                largestElement = arr[i];
            }
        }
        return largestElement;
    }

    // Method getSmallestElement(int[] arr)
    // Method to get smallest value in the array
    public static int getSmallestElemnt(int[] arr) {
        int smallestElement = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallestElement) {
                smallestElement = arr[i];
            }
        }
        return smallestElement;
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
        System.out.println("Largest Value in the Array = " + getLargestElemnt(arr));
        System.out.println("Smallest Value in the Array = " + getSmallestElemnt(arr));

        System.out.println("\n");
        System.out.println("The Difference Between Largest and Smallest Value in the Array = "
                + (getLargestElemnt(arr) - getSmallestElemnt(arr)));
    }
}