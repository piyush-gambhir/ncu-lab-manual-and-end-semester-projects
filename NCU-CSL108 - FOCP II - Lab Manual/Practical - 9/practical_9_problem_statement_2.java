/*
Write a program to change the file permissions.
*/

import java.io.*;

/**
 * practical_9_problem_statement_2
 */
public class practical_9_problem_statement_2 {

    public static void main(String[] args) {

        File file = new File("practical_9_problem_statement_2.txt");

        if (file.exists()) {

            file.setExecutable(true);
            file.setReadable(true);
            file.setWritable(false);

            System.out.println("File Permissions Changed.");

            System.out.println("----------File Permissions----------");
            System.out.println("Executable: " + file.canExecute());
            System.out.println("Readable: " + file.canRead());
            System.out.println("Writable: " + file.canWrite());
        }

        else {
            System.out.println("File Not Found.");
        }
    }
}
