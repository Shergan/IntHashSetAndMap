package com.divashchenko;

import java.util.HashSet;
import java.util.Set;

public class IntHashMap implements IntMap {

    private class Entry {
        int key;
        int value;
        Entry next;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry[] table = new Entry[16];
    private double loadFactor = 0.75;
    private int threshold = (int) (loadFactor * table.length);
    private int size;


    @Override
    public void clear() {
        table = new Entry[16];
        size = 0;
    }

    @Override
    public boolean containsKey(int key) {
        Entry tmp = findEntry(key);
        return tmp != null;
    }

    @Override
    public boolean containsValue(int value) {
        for (Entry entry : table) {
            if (entry != null) {
                if (entry.value == value) {
                    return true;
                }
                if (entry.next != null) {
                    Entry tmp = entry;
                    while (tmp.next != null) {
                        tmp = entry.next;
                        if (tmp.value == value) {
                            return true;
                        }
                    }
                }
            }

        }

        return false;
    }

    @Override
    public int get(int key) {
        if (!containsKey(key)) {
            return -1;
        }

        Entry tmp = findEntry(key);
        return tmp.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void put(int key, int value) {
        if (containsKey(key)) {
            findEntry(key).value = value;
        } else {
            addEntry(key, value);
            size++;

            if (size > threshold) {
                resize();
            }
        }
    }

    @Override
    public void remove(int key) {
        if (containsKey(key)) {
            int keyHash = indexFor(key, table);


            if (table[keyHash].key == key) {
                table[keyHash] = table[keyHash].next;
            } else {
                Entry previousEntry = table[keyHash];
                Entry nextEntry = table[keyHash].next;

                while (nextEntry != null) {
                    if (nextEntry.key == key) {
                        nextEntry = nextEntry.next;
                        previousEntry.next = nextEntry;
                    } else {
                        previousEntry = nextEntry;
                        nextEntry = nextEntry.next;
                    }
                }
            }

            size--;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Set<Integer> keySet() {
        Set<Integer> keySet = new HashSet<>();

        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                Entry tmp = table[i];
                while (tmp != null) {
                    keySet.add(tmp.key);
                    tmp = tmp.next;
                }
            }
        }

        return keySet;
    }

    private int indexFor(int key, Entry[] table) {
        return key & (table.length - 1);
    }

    private void addEntry(int key, int value) {
        Entry entry = new Entry(key, value);
        addToTable(entry, table);
    }

    private void addToTable(Entry entry, Entry[] table) {
        int keyHash = indexFor(entry.key, table);

        if (table[keyHash] == null) {
            table[keyHash] = entry;
        } else {
            entry.next = table[keyHash];
            table[keyHash] = entry;
        }
    }

    private Entry findEntry(int key) {
        int keyHash = indexFor(key, table);

        if (table[keyHash] != null && table[keyHash].key == key) {
            return table[keyHash];
        } else {
            Entry entry = table[keyHash];
            while (entry != null) {
                if (entry.key == key) {
                    return entry;
                }
                entry = entry.next;
            }
        }

        return null;
    }

    private void resize() {
        int newSize = table.length * 2;
        Entry[] newTable = new Entry[newSize];

        transfer(newTable);

        table = newTable;
        threshold = (int) (loadFactor * table.length);
    }

    private void transfer(Entry[] newTable) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                Entry tmp = table[i];
                Entry tmpNext;

                while (tmp != null) {
                    tmpNext = tmp.next;
                    tmp.next = null;
                    addToTable(tmp, newTable);
                    tmp = tmpNext;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                Entry tmp = table[i];
                while (tmp != null) {
                    sb.append(tmp.key).append(" = ").append(tmp.value).append(", ");
                    tmp = tmp.next;
                }
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");

        return sb.toString();
    }
}
