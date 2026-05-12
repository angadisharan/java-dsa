package org.matools.java.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounterExample {

    private int count = 0;

    // true = fair lock (FIFO style)
    private final ReentrantLock lock = new ReentrantLock(true);

    public void increment() {
        lock.lock(); // acquire lock
        try {
            count++;
            System.out.println(Thread.currentThread().getName()
                    + " -> " + count);
        } finally {
            lock.unlock(); // always unlock in finally
        }
    }

    public void demoTryLock() {
        if (lock.tryLock()) {
            try {
                System.out.println("Lock acquired");
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Could not acquire lock");
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {

        ReentrantLockCounterExample counter = new ReentrantLockCounterExample();

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                counter.increment();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

        counter.demoTryLock();
    }
}