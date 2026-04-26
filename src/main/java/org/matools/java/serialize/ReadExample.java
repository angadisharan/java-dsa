package org.matools.java.serialize;

import org.matools.java.dto.User;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadExample {
    public static void main(String[] args) throws Exception {

        ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream("user.ser"));



        User user = (User) ois.readObject();
        ois.close();

        System.out.println("Name: " + user.name);
        System.out.println("Age: " + user.age);
    }
}