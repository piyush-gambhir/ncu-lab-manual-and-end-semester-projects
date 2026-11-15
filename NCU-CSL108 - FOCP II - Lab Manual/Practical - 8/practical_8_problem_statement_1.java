













class CheckArgumentException extends Exception {

}

public class practical_8_problem_statement_1 {

    public static void main(String[] args) {

        int sum = 0;
        if (args.length < 5) {
            try {
                throw new CheckArgumentException();
            } catch (CheckArgumentException e) {
                System.out.println("Exception: " + e);
            }
        } else {
            for (int i = 0; i < args.length; i++) {
                sum = sum + Integer.parseInt(args[i]);
            }
            System.out.println("Sum is: " + sum);
        }
    }
}
