/*
Write a Java program that asks the user to provide a single character from the alphabet. 
Print Vowel or Consonant, depending on the user input. 
If the user input is not a letter (between a and z or A and Z), or is a string of length > 1, 
print an error message.

Definition of Done:
DoD 1: The program asks an input from the user.
DoD 2: A single character input is taken from the user or an error message is generated.
DoD 3: The program should print “Vowel” if the entered character is a vowel and 
“Consonant” if the entered character is a consonant.
*/

import java.util.Scanner;

/**
 * practical_2_problem_statement_2
 */
public class practical_2_problem_statement_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter a character: ");
        String character = sc.next();

        int ascii = character.charAt(0);

        if (character.length() == 1) {
            if (ascii >= 65 && ascii <= 90 || ascii >= 97 && ascii <= 122) {
                if (character.equalsIgnoreCase("a") ||
                        character.equalsIgnoreCase("e") ||
                        character.equalsIgnoreCase("i") ||
                        character.equalsIgnoreCase("o") ||
                        character.equalsIgnoreCase("u")) {

                    System.out.println("\nThe Entered Character is a Vowel.");
                } else {
                    System.out.println("\nThe Entered Character is a Consonant");
                }
            } else {
                System.out.println("Invalid Input! The Entered Value is not a Alapahbetic Character.");
            }
        } else {
            System.out.println("Invalid Input! You Have Entered More than One Character.");
        }
    }
}