package com.dsa;

import java.util.Arrays;
import java.util.Scanner;


/**
 * List Implementation by Array.
 */
public class DynamicArrayListImpl {

    public static void main(String[] args) {
        int value, position;
        Scanner scanner = new Scanner(System.in);
        DynamicArray dynamicArray = new DynamicArray();
        while(true) {
            System.out.println("\n -------------- List Menu -------------- \n");
            System.out.println("1.  Insert element at the end");
            System.out.println("2.  Display the list");
            System.out.println("3.  Insert at specified position");
            System.out.println("4.  Delete at specified position");
            System.out.println("5.  Delete at end");
            System.out.println("6.  Delete at beginning");
            System.out.println("7.  Insert at beginning");
            System.out.println("8.  Get element by index");
            System.out.println("9.  Update element by index");
            System.out.println("10. Search element");
            System.out.println("11. Contains");
            System.out.println("12. Clear Array");
            System.out.println("13. Exit");
            System.out.println("\n --------------------------------------- \n");
            System.out.println("Enter your choice: \t");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the element: ");
                    value = scanner.nextInt();
                    dynamicArray.add(value);
                    break;
                case 2:
                    dynamicArray.display();
                    break;
                case 3:
                    System.out.println("Enter the position(default: 0): ");
                    position = scanner.nextInt();
                    System.out.println("Enter the value: ");
                    value = scanner.nextInt();
                    dynamicArray.insertAtPosition(value, position);
                    break;
                case 4:
                    System.out.println("Delete the position(default: 0): ");
                    position = scanner.nextInt();
                    dynamicArray.delete(position);
                    break;
                // exercise
                case 5:
                    System.out.println("Deleted at end");
                    dynamicArray.delete(-1);
                    break;
                case 6:
                    System.out.println("Deleted at beginning");
                    dynamicArray.delete(0);
                    break;
                case 7:
                    System.out.println("Enter the value: ");
                    value = scanner.nextInt();
                    dynamicArray.insertAtPosition(value, 0);
                    break;
                case 8:
                    System.out.println("Enter index value: ");
                    value = scanner.nextInt();
                    dynamicArray.get(value);
                    break;
                case 9:
                    System.out.println("Enter the index: ");
                    position = scanner.nextInt();
                    System.out.println("Enter the value: ");
                    value = scanner.nextInt();
                    dynamicArray.update(value, position);
                    break;
                case 10:
                    System.out.println("Enter search value: ");
                    value = scanner.nextInt();
                    System.out.println(dynamicArray.search(value));
                    break;
                case 11:
                    System.out.println("Enter the value: ");
                    value = scanner.nextInt();
                    System.out.println(dynamicArray.contains(value));
                    break;
                case 12:
                    System.out.println("Clearing Array");
                    dynamicArray.clear();
                    break;
                case 13:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }

}

class DynamicArray {
    public static final int initialCapacity = 16;
    private int[] arr;
    private int size;
    private int capacity;

    public DynamicArray() {
        size = 0;
        arr = new int[initialCapacity];
        capacity = initialCapacity;
    }


    public void add(int value) {
        if(size == capacity) expandArray();
        arr[size++] = value;
        display();
    }

    private void expandArray() {
        capacity *= 2;
        arr = Arrays.copyOf(arr, capacity);
    }

    public void display() {
        System.out.println("Elements in list");
        for (int i = 0; i < size; i++) System.out.print(arr[i] + " ");
    }

    public void insertAtPosition(int value, int position) {
        // 3 4 5 678 5
        // 0 1 2 3   4
        if (size == capacity) expandArray();
        for (int i = size - 1; i >= position; i--) arr[i - 1] = arr[i];
        arr[position] = value;
        size++;
        display();
    }


    public void delete(int position) {
        // 3 4 5 678 5
        // 0 1 2 3   4
        if (position == -1) position = size - 1;
        for (int i = position + 1; i < size; i++) arr[i - 1] = arr[i];
        size--;
        if (capacity > initialCapacity && capacity > 3 * size) shrinkArray();
        display();
    }

    private void shrinkArray() {
        capacity /= 2;
        arr = Arrays.copyOf(arr, capacity);
    }

    public void get(int index) {
        if (index < size) {
            System.out.println(arr[index]);
        } else {
            System.out.println("Enter below " + size);
        }
    }

    public void update(int value, int position) {
        if (position < size) {
            arr[position] = value;
        } else {
            System.out.println("Enter below " + size);
        }
        display();
    }

    public String search(int value) {
        String message = "Element not found";
        for (int i = 0; i < size; i++)
            if (arr[i] == value) {
                message = "Found at index: " + i;
                break;
            }
        return message;
    }

    public void clear() {
        size = 0;
        arr = new int[initialCapacity];
        capacity = initialCapacity;
    }

    public boolean contains(int value) {
        boolean bool = false;
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                bool = true;
                break;
            }
        }
        return bool;
    }
}

