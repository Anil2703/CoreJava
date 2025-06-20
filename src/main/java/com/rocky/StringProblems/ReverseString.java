package com.rocky.StringProblems;

public class ReverseString {

    public static void main(String[] args) {
        String str = "Hello World";
        String reversed = reverseString(str);
        System.out.println("Original: " + str);
        System.out.println("Reversed: " + reversed);
    }

    private static String reverseString(String s) {
        String reversed = "";
        for(int i = s.length()-1; i>=0; i--) {
            reversed = reversed + s.charAt(i);
        }
        return reversed;
    }
}
