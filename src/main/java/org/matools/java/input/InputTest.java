package org.matools.java.input;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InputTest {
    public static void main(String args[]) {
        try {
            Scanner s = new Scanner(System.in);
            System.out.print("Enter input count: ");
            if (s.hasNextLine()) {
                String countString = s.nextLine();
                int count = Integer.parseInt(countString);
                while (count != 0) {
                    System.out.format("Enter input %d: ", count);
                    s.nextLine();
                    count--;
                }
            }




        } catch (Exception e) {

        }

    }
}