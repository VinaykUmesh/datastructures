package com.dsa;

public class CircularLinkedListImpl {

    public static void main(String[] args) {
        CircularLinkedList<String> list = new CircularLinkedList<>();
        list.insertAtBeg("adam");
        list.insertAtBeg("abby");
        list.insertAtBeg("gabe");
        list.insertAtBeg("ravi");
        list.insertAtBeg("ram");
        list.display();
        list.insertAtEnd("jade");
        list.display();
        list.deleteAtBeg();
        list.display();
        list.deleteAtEnd();
        list.display();
        list.deleteValue("gabe");
        list.display();
        list.insertAfter("abby", "raja");
        list.display();
    }

}

class CircularLinkedList<T> {
    Node last;

    class Node {
        T data;
        Node next;

        Node(T value) {
            data = value;
            next = null;
        }
    }

    CircularLinkedList() {
        last = null;
    }

    public void insertAtBeg(T value) {
        Node node = new Node(value);
        if (last == null) {
            node.next = node;
            last = node;
        } else {
            // [gabe] abby adam
            node.next = last.next;
            last.next = node;

        }
    }

    public void insertAtEnd(T value) {
        Node node = new Node(value);
        if (last == null) {
            node.next = node;
        } else {
            // gabe abby adam [jade]
            node.next = last.next;
            last.next = node;

        }
        last = node;
    }

    public void display() {
        if (last == null) {
            return;
        }

        Node temp = last.next;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != last.next);

        System.out.println(" ");
    }

    public void deleteAtBeg() {
        if (last == null) {
            throw new IndexOutOfBoundsException("Deletion attempted on empty list ");
        }

        if (last == last.next) {
            System.out.println("Deleting :" + last.data);
            last = null;
        } else {
            // [gabe] abby adam jade
            last.next = last.next.next;
        }
    }

    public void deleteAtEnd() {
        if (last == null) {
            throw new IndexOutOfBoundsException("Deletion attempted on empty list ");
        }

        if (last == last.next) {
            System.out.println("Deleting :" + last.data);
            last = null;
        } else {
            // abby adam [jade]
            Node temp = last.next;
            while (temp.next != last) {
                temp = temp.next;
            }
            temp.next = last.next;
            last = temp;
        }
    }

    public void deleteValue(T value) {
        if (last == null) {
            throw new IndexOutOfBoundsException("Deletion attempted on empty list ");
        }

        if (last == last.next) {
            if (last.data.equals(value)) {
                last = null;
            }
        } else {
            Node temp = last.next;
            do {
                if (temp.next.data == value) {
                    temp.next = temp.next.next;
                    break;
                }
                temp = temp.next;
            } while (temp != last.next);
        }
    }

    public void insertAfter(T insert, T value) {
        Node node = new Node(value);
        if (last == null) {
            throw new IndexOutOfBoundsException("Insertion attempted on empty list ");
        }

        if (last == last.next) {
            if (last.data.equals(insert)) {
                node.next = last.next;
                last.next = node;
                last = node;
            }
        } else {
            Node temp = last.next;
            do {
                if (temp.data.equals(insert)) {
                    if (temp == last) {
                        insertAtEnd(value);
                        return;
                    } else {
                        node.next = temp.next;
                        temp.next = node;
                        return;
                    }
                }
                temp = temp.next;
            } while (temp != last.next);
            System.out.println(insert + " not found");
        }
    }

}
