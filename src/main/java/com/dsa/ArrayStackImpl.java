package com.dsa;


import java.util.Arrays;

public class ArrayStackImpl {

    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        s.push("ram");
        s.push("raja");
        s.push("ravi");

        System.out.println(Arrays.toString(s.stack));
        System.out.println("Popped: " + s.pop());
        System.out.println(s.peek());
        System.out.println(s.isEmpty());

    }
}

class Stack<T> {

    static final int MAX_SIZE = 30;

    T[] stack;
    int top;

    @SuppressWarnings("unchecked")
    Stack() {
        stack = (T[]) new Object[MAX_SIZE];
        top = -1;
    }

    public void push(T value) {
        if (top == MAX_SIZE - 1)
            throw new IndexOutOfBoundsException("Stack Overflow");
        stack[++top] = value;
    }

    public T pop() {
        if (top == -1)
            throw new IndexOutOfBoundsException("Stack Underflow");
        return stack[top--];
    }

    public T peek() {
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
