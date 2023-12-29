/*

Problem Statement

Write a program to create a doubly linked list of n nodes and perform:
• Insertion
    o At the beginning
    o At the end
    o At a specific location
• Deletion
    o At the beginning
    o At the end 
    o At a specific location

 */

/**
 * problem_statement_experiment_4
 */
public class problem_statement_experiment_5 {
    static Node head;

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static void printLinkedList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }

    public static void insertNodeAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        newNode.prev = null;
        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
    }

    public static void insertNodeAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        newNode.prev = currentNode;
    }

    public static void insertNodeAtSpecificLocation(int data, int location) {
        Node newNode = new Node(data);
        Node currentNode = head;
        int count = 1;
        while (currentNode != null) {
            if (count == location) {
                newNode.next = currentNode.next;
                currentNode.next = newNode;
                newNode.prev = currentNode;
                if (newNode.next != null) {
                    newNode.next.prev = newNode;
                }
                break;
            }
            currentNode = currentNode.next;
            count++;
        }
    }

    public static void deleteNodeAtBeginning() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public static void deleteNodeAtEnd() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.prev.next = null;
        }
    }

    public static void deleteNodeAtSpecificLocation(int location) {
        Node currentNode = head;
        int count = 1;
        while (currentNode != null) {
            if (count == location) {
                currentNode.prev.next = currentNode.next;
                currentNode.next.prev = currentNode.prev;
                break;
            }
            currentNode = currentNode.next;
            count++;
        }
    }

    public static void main(String[] args) {

        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head = first;
        first.next = second;
        second.next = third;
        second.prev = first;
        third.next = fourth;
        third.prev = second;
        fourth.next = fifth;
        fourth.prev = third;
        fifth.prev = fourth;

        System.out.println("Linked List before insertion:");
        printLinkedList();
        System.out.println();

        System.out.println("Linked List after insertion at beginning:");
        insertNodeAtBeginning(0);
        printLinkedList();
        System.out.println();

        System.out.println("Linked List after insertion at end:");
        insertNodeAtEnd(6);
        printLinkedList();
        System.out.println();

        System.out.println("Linked List after insertion at specific location:");
        insertNodeAtSpecificLocation(7, 3);
        printLinkedList();
        System.out.println();

        System.out.println("Linked List after deletion at beginning:");
        deleteNodeAtBeginning();
        printLinkedList();
        System.out.println();

        System.out.println("Linked List after deletion at end:");
        deleteNodeAtEnd();
        printLinkedList();
        System.out.println();

        System.out.println("Linked List after deletion at specific location:");
        deleteNodeAtSpecificLocation(3);
        printLinkedList();
        System.out.println();

    }
}