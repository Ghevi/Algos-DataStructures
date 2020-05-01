package com.ghevi.ads.linkedlists;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// Notes at Notes/Singly&Doubly LinkedList.txt

public class DoublyLinkedList<E> implements Iterable<E> {

    @Override
    public Iterator<E> iterator() {
        return new IteratorHelper();
    }

    class IteratorHelper implements ListIterator<E>{

        Node<E> index;

        public IteratorHelper(){
            index = head;
        }

        // Return true if there is an element to return at the pointer
        @Override
        public boolean hasNext() {
            return (index != null);
        }

        // Return the element where the pointer is and move the pointer to the next element
        @Override
        public E next() {
            if(!hasNext())
                throw new NoSuchElementException();

            E val = index.data;
            index = index.next;

            return val;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public E previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {

        }

        /* For version older than java 1.8
        public void remove(){
            throw new UnsupportedOperationException();
        }

        public void forEachRemaining(){};
        */

    } // inner class (can only be accessed by the outer class)

    class Node<E> {

        E data;
        Node<E> next;
        Node<E> previous;

        public Node(E obj){
            data = obj;
            next = null;
        }
    } // inner class (can only be accessed by the outer class)

    private Node<E> head;
    private Node<E> previous;
    private Node<E> tail;
    private int currentSize;

    public DoublyLinkedList(){
        head = null;
        previous = null;
        tail = null;
        currentSize = 0;
    }

    // O(1)
    public void addFirst(E obj){
        Node<E> node = new Node<E>(obj);

        // The order of these 2 lines is fundamental
        node.next = head;
        head.previous = node;
        head = node;

        currentSize++;
    }

    // O(1)
    public void addFirstWithTail(E obj){
        Node<E> node = new Node<E>(obj);

        if(head == null){
            head = tail = node;
            return;
        }

        // The order of these 2 lines is fundamental
        node.next = head;
        head = node;

        currentSize++;
    }

    // O(n)
    public void slowAddLast(E obj){
        Node<E> node = new Node<E>(obj);

        if(head == null){
            head = tail = node;
            currentSize++;
            return;
        }

        Node<E> tmp = head;

        while(tmp.next != null){
            tmp = tmp.next;
        }

        tmp.next = node;
        currentSize++;
    }

    // O(1)
    public void fasterAddLast(E obj){
        Node<E> node = new Node<E>(obj);

        if(head == null){
            head = tail = node;
            currentSize++;
            return;
        }

        tail.next = node;
        tail = node;

        currentSize++;
    }

    public E removeFirst(){

        if(head == null){
            return null;
        }

        E tmp = head.data;

        if(head == tail){
            head = tail = null;
        } else {
            head = head.next;
        }

        currentSize--;
        return tmp;
    }

    public E removeLast(){
        if(head == null){
            return null;
        }

        if(head == tail){
            return removeFirst();
        }

        Node<E> current = head; // Can also write Node<E> current = head, previous = null;
        Node<E> previous = null;

        while(current != tail){
            // The order is crucial
            previous = current;
            current = current.next;
        }

        previous.next = null;
        tail = previous;
        currentSize--;

        return current.data;
    }

    // TO DO
    public E findAndRemove(E obj){
        Node<E> current = head, previous = null;

        // In an empty list current = null so we skip to the last line
        while(current != null){
            if(((Comparable<E>)obj).compareTo(current.data) == 0){

                // Beginning or single element
                if(current == head)
                    return removeFirst();

                // Ending of the list
                if(current == tail)
                    return removeLast();

                currentSize--;

                // Removing the reference to the node to delete
                previous.next = current.next;

                return current.data;
            }
            previous = current;
            current = current.next;
        }
        // Node not found
        return null;
    }

    // TO DO
    public void insert(E obj){

    }

    public boolean contains(E obj){
        Node<E> current = head;

        while(current != null) {
            if(((Comparable<E>) obj).compareTo(current.data) == 0)
                return true;

            current = current.next;
        }
        return false;
    }

    public E peekFirst(){
        if(head == null)
            return null;

        return head.data;
    }

    public E peekLast(){
        if(tail == null)
            return null;

        return tail.data;
    }


    // Interface methods



}




















