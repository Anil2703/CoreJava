package com.rocky.arrayProblems;

import java.util.Arrays;

public class SecondHighestStream {

    public static Integer secondHighest(int[] arr) {

        return Arrays.stream(arr)          // int stream
                .boxed()                   // convert to Stream<Integer>
                .distinct()               // remove duplicates
                .sorted((a, b) -> b - a)   // sort descending
                .skip(1)                  // skip the 1st (highest)
                .findFirst()              // get the next one
                .orElse(null);            // return null if none
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 20, 8, 20, 3};
        System.out.println(secondHighest(arr));   // 10
    }
}