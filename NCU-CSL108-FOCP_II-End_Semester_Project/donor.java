// Defining Package
package BloodBank;

// importing the required built-in librarires
import java.util.*;
import java.io.*;
import java.io.FileWriter;

// Donor Class
public class donor {

    private String name; // Donor Name
    private int age; // Donor Age
    private String anyDisease; // Donor Suffering From Any Disease
    private String bloodGroup; // Donor Blood Group

    // Empty constructor for Donor class.
    public donor() {

    }

    // Parameterized constructor for Donor Class
    // This constructor is used for creating donor records.
    public donor(String Name, int Age, String AnyDisease, String BloodGroup) {
        setName(Name);
        setAge(Age);
        setAnyDisease(AnyDisease);
        setBloodGroup(BloodGroup);
    }

    // Method setName()
    // This method is used to set donor name.
    public void setName(String Name) {
        this.name = Name;
    }

    // Method setAge()
    // This method is used to set donor age.
    public void setAge(int Age) {
        this.age = Age;
    }

    // Method setAnyDisease()
    // This method is used to set donor suffering from any disease.
    public void setAnyDisease(String AnyDisease) {
        this.anyDisease = AnyDisease;
    }

    // Method setBloodGroup()
    // This method is used to set donor Blood.
    public void setBloodGroup(String BloodGroup) {
        this.bloodGroup = BloodGroup;
    }

    // Method getName()
    // This method is used to fetch donor name.
    public String getName() {
        return this.name;
    }

    // Method getAge()
    // This method is used to fetch donor age.
    public int getAge() {
        return this.age;
    }

    // Method getAnyDisease()
    // This method is used to fetch donor suffering any_disease.
    public String getAnyDisease() {
        return this.anyDisease;
    }

    // Method getBloodGroup()
    // This method is used to fetch donor blood group.
    public String getBloodGroup() {
        return this.bloodGroup;
    }

    // Method Display()
    // This method displays donor record in structured view.
    public void display() {
        System.out.println("""
                -------------------
                Donor Details
                -------------------
                """);

        System.out.println("Name           :    " + this.name);
        System.out.println("Age            :    " + this.age);
        System.out.println("Any Disease    :    " + this.anyDisease);
        System.out.println("Blood Group    :    " + this.bloodGroup);

    }

    // Method addDonorRecord()
    // This function takes donor details such as name, age, any disesase, blood
    // group as input and create a record for donor.
    public void addDonorRecord() {
        Scanner sc = new Scanner(System.in);
        Boolean moreRecord = true;
        while (moreRecord == true) {
            try {
                System.out.println(
                        """

                                ----------------------------------------------------------------------------------------------------

                                ------------------------
                                Enter Donor Details
                                ------------------------
                                """);

                System.out.print("Name          :    ");
                String name = sc.nextLine();

                System.out.print("Age           :    ");
                String age = sc.nextLine();

                if (Integer.parseInt(age) < 20) {
                    throw new MinimumAgeException();
                }

                System.out.print("Any Disease   :   ");
                String AnyDisease = sc.nextLine();

                System.out.print("Blood Group   :   ");
                String BloodGroup = sc.nextLine();

                donor donor = new donor(name, Integer.parseInt(age), AnyDisease, BloodGroup);
                donor.display();
                System.out.println("Donor Record Added Succesfully.");

                try {
                    donor.addDonorRecordToFile();
                }

                catch (Exception e) {
                    System.out.println("Error: " + e);
                }
            }

            catch (MinimumAgeException MAE) {

            }

            catch (Exception e) {
                System.out.println("Error: " + e);
            }

            System.out.println("\n");

            System.out.println("Do You Want to Add Another donor Record?");
            System.out.print("Enter Y or N: ");

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
            } catch (InvalidInputException IIE) {

            }

            catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }

    }

    // Method addDonorRecordToFile()
    // This method appends the donor record to the file "donorRecords.txt" text
    // file.
    public void addDonorRecordToFile() throws IOException {
        String outputText = this.getName() + "|" + this.getAge() + "|" + this.getAnyDisease() + "|"
                + this.getBloodGroup();

        File donorRecords = new File("donorRecords.txt");

        if (donorRecords.exists()) {

            FileWriter fileWriter = new FileWriter(donorRecords, true);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(outputText);
            printWriter.close();
        }

        else {
            FileWriter fileWriter = new FileWriter(donorRecords);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(outputText);
            printWriter.close();
        }
    }

    // Method getDonorRecordFromFile()
    // This method fetch the donor records from the file "donor_records.txt" and
    // add them to an ArrayList donor_records
    public ArrayList<donor> getDonorRecordFromFile() throws FileNotFoundException {
        File donorRecords = new File("donorRecords.txt");
        Scanner sc = new Scanner(donorRecords);

        ArrayList<donor> donorList = new ArrayList<donor>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] detail = line.split("\\|");
            donor donor = new donor(detail[0], Integer.parseInt(detail[1]), detail[2], detail[3]);
            donorList.add(donor);

        }
        return donorList;
    }

    // Method searchDonorWithBloodGroup
    // This function takes blood group as input and then search for donors with the
    // enetered blood group.
    public void searchDonorWithBloodGroup() {
        Scanner sc = new Scanner(System.in);

        donor donorDriver = new donor();

        ArrayList<donor> donorList = new ArrayList<donor>();
        try {
            donorList = donorDriver.getDonorRecordFromFile();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        System.out.println("""

                ----------------------------------------------------------------------------------------------------

                ----------------------------------
                Search Donor With Blood Group
                ----------------------------------
                """);

        System.out.print("Enter Blood Group: ");
        String donorBloodGroup = sc.nextLine();

        try {
            int donorFound = 0;
            for (int i = 0; i <= donorList.size() - 1; i++)
                if (donorList.get(i).getBloodGroup().equals(donorBloodGroup)) {
                    donorFound++;
                    donorList.get(i).display();
                    System.out.println(
                            "--------------------------------------------------------\n");
                }

            if (donorFound == 0) {
                throw new RecordNotFoundException();
            }
        }

        catch (RecordNotFoundException RNFE) {
        }
    }

    // Method getDonorListAscendingOrder()
    // This method sort the records in asscending order and the display all the
    // records.
    public void getDonorListAscendingOrder() {
        Scanner sc = new Scanner(System.in);

        donor donorDriver = new donor();

        ArrayList<donor> donorList = new ArrayList<donor>();

        try {
            donorList = donorDriver.getDonorRecordFromFile();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        System.out.println("""

                ----------------------------------------------------------------------------------------------------

                --------------------------------------
                List of Donors in Ascending Order
                --------------------------------------
                """);

        try {
            for (int i = 0; i <= donorList.size() - 1; i++) {
                int minimumIndex = i;
                for (int j = i + 1; j <= donorList.size() - 1; j++) {
                    if (donorList.get(j).getName().compareTo(donorList.get(minimumIndex).getName()) < 0) {
                        minimumIndex = j;
                        donor temp = donorList.get(minimumIndex);
                        Collections.swap(donorList, minimumIndex, i);
                        donorList.set(i, temp);
                    }
                }
            }

            for (int i = 0; i <= donorList.size() - 1; i++) {

                System.out.println("Name            :    " + donorList.get(i).getName());
                System.out.println("Age             :    " + donorList.get(i).getAge());
                System.out.println("Blood Group     :    " + donorList.get(i).getBloodGroup());
                System.out.println("Any Disease     :    " + donorList.get(i).getAnyDisease());
                System.out.println(
                        "--------------------------------------------------------\n");

            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}

