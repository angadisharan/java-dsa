package org.matools.java.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class InputBuffered {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter name: ");
        String name = br.readLine();

        System.out.print("Enter age: ");
        int age = Integer.parseInt(br.readLine());

        System.out.println(name + " " + age);
    }
}