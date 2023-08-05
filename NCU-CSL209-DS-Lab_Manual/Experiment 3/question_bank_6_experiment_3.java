/*

Problem Statement:
Write a method called median() that accepts an array of integers as its argument and returns the median of the numbers in the array. The median is the number that will appear in the middle if you arrange the elements in order.

*/

/**
 * question_bank_6_experiment_4
 */
public class question_bank_6_experiment_4 {
    public static int median(int[] arr) {
        int median = 0;
        int n = arr.length;
        if (n % 2 == 0) {
            median = (arr[n / 2] + arr[(n / 2) - 1]) / 2;
        } else {
            median = arr[n / 2];
        }
        return median;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(median(arr));
    }

}