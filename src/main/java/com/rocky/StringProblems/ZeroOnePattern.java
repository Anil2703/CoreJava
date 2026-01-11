package com.rocky.StringProblems;

public class ZeroOnePattern {
    public static void main(String[] args) {
        zeroOnePattern(10);
    }

    public static void zeroOnePattern(int rows) {
        int value = 0;
        for (int row = 1; row <= rows; row++) {
            for (int count = 1; count <= row; count++) {
                System.out.print(value + " ");
                value = 1 - value; // flip 0 ↔ 1
            }
            System.out.println();
        }
    }
}

