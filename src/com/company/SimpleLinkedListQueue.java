package com.company;

import java.util.Iterator;

public class SimpleLinkedListQueue<T>
        extends SimpleLinkedList<T> implements SimpleQueue<T>

    {
        @Override
        public void add (T value){
        addLast(value);
    }

        @Override
        public T remove () throws Exception {
        return removeFirst();
    }

        @Override
        public T element () throws Exception {
        return getFirst();
    }
        @Override
        public int size () {
        return Count();
    }
    @Override
        public T GetIndex(int i){
        try {
            return get(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
