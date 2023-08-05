/*

Problem Statement

Write a program to implement Following operations using Queue: 
1.Enqueue() 
2.Dequeue() 
3.Isfull()
4.Isempty()
5.Peek()

a) Using array implementation 
b) Using Linked List Implementation

*/

class queueArray {

    int front, rear, size;
    int capacity;
    int array[];

    public queueArray(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }

    boolean isFull(queueArray queue) {
        return (queue.size == queue.capacity);
    }

    boolean isEmpty(queueArray queue) {
        return (queue.size == 0);
    }

    void enqueue(int item) {
        if (isFull(this))
            return;
        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size = this.size + 1;
        System.out.println(item + " enqueued to queue");
    }

    int dequeue() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;
        int item = this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size = this.size - 1;
        return item;
    }

    int front() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;
        return this.array[this.front];
    }

    int rear() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;
        return this.array[this.rear];
    }

}

class queueLinkedList {
    class Node {
        int key;
        Node next;

        public Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    Node front, rear;

    public queueLinkedList() {
        this.front = this.rear = null;
    }

    void isEmpty() {
        if (this.front == null)
            System.out.println("Queue is empty");
    }

    void enqueue(int key) {
        Node temp = new Node(key);
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }
        this.rear.next = temp;
        this.rear = temp;
        System.out.println(key + " enqueued to queue");
    }

    void dequeue() {
        if (this.front == null)
            return;
        Node temp = this.front;
        this.front = this.front.next;
        if (this.front == null)
            this.rear = null;
        System.out.println(temp.key + " dequeued from queue");
    }
}

/**
 * problem_statement_experiment_12
 */
public class problem_statement_experiment_12 {

    public static void main(String[] args) {
        System.out.println("Using Array Iimplementation\n");

        queueArray queue = new queueArray(1000);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        System.out.println(queue.dequeue() + " dequeued from queue");
        System.out.println();
        System.out.println("Front item is " + queue.front());
        System.out.println("Rear item is " + queue.rear());

        System.out.println("\n");

        System.out.println("Using Linked List Implementation\n");

        queueLinkedList queue1 = new queueLinkedList();

        queue1.enqueue(10);
        queue1.enqueue(20);
        queue1.dequeue();
        queue1.dequeue();
        queue1.enqueue(30);
        queue1.enqueue(40);
        queue1.enqueue(50);
        queue1.dequeue();
        System.out.println();
        System.out.println("Queue Front : " + queue1.front.key);
        System.out.println("Queue Rear : " + queue1.rear.key);

    }
}