package com.rocky.multiThreading.importantTopics;

public class ThreadLifecycleExample {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("Running thread...");
        });

        System.out.println(t.getState()); // NEW
        t.start();
        System.out.println(t.getState()); // RUNNABLE (or RUNNING)
        t.join(); 
        System.out.println(t.getState()); // TERMINATED
    }
}