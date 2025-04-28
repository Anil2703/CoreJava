package com.rocky.multiThreading.raceCondition.unsolved;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RaceCondition {

    private final Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount();
        bankAccount.setBalance(100);

        Thread anil = new Thread(bankAccount);
        anil.setName("Anil");

        Thread rocky = new Thread(bankAccount);
        rocky.setName("Rocky");

        anil.start();
        rocky.start();
    }

}

class BankAccount implements Runnable {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public void run() {
        makeWithdrawl(75);
        if(balance < 0) {
            System.out.println("Money Overdrawn by "+ Thread.currentThread().getName()+" !!, Balance is :" +balance);
        }
    }

    private synchronized void makeWithdrawl(int amount) {

        if(balance > amount) {
            System.out.println(Thread.currentThread().getName()+ "'s Request entered MakeWithdrawl..");
            System.out.println(Thread.currentThread().getName()+ " is about to withdraw..., Balance: "+balance+ "," +"Amount: " +amount);
            balance -= amount;
            System.out.println(Thread.currentThread().getName()+ " has withdrawn money..., Balance: "+balance);
        } else {
             System.out.println("Sorry!! Not enough balance for User: " + Thread.currentThread().getName());
        }
    }
}