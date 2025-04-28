package com.rocky.multiThreading.importantTopics;

import java.util.Arrays;

public class ParallelStreamExample {
    public static void main(String[] args) {
        Arrays.asList(1,2,3,4,5,6)
              .parallelStream()
              .forEach(System.out::println);
    }
}