package org.matools.java.thread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    private int value = 0;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {

        lock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName()
                    + " reading value: " + value);

            Thread.sleep(1000);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void write(int newValue) {

        lock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName()
                    + " writing value: " + newValue);

            Thread.sleep(1000);

            value = newValue;

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {

        ReadWriteLockExample obj = new ReadWriteLockExample();

        Runnable readTask = obj::read;

        Runnable writeTask = () -> obj.write((int) (Math.random() * 100));

        Thread r1 = new Thread(readTask, "Reader-1");
        Thread r2 = new Thread(readTask, "Reader-2");
        Thread r3 = new Thread(readTask, "Reader-3");

        Thread w1 = new Thread(writeTask, "Writer-1");

        r1.start();
        r2.start();
        r3.start();
        w1.start();
    }
}