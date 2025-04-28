package com.rocky.multiThreading.basics;

public class FirstThreadUsingThread extends Thread{

    @Override
    public void run() {
        System.out.println("Thread Created using Thread is running");
    }
}
