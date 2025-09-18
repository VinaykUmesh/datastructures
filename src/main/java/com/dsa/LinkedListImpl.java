package com.dsa;

/**
 * Singly Linked List Implementation.
 */
public class LinkedListImpl {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtBegin(5);
        list.insertAtBegin(9);
        list.insertAtBegin(12);
        list.insertAtBegin(17);
        list.insertAtBegin(25);


        list.display();
        System.out.println("\nInserted at Position");
        list.insertAtPos(3, 10);


        list.display();

        System.out.println("\nget by position");
        list.getPos(3);

        list.deleteAtPos(3);
        System.out.println("deleted by position");
        list.display();

        System.out.println("\nupdate by position");
        list.update(3, 26);
        list.display();

        System.out.println("\ninsert at end");
        list.insertAtEnd(30);
        list.display();

        System.out.println("\ndeleted at end");
        list.deleteAtEnd();
        list.display();

        System.out.println("\nSearch by value");
        list.search(17);

        System.out.println("\nContains: " + list.contains(2573636));

        System.out.println("Length: " + list.length());
    }
}

class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        public Node(int value) {
            data = value;
            next = null;
        }
    }

    LinkedList() {
        head = null;
    }

    public void insertAtBegin(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
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

    public void insertAtPos(int position, int value) {
        Node node = new Node(value);

        if (position == 0) {
            head = node;
            return;
        }

        Node temp = head;
        // 25 17 12 [10] 9 5
        for (int i = 1; i < position; i++) {
            temp = temp.next;
            if (temp == null) {
                throw new IndexOutOfBoundsException("Invalid Position " + position);
            }
        }
        node.next = temp.next;
        temp.next = node;
    }

    public void deleteAtPos(int position) {
        if (head == null) {
            throw new IndexOutOfBoundsException("Invalid Position " + position);
        }

        if (position == 0) {
            head = head.next;
            return;
        }

        Node temp = head;
        Node previous = null;
        // 25 17 12 [10] 9 5
        for (int i = 1; i <= position; i++) {
            previous = temp;
            temp = temp.next;
        }
        assert previous != null;
        previous.next = temp.next;
    }

    public void getPos(int position) {
        Node temp = head;
        if (position == 0) {
            System.out.println(head.data);
            return;
        }
        for (int i = 1; i <= position; i++) {
            temp = temp.next;
            if (i == position) {
                System.out.println(temp.data);
            }
            if (temp == null) {
                throw new IndexOutOfBoundsException("Invalid Position " + position);
            }
        }
    }

    public void update(int position, int value) {
        Node node = new Node(value);
        Node temp = head;
        if (position == 0) {
            head.data = node.data;
            return;
        }
        for (int i = 0; i < position; i++) {
            temp = temp.next;
            if (temp == null) {
                throw new IndexOutOfBoundsException("Invalid Position " + position);
            }
        }
        node.next = temp.next;
        temp.data = node.data;

    }

    public void deleteAtEnd() {
        Node temp = head;

        if (head == null) return;

        if (head.next.next == null) {
            head = null;
            return;
        }

        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public void insertAtEnd(int value) {
        Node node = new Node(value);

        if (head == null) {
            head = node;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void search(int value) {
        Node temp = head;
        if (head.data == value) {
            System.out.print("Search Found at index: 0");
            return;
        }
        int index = -1;
        for (int i= 1; temp != null; i++) {
            temp = temp.next;
            if (temp != null && temp.data == value) {
                index = i;
                break;
            }
        }
        System.out.print("Search Found at index: " + index);
    }

    public boolean contains(int value) {
        Node temp = head;
        boolean index = false;
        if (head.data == value) {
            index = true;
            return index;
        }

        while (temp != null) {
            temp = temp.next;
            if (temp != null && temp.data == value) {
                index = true;
                break;
            }
        }
        return index;
    }

    public int length() {
        int length = 0;
        if (head == null) {
            return length;
        }
        if (head.next == null) {
            length = 1;
            return length;
        }
        Node temp = head;
        for (int i = 1; temp != null; i++) {
            temp = temp.next;
            length = i;
        }
        return length;
    }

}