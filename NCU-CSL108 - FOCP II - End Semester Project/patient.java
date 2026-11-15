
package BloodBank;


import java.util.*;
import java.io.*;
import java.io.FileWriter;
import java.util.Collections;


public class patient {

    private String name;
    private int age;
    private String disease;
    private String doctorName;
    private String dateAdmitted = "YYYY-MM-DD";
    private String bloodGroupRequired;


    public patient() {

    }



    public patient(String Name, int Age, String Disease, String DoctorName, String DateAdmitted,
            String BloodGroupRequired) {

        setName(Name);
        setAge(Age);
        setDisease(Disease);
        setDoctorName(DoctorName);
        setDateAdmitted(DateAdmitted);
        setBloodGroupRequired(BloodGroupRequired);

    }



    public void setName(String Name) {
        this.name = Name;
    }



    public void setAge(int Age) {
        this.age = Age;
    }



    public void setDisease(String Disease) {
        this.disease = Disease;
    }



    public void setDoctorName(String DoctorName) {
        this.doctorName = DoctorName;
    }



    public void setDateAdmitted(String DateAdmitted) {
        this.dateAdmitted = DateAdmitted;
    }



    public void setBloodGroupRequired(String BloodGroupRequired) {
        this.bloodGroupRequired = BloodGroupRequired;
    }



    public String getName() {
        return this.name;
    }



    public int getAge() {
        return this.age;
    }



    public String getDisease() {
        return this.disease;
    }



    public String getDoctorName() {
        return this.doctorName;
    }



    public String getDateAdmitted() {
        return this.dateAdmitted;
    }



    public String getBloodGroupRequired() {
        return this.bloodGroupRequired;
    }



    public void display() {
        System.out.println("""
                -------------------
                Patient Details
                -------------------
                """);

        System.out.println("Name                        :      " + this.name);
        System.out.println("Age                         :      " + this.age);
        System.out.println("Disease                     :      " + this.disease);
        System.out.println("Doctor Name                 :      " + this.doctorName);
        System.out.println("Date Admitted (YYYY-MM-DD)  :      " + this.dateAdmitted);
        System.out.println("Blood Group Required        :      " + this.bloodGroupRequired);
    }




    public void addPatientRecord() {
        Scanner sc = new Scanner(System.in);

        Boolean moreRecord = true;



        while (moreRecord == true) {
            try {
                System.out.println(
                        """

                                ----------------------------------------------------------------------------------------------------
                                ------------------------
                                Enter Patient Details
                                ------------------------
                                """);

                System.out.print("Name                       :      ");
                String name = sc.nextLine();

                System.out.print("Age                        :      ");
                String age = sc.nextLine();

                System.out.print("Disease                    :      ");
                String disease = sc.nextLine();

                System.out.print("Doctor Name                :      ");
                String DoctorName = sc.nextLine();

                System.out.print("Date Admitted (YYYY-MM-DD) :      ");
                String DateAdmitted = sc.nextLine();

                System.out.print("Blood Group Required       :      ");
                String BloodGroupRequired = sc.nextLine();

                patient patient = new patient(name, Integer.parseInt(age), disease, DoctorName, DateAdmitted,
                        BloodGroupRequired);

                try {
                    patient.addPatientRecordToFile();
                    patient.display();
                    System.out.println("Patient Record Added Succesfully.");

                    System.out.println("\n");

                    System.out.println("Do You Want to Add Another Patient Record?");
                    System.out.print("Enter Y or N: ");
                }

                catch (Exception e) {
                    System.out.println("Error: " + e);
                }
            }

            catch (Exception e) {
                System.out.println("Error: " + e);
            }

            try {
                String user_input = sc.nextLine();
                if (user_input.equalsIgnoreCase("N")) {
                    moreRecord = false;
                }

                else if (user_input.equalsIgnoreCase("Y")) {
                    continue;
                }

                else {
                    throw new InvalidInputException();
                }
            } 
            
            catch (InvalidInputException e) {
                System.out.println("Error: " + e);
            }
        }
    }




    public void addPatientRecordToFile() throws IOException {

        String outputText = this.getName() + "|" + this.getAge() + "|" + this.getDisease() + "|"
                + this.getDoctorName() + "|" + this.getDateAdmitted() + "|" + this.getBloodGroupRequired();

        File patientRecords = new File("patientRecords.txt");
        if (patientRecords.exists()) {
            FileWriter fileWriter = new FileWriter(patientRecords, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(outputText);
            printWriter.close();
        }

        else {
            FileWriter fileWriter = new FileWriter(patientRecords);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(outputText);
            printWriter.close();
        }
    }




    public ArrayList<patient> getPatientRecordFromFile() throws FileNotFoundException {
        File patientRecords = new File("patientRecords.txt");
        Scanner sc = new Scanner(patientRecords);

        ArrayList<patient> patientList = new ArrayList<patient>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] detail = line.split("\\|");
            patient patient = new patient(detail[0], Integer.parseInt(detail[1]), detail[2], detail[3], detail[4],
                    detail[5]);
            patientList.add(patient);
        }
        return patientList;
    }




    public void searchPatientWithName() {
        Scanner sc = new Scanner(System.in);

        patient patientDriver = new patient();

        ArrayList<patient> patientList = new ArrayList<patient>();
        
        try {
            patientList = patientDriver.getPatientRecordFromFile();
        } 
        
        catch (Exception e) {
            System.out.println("Error: " + e);
        }

        System.out.println("""

                ----------------------------------------------------------------------------------------------------

                -----------------------------
                Search Patient With Name
                -----------------------------
                """);

        System.out.print("Enter Patient Name: ");
        String patientName = sc.nextLine();

        System.out.println("\n");
        try {
            int patientFound = 0;
            for (int i = 0; i <= patientList.size() - 1; i++) {
                if (patientList.get(i).getName().equalsIgnoreCase(patientName)) {
                    patientFound++;
                    patientList.get(i).display();
                    System.out.print(
                            "--------------------------------------------------------\n\n");
                }
            }
            if (patientFound == 0) {
                throw new RecordNotFoundException();
            }
        }

        catch (RecordNotFoundException RNFE) {

        }

        catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }




    public void getpatientListAscendingOrder() {
        Scanner sc = new Scanner(System.in);

        patient patientDriver = new patient();

        ArrayList<patient> patientList = new ArrayList<patient>();
        try {
            patientList = patientDriver.getPatientRecordFromFile();
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }

        System.out.println("""


                ----------------------------------------------------------------------------------------------------

                -------------------------------------------------------------------------------------------
                List of Patients With Blood Group Required And Admitted Date Sorted in Ascending Order
                -------------------------------------------------------------------------------------------
                """);

        try {
            for (int i = 0; i <= patientList.size() - 1; i++) {
                int minimum_index = i;
                for (int j = i + 1; j <= patientList.size() - 1; j++) {
                    if (patientList.get(j).getName().compareTo(patientList.get(minimum_index).getName()) < 0) {
                        minimum_index = j;
                        patient temp = patientList.get(minimum_index);
                        Collections.swap(patientList, minimum_index, i);
                        patientList.set(i, temp);
                    }
                }
            }

            for (int i = 0; i <= patientList.size() - 1; i++) {

                System.out.println("Name                      :      " + patientList.get(i).getName());
                System.out.println("Blood Group Required      :      " + patientList.get(i).getBloodGroupRequired());
                System.out.println("Date Admitted             :      " + patientList.get(i).getDateAdmitted());
                System.out.println(
                        "--------------------------------------------------------\n");

            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }



    public void getSuitableDonors() {
        Scanner sc = new Scanner(System.in);

        patient patientDriver = new patient();

        ArrayList<patient> patientList = new ArrayList<patient>();
        try {
            patientList = patientDriver.getPatientRecordFromFile();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        donor donorDriver = new donor();

        ArrayList<donor> donorList = new ArrayList<donor>();
        try {
            donorList = donorDriver.getDonorRecordFromFile();

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("""

                ----------------------------------------------------------------------------------------------------

                ----------------------------------------------
                Get List of Suitable Donors For a Patient
                ----------------------------------------------
                """);

        System.out.print("Enter Patient Name: ");
        String patientName = sc.nextLine();

        try {
            int patientFound = 0;
            int donorFound = 0;

            int recordNumber = 0;

            for (int i = 0; i <= patientList.size() - 1; i++) {
                if (patientList.get(i).getName().equalsIgnoreCase(patientName)) {
                    patientFound++;
                    recordNumber = i;
                    break;
                }
            }
            if (patientFound == 0) {
                throw new RecordNotFoundException();
            }

            for (int j = 0; j <= donorList.size() - 1; j++) {
                if (patientList.get(recordNumber).getBloodGroupRequired()
                        .equalsIgnoreCase(donorList.get(j).getBloodGroup())) {
                    donorFound++;

                    System.out.println(
                            "--------------------------------------------------------\n\n");
                    donorList.get(j).display();
                }
            }
            if (donorFound == 0) {
                System.out.println("No Patient Found With Required Blood Group.");
            }
        }

        catch (RecordNotFoundException RNFE) {

        }

        catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }



    public void getPatientsRequireEnteredBloodGroup() {
        Scanner sc = new Scanner(System.in);

        patient patientDriver = new patient();

        ArrayList<patient> patientList = new ArrayList<patient>();
        try {
            patientList = patientDriver.getPatientRecordFromFile();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        System.out.println("""
                ----------------------------------------------------------------------------------------------------

                --------------------------------------------------------------
                Get List of Patients That Require the Entered Blood Group
                --------------------------------------------------------------
                """);

        System.out.print("Enter Blood Group: ");
        String patientBloodGroupRequired = sc.nextLine();

        try {

            int patientFound = 0;
            for (int i = 0; i <= patientList.size() - 1; i++) {
                if (patientList.get(i).getBloodGroupRequired().equalsIgnoreCase(patientBloodGroupRequired)) {
                    patientFound++;
                    System.out.println(
                            "--------------------------------------------------------\n");
                    patientList.get(i).display();
                }
            }
            if (patientFound == 0) {
                throw new RecordNotFoundException();
            }
        }

        catch (RecordNotFoundException RNFE) {

        }
    }
}