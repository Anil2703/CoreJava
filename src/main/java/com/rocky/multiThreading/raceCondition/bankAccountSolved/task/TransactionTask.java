package com.rocky.multiThreading.raceCondition.bankAccountSolved.task;


import com.rocky.multiThreading.raceCondition.bankAccountSolved.service.BankService;

public class TransactionTask implements Runnable {
    private final BankService service;
    private final String operation;
    private final double amount;

    public TransactionTask(BankService service, String operation, double amount) {
        this.service = service;
        this.operation = operation;
        this.amount = amount;
    }

    @Override
    public void run() {
        switch (operation.toLowerCase()) {
            case "read":
                service.getBalance();
                break;
            case "deposit":
                service.deposit(amount);
                break;
            case "withdraw":
                service.withdraw(amount);
                break;
            default:
                System.out.println(Thread.currentThread().getName() + " Invalid operation: " + operation);
        }
    }
}