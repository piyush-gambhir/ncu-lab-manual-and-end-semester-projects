/*
Write a program that takes 5 integer command line arguments. Create a user defined Exception named CheckArgumentException to check the number of arguments  passed through command line. If the number of arguments is less than five, throw the CheckArgumentException, else print the addition of all five numbers.

Definition of Done:
DOD 1:Create a user-defined exception by the name CheckArgumentException
DOD 2:Ask the user to enter the number of arguments
DOD 3:Use for loop to enter the arguments
DOD 4:Calculate the sum of the values entered
*/

/**
 * practical_8_problem_statement_1
 */

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
