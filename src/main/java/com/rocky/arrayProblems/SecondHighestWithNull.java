package com.rocky.arrayProblems;

public class SecondHighestWithNull {

    public static Integer secondHighest(int[] arr) {

        Integer first = null;   // largest
        Integer second = null;  // second largest

        for (int n : arr) {

            // ignore duplicates of first or second
            if (Integer.valueOf(n).equals(first) || Integer.valueOf(n).equals(second)) {
                continue;
            }

            // new largest
            if (first == null || n > first) {
                second = first;
                first = n;
            }
            // candidate for second
            else if (second == null || n > second) {
                second = n;
            }
        }

        return second;   // may be null if no distinct 2nd largest
    }

    public static void main(String[] args) {

        int[] arr = {10, 5, 20, 8, 20, 3};

        Integer result = secondHighest(arr);

        if (result == null) {
            System.out.println("No valid second highest number exists.");
        } else {
            System.out.println("Second highest number: " + result);
        }
    }
}

