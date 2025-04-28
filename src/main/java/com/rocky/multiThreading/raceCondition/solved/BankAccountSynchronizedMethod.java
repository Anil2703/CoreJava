package com.rocky.multiThreading.raceCondition.solved;

public class BankAccountSynchronizedMethod implements Runnable {
    private int balance = 100;

    public synchronized void setBalance(int balance) {
        this.balance = balance;
    }

    public synchronized int getBalance() {
        return balance;
    }

    @Override
    public void run() {
        makeWithdrawal(75);
    }

    private synchronized void makeWithdrawal(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining Balance: " + balance);
        } else {
            System.out.println("Sorry! Not enough balance for " + Thread.currentThread().getName());
        }
    }
}