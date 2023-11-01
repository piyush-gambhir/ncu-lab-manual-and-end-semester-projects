// Defining Package
package BloodBank;

// Custom Exception: InvalidInputException
public class InvalidInputException extends Exception {
    public InvalidInputException() {
        System.out.println("\nError: Invalid Input.");
    }
}