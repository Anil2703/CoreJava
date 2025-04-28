package com.rocky.multiThreading.importantTopics;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        counter.incrementAndGet();
        System.out.println(counter.get());
    }
}