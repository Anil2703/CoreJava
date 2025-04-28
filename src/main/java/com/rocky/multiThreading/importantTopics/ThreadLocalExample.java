package com.rocky.multiThreading.importantTopics;

public class ThreadLocalExample {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        threadLocal.set(100);
        System.out.println(threadLocal.get());
    }
}