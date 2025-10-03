package com.dsa;

import java.util.Arrays;

public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = {2, 54, 6, 7, 8, 8, 9};
        System.out.println(find(arr, 7));
        System.out.println(contains(arr, 7));

        String str = "krishnan";
        System.out.println(find(str, 'n'));
        System.out.println(contains(str, 'x'));

        int[][] twoDArr = {
                {3, 5, 67},
                {34, 56, 23, 45, 56},
                {32, 45, 2, 1, 7}
        };

        System.out.println(Arrays.toString(find(twoDArr, 7)));

        System.out.println(max(arr));
        System.out.println(min(arr));
        System.out.println(count(str, 'n'));

        int[] array = {123, 7845, 124, 78452, 1429, 7865};
        System.out.println(count(array));

    }

    private static int find(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    private static boolean contains(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return true;
        }
        return false;
    }

    private static int find(String str, char target) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                return i;
            }
        }
        return -1;
    }

    private static boolean contains(String str, char target) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target)
                return true;
        }
        return false;
    }

    private static int[] find(int[][] arr, int target) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == target) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private static int max(int[] arr) {
        int max = arr[0];
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

    private static int min(int[] arr) {
        int max = arr[0];
        for (int j : arr) {
            if (j < max) {
                max = j;
            }
        }
        return max;
    }

    private static int count(String str, char target) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target)
                count++;
        }
        return count;
    }

    private static int count(int[] arr) {
        int count = 0;
        for (int n : arr) {
            if (n >= 1000 && n <= 9999) count++;
//            if (String.valueOf(n).length() == 4) count++;
        }
        return count;
    }

}