package org.matools.java.thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {


    static Map<String, Long> cache = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        // Add some cache data (expiry time)
        cache.put("user1", System.currentTimeMillis() + 5000); // expires in 5 sec
        cache.put("user2", System.currentTimeMillis() + 10000);

        // Daemon thread for cleanup
        Thread cleaner = new Thread(() -> {
            while (true) {
                long now = System.currentTimeMillis();

                cache.entrySet().removeIf(entry -> entry.getValue() < now);

                System.out.println("Cache after cleanup: " + cache);

                try {
                    Thread.sleep(2000); // run every 2 sec
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        cleaner.setDaemon(true); // 👈 important
        cleaner.start();

        // Main thread simulating app work
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished");
    }

}
