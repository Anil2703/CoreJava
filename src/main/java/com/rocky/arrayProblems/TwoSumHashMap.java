package com.rocky.arrayProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumHashMap {
    private static int[] twoSum(int[] numbers, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int x = numbers[i];
            if (map.containsKey(target - x)) {
                return new int[] {map.get(target -x), i};
            }
            map.put(x, i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] numbers = {2, 3, 7, 5, 4};

        int[] result = twoSum(numbers, 8);

        System.out.println(Arrays.toString(result));

    }
}
