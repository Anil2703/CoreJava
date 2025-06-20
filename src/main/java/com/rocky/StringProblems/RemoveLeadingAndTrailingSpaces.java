package com.rocky.StringProblems;

import java.util.Arrays;

public class RemoveLeadingAndTrailingSpaces {

    public static void main(String[] args) {

        String s = "  abc  def\t";

        s = s.strip();

        System.out.println(s);


        int[] array = {1, 2, 3, -1, -2, 4};

        Arrays.sort(array);

        System.out.println(array);
        System.out.println(Arrays.toString(array));

    }
}
