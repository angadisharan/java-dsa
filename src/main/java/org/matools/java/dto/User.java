package org.matools.java.dto;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    public String name;
    public int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}