



















package BloodBank;


import java.util.Scanner;



public class bloodBank {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        patient patientDriver = new patient();
        donor donorDriver = new donor();

        Boolean runAgain = true;


        while (runAgain == true) {





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


                switch (user_choice) {

                    case 1:
                        patientDriver.addPatientRecord();
                        break;

                    case 2:
                        donorDriver.addDonorRecord();
                        break;

                    case 3:
                        donorDriver.searchDonorWithBloodGroup();
                        break;

                    case 4:
                        patientDriver.searchPatientWithName();
                        break;

                    case 5:

                        patientDriver.getpatientListAscendingOrder();
                        break;

                    case 6:
                        donorDriver.getDonorListAscendingOrder();
                        break;

                    case 7:
                        patientDriver.getSuitableDonors();
                        break;

                    case 8:
                        patientDriver.getPatientsRequireEnteredBloodGroup();
                        break;

                    case 9:
                        runAgain = false;
                        break;

                    default:
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