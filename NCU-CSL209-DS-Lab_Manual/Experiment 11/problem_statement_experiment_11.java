/*

Problem Statement
Write a program to implement Tower of Hanoi

*/

import java.util.*;

/**
 * problem_statement_experiment_11
 */
public class problem_statement_experiment_11 {

    // Recursive Implementation of Tower of Hanoi Problem
    public static void recursiveTowerOfHanoi(int numberOfDisks, String tower1, String tower2, String tower3) {
        if (numberOfDisks == 0) {
            System.out.println("No disks to move");
            return;
        }
        if (numberOfDisks == 1) {
            System.out.println("Move disk 1 from " + tower1 + " to " + tower3);
            return;
        }

        recursiveTowerOfHanoi(numberOfDisks - 1, tower1, tower3, tower2);
        System.out.println("Move disk " + numberOfDisks + " from " + tower1 + " to " + tower3);
        recursiveTowerOfHanoi(numberOfDisks - 1, tower2, tower1, tower3);
    }

    public static void main(String[] args) {
        System.out.println("Recursive Implementation of Tower of Hanoi Problem");
        System.out.println("-------------------------------------------------");
        System.out.println("For 2 disks");
        recursiveTowerOfHanoi(2, "A", "B", "C");
        System.out.println("--------------------");
        System.out.println("For 3 disks");
        recursiveTowerOfHanoi(3, "A", "B", "C");
        System.out.println("-------------------------------------------------");

    }
}