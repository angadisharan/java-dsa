package org.matools.java.thread.adders;

import java.util.concurrent.atomic.LongAdder;

public class LongAdderExample {

    private static final LongAdder counter = new LongAdder();

    public static void main(String[] args) {

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(task).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(counter.sum());
    }
}