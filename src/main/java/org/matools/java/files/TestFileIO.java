package org.matools.java.files;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class TestFileIO {

    public static void main(String[] args) {
        try {
            String fileName = "test.txt";

            // 🔹 WRITE to file
            FileOutputStream fos = new FileOutputStream(fileName);
            String data = "Hello Java File IO";
            fos.write(data.getBytes());
            fos.close();

            System.out.println("Data written to file.");

            // 🔹 READ from file
            FileInputStream fis = new FileInputStream(fileName);

            int ch;
            System.out.print("Data read from file: ");
            while ((ch = fis.read()) != -1) {
                System.out.print((char) ch);
            }

            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}