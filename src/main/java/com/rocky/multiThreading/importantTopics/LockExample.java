package com.rocky.multiThreading.importantTopics;

import java.util.concurrent.locks.*;

class LockExample {
    private final Lock lock = new ReentrantLock();

    public void accessResource() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " accessed resource");
        } finally {
            lock.unlock();
        }
    }
}