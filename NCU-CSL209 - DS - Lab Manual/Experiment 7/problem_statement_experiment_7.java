/*
Problem Statement

Write a program to create a stack and perform:
• POP
• PUSH
• PEEK
• ISEMPTY
• ISFULL

1) Use Arrays for Implementation
2) Use Linked List for Implementation

*/

// Implementing Stack Using Arrays
class stackArray {
    public int stackSize = 5;

    int[] stack = new int[stackSize];
    int top = -1;

    // Method POP()
    // Method to delete top most element of the stack.
    public int POP() {
        if (top < 0) {
            System.out.println("Stack Underflow!");
            return 0;
        }

        else {
            top = stack[top--];
            return top;
        }
    }

    // Method PUSH()
    // Method to push element into stack.
    public void PUSH(int data) {
        if (top >= stackSize - 1) {
            System.out.println("Stack OverFlow!");
        }

        else {
            stack[++top] = data;
            System.out.println(data + " pushed into stack.");
        }
    }

    // Method PEEK()
    // Method to get the top most elemnt of the stack.
    public int PEEK() {
        if (top < 0) {
            System.out.println("Stack Underflow!");
            return -1;
        }

        else {
            return top;
        }
    }

    // Method ISEMPTY()
    // Method to check if the stack is empty or not.
    public boolean ISEMPTY() {
        if (top < 0) {
            return true;
        }

        else {
            return false;
        }
    }

    // Method ISFULL()
    // Method to check if the stack is full or not.
    public boolean ISFULL() {
        if (top == stackSize) {
            return true;
        } else {
            return false;
        }
    }
}

// Implementing Stack Using Linked List
class stackLinkedList {

    stackNode top;

    class stackNode {
        int data;
        stackNode next;

        stackNode(int data) {
            this.data = data;
        }
    }

    // Method PUSH()
    // Method to push element into stack.
    public void PUSH(int data) {

        stackNode newNode = new stackNode(data);
        if (top == null) {
            top = newNode;
        }

        else {
            newNode.next = top;
            top = newNode;
            System.out.println(newNode.data + " pushed into stack.");
        }
    }

    // Method POP()
    // Method to delete top most element of the stack.
    public int POP() {

        int popValue = -1;
        if (top == null) {
            System.out.println("Stack is Empty!");
        }

        else {
            popValue = top.data;
            top = top.next;
        }
        return popValue;

    }

    // Method PEEK()
    // Method to get the top most elemnt of the stack.
    public int PEEK() {
        if (top == null) {
            System.out.println("Stack is Empty!");
            return -1;
        }

        else {
            return top.data;
        }
    }

    // Method ISEMPTY()
    // Method to check if the stack is empty or not.
    public boolean ISEMPTY() {
        if (top == null) {
            return true;
        }

        else {
            return false;
        }

    }
}

/**
 * problem_statement_experiment_7
 */
public class problem_statement_experiment_7 {
    public static void main(String[] args) {

        // Using Array Implementation of Stack
        stackArray stackA = new stackArray();

        System.out.println("""
                ===============================
                Array Implementation of Stack
                ===============================
                """);

        stackA.PUSH(1);
        stackA.PUSH(2);
        stackA.PUSH(3);
        stackA.PUSH(4);
        stackA.PUSH(5);
        System.out.println("Top --> " + stackA.PEEK());
        System.out.println("Popped --> " + stackA.POP());
        System.out.println("Stack is Empty: " + stackA.ISEMPTY());
        System.out.println("Stack is Full: " + stackA.ISFULL());

        System.out.println("\n");

        // Using Linked List Implementation of Stack
        stackLinkedList stackLL = new stackLinkedList();

        System.out.println("""
                ===================================
                Linked List Implementation of Stack
                ===================================
                """);

        stackLL.PUSH(1);
        stackLL.PUSH(2);
        stackLL.PUSH(3);
        stackLL.PUSH(4);
        stackLL.PUSH(5);
        System.out.println("Top --> " + stackLL.PEEK());
        System.out.println("Popped --> " + stackLL.POP());
        System.out.println("Stack is Empty: " + stackLL.ISEMPTY());
    }
}