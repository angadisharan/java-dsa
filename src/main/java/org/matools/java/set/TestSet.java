package org.matools.java.set;

import java.util.HashMap;
import java.util.HashSet;

public class TestSet {
    public static void main(String[] args) {
        HashSet<Student> studentList = new HashSet<>();

        Student st1 = new Student("A", 1);
        Student st2 = new Student("B", 2);
        Student st3 = new Student("C", 3);
        Student st4 = new Student("D", 3);
        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);
        studentList.add(st4);

        System.out.println(studentList.size());
        st1.id = 3;
        System.out.println(studentList.size());

        System.out.println(studentList.contains(new Student("A", 1)));
        for (Student s: studentList) {
            System.out.println(s);
        }
    }

}
