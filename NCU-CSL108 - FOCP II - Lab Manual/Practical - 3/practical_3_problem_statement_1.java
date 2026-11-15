






import java.util.Scanner;





public class practical_3_problem_statement_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter the Number of Elemnts You Wish to Enter: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

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
