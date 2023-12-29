/*
 * Problem Statement:
 * Write a program that initializes an array with ten random integers and then prints four lines of output, containing: 
 * • Every element at an even index
 * • Every odd element
 * • All elements in reverse order
 * • Only the first and last elemenarray.
 */

import java.util.Scanner;

/**
 * problem_statement_experiment_2
 */
public class problem_statement_experiment_2 {

    // Method enterArrayElements(int[] arr)
    // Method for taking input for array elements
    public static void enterArrayElements(int[] arr) {
        Scanner sc = new Scanner(System.in);

        System.out.print("""
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

    // Method printArrayElements(int[] arr)
    // Method for printing array elements
    public static void printReversedArrayElements(int[] arr) {
        System.out.print("""
                ====================================
                Printing Array Elements in Reverse
                ====================================
                """);
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println("Value of Array Element " + (i + 1) + ": " + arr[i]);
        }
    }

    // Method printOddIndexArrayElements(int[] arr)
    // Method for printing array elements at odd index
    public static void printOddIndexArrayElements(int[] arr) {
        System.out.print("""
                =======================================
                Printing Array Elements at Odd Indices
                =======================================
                """);
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 != 0) {
                System.out.println("Value of Array Element at Index: " + (i) + ": " + arr[i]);
            }
        }
    }

    // Method printEvenIndexArrayElements(int[] arr)
    // Method for printing array elements at even index
    public static void printEvenIndexArrayElements(int[] arr) {
        System.out.print("""
                ========================================
                Printing Array Elements at Even Indices
                ========================================
                """);
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                System.out.println("Value of Array Element at Index: " + (i) + ": " + arr[i]);
            }
        }
    }

    public static void printFirstLastArrayElement(int[] arr) {
        System.out.print("""
                ========================================
                Printing First and Last Array Element
                ========================================
                """);
        System.out.println("The First Element of Array; " + arr[0]);
        System.out.println("The Last Element of Array; " + arr[arr.length - 1]);
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
        printReversedArrayElements(arr);

        System.out.println("\n");
        printOddIndexArrayElements(arr);

        System.out.println("\n");
        printEvenIndexArrayElements(arr);

        System.out.println("\n");
        printFirstLastArrayElement(arr);
    }
}