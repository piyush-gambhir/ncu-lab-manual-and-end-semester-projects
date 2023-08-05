/*

Write a program to implement Following operations using Circular Queue: 
1. Enqueue() 
2. Dequeue() 

Using array implementation

*/

class circularQueueArray {

    int front, rear, size;
    int capacity;
    int array[];

    public circularQueueArray(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }

    boolean isFull(circularQueueArray queue) {
        return (queue.size == queue.capacity);
    }

    boolean isEmpty(circularQueueArray queue) {
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

/**
 * problem_statement_experiment_13
 */
public class problem_statement_experiment_13 {

    public static void main(String[] args) {
        circularQueueArray queue = new circularQueueArray(1000);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println();
        System.out.println(queue.dequeue() + " dequeued from queue");

    }
}