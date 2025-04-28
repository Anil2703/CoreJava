package com.rocky.multiThreading.raceCondition.bankAccountSolved.service;


import com.rocky.multiThreading.raceCondition.bankAccountSolved.model.BankAccount;

public class SynchronizedBankService implements BankService {
    private final BankAccount account;

    public SynchronizedBankService(BankAccount account) {
        this.account = account;
    }

    public synchronized double getBalance() {
        System.out.println(Thread.currentThread().getName() + " checking balance: " + account.getBalance());
        return account.getBalance();
    }

    public synchronized void deposit(double amount) {
        System.out.println(Thread.currentThread().getName() + " depositing: " + amount);
        account.deposit(amount);
        System.out.println(Thread.currentThread().getName() + " new balance: " + account.getBalance());
    }

    public synchronized void withdraw(double amount) {
        try {
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " withdrawing: " + amount);
            System.out.println(Thread.currentThread().getName() + " new balance: " + account.getBalance());
        } catch (RuntimeException e) {
            System.out.println(Thread.currentThread().getName() + " " + e.getMessage());
        }
    }
}