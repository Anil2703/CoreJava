package com.rocky.StringProblems;

public class Factorial {

    public static long factorial(int n) {
        long result = 1;
        for (int i = n; i > 1; i--) {
            result = result * i;
        }
        return result;
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println("Factorial of " + num + " is: " + factorial(num));
    }
}
