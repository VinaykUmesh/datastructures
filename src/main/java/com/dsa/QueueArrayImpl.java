package com.dsa;

public class QueueArrayImpl {

    public static void main(String[] args) {
        QueueArray<Integer> q = new QueueArray<>();
        q.enqueue(3);
        q.enqueue(5);
        q.enqueue(8);
        q.enqueue(10);

        System.out.println("Dequeue " + q.dequeue());
        System.out.println("Dequeue " + q.dequeue());
        System.out.println("Dequeue " + q.dequeue());
        System.out.println("Dequeue " + q.dequeue());

        q.enqueue(8);
        q.enqueue(10);

        System.out.println("Dequeue " + q.dequeue());
        System.out.println("Dequeue " + q.dequeue());

        System.out.println("\n Queue Array Impl 2 \n");

        QueueArray2<String> q2 = new QueueArray2<>();
        q2.enqueue("three");
        q2.enqueue("two");
        q2.enqueue("eight");
        q2.enqueue("ten");

        System.out.println("Dequeue " + q2.dequeue());
        System.out.println("Dequeue " + q2.dequeue());
        System.out.println("Dequeue " + q2.dequeue());
        System.out.println("Dequeue " + q2.dequeue());

        q2.enqueue("eight");
        q2.enqueue("ten");

        System.out.println("Dequeue " + q2.dequeue());
        System.out.println("Dequeue " + q2.dequeue());
    }

}

class QueueArray<T> {
    static final int MAX_SIZE = 16;
    T[] queue;
    int front, rear;

    @SuppressWarnings("unchecked")
    QueueArray() {
        queue = (T[]) new Object[MAX_SIZE];
        front = -1;
        rear = -1;
    }

    public void enqueue(T value) {
        if (front == MAX_SIZE - 1)
            throw new IndexOutOfBoundsException("Queue is full");
        if (front == -1)
            front++;
        queue[++rear] = value;
    }

    public T dequeue() {
        if (front == -1 || front > rear)
            throw new IndexOutOfBoundsException("Queue is empty");
        return queue[front++];
    }
}

class QueueArray2<T> {
    static final int MAX_SIZE = 16;
    T[] queue;
    int rear;

    @SuppressWarnings("unchecked")
    QueueArray2() {
        queue = (T[]) new Object[MAX_SIZE];
        rear = -1;
    }

    public void enqueue(T value) {
        if (rear == MAX_SIZE - 1)
            throw new IndexOutOfBoundsException("Queue is full");
        queue[++rear] = value;
    }

    public T dequeue() {
        if (rear == -1)
            throw new IndexOutOfBoundsException("Queue is empty");
        T temp = queue[0];
        for (int i = 1; i <= rear; i++)
            queue[i - 1] = queue[i];
        rear--;
        return temp;
    }
}
