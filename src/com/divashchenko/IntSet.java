package com.divashchenko;

public interface IntSet {
    void clear();

    boolean contains(Integer key);

    boolean isEmpty();

    void put(Integer key);

    void remove(Integer key);

    int size();
}
