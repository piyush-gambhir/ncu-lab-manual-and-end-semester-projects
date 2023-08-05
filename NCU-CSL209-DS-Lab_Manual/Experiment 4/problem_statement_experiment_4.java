/*

Problem Statement

Write a program to create a singly linked list of n nodes and perform:
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
public class problem_statement_experiment_4 {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
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
    }

    public static void insertNode(int data, int position) {
        Node newNode = new Node(data);
        Node currentNode = head;
        int size = 0;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            size++;
        }
        if (position > size) {
            System.out.println("Invalid position");
        } else {
            currentNode = head;
            while (position > 1) {
                currentNode = currentNode.next;
                position--;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
    }

    public static void deleteNodeAtBeginning() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            head = head.next;
        }

    }

    public static void deleteNodeAtEnd() {
        if (head == null) {
            System.out.println("List is Empty.");
        } else {
            Node currentNode = head;
            while (currentNode.next.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = null;
        }
    }

    public static void deleteNode(int position) {
        if (head == null) {
            System.out.println("List is Empty.");
        } else {
            Node currentNode = head;
            int size = 0;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
                size++;
            }
            if (position > size) {
                System.out.println("Invalid position");
            } else {
                currentNode = head;
                while (position > 1) {
                    currentNode = currentNode.next;
                    position--;
                }
                currentNode.next = currentNode.next.next;
            }
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
        third.next = fourth;
        fourth.next = fifth;

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
        insertNode(7, 3);
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
        deleteNode(2);
        printLinkedList();
        System.out.println();

    }
}
