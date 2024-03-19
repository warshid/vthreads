package org.vthreads;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.startVirtualThread;

public class TwelveMillion {

    private final static Random random = new Random();

    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("hello world!");
        long start = System.currentTimeMillis();
        startVirtualThreads();
        long finish = System.currentTimeMillis();
        System.out.println("main ended");
        long timeElapsed = finish - start;
        System.out.println("Run time: " + timeElapsed + "ms");
    }

    private static void startVirtualThreads() throws InterruptedException {
        var threads = new ArrayList<Thread>();
        for (int i = 0; i < 12_000_000; i++) {
            var thread = startVirtualThread(() -> {
                double v = random.nextDouble(1000) % random.nextDouble(1000);
            });
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }
}