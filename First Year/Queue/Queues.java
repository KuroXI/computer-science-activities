package Queue;

import java.util.Scanner;

public class Queues {
    private final int[] queue;
    private int front;
    private int rear;
    private final int maxSize;
    private int size;

    public Queues(int size) {
        this.queue = new int[size];
        this.front = -1;
        this.rear = -1;
        this.maxSize = size;
        this.size = 0;
    }

    public void enqueue(int number) {
        if (isFull()) {
            System.out.println("Queue Overflow! Cannot enqueue: " + number);
            return;
        }

        if (this.front == -1) this.front++;
        this.rear++;
        this.queue[this.size++] = number;

        displayQueue();
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Cannot dequeue");
            return;
        }

        this.front++;
        this.size--;
        displayQueue();

        if (this.front > this.rear) {
            this.front = -1; this.rear = -1; this.size = 0;
        }
    }

    public void displayQueue() {
        StringBuilder strings = new StringBuilder();
        for (int i = 0; i < this.size; i++)
            strings.append(queue[this.front + i]).append(" ");

        System.out.println("Queue: " + strings);
        System.out.println("Front: " + this.front);
        System.out.println("Rear: " + this.rear);
    }

    public boolean isFull() { return this.size == maxSize; }
    public boolean isEmpty() { return this.size == 0; }

    public static void main(String[] args) {
        boolean isStop = false;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the Queue: ");

        int size = scanner.nextInt();
        Queues queues = new Queues(size);

        while(!isStop) {
            System.out.println("\n1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display Queue");
            System.out.println("4. Exit\n");

            System.out.print("Enter Choice [1..4]: ");
            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    System.out.print("Enter a number: ");
                    queues.enqueue(scanner.nextInt());
                    break;
                case 2:
                    queues.dequeue();
                    break;
                case 3:
                    queues.displayQueue();
                    break;
                case 4:
                    System.out.println("Gonzales, John Victor");
                    isStop = true;
                    break;
                default:
                    System.out.println("Invalid Input!");
                    break;
            }
        }
    }
}