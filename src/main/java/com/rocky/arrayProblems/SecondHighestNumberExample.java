package com.rocky.arrayProblems;


public class SecondHighestNumberExample {

    public static Integer secondHighest(int[] arr) {

        if (arr == null || arr.length < 2) return null;

        int first = Integer.MIN_VALUE; //0
        int second = Integer.MIN_VALUE; //0

        for (int n : arr) {
            // New largest
            if (n > first) {
                second = first;
                first = n;
            }
            // Candidate for second (not equal to largest)
            else if (n > second && n != first) {
                second = n;
            }
        }

        // If there is no valid second highest (e.g., all elements same)
        return (second == Integer.MIN_VALUE) ? null : second;
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
