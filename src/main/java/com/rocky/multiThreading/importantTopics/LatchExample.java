package com.rocky.multiThreading.importantTopics;

import java.util.concurrent.CountDownLatch;

public class LatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        new Thread(latch::countDown).start();
        new Thread(latch::countDown).start();

        latch.await();
        System.out.println("Both threads finished!");
    }
}