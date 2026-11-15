






import java.util.Scanner;




public class practical_1_problem_statement_2 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("\n\nEnter Number of Minutes: ");
        int minutes = sc.nextInt();

        int years = minutes / (60 * 24 * 365);
        int r1 = minutes % (60 * 24 * 365);
        int months = r1 / (60 * 24 * 30);
        int r2 = r1 % (60 * 24 * 30);
        int days = r2 / (60 * 24);
        int r3 = r2 % (60 * 24);
        int hours = r3 / (60);

        System.out.println("\nEntered Minutes in the Format hh--dd-mm-yy: " + hours + "--" + days + "--" + months + "--" + years);
    }
}

