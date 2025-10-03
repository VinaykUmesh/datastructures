package com.dsa;

public class QueueLinkedListImpl {

    public static void main(String[] args) {
        QueueLL<String> q = new QueueLL<>();
        q.enqueue("five");
        q.enqueue("seven");
        q.enqueue("ten");
        q.enqueue("twenty");

        System.out.println("Dequeue " + q.dequeue());
        System.out.println("Dequeue " + q.dequeue());
        System.out.println("Dequeue " + q.dequeue());
        System.out.println("Dequeue " + q.dequeue());

        q.enqueue("eight");
        q.enqueue("ten");

        System.out.println("Dequeue " + q.dequeue());
        System.out.println("Dequeue " + q.dequeue());

        q.enqueue("eight");
        q.enqueue("ten");

        System.out.println("Is Empty: " + q.isEmpty());
        System.out.println("1st Element: " + q.elementAtFront());
    }

}

class QueueLL<T> {

    class Node {
        T data;
        Node next;

        Node(T value) {
            data = value;
            next = null;
        }
    }

    Node front, rear;

    QueueLL() {
        front = null;
        rear = null;
    }

    public void enqueue(T value) {
        Node newNode = new Node(value);
        if (front == null)
            front = newNode;
        else
            rear.next = newNode;
        rear = newNode;
    }

    public T dequeue() {
        if (rear == null)
            throw new IndexOutOfBoundsException("Queue is Empty");
        T data = front.data;
        front = front.next;
        if (front == null)
            rear = null;
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public T elementAtFront() {
        if (front == null)
            throw new IndexOutOfBoundsException("Queue is Empty");
        return front.data;
    }
}
