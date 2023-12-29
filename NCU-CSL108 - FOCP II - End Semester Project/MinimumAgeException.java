// Defining Package
package BloodBank;

// Custom Exception: MinimumAgeException
public class MinimumAgeException extends Exception {
    public MinimumAgeException() {
        System.out.println("\nError: The Entered Age is Below Minimum Age.");
    }
}


