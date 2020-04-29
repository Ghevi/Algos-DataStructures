package com.ghevi.ads.linkedlists;

import java.util.ListIterator;

/* Complexity of going trough the list for, as an example, counting the size of the list would be: θ(n) aka
   Theta of n because we have to count exactly n elements. So we get to know the currentSize.
   But if we keep track of the currentSize, then the complexity get reduced to O(1) aka constant time, because
   we just need to add or subtract from the currentSize when we add or remove a node.
*/
public class SinglyLinkedList<E> implements ListIterator<E> {

    class Node<E> {

        E data;
        Node<E> next;

        public Node(E obj){
            data = obj;
            next = null;
        }
    } // inner class (can only be accessed by the outer class)

    private Node<E> head;
    private int currentSize;

    public SinglyLinkedList(){
        head = null;
        currentSize = 0;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public E next() {
        return null;
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

}
