package com.dsa.sort;

import java.util.Arrays;

public class MergeSortInSameArray {


    public static void main(String[] args) {
        int[] arr = {5, 6, 9, 1, 8, 2, 3};
        mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));

    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (end - start == 1)
            return;
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);

        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] joined = new int[end - start];
        int i = start;
        int j = mid;
        int k = 0;

        while (i < mid && j < end) {
            if (arr[i] > arr[j])
                joined[k++] = arr[i++];
            else
                joined[k++] = arr[j++];
        }

        while (i < mid)
            joined[k++] = arr[i++];
        while (j < end)
            joined[k++] = arr[j++];

        for (k = 0; k < joined.length; k++)
            arr[start + k] = joined[k];
    }
}
