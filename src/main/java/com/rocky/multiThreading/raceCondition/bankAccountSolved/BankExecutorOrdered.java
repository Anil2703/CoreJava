package com.rocky.multiThreading.raceCondition.bankAccountSolved;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankExecutorOrdered {
    private static double balance = 1000;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor(); // one thread, ordered tasks

        executor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " Reader-1 checking balance: " + balance);
        });

        executor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " Reader-2 checking balance: " + balance);
        });

        executor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " Depositor depositing 500");
            balance += 500;
            System.out.println(Thread.currentThread().getName() + " New balance after deposit: " + balance);
        });

        executor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " Withdrawer withdrawing 700");
            if (balance >= 700) {
                balance -= 700;
                System.out.println(Thread.currentThread().getName() + " New balance after withdrawal: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " Insufficient balance to withdraw");
            }
        });

        executor.shutdown(); // Important! shutdown the executor when done
    }
}
