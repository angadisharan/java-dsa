package org.matools.java.test;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class TestCode {
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger();
        integer.incrementAndGet();

        LongAdder longAdder = new LongAdder();
        longAdder.add(1);

        System.out.println(Math.abs(-9));
    }
}
