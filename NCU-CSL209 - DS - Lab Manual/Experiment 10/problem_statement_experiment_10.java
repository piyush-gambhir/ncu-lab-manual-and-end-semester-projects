import java.util.*;
/*

Problem Statement

Write a program to convert Infix expression into Postfix.
Given a string str consisting of an infix expression, convert it into Postfix
Examples:
Input: str = (a+b)*c
Output: ab+c*

*/

/**
 * problem_statement_experiment_10
 */
public class problem_statement_experiment_10 {

    public static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public static String infixToPostfix(String infixExpression) {
        Stack<Character> stack = new Stack<Character>();
        String postfixExpression = "";
        for (int i = 0; i < infixExpression.length(); i++) {
            if (infixExpression.charAt(i) == '(') {
                stack.push(infixExpression.charAt(i));
            } else if (infixExpression.charAt(i) == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfixExpression += stack.pop();
                }
                stack.pop();
            } else if (infixExpression.charAt(i) == '+' || infixExpression.charAt(i) == '-'
                    || infixExpression.charAt(i) == '*' || infixExpression.charAt(i) == '/') {
                while (!stack.isEmpty() && stack.peek() != '('
                        && getPrecedence(infixExpression.charAt(i)) <= getPrecedence(stack.peek())) {
                    postfixExpression += stack.pop();
                }
                stack.push(infixExpression.charAt(i));
            } else {
                postfixExpression += infixExpression.charAt(i);
            }
        }
        while (!stack.isEmpty()) {
            postfixExpression += stack.pop();
        }
        return postfixExpression;
    }

    public static void main(String[] args) {
        String infixExpression = "(a+b)*c";
        System.out.println(infixToPostfix(infixExpression));
    }
}