package com.company;

public interface SimpleQueue<T> {
    void add(T value);
    T remove() throws Exception;
    T element() throws Exception;
    default int size() {
        return 0;
    }
    T GetIndex(int i);
}
