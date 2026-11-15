



import java.util.Scanner;




public class experiment_1_problem_statement_2 {








    public static int iterativeFibonacci(int n) {
        int a = 0, b = 1, c = 0;
        if (n == 0) {
            return a;
        } else if (n == 1) {
            return b;
        } else {
            for (int i = 2; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }







    public static int recursiveFibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("Fibonacci(Recursive) of " + n + " is " + recursiveFibonacci(n) + ".");
        System.out.println("Fibonacci(Iterative) of " + n + " is " + iterativeFibonacci(n) + ".");
    }
}