import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class CounterBenchMark {

    static final int THREADS = 1000;
    static final int INCREMENTS = 10000;

    public static void main(String[] args) throws InterruptedException {
        testAtomicInteger();
        testLongAdder();
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
