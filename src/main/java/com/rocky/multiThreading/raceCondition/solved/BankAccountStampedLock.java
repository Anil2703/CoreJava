package com.rocky.multiThreading.raceCondition.solved;

import java.util.concurrent.locks.StampedLock;

public class BankAccountStampedLock implements Runnable{

    private double balance;
    private final StampedLock lock = new StampedLock();

    private String operation;
    private double amount;

    public BankAccountStampedLock(double initialBalance) {
        this.balance = initialBalance;
    }

    // Constructor for actions
    public BankAccountStampedLock(double initialBalance, String operation, double amount) {
        this.balance = initialBalance;
        this.operation = operation;
        this.amount = amount;
    }

    public double getBalance() {
        long stamp = lock.tryOptimisticRead();
        double currentBalance = balance;
        if (!lock.validate(stamp)) {
            stamp = lock.readLock();
            try {
                currentBalance = balance;
            } finally {
                lock.unlockRead(stamp);
            }
        }
        System.out.println(Thread.currentThread().getName() + " checking balance: " + currentBalance);
        return currentBalance;
    }

    public void deposit(double amount) {
        long stamp = lock.writeLock();
        try {
            System.out.println(Thread.currentThread().getName() + " depositing: " + amount);
            Thread.sleep(500);
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " new balance: " + balance);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    public void withdraw(double amount) {
        long stamp = lock.writeLock();
        try {
            if (balance >= amount) {
                System.out.println(Thread.currentThread().getName() + " withdrawing: " + amount);
                Thread.sleep(500);
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " new balance: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " insufficient balance");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    @Override
    public void run() {
        if ("read".equalsIgnoreCase(operation)) {
            getBalance();
        } else if ("deposit".equalsIgnoreCase(operation)) {
            deposit(amount);
        } else if ("withdraw".equalsIgnoreCase(operation)) {
            withdraw(amount);
        } else {
            System.out.println(Thread.currentThread().getName() + " Invalid operation: " + operation);
        }
    }

    public static void main(String[] args) {
        BankAccountStampedLock account = new BankAccountStampedLock(1000);

        // We need shared account for all threads
        BankAccountStampedLock reader1 = new BankAccountStampedLock(0, "read", 0);
        BankAccountStampedLock reader2 = new BankAccountStampedLock(0, "read", 0);
        BankAccountStampedLock depositor = new BankAccountStampedLock(0, "deposit", 500);
        BankAccountStampedLock withdrawer = new BankAccountStampedLock(0, "withdraw", 700);

        Thread t1 = new Thread(() -> account.getBalance(), "Reader-1");
        Thread t2 = new Thread(() -> account.getBalance(), "Reader-2");
        Thread t3 = new Thread(() -> account.deposit(500), "Depositor");
        Thread t4 = new Thread(() -> account.withdraw(700), "Withdrawer");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
