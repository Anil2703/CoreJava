package com.rocky.multiThreading.raceCondition.solved;

public class TestRaceConditions {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("===== Testing synchronized method =====");
        BankAccountSynchronizedMethod accountMethod = new BankAccountSynchronizedMethod();
        runTest(accountMethod);

        System.out.println("\n===== Testing synchronized block =====");
        BankAccountSynchronizedBlock accountBlock = new BankAccountSynchronizedBlock();
        runTest(accountBlock);

        System.out.println("\n===== Testing ReentrantLock =====");
        BankAccountReentrantLock accountLock = new BankAccountReentrantLock();
        runTest(accountLock);

        System.out.println("\n===== Testing AtomicInteger =====");
        BankAccountAtomic bankAccountAtomic = new BankAccountAtomic();
        runTest(bankAccountAtomic);

    }

    private static void runTest(Runnable account) throws InterruptedException {
        Thread t1 = new Thread(account);
        t1.setName("Anil");

        Thread t2 = new Thread(account);
        t2.setName("Rocky");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}