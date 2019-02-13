package com.divashchenko;

public class IntHashSet implements IntSet {

    private IntHashMap map = new IntHashMap();

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean contains(Integer key) {
        return map.containsKey(key);
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public void put(Integer key) {
        map.put(key, null);
    }

    @Override
    public void remove(Integer key) {
        map.remove(key);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(map.toString());

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '=') {
                sb.delete(i - 1, i + 6); //delete " = null"
            }
        }

        return sb.toString();
    }
}
