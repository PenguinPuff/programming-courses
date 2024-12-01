package de.tum.cit.ase;

import java.util.List;

public class ListNode<T> {
    // TODO 2.1 Add attributes
    private T value;
    private ListNode<T> previous;
    private ListNode<T> next;

    // TODO 2.1 Add 3 constructors as in the problem statement
    public ListNode(){
        this.value = null;
        this.previous = null;
        this.next = null;
    }

    public ListNode(T value){
        this.value = value;
        this.previous = null;
        this.next = null;
    }

    public ListNode(T value, ListNode<T> previous, ListNode<T> next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }

    // TODO 2.1 Add getters and setters
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ListNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(ListNode<T> previous) {
        this.previous = previous;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }
}
