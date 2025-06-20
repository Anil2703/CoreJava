package com.rocky.StringProblems;

public class CheckPrimeNumber {

    public static void main(String[] args) {

        //System.out.println(isPrime(2));
        //System.out.println(isPrime(3));
        //System.out.println(isPrime(4));
        System.out.println(isPrime(5));

    }

    private static boolean isPrime(int n) {
        if(n <= 1) {
            return false;
        }
        if(n == 2) {
            return true;
        }
        for(int i = 2; i<= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
