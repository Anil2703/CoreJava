package com.rocky.multiThreading.raceCondition.bankAccountSolved.service;

import com.rocky.multiThreading.raceCondition.bankAccountSolved.model.BankAccount;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockBankService implements BankService {
    private final BankAccount account;
    private final ReentrantLock lock = new ReentrantLock();

    public ReentrantLockBankService(BankAccount account) {
        this.account = account;
    }

    public double getBalance() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " checking balance: " + account.getBalance());
            return account.getBalance();
        } finally {
            lock.unlock();
        }
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " depositing: " + amount);
            account.deposit(amount);
            System.out.println(Thread.currentThread().getName() + " new balance: " + account.getBalance());
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " withdrawing: " + amount);
            System.out.println(Thread.currentThread().getName() + " new balance: " + account.getBalance());
        } catch (RuntimeException e) {
            System.out.println(Thread.currentThread().getName() + " " + e.getMessage());
        } finally {
            lock.unlock();
        }
    }
}