/*
Problem Statement:
Write a Java Program to check if see if Array contains a specific value. (Linear Search)
*/

/**
 * question_bank_8
 */
public class question_bank_8_experiment_1 {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int searchValue = 5;
        boolean isFound = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchValue) {
                isFound = true;
                break;
            }
        }
        System.out.println("Is " + searchValue + " Found in Array: " + isFound);
    }
}