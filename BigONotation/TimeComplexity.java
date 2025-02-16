package BigONotation;

import java.util.Arrays;

public class TimeComplexity {

    public static void main(String[] args) {
        constantTime();       // O(1)
        linearTime();         // O(n)
        logarithmicTime();    // O(log n)
        logLinearTime();      // O(n log n)
        quadraticTime();      // O(n^2)
        exponentialTime();    // O(n^2)
    }

    private static void constantTime() {
        int[] arr = {2, 5, 6, 54, 667, 32};
        System.out.println(arr[3]); // O(1) constant time.
    }

    private static void linearTime() {
        int[] arr = {2, 5, 6, 54, 667, 32};
        for (int i = 0; i <= arr.length - 1; i++) {
            System.out.println(arr[i]); // O(n) linear time
        }
    }

    private static void logarithmicTime() {
        int[] arr = {2, 5, 6, 54, 667, 32};
        int index = Arrays.binarySearch(arr, 54); // O(log n) logarithmic time
        System.out.println("Element at the index(i): " + index);

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 54) {
                index = i;
            }
        }
        System.out.println("(T) Element at the index(i): " + index);
    }

    private static void logLinearTime() {
        int[] arr = {2, 5, 6, 54, 667, 32};
        Arrays.sort(arr);  // O(n log n)
        System.out.println(Arrays.toString(arr));
    }

    private static void quadraticTime() {
        int[] arr = {6, 2, 54, 667, 32, 7, 3};
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[i] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr)); // O(2^n)
    }

    private static void exponentialTime() {
        System.out.println(fibonacci(5)); // Slow for large n
    }

    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);  // Recursive calls lead to O(2^n)
    }
}
