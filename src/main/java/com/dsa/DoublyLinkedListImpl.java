package com.dsa;

import java.util.Iterator;
import java.util.function.Consumer;

public class DoublyLinkedListImpl {

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.insertAtBeg(3);
        list.insertAtBeg(4);
        list.insertAtBeg(9);
        list.insertAtBeg(88);
        list.insertAtBeg(102);

        list.display();
        System.out.println(" ");
        list.displayRev();

        System.out.println(" ");
        list.insertAtPos(3, 54);
        list.display();

        System.out.println(" ");
        list.deleteAtPos(3);
        list.display();


        System.out.println(" ");
        list.insertAtEnd(89);
        list.display();

        System.out.println(" ");
        list.deleteAtEnd();
        list.display();

        System.out.println(" ");
        list.deleteAtBeginning();
        list.display();

        System.out.println(" ");
        list.search(3);

        System.out.println("\n" + list.contains(3));
        System.out.println(list.length());

        list.forEach(d -> System.out.print(d + " "));
        System.out.println(" ");
        list.forEachReverse(d -> System.out.print(d + " "));
    }
}

class DoublyLinkedList<T> implements Iterable<T> {
    Node head;
    Node tail;

    class Node {
        T data;
        Node next;
        Node prev;

        Node(T val) {
            data = (T) val;
            next = null;
            prev = null;
        }
    }


    public void insertAtBeg(T value) {
        Node node = new Node(value);
        node.next = head;
        if (head == null) {
            tail = node;
            head = node;
        } else {
            head.prev = node;
            head = node;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }


    public void displayRev() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
    }

    public void insertAtPos(int pos, T value) {
        if (pos == 0) {
            insertAtBeg(value);
            return;
        }
        Node node = new Node(value);
        Node temp = head;
        // 102 88 9 [54] 4 3
        for (int i = 1; i < pos; i++) {
            temp = temp.next;
            if (temp == null) {
                throw new IndexOutOfBoundsException("Invalid Position " + pos);
            }
        }

        // temp = 9
        // temp.next = 4
        node.next = temp.next;
        node.prev = temp;
        if (temp == tail) {
            tail = node;
        } else {
            temp.next.prev = node;
        }
        temp.next = node;

    }

    public void deleteAtPos(int pos) {
        if (pos == 0) {

        }

        Node temp = head;
        Node prev = null;
        // 102 88 9 [54] 4 3
        for (int i = 1; i <= pos; i++) {
            prev = temp;
            temp = temp.next;
            if (temp == null) {
                throw new IndexOutOfBoundsException("Invalid Position " + pos);
            }
        }

        // temp = 4
        // temp.next = 3
        // prev = 9
        prev.next = temp.next;
        if (temp.next == null) {
            tail = prev;
        } else {
            temp.next.prev = prev;
        }


    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node temp = head;

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
                T data = temp.data;
                temp = temp.next;
                return data;
            }
        };
    }

    public void forEachReverse(Consumer<? super T> action) {
        Iterator<T> it = reverseIterator();
        while (it.hasNext()) {
            action.accept(it.next());
        }
    }

    public Iterator<T> reverseIterator() {
        return new Iterator<T>() {
            Node temp = tail;

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
                T data = temp.data;
                temp = temp.prev;
                return data;
            }
        };
    }


    public void insertAtEnd(T value) {
        Node node = new Node(value);
        // 102 88 9 4 3 [89]
        if (head == null) {
            insertAtBeg(node.data);
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

    }

    public void deleteAtEnd() {
        // 102 88 9 4 3 [89]
        if (head.next == null && tail.prev == null) {
            head = null;
            tail = null;
            return;
        }
        assert tail != null;
        tail.prev.next = null;
        tail = tail.prev;
    }

    public void deleteAtBeginning() {
        // [102] 88 9 4 3
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
        head.prev = null;
    }

    public void search(T value) {
        Node temp = head;
        int index = -1;
        for (int i = 0; temp != null; i++) {
            if (temp.data == value) {
                index = i;
                break;
            }
            temp = temp.next;
        }

        if (index == -1) {
            System.out.print("Search not found");
        } else {
            System.out.print("Search Found at index: " + index);
        }
    }

    public boolean contains(T value) {
        Node temp = head;
        boolean contains = false;
        while (temp != null) {
            if (temp.data == value) {
                contains = true;
                break;
            }
            temp = temp.next;
        }
        return contains;
    }

    public int length() {
        Node temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }


    /*
     * loop - o(n)
     * no loop - o(1)
     *
     */
}
