package com.rocky.arrayProblems;

public class ThirdHighestNumberExample {

    public static Integer thirdHighest(int[] arr) {

        if (arr == null || arr.length == 0) return null;

        Integer first = null;    // highest
        Integer second = null;   // second highest
        Integer third = null;    // third highest

        for (int n : arr) {

            // skip duplicates of current top 3 (distinct values only)
            if (Integer.valueOf(n).equals(first) ||
                    Integer.valueOf(n).equals(second) ||
                    Integer.valueOf(n).equals(third)) {
                continue;
            }

            // new highest
            if (first == null || n > first) {
                third = second;
                second = first;
                first = n;
            }
            // between first and second
            else if (second == null || n > second) {
                third = second;
                second = n;
            }
            // between second and third
            else if (third == null || n > third) {
                third = n;
            }
        }

        return third;   // null if 3rd distinct highest doesn't exist
    }

    public static void main(String[] args) {

        int[] arr1 = {10, 5, 20, 8, 30, 25, 30};
        int[] arr2 = {5, 5, 5};
        int[] arr3 = {3, 1, 2};

        System.out.println("Array 1 third highest: " + thirdHighest(arr1)); // 20
    }
}
