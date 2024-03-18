package org.vthreads;

import lombok.SneakyThrows;

import java.util.ArrayList;

import static java.lang.Thread.sleep;
import static java.lang.Thread.startVirtualThread;

public class Main {

    private static final int ONE_MILLION_DOLLARS = 1000000;

    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("Hello world!");
        startVirtualThreads_1_Million();
    }

    private static void startVirtualThreads_1_Million() throws InterruptedException {
        var threads = new ArrayList<Thread>(ONE_MILLION_DOLLARS);
        for (int i = 0; i < ONE_MILLION_DOLLARS; i++) {
            var thread = startVirtualThread(() -> {
                System.out.println(Thread.currentThread());
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