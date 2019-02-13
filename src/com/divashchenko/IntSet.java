package com.divashchenko;

public interface IntSet {
    void clear();

    boolean contains(int key);

    boolean isEmpty();

    void put(int key);

    void remove(int key);

    int size();
}
