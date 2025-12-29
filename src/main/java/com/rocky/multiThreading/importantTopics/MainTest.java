package com.rocky.multiThreading.importantTopics;


import com.rocky.multiThreading.CompletableFutureExample;

public class MainTest {

    public static void main(String[] args) throws Exception {
        System.out.println("===== Thread Lifecycle Example =====");
        ThreadLifecycleExample.main(null);

        System.out.println("\n===== Runnable vs Callable Example =====");
        RunnableCallableExample.main(null);

        System.out.println("\n===== Executor Example =====");
        ExecutorExample.main(null);

        System.out.println("\n===== CompletableFuture Example =====");
        CompletableFutureExample.main(null);

        System.out.println("\n===== Atomic Example =====");
        AtomicExample.main(null);

        System.out.println("\n===== ThreadLocal Example =====");
        ThreadLocalExample.main(null);

        System.out.println("\n===== Parallel Stream Example =====");
        ParallelStreamExample.main(null);

        System.out.println("\n===== Executor Shutdown Example =====");
        ExecutorShutdownExample.main(null);
        
        // Notes:
        // Some examples like SynchronizationExample, LockExample, DeadlockExample, LatchExample, Singleton are structural examples.
        // They either require manual trigger or are passive patterns, not runnable by main directly.
        // (These are kept for structure understanding, not direct invocation here.)
    }
}