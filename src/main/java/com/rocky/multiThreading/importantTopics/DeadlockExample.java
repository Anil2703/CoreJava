package com.rocky.multiThreading.importantTopics;

class DeadlockExample {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void methodA() {
        synchronized (lock1) {
            synchronized (lock2) {
                System.out.println("Acquired both locks");
            }
        }
    }

    public void methodB() {
        synchronized (lock2) {
            synchronized (lock1) {
                System.out.println("Acquired both locks");
            }
        }
    }
}