package com.dsa;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 7, 9, 10, 12, 13, 14, 16, 17, 18, 20, 23, 26, 28, 29, 30};
        System.out.println(binarySearch(arr, 5));

        arr = new int[]{30, 29, 28, 26, 24, 23, 20, 18, 17, 16, 14, 13, 12, 10, 9, 7, 5, 4, 3, 1};
        System.out.println(binarySearch(arr, 4));
    }

    private static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        boolean asc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (asc) {
                if (target < arr[mid]) // focus on left side
                    end = mid - 1;
                else if (target > arr[mid]) // focus oon right side
                    start = mid + 1;
                else
                    return mid;
            } else {
                if (target < arr[mid]) // focus on right side
                    start = mid + 1;
                else if (target > arr[mid]) // focus on left side
                    end = mid - 1;
                else
                    return mid;
            }

        }
        return -1;
    }
}
