package org.matools.java.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteAppendExample {
    public static void main(String[] args) throws IOException {
        fileWriter();
        bufferedWriter();
    }

    private static void fileWriter() throws IOException {
        FileWriter fw = new FileWriter("file.txt", true); // true = append
        fw.write("Hello, World!\n");
        fw.write("Writing to file using FileWriter");

        fw.close();
    }

    private static void bufferedWriter() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt"));

        bw.write("Hello");
        bw.newLine();
        bw.write("Buffered write example");

        bw.close();
    }

    public static void printWriter() throws Exception {

        PrintWriter pw = new PrintWriter("file.txt");

        pw.println("Hello");
        pw.println("Easy writing with PrintWriter");

        pw.close();
    }
}