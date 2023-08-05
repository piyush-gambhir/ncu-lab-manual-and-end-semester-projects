/*

Problem Statement:
Write a program to create a Circular linked list of n nodes and perform:
•	Insertion
    o	At the beginning
    o	At the end
    o	At a specific location

•	Deletion
    o	At the beginning
    o	At the end 
    o	At a specific location

 */


/**
 * problem_statement_experiment_6
 */
public class problem_statement_experiment_6 {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void printList() {
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
        }
        System.out.println();
    }

    public static void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public static void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    public static void insertAtSpecificLocation(int data, int location) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            int count = 1;
            while (count < location - 1) {
                temp = temp.next;
                count++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public static void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head.next;
            head = head.next;
        }
    }

    public static void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
            while (temp.next.next != head) {
                temp = temp.next;
            }
            temp.next = head;
        }
    }

    public static void deleteAtSpecificLocation(int location) {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
            int count = 1;
            while (count < location - 1) {
                temp = temp.next;
                count++;
            }
            temp.next = temp.next.next;
        }
    }

    public static void main(String[] args) {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        head = first;
        first.next = second;
        second.next = third;

        third.next = fourth;
        fourth.next = head;

        System.out.println("Circular Linked List before insertion");
        printList();

        insertAtBeginning(0);
        System.out.println("Circular Linked List after insertion at beginning");
        printList();

        insertAtEnd(5);
        System.out.println("Circular Linked List after insertion at end");
        printList();

        insertAtSpecificLocation(6, 3);
        System.out.println("Circular Linked List after insertion at specific location");
        printList();

        deleteAtBeginning();
        System.out.println("Circular Linked List after deletion at beginning");
        printList();

        deleteAtEnd();
        System.out.println("Circular Linked List after deletion at end");
        printList();

        deleteAtSpecificLocation(3);
        System.out.println("Circular Linked List after deletion at specific location");
        printList();
    }
}