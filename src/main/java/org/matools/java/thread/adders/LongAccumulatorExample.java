package org.matools.java.thread.adders;

import java.util.concurrent.atomic.LongAccumulator;

public class LongAccumulatorExample {

    // Keep maximum value
    private static final LongAccumulator maxAccumulator =
            new LongAccumulator(Long::max, Long.MIN_VALUE);

    public static void main(String[] args) {

        Runnable task1 = () -> {
            maxAccumulator.accumulate(10);
            maxAccumulator.accumulate(50);
        };

        Runnable task2 = () -> {
            maxAccumulator.accumulate(20);
            maxAccumulator.accumulate(100);
        };

        new Thread(task1).start();
        new Thread(task2).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Max Value: " + maxAccumulator.get());
    }
}