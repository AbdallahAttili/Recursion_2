import java.util.Arrays;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        System.out.println(fibonacci(6));

        System.out.println(Arrays.toString(usingArray(46)));

        System.out.println(fibonacciSeries(92));

        System.out.println("Does the array sorted : " + checkSorted(new int[]{4, 3, 2, 10}));

        System.out.println(sum(new int[]{9, 8, 9}));

        System.out.println(sum2(new int[]{9, 8, 9}));

        System.out.println(checkNumber(new int[]{9, 8, 10}, 2));

        System.out.println(checkSortedBetter(new int[]{10, 20, 30, 2}));

        System.out.println(firstIndex(new int[]{9, 8, 10, 8}, 8));

        System.out.println(lastIndex(new int[]{9, 8, 10, 8}, 8));

    }

    // Find the i-th fibonacci number.
    public static long fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Fibonacci series.
    public static Vector<Long> fibonacciSeries(int n) {
        Vector<Long> toStore = new Vector<>();

        toStore.add(0L);
        toStore.add(1L);

        for (int i = 2; i <= n; i++) {
            toStore.add(toStore.get(i - 1) + toStore.get(i - 2));
        }

        return toStore;
    }

    public static int[] usingArray(int n) {
        int[] toStore = new int[n + 1];

        toStore[0] = 0;
        toStore[1] = 1;

        for (int i = 2; i <= n; i++) {
            toStore[i] = toStore[i - 1] + toStore[i - 2];
        }

        return toStore;
    }

    public static boolean checkSorted(int[] input) {
        int n = input.length;

        if (n <= 1) { // Base case.
            return true;
        }

        int[] smallArray = new int[n - 1];

        System.arraycopy(input, 1, smallArray, 0, n - 1);

        boolean check = checkSorted(smallArray);

        if (!check) {
            return false;
        }

        return input[0] <= input[1];
    }

    public static int sum(int[] input, int startIndex) {
        if (startIndex == input.length) {
            return 0;
        }

        return input[startIndex] + sum(input, startIndex + 1);
    }

    public static int sum(int[] input) {
        return sum(input, 0);
    }

    public static int sum2(int[] input, int n) {
        if (n <= 0) {
            return 0;
        }

        return sum2(input, n - 1) + input[n - 1];
    }

    public static int sum2(int[] input) {
        int n = input.length;
        return sum2(input, n);
    }

    public static boolean checkNumber(int[] input, int n, int x) {
        if (n == 0) {
            return false;
        }

        if (input[n - 1] == x) {
            return true;
        }
        return checkNumber(input, n - 1, x);
    }

    public static boolean checkNumber(int[] input, int x) {
        int n = input.length;
        return checkNumber(input, n, x);
    }

    public static boolean checkSortedBetter(int[] input, int startIndex) {
        if (startIndex == input.length - 1) {
            return true;
        }

        if (input[startIndex] > input[startIndex + 1]) {
            return false;
        }

        return checkSortedBetter(input, startIndex + 1);
    }

    public static boolean checkSortedBetter(int[] input) {
        return checkSortedBetter(input, 0);
    }


    public static int firstIndex(int[] input, int x, int startIndex) {
        if (startIndex == input.length - 1) {
            return -1;
        }

        if (input[startIndex] == x) {
            return startIndex;
        }

        return firstIndex(input, x, startIndex + 1);
    }

    public static int firstIndex(int[] input, int x) {
        return firstIndex(input, x, 0);
    }

    public static int lastIndex(int[] input, int x, int startIndex) {
        if (startIndex == 0) {
            return -1;
        }

        if (input[startIndex] == x) {
            return startIndex;
        }

        return lastIndex(input, x, startIndex - 1);
    }

    public static int lastIndex(int[] input, int x) {
        return lastIndex(input, x, input.length - 1);
    }

}
