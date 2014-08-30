package com.github.fedeoasi.lists;

public class ListNode<T> {
    T elem;
    ListNode<T> next;

    public ListNode(T elem) {
        this.elem = elem;
        this.next = next;
    }

    public T elem() {
        return elem;
    }

    public ListNode<T> next() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }
}
