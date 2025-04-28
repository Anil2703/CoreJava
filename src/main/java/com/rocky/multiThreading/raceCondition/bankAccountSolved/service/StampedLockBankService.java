package com.rocky.multiThreading.raceCondition.bankAccountSolved.service;

import com.rocky.multiThreading.raceCondition.bankAccountSolved.model.BankAccount;

import java.util.concurrent.locks.StampedLock;

public class StampedLockBankService implements BankService {
    private final BankAccount account;
    private final StampedLock lock = new StampedLock();

    public StampedLockBankService(BankAccount account) {
        this.account = account;
    }

    public double getBalance() {
        long stamp = lock.tryOptimisticRead();
        double currentBalance = account.getBalance();
        if (!lock.validate(stamp)) {
            stamp = lock.readLock();
            try {
                currentBalance = account.getBalance();
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
            account.deposit(amount);
            System.out.println(Thread.currentThread().getName() + " new balance: " + account.getBalance());
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    public void withdraw(double amount) {
        long stamp = lock.writeLock();
        try {
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " withdrawing: " + amount);
            System.out.println(Thread.currentThread().getName() + " new balance: " + account.getBalance());
        } catch (RuntimeException e) {
            System.out.println(Thread.currentThread().getName() + " " + e.getMessage());
        } finally {
            lock.unlockWrite(stamp);
        }
    }
}