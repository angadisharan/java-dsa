package org.matools.java.files;

import java.io.RandomAccessFile;

public class RAFExample {
    public static void main(String[] args) throws Exception {

        RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");

        raf.writeBytes("Hello World"); // write initial data

        raf.seek(6); // move pointer to position 6
        raf.writeBytes("Java"); // overwrite "World"

        raf.seek(0); // go back to start

        String line = raf.readLine();
        System.out.println(line);

        raf.close();
    }
}