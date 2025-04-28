package com.rocky.multiThreading.importantTopics;

import java.util.concurrent.*;

public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable task = () -> System.out.println("Running in " + Thread.currentThread().getName());

        executor.submit(task);
        executor.submit(task);
        executor.submit(task);
        executor.submit(task);
        executor.submit(task);
        executor.submit(task);
        executor.submit(task);
        executor.submit(task);
        executor.submit(task);
        executor.submit(task);
        executor.submit(task);
        executor.submit(task);
        executor.shutdown();
    }
}