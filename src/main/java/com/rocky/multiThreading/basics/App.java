package com.rocky.multiThreading.basics;

public class App {
    public static void main(String[] args) throws InterruptedException{

        //Thread started using Runnable
        //FirstThreadUsingRunnable thread1 = new FirstThreadUsingRunnable();
        //Thread thread = new Thread(thread1);
        //thread.start();

        //Thread started using Thread Class
        //FirstThreadUsingThread thread2= new FirstThreadUsingThread();
        //thread2.start();

        //Using java8
        //Thread
        /*Thread t2 = new Thread(() -> {
            System.out.println("Thread running using lambda (Thread class)");
        });
        t2.start();*/


        //Runnable
        Runnable runnable = () -> {
            System.out.println("Thread running using lambda (Runnable interface)");
            System.out.println("Runnable Name--" + Thread.currentThread().getName());
            try {
                Thread.currentThread().join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };



        Thread t1 = new Thread(runnable);
        t1.setName("Thread1");
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();



        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        System.out.println(Thread.currentThread().getName());

    }
}
