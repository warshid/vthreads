package org.vthreads;

import lombok.SneakyThrows;

import java.util.ArrayList;

import static java.lang.Thread.sleep;
import static java.lang.Thread.startVirtualThread;

public class OneMillion {

    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("hello world!");
        long start = System.currentTimeMillis();
        startVirtualThreads_1_Million();
        long finish = System.currentTimeMillis();
        System.out.println("main ended");
        long timeElapsed = finish - start;
        System.out.println("Run time: " + timeElapsed + "ms");
    }

    private static void startVirtualThreads_1_Million() throws InterruptedException {
        var threads = new ArrayList<Thread>();
        for (int i = 0; i < 1_000_000; i++) {
            var thread = startVirtualThread(() -> {
//                System.out.println(Thread.currentThread());
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Exception Occurred: " + e.getMessage());
                }
            });
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }
}