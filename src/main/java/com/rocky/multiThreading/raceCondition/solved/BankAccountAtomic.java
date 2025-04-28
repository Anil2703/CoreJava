package com.rocky.multiThreading.raceCondition.solved;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccountAtomic implements Runnable {

    private AtomicInteger balance = new AtomicInteger(100);

    public void setBalance(int amount) {
        balance.set(amount);  // Sets new balance atomically
    }

    public int getBalance() {
        return balance.get(); // Reads value atomically
    }

    @Override
    public void run() {
        makeWithdrawal(75);
        if (getBalance() < 0) {
            System.out.println("Money Overdrawn by " + Thread.currentThread().getName() + " !! Balance: " + getBalance());
        }
    }

    private void makeWithdrawal(int amount) {
        // No need to lock manually!
        if (balance.get() >= amount) {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw. Current Balance: " + balance.get());

            balance.addAndGet(-amount); // Atomically subtract
            System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining Balance: " + balance.get());
        } else {
            System.out.println("Sorry! Not enough balance for " + Thread.currentThread().getName());
        }
    }
}