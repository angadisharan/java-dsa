package org.matools.java.file;

import java.io.*;

public class ReadFileExample {
    public static void main(String[] args) {
        readFromBufferReaderFileReader();
        readFromFileInputStream();
        readWithOnlyStream();
    }

    private static void readFromBufferReaderFileReader() {
        System.out.println("_______________ readFromBufferReaderFileReader _____________");

        String filePath = "input.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = br.readLine()) != null) {
                String words[] = line.split("\s+");
                for (String word : words) {
                    System.out.println(word);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readFromFileInputStream() {
        System.out.println("_______________ readFromFileInputStream _____________");

        try (InputStream is = new FileInputStream("input.txt");
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readWithOnlyStream() {
        System.out.println("_______________ readWithOnlyStream _____________");

        try (InputStream is = new FileInputStream("input.txt")) {

            int data;

            while ((data = is.read()) != -1) {
                System.out.print((char) data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}