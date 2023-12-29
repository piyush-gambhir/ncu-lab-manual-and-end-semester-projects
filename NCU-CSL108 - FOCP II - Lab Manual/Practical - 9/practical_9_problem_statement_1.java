/*
Write a program to check if the file exist is a file or directory.
*/

import java.io.*;

/**
 * practical_9_problem_statement_1
 */

public class practical_9_problem_statement_1 {

    public static void main(String[] args) {
        try {
            File f = new File("practical_9_problem_statement_1.txt");
            f.createNewFile();
            if (f.exists()) {
                System.out.println("Is a File.");
            }

            else if (f.isDirectory()) {
                System.out.println("Is a Direcotry.");
            }
        }

        catch (Exception e) {
            System.out.println("File Does Not Exists.");
        }
    }
}