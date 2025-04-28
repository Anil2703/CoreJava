package com.rocky.multiThreading.basics;

import java.util.concurrent.TimeUnit;

public class FirstThreadUsingRunnable implements Runnable {
    @Override
    public void run() {
        try {
            //Thread.sleep(10000);
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread Created using Runnable is running");
    }
}
