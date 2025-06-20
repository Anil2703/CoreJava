package com.rocky.StringProblems;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("madam")); // true
        System.out.println(isPalindrome("radar")); // true
        System.out.println(isPalindrome("level")); // true
        System.out.println(isPalindrome("Anil")); // true
    }

    private static Boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left)!= s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
