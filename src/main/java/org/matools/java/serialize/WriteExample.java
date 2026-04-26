package org.matools.java.serialize;


import org.matools.java.dto.User;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteExample {
    public static void main(String[] args) throws Exception {

        User user = new User("Sharan", 25);

        ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream("user.ser"));

        oos.writeObject(user);
        oos.close();

        System.out.println("Object written to file");
    }
}