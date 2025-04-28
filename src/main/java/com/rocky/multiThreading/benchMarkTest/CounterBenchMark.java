package com.rocky.multiThreading.benchMarkTest;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class CounterBenchMark {

    static final int THREADS = 1000;
    static final int INCREMENTS = 10000;

    public static void main(String[] args) throws InterruptedException {
        testAtomicInteger();
        testLongAdder();

        //Under massive concurrency, AtomicInteger can become a hotspot due to CAS retry storms.
        //LongAdder splits the contention by maintaining several counters, massively improving performance.
        //For scenarios where reads dominate, StampedLock allows optimistic reading for even better scaling.

        //AtomicInteger uses CAS (Compare-And-Swap) at CPU level.
        //When too many threads try to update it simultaneously, they CAS fail and retry again and again.
        //CPU contention becomes very high → heavy "spinning" (retry loops) → low throughput → high CPU utilization.
        //This is called "false sharing" or "contention bottleneck".

        //Why LongAdder is better:
        //Instead of one counter, it maintains internal cells(small counters).
        //Threads update different cells →much less contention.
        //Final result is sum of all cells.
        //Massively better at high concurrency.


    }

    static void testAtomicInteger() throws InterruptedException {
        AtomicInteger counter = new AtomicInteger();
        Thread[] threads = new Thread[THREADS];
        long start = System.nanoTime();
        for (int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < INCREMENTS; j++) {
                    counter.incrementAndGet();
                }
            });
            threads[i].start();
        }
        for (Thread t : threads) t.join();
        long end = System.nanoTime();
        System.out.println("AtomicInteger time: " + (end - start) / 1_000_000 + " ms");
    }

    static void testLongAdder() throws InterruptedException {
        LongAdder counter = new LongAdder();
        Thread[] threads = new Thread[THREADS];
        long start = System.nanoTime();
        for (int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < INCREMENTS; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }
        for (Thread t : threads) t.join();
        long end = System.nanoTime();
        System.out.println("LongAdder time: " + (end - start) / 1_000_000 + " ms");
    }
}
