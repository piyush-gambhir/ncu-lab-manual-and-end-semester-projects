import java.util.*;
/*
Problem Statement

Write a program to create a stack and perform:
1) Reversal of a sentence using stack.
2) Given a string str consisting of a sentence, the task is to reverse the entire
   sentence word by word.
   
   Examples:
   Input: str = “data structures and algorithms”
   Output: algorithms and structures data
*/

/**
 * problem_statement_experiment_8
 */
public class problem_statement_experiment_8 {

    public static String reverseSentence(String str) {
        Stack<String> stack = new Stack<String>();
        String[] strArray = str.split(" ");
        String result = "";

        for (int i = 0; i < strArray.length; i++) {
            stack.push(strArray[i]);
        }

        while (!stack.isEmpty()) {
            result += stack.pop() + " ";
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "data structures and algorithms";
        System.out.println(reverseSentence(str));

    }
}