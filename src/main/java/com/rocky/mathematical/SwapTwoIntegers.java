package com.rocky.mathematical;

public class SwapTwoIntegers {

    public static void main(String[] args) {

        int a = 50;
        int b = 70;

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println(a);
        System.out.println(b);
    }
}
