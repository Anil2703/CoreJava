package com.rocky.multiThreading.importantTopics;

import java.util.concurrent.*;

public class RunnableCallableExample {
    public static void main(String[] args) throws Exception {
        Runnable r = () -> System.out.println("Runnable running!");
        Callable<String> c = () -> "Callable result!";

        new Thread(r).start();

        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(c);
        System.out.println(future.get());
        service.shutdown();
    }
}