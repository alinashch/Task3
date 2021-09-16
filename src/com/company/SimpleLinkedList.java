package com.company;

import java.util.Iterator;

public class SimpleLinkedList<T> implements Iterable<T> {

    private class ListNode<T> {
        public T value;
        public ListNode<T> next;

        public ListNode(T value, ListNode<T> next) {
            this.value = value;
            this.next = next;
        }
        public ListNode(T value) {
            this(value, null);
        }
        public ListNode() {
            this(null);
        }
    }

    private ListNode<T> head = null;
    private ListNode<T> tail = null;

    private int count = 0;


    public void addLast(T value) {
        ListNode<T> newNode = new ListNode<>(value);
        if (count > 0) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
        count++;
    }

    private void emptyError() throws Exception {
        if (count == 0) {
            throw new Exception("List is empty");
        }
    }

    public T getFirst() throws Exception {
        emptyError();
        return head.value;
    }

    public int Count() {
        return count;
    }
    private ListNode<T> getNode(int index) throws Exception {
        if (index < 0 || index >= count) {
            throw new Exception("Wrong index");
        }
        ListNode<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public T get(int index) throws Exception {
        return getNode(index).value;
    }

    public T removeFirst() throws Exception {
        T value = getFirst();
        head = head.next;
        count--;
        if (count == 0) {
            tail = null;
        }
        return value;
    }

    public int getCount() {
        return count;
    }


    @Override
    public Iterator<T> iterator() {
        class LinkedListIterator implements Iterator<T> {
            ListNode<T> curr;

            public LinkedListIterator(ListNode<T> head) {
                curr = head;
            }

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T result = curr.value;
                curr = curr.next;
                return result;
            }
        }

        return new LinkedListIterator(head);
    }
}
