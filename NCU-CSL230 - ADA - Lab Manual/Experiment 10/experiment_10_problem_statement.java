/*
Write a program for 0/1 Knapsack using Branch and Bound
*/

import java.util.*;

/**
 * experiment_10_problem_statement
 */
public class experiment_10_problem_statement {
    static class Item {
        int weight;
        int value;

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    static class Node {
        int level;
        int profit;
        int bound = 0;
        int weight = 0;
    }

    private static int bound(Node u, Item[] items, int n, int maxWeight) {
        if (u.weight >= maxWeight) {
            return 0;
        }
        int profitBound = u.profit;
        int j = u.level + 1;
        int totalWeight = u.weight;
        while (j < n && totalWeight + items[j].weight <= maxWeight) {
            totalWeight += items[j].weight;
            profitBound += items[j].value;
            j++;
        }
        if (j < n) {
            profitBound += (maxWeight - totalWeight) * items[j].value / items[j].weight;
        }
        return profitBound;
    }

    public static void knapsackUsingBranchBound(Item[] items, int n, int maxWeight) {
        Queue<Node> queue = new LinkedList<>();
        Node u = new Node();
        Node v = new Node();
        queue.add(u);
        int maxProfit = 0;
        while (!queue.isEmpty()) {
            u = queue.poll();
            if (u.level == -1) {
                v.level = 0;
            }
            if (u.level == n - 1) {
                continue;
            }
            v.level = u.level + 1;
            v.weight = u.weight + items[v.level].weight;
            v.profit = u.profit + items[v.level].value;
            if (v.weight <= maxWeight && v.profit > maxProfit) {
                maxProfit = v.profit;
            }
            v.bound = bound(v, items, n, maxWeight);
            if (v.bound > maxProfit) {
                queue.add(v);
            }
            v.weight = u.weight;
            v.profit = u.profit;
            v.bound = bound(v, items, n, maxWeight);
            if (v.bound > maxProfit) {
                queue.add(v);
            }
        }
        System.out.println("Maximum profit is " + maxProfit + ".");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int n = sc.nextInt();
        System.out.print("Enter the capacity of knapsack: ");
        int capacity = sc.nextInt();

        Item[] items = new Item[n];
        System.out.print("Enter the weight and value of items: ");
        for (int i = 0; i < n; i++) {
            int weight = sc.nextInt();
            int value = sc.nextInt();
            items[i] = new Item(weight, value);
        }

        knapsackUsingBranchBound(items, n, capacity);
        sc.close();
    }
}