package com.rocky.multiThreading;

import java.util.concurrent.*;

public class CompletableFutureExample {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
            return "Hello from Background Thread";
        });

        future.thenAccept(result -> {
            System.out.println(result);
        });

        future.thenAccept(result -> {
            System.out.println(result);
        });

        System.out.println(future.get());
    }
}