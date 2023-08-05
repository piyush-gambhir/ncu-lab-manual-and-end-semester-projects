import java.util.*;
/*
Problem Statement

Write a program to check whether the parenthesis in the expression are balanced or not.
Given a string str consisting of an expression 
Examples:
Input: str = (a+b)*c
Output: Parenthesis Balanced

*/

/**
 * problem_statement_experiment_9
 */
public class problem_statement_experiment_9 {

    public static void checkParenthesisBalanced(String expression) {
        Stack<Character> stack = new Stack<Character>();
        boolean isBalanced = true;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                stack.push(expression.charAt(i));
            } else if (expression.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        if (isBalanced) {
            System.out.println("Parenthesis Balanced");
        } else {
            System.out.println("Parenthesis Not Balanced");
        }
    }

    public static void main(String[] args) {
        String expression = "(a+b)*c";
        checkParenthesisBalanced(expression);
    }
}