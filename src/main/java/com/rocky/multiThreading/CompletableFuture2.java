package com.rocky.multiThreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFuture2 {

    public static void main(String[] args) throws Exception {


        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
            return "Hello from Background Thread";
        });


        completableFuture.thenAccept(result -> {
            System.out.println("Result Parameter is: " + result);
        });

        completableFuture.thenAccept(result -> {
            System.out.println("Result Parameter is: " + result);
        });

        completableFuture.thenAccept(result -> {
            System.out.println("Result Parameter is: " + result);
        });

        System.out.println(completableFuture.get());

        //CompletableFuture is a Java 8 class in java.util.concurrent that represents a future result of an asynchronous computation, with powerful features like:
        //Non-blocking execution
        //Callback chaining
        //Combining multiple tasks
        //Built-in error handling


        //Future Vs CompletableFuture
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(() -> "Hello");
        System.out.println(future.get()); // blocks
        executor.shutdown();


        CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(msg -> msg + " World")
                .thenAccept(System.out::println); // no blocking
    }


}
