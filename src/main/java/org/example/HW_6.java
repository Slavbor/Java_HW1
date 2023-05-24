package org.example;

import java.util.*;

public class HW_6 {
    public static void main(String[] args) {

        TreeClass TreeSet = new TreeClass();

        for (int i = 0; i < 15; i++) {
            TreeSet.add(new Random().nextInt(-40, 40));
        }

        String string_with_set = TreeSet.toString();
        System.out.println(string_with_set);

        System.out.println(TreeSet.getItem(new Random().nextInt(TreeSet.size())));

    }
}


class TreeClass {

    static final Object OBJECT = new Object();
    private final TreeMap<Integer, Object> treeMap = new TreeMap<>();

    public void add(int num) {
        treeMap.put(num, OBJECT);
    }

    public Integer getItem(int index) {
        return (Integer) treeMap.keySet().toArray()[index];
    }

    public String toString() {
        return treeMap.keySet().toString();
    }

    public Integer size() {
        return treeMap.size();
    }
}
