package org.vthreads;

import java.util.Random;

public class ThreadComparison {

  private final static boolean vThreads = false;
  private final static Random random = new Random();

  public static void main(String[] args) {

    System.out.println( "Using vThreads: " + vThreads);

    Runnable runnable = () -> {
      double i = random.nextDouble(1000) % random.nextDouble(1000);
    };

    long start = System.currentTimeMillis();

    for (int i = 0; i < 50000; i++) {
      if (vThreads) {
        Thread.startVirtualThread(runnable);
      } else {
        new Thread(runnable).start();
      }
    }

    long finish = System.currentTimeMillis();

    long timeElapsed = finish - start;
    System.out.println("Run time: " + timeElapsed + "ms");
  }
}