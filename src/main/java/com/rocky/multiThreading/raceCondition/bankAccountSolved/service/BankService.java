package com.rocky.multiThreading.raceCondition.bankAccountSolved.service;

public interface BankService {
    double getBalance();
    void deposit(double amount);
    void withdraw(double amount);
}