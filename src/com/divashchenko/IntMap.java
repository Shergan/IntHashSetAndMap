package com.divashchenko;

public interface IntMap {
    void clear();

    boolean containsKey(Integer key);

    boolean containsValue(Integer value);

    int get(Integer key);

    boolean isEmpty();

    void put(Integer key, Integer value);

    void remove(Integer key);

    int size();

    IntHashSet keySet();
}
