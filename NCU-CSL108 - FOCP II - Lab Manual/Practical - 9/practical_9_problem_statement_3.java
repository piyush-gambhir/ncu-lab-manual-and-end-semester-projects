/* 
Write a program to perform simple read and write operation into file.
*/

import java.io.*;

/**
 * practical_9_problem_statement_3
 */
public class practical_9_problem_statement_3 {

    public static void writeFile(String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            bufferWriter.write("This is sample file for Practical 9 Problem Statement 3.");
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

            System.out.println("\nText in the File: ");
            String st;
            while ((st = bufferReader.readLine()) != null) {
                System.out.println(st);
            }

            bufferReader.close();
            fileReader.close();

            System.out.println("\nText Succesfully Read From File");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        writeFile("practical_9_problem_statement_3.txt");
        readFile("practical_9_problem_statement_3.txt");
    }
}