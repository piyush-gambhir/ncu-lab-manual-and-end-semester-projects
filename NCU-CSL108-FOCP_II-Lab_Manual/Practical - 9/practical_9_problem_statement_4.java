/*
Write a program that writes an Serial No.(int), First Name (String), CGPA (float) and Grade(char) into a text file using bufferedWriter and displays the contents using bufferedReader.
*/

import java.io.*;
import java.util.Scanner;

/**
 * practical_9_problem_statement_4
 */
public class practical_9_problem_statement_4 {

    public static void writeFile(String fileName) {
        Scanner sc = new Scanner(System.in);

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);

            System.out.print("Enter the Serial Number: ");
            String serialNumber = sc.nextLine();
            System.out.print("Enter the Name: ");
            String name = sc.nextLine();
            System.out.print("Enter the CGPA: ");
            String cgpa = sc.nextLine();
            System.out.print("Enter the Grade: ");
            char grade = sc.next().charAt(0);

            bufferWriter.write(serialNumber);
            bufferWriter.write("\t");
            bufferWriter.write(name);
            bufferWriter.write("\t");
            bufferWriter.write(cgpa);
            bufferWriter.write("\t");
            bufferWriter.write(grade);

            bufferWriter.close();
            fileWriter.close();

            System.out.println("\nText Succesfully Written in File");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void readFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferReader = new BufferedReader(fileReader);

            System.out.println("Content in the File: ");
            String st;
            while ((st = bufferReader.readLine()) != null) {
                System.out.println(st);
            }

            bufferReader.close();
            fileReader.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        writeFile("practical_9_problem_statement_4.txt");
        readFile("practical_9_problem_statement_4.txt");

    }
}