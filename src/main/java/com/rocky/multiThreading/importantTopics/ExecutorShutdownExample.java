package com.rocky.multiThreading.importantTopics;

import java.util.concurrent.*;

public class ExecutorShutdownExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.shutdown();
        executor.awaitTermination(60, TimeUnit.SECONDS);
    }
}