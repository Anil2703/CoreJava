package com.rocky.multiThreading.raceCondition.bankAccountSolved.service;

import com.rocky.multiThreading.raceCondition.bankAccountSolved.model.BankAccount;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockBankService implements BankService {
    private final BankAccount account;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public ReadWriteLockBankService(BankAccount account) {
        this.account = account;
    }

    public double getBalance() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " checking balance: " + account.getBalance());
            return account.getBalance();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void deposit(double amount) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " depositing: " + amount);
            account.deposit(amount);
            System.out.println(Thread.currentThread().getName() + " new balance: " + account.getBalance());
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void withdraw(double amount) {
        lock.writeLock().lock();
        try {
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " withdrawing: " + amount);
            System.out.println(Thread.currentThread().getName() + " new balance: " + account.getBalance());
        } catch (RuntimeException e) {
            System.out.println(Thread.currentThread().getName() + " " + e.getMessage());
        } finally {
            lock.writeLock().unlock();
        }
    }
}