package com.rocky.multiThreading.raceCondition.bankAccountSolved;


import com.rocky.multiThreading.raceCondition.bankAccountSolved.model.BankAccount;
import com.rocky.multiThreading.raceCondition.bankAccountSolved.service.BankService;
import com.rocky.multiThreading.raceCondition.bankAccountSolved.service.SynchronizedBankService;
import com.rocky.multiThreading.raceCondition.bankAccountSolved.task.TransactionTask;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BankAccount sharedAccount = new BankAccount(1000);

        // Switching between services easily
        BankService service = new SynchronizedBankService(sharedAccount);
        // BankService service = new ReentrantLockBankService(sharedAccount);
        // BankService service = new ReadWriteLockBankService(sharedAccount);
        // BankService service = new StampedLockBankService(sharedAccount);

        Thread reader1 = new Thread(new TransactionTask(service, "read", 0), "Reader-1");
        Thread reader2 = new Thread(new TransactionTask(service, "read", 0), "Reader-2");
        Thread depositor = new Thread(new TransactionTask(service, "deposit", 500), "Depositor");
        Thread withdrawer = new Thread(new TransactionTask(service, "withdraw", 700), "Withdrawer");

        reader1.start();
        reader1.join();
        reader2.start();
        reader2.join();
        depositor.start();
        depositor.join();
        withdrawer.start();
        withdrawer.join();
    }
}