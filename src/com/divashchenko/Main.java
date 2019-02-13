package com.divashchenko;

import java.util.HashMap;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.keySet();

        IntHashMap intHashMap = new IntHashMap();

        intHashMap.put(17, 5);
        intHashMap.put(6, 54);
        intHashMap.put(5, 324);
        intHashMap.put(5, 55);
        intHashMap.put(26, 66);
        intHashMap.put(7, 12);
        intHashMap.put(103, 1);
        intHashMap.put(245, 2);
        intHashMap.put(23, 3);
        intHashMap.put(11, 4);
        intHashMap.put(12, 5);
        intHashMap.put(13, 5);
        intHashMap.put(14, 5);
        intHashMap.put(15, 5);
        intHashMap.put(16, 5);
        intHashMap.put(17, 5);

        System.out.println("ContainsValue 54: " + intHashMap.containsValue(54));
        System.out.println("ContainsValue 14: " + intHashMap.containsValue(14));

        System.out.println("Get from key 7: " + intHashMap.get(7));

        System.out.println("Size is: " + intHashMap.size());

        System.out.println();
        System.out.println(intHashMap);
        System.out.println("Remove key 6");
        intHashMap.remove(6);
        System.out.println(intHashMap);
        System.out.println();


        Set<Integer> test = intHashMap.keySet();

        System.out.println("Sout keySet:");
        System.out.println(test);
        System.out.println();

        System.out.println("Is empty? " + intHashMap.isEmpty());
        System.out.println("Clear!");
        intHashMap.clear();
        System.out.println("And now? " + intHashMap.isEmpty());
    }
}
