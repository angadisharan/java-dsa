package org.matools.java.string;

public class TestString {

    public static void main(String[] args) {
        String s = "Hello";

        StringBuilder stringBuilder = new StringBuilder(s);

        stringBuilder.setCharAt(0, 'h');

        System.out.println(stringBuilder.toString());

        System.out.println(21 / 10);
    }

}
