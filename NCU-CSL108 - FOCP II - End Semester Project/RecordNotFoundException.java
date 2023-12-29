// Defining Package
package BloodBank;

// Custom Exception: RecordNotFoundException
public class RecordNotFoundException extends Exception {
    public RecordNotFoundException() {
        System.out.println("\nError: Record Not Found.");
    }
}
