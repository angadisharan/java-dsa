package org.matools.java.map;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("sdf");

        Set<Integer> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();

        map.put("a", 1);
        map.put("b", 1);
        map.put("c", 1);
        System.out.println(map);

        map.forEach((k, v) -> {
            if (k.equals("a")) {
                return;
            }
            System.out.println(k);
        });


        set.add(12);
        set.add(2);

        for(Integer i: set) {
            if (i == 2) {
                break;
            }
        }

    }
}
