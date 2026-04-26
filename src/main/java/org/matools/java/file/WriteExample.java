package org.matools.java.file;

import java.io.FileWriter;
import java.io.IOException;

public class WriteExample {
    public static void main(String[] args) throws IOException {

        FileWriter fw = new FileWriter("file.txt");
        fw.write("Hello, World!\n");
        fw.write("Writing to file using FileWriter");

        fw.close();
    }
}