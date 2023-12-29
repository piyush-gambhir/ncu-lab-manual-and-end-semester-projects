/*
Write a Java program to read numbers in an integer array of size 5 and display the following (using functions for each functionality):
i) Sum of all the elements
ii) Sum of alternate elements in the array.

Definition of Done:
DoD 1: The program should ask the user to enter the elements of the array.
DoD 2: The program should display a menu with the above choices and ask the user to choose one of the choices.
*/

import java.util.Scanner;

/**
 * practical_3_problem_statement_4
 */

public class practical_3_problem_statement_4 {

    static int Sum_Array_Elements(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    static int Sum_Array_Alternate_Elements(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                sum += arr[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 5;
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
        System.out.println("\n");
        
        while (true) {
            System.out.println("\n");
            System.out.println("""
                    Enter 1 To Print Sum of All Elements of Array.
                    Enter 2 To Print Sum of Alternate Elements of Array.
                    Enter 3 To Exit the Program.
                    """);
            System.out.print("Enter Your Choice: ");
            int user_choice = sc.nextInt();

            if (user_choice == 1) {
                System.out.println("The Sum of the Elements of The Array are: " + Sum_Array_Elements(arr));
            }
            else if(user_choice == 2){
                System.out.println("The Sum of the Alternate Elemnts of the Array are: " + Sum_Array_Alternate_Elements(arr));
            }
            else if(user_choice == 3){
                System.out.println("Exiting.... ");
                break;
            }
            else{
                System.out.println("Invalid Input!");
                System.out.println("Try Again");
            }
        }
    }
}