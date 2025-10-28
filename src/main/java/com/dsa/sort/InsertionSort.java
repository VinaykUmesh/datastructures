package com.dsa.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {12, 4, 13, 8, 10, 2, 23};

        insertionSortAsc(arr);
        System.out.println("Ascending: " + Arrays.toString(arr));

        insertionSortDsc(arr);
        System.out.println("Descending: " + Arrays.toString(arr));
    }

    private static void insertionSortDsc(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] > arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    private static void insertionSortAsc(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
