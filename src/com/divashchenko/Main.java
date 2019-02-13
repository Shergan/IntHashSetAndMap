package com.divashchenko;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println("IntHashMap tests");
        System.out.println("===================================================");
        System.out.println();

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


        IntHashSet testSet = intHashMap.keySet();

        System.out.println("Sout IntHashSet keySet:");
        System.out.println(testSet);
        System.out.println();

        System.out.println("Is empty? " + intHashMap.isEmpty());
        System.out.println("Clear!");
        intHashMap.clear();
        System.out.println("And now? " + intHashMap.isEmpty());

        System.out.println();
        System.out.println();
        System.out.println("IntHashSet tests");
        System.out.println("===================================================");
        System.out.println();

        IntHashSet intHashSet = new IntHashSet();
        intHashSet.put(10);
        intHashSet.put(20);
        intHashSet.put(30);
        intHashSet.put(40);
        intHashSet.put(50);
        intHashSet.put(50);
        intHashSet.put(70);

        System.out.println(intHashSet);
        System.out.println("Remove 20");
        intHashSet.remove(20);
        System.out.println(intHashSet);
        System.out.println();

        System.out.println("Contains 10? " + intHashSet.contains(10));
        System.out.println("Contains 20? " + intHashSet.contains(20));

        System.out.println("Size " + intHashSet.size());

        System.out.println("Is empty? " + intHashSet.isEmpty());
        System.out.println("Clear!");
        intHashSet.clear();
        System.out.println("And now? " + intHashSet.isEmpty());
    }
}
