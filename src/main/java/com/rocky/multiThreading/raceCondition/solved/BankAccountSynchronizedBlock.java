package com.rocky.multiThreading.raceCondition.solved;

public class BankAccountSynchronizedBlock implements Runnable {
    private int balance = 100;
    private final Object lock = new Object();

    public void setBalance(int balance) {
        synchronized (lock) {
            this.balance = balance;
        }
    }

    public int getBalance() {
        synchronized (lock) {
            return balance;
        }
    }

    @Override
    public void run() {
        makeWithdrawal(75);
    }

    private void makeWithdrawal(int amount) {
        synchronized (lock) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining Balance: " + balance);
            } else {
                System.out.println("Sorry! Not enough balance for " + Thread.currentThread().getName());
            }
        }
    }
}