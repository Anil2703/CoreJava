package com.rocky.multiThreading.basics;

import java.util.concurrent.Callable;

public class FirstThreadUsingCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("Callable");
        return "String from Callable Thread";
    }
}
