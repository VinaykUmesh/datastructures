package com.dsa;


public class StackUsingLinkedListImpl {

    public static void main(String[] args) {
        StackLinkedList<String> s = new StackLinkedList<>();
        s.push("ram");
        s.push("raja");
        s.push("ravi");

        System.out.println("Popped: " + s.pop());
        System.out.println(s.peek());
        System.out.println(s.isEmpty());
    }

}

class StackLinkedList<T> {

    class Node {
        T data;
        Node next;

        Node(T value) {
            data = value;
            next = null;
        }
    }

    Node top;

    StackLinkedList() {
        top = null;
    }

    public void push(T value) {
        Node node = new Node(value);
        node.next = top;
        top = node;
    }

    public T pop() {
        if (top == null)
            throw new IndexOutOfBoundsException("Stack is Empty");

        T temp = top.data;
        top = top.next;
        return temp;
    }

    public T peek() {
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
