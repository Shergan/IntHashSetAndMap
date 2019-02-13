package com.divashchenko;

import java.util.Set;

public interface IntMap {
    void clear();

    boolean containsKey(int key);

    boolean containsValue(int value);

    int get(int key);

    boolean isEmpty();

    void put(int key, int value);

    void remove(int key);

    int size();

    Set<Integer> keySet();
}
