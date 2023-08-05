/*

Problem Statement

Write a program to implement Following operations using Doubly ended Queue: 
1. Enqueue() 
2. Dequeue() 
3. Isfull()
4. Isempty()
5. Peek()

Using array implementation

*/

class doublyEndedQueueArray {

    int front, rear, size;
    int capacity;
    int array[];

    public doublyEndedQueueArray(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }

    boolean isFull(doublyEndedQueueArray queue) {
        return (queue.size == queue.capacity);
    }

    boolean isEmpty(doublyEndedQueueArray queue) {
        return (queue.size == 0);
    }

    void enqueueFront(int item) {
        if (isFull(this))
            return;
        this.front = (this.front - 1 + this.capacity) % this.capacity;
        this.array[this.front] = item;
        this.size = this.size + 1;
        System.out.println(item + " enqueued to front");
    }

    void enqueueRear(int item) {
        if (isFull(this))
            return;
        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size = this.size + 1;
        System.out.println(item + " enqueued to rear");
    }

    int dequeueFront() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;
        int item = this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size = this.size - 1;
        return item;
    }

    int dequeueRear() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;
        int item = this.array[this.rear];
        this.rear = (this.rear - 1 + this.capacity) % this.capacity;
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
 * problem_statement_experiment_14
 */
public class problem_statement_experiment_14 {

    public static void main(String[] args) {
        doublyEndedQueueArray queue = new doublyEndedQueueArray(1000);

        queue.enqueueFront(10);
        queue.enqueueRear(20);
        queue.enqueueFront(30);
        queue.enqueueRear(40);

        System.out.println();
        System.out.println(queue.dequeueFront() + " dequeued from front");
        System.out.println(queue.dequeueRear() + " dequeued from rear");

        System.out.println();
        System.out.println("Front item is " + queue.front());
        System.out.println("Rear item is " + queue.rear());

        System.out.println();
        System.out.println("Is queue full: " + queue.isFull(queue));
        System.out.println("Is queue empty: " + queue.isEmpty(queue));

    }
}