package com.rocky.multiThreading.raceCondition.solved;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountReentrantLock implements Runnable {
    private int balance = 100;
    private final Lock lock = new ReentrantLock();

    public void setBalance(int balance) {
        lock.lock();
        try {
            this.balance = balance;
        } finally {
            lock.unlock();
        }
    }

    public int getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        makeWithdrawal(75);
    }

    private void makeWithdrawal(int amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining Balance: " + balance);
            } else {
                System.out.println("Sorry! Not enough balance for " + Thread.currentThread().getName());
            }
        } finally {
            lock.unlock();
        }
    }
}