package BigONotation;

import java.util.HashMap;

import static BigONotation.TimeComplexity.fibonacci;

public class SpaceComplexity {

    public static void main(String[] args) {
        // Fixed memory allocation.
        constantSpace();       // O(1)
        linearSpace();         // O(n)
        recursiveSpace();      // O(n)

        // Space Complexity in Fibonacci Algorithm
        fibonacciRecursive();
        fibonacciMemoization();
        fibonacciIterative();

    }

    private static void constantSpace() {
        // Independent of input size. E.g. int, char, boolean
        int a = 10;     // O(1) Fixed memory allocation
        char chr = 'A';
        boolean b = false;
    }

    private static void linearSpace() {
        // Arrays, lists, hashmaps, etc., depend on n.
        int[] arr = new int[10000]; // O(n)
    }

    private static void recursiveSpace() {
        System.out.println(factorial(6));
    }

    private static int factorial(int n) {
        if (n == 1) return n;
        return n * factorial(n - 1);  // O(n) stack space
    }

    private static void fibonacciRecursive() {
        // Time Complexity: O(2^n)
        // Space Complexity: O(n) (stack calls for depth n)
        System.out.println(fibonacci(5));
    }

    private static void fibonacciMemoization() {
        System.out.println(fibonacciMemo(5));
    }

    private static int fibonacciMemo(int n) {
        // Time Complexity: O(2^n)
        // Space Complexity: O(n) (hash map stores n values)
        HashMap<Integer, Integer> memo = new HashMap<>();
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n); // O(n) space for HashMap
        int result = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);
        memo.put(n, result);
        return result;
    }

    private static void fibonacciIterative() {
        System.out.println(fibonacciIterated(5));
    }

    private static int fibonacciIterated(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
