package com.dsa;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {11, 5, 7, 9, 2, 10, 4};
        bubbleSortAsc(arr);
        System.out.println(Arrays.toString(arr));

        bubbleSortDesc(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSortDesc(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    private static void bubbleSortAsc(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
