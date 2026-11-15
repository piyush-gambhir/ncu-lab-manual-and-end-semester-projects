









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