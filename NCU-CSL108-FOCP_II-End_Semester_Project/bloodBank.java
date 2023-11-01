/* 

Problem Statement 

Blood Bank management System: The aim of the project is to retrieve, process and store information related to donors and patients. The system inputs the details of patients (name, age, disease, doctor, admitted date, blood group required) and details of donors (name, age, blood group, any disease). There is a menu which has following choices:
•	Adding record of patient
•	Adding record of donor
•	Search donor with existing blood group
•	Search patient with name
•	List of patients with blood group required and admitted date sorted in ascending order

Definition of Done:
1.	The donor is allotted to a patient only if both blood group matches. 
2.	Above choices have to be implemented using functions
3.	If the age of a donor is greater than 20, then only he is allowed to give blood otherwise display “invalid age”.
4.	While assigning donor to patient, retrieve the list of patients who require blood with particular group. If there are more than one patient, then the patient with least admitted date is allotted blood.

*/

// Defining Package 
package BloodBank;

// importing the required built-in librarires
import java.util.Scanner;

// Class bloodBank
// Main Class
public class bloodBank {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        patient patientDriver = new patient(); // Patient object patientDriver to call Patient class methods.
        donor donorDriver = new donor(); // Donor object donorDriver to call Donor class methods.

        Boolean runAgain = true;

        // An infinite while loop to run the driver menu until user wants to exit.
        while (runAgain == true) {

            /*
             * Driver Menu
             */

            System.out.println("""

                    ----------------------------------------------------------------------------------------------------

                    -----------------------------------------
                    -Welcome To Blood Bank Management System-
                    -----------------------------------------
                                        """);
            System.out.println("""
                    1. Add Patient Record.
                    2. Add Donor Record.
                    3. Search and Get List of Donors With Entered Blood Group.
                    4. Search and Get Patient With Entered Name.
                    5. Get List of Patients With Blood Group Required And Admitted Date Sorted in Ascending Order.
                    6. Get List of Donors in Asscending Order.
                    7. Get List of Suitable Donors For a Patient
                    8. Get List of Patients that Requires the Entered Blood Group.
                    9. Exit.

                    Enter the Number To Choose an Option.
                    """);

            try {
                System.out.print("Enter Your Choice: ");
                int user_choice = sc.nextInt();

                // Using switch case to run the menu
                switch (user_choice) {

                    case 1: // Add patient Record
                        patientDriver.addPatientRecord();
                        break;

                    case 2: // Add Donor Record
                        donorDriver.addDonorRecord();
                        break;

                    case 3: // Search Donor With Blood Group
                        donorDriver.searchDonorWithBloodGroup();
                        break;

                    case 4: // Search Patient With Name
                        patientDriver.searchPatientWithName();
                        break;

                    case 5: // Get List of Patients With Blood Group Required And Admitted Date Sorted in
                            // Asscending Order
                        patientDriver.getpatientListAscendingOrder();
                        break;

                    case 6: // Get List of of Donors Sorted in Asscending Order
                        donorDriver.getDonorListAscendingOrder();
                        break;

                    case 7: // Get List of Suitable Donors For a Patient
                        patientDriver.getSuitableDonors();
                        break;

                    case 8: // Get List of Patients That Requires the Entered Blood Group
                        patientDriver.getPatientsRequireEnteredBloodGroup();
                        break;

                    case 9: // Exit The Program
                        runAgain = false;
                        break;

                    default: // In Case of Invalid Input
                        System.out.println("Invalid Input! Enter a Valid Input.");
                        System.out.println("Try Again.");
                        break;
                }
            }

            catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
    }
}