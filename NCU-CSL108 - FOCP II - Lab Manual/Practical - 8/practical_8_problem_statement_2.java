/*
Create a class with a main() method that throws an object of class Exception inside a try block. Give the constructor for Exception a String argument. Catch the exception inside a catch clause and print the String argument. Add a finally clause and print a message to prove you were there.
*/

/**
 * practical_8_problem_statement_2
 */

public class practical_8_problem_statement_2 {
    public static void main(String[] args) {

        try {
            String argument = "Practical 8 Problem Statement 2";
            throw new Exception(argument);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Final Block");
        }
    }
}