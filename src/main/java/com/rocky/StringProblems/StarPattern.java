package com.rocky.StringProblems;

public class StarPattern {
    public static void main(String[] args) {

        int rows = 4;

        for (int row = 1; row <= rows; row++) {
            for (int count = 1; count <= row; count++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
