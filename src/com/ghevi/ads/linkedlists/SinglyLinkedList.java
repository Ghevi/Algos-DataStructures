package com.ghevi.ads.linkedlists;

import java.util.ListIterator;

// Notes below

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
    private Node<E> tail;
    private int currentSize;

    public SinglyLinkedList(){
        head = null;
        tail = null;
        currentSize = 0;
    }

    public void addFirst(E obj){
        Node<E> node = new Node<E>(obj);

        // The order of these 2 lines is fundamental
        node.next = head;
        head = node;

        currentSize++;
    }

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
    }

    // Interface methods

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

/* Complexity of counting the size of the list would be: θ(n) aka Theta of n because we have to count exactly n elements.
   So we get to know the currentSize. But if we keep track of the currentSize,
   then the complexity to know the size get reduced to O(1) aka constant time,
   because we just need to add or subtract from the currentSize when we add or remove a node.

   BOUNDARY CONDITIONS:
   Empty data structure -> worries : adding last(nullPExc)
   Single element in the data structure
   Adding or removing from the beginning of the data structure
   Adding or removing from the ending of the data structure
   Working in the middle

   ADDING FIRST:
   head is null when the linked list is empty. In order to add a node, we have to assign the memory address
   of the A node to the head, meaning that the head variable will be a pointer to A node.
   If we want to add a new node B AS THE FIRST NODE, so before A, we will do the same process. The head variable will
   point to B node and now, nothing will point to A node anymore, so it will be a candidate for garbage collection.
   BUT WAIT!! We don't want A to be garbage collected. So what we do instead is we let the variable head point to A
   and make the variable next of node B point to A, before anything else, so we don't lose the reference to A.
   Now we can finally assign to head the reference to B.

   The complexity of adding first to a linked list, so, is just 1 because i don't need to traverse the list.
   When adding first we don't need to worry of null pointer exception because we are just assigning null to the
   A node next, which ofc doesn't cause any trouble.

   ADDING LAST:
   Since we have assigned node to head, if we have a linked list of 3 nodes, we could write
   head.next.next.next = node;
   where node is the node we adding at the end of the list. But this isn't feasible if the list will contain a lots of nodes.

   So instead we add a temporary pointer called tmp which will point to the head (node A for example).
   Now we check if(tmp.next != null) then we will have tmp = tmp.next; tmp will point to node B.
   We check again then we will make tmp point to node C. We check again and now tmp.next is indeed null.
   So we can add a new node called D and we make tmp.next point to it and ALSO the C node.next will point to D.
   Finally we increase the currentSize;
   We do this in a while loop.

   We have to worry when we have an empty list about the null pointer exception because we have temp.next which is null.
   So we check if head == null right after creating the new node, we assign node to head, we increment the currentSize and
   finally we return; out of the addLast method.
   The complexity of adding last is O(n) because of the while loop, we are traversing the whole list.

   To reduce this, we can use another pointer called tail that points to the last node of the list,
   so the complexity becomes O(1). We add a global variable called tail that at first is null.
   When we add a last node with this faster method, we have to make tail equal to the node if the head is equal to null.
   If not then we make tail.next = node, tail = node and increment size.
   We also needs to modify the addFirst method in order for the tail to point to the added node aswell as the head if the list is empty.
*/




















