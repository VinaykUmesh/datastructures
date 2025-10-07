package com.dsa;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {12, 4, 13, 8, 10, 2, 23};

        selectionSortAsc(arr);
        System.out.println("Ascending: " + Arrays.toString(arr));

        selectionSortDsc(arr);
        System.out.println("Descending: " + Arrays.toString(arr));
    }

    private static void selectionSortDsc(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[maxIndex])
                    maxIndex = j;
            }
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }

    private static void selectionSortAsc(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }


}
