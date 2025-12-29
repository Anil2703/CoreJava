package com.rocky.arrayProblems;

import java.util.Arrays;

public class TwoSumSortedArray {
    private static int[] twoSum(int[] numbers, int target) {

       int left = 0;
       int right = numbers.length -1;

       while(left < right) {
           if(numbers[left] + numbers[right] > target) {
               right--;
           } else if(numbers[left] + numbers[right] < target) {
               left++;
           } else {
               return new int[] {left, right};
           }
       }
       return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] numbers = {2, 3, 4, 5, 7, 9};

        int[] result = twoSum(numbers, 8);

        System.out.println(Arrays.toString(result));

    }
}
