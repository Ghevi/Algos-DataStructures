package com.ghevi.ads.hashes;

import com.ghevi.ads.linkedlists.LinkedList;

import java.util.Iterator;

public class Hash<K, V> implements Iterable<K> {

    @Override
    public Iterator iterator() {
        return new IteratorHelper();
    }

    // It has O(n)
    class IteratorHelper<T> implements Iterator<T>{

        T[] keys;
        int position;

        public IteratorHelper(){
            keys = (T[]) new Object[numElements];
            int p = 0;

            for(int i = 0; i < tableSize; i++){
                LinkedList<HashElement<K, V>> list = hashArray[i];

                for(HashElement<K, V> h : list){
                    keys[p++] = (T) h.key;
                }

                position = 0;
            }
        }

        @Override
        public boolean hasNext() {
            return position < keys.length;
        }

        @Override
        public T next() {
            if(!hasNext())
                return null;

            return keys[position++];
        }

    } // inner class, custom iterator

    class HashElement<K, V> implements Comparable<HashElement<K, V>> {

        K key;
        V value;

        public HashElement(K key, V value){
            this.key = key;
            this.value = value;
        }

        // As said in the notes, what being the same means is something
        // we get to decide, for example the two compared elements must
        // have their keys or values the same.
        // In this example the keys must be the same
        @Override
        public int compareTo(HashElement<K, V> o) { // o = other
            return (((Comparable<K>)o.key).compareTo(this.key)); // The cast ensure that if someone wants to add a key
                                                                 // to our hash, their key has to have a compareTo method.
        }
    } // inner class, the data

    int numElements; // current size
    int tableSize; // size of the array

    double maxLoadFactor; // the point where to resize

    LinkedList<HashElement<K, V>>[] hashArray; // the array with generics elements

    // How to create a generic array
    // k[] keys = (K[]) new Object[10];

    public Hash(int tableSize){
        this.tableSize = tableSize;
        hashArray = (LinkedList<HashElement<K, V>> []) new LinkedList[tableSize];

        // Initialize every position in the array with an empty linked list
        for(int i = 0; i < tableSize; i++){
            hashArray[i] = new LinkedList<HashElement<K, V>>();
        }

        maxLoadFactor = 0.75;
        numElements = 0;
    }

    public boolean add(K key, V value){
        if(loadFactor() > maxLoadFactor){
            resize(tableSize * 2);
        }

        HashElement<K, V> hashElement = new HashElement<>(key, value);

        hashArray[calculateHashIndex(key, tableSize)].addFirstWithTail(hashElement); // We could use addFirst, fasterAddLast, doesn't matter.

        numElements++;

        return true;
    }

    public boolean remove(K key){
        hashArray[calculateHashIndex(key, tableSize)].removeFirst(); // If we use findAndRemove we must provide the hashElement as an argument

        numElements--;

        return true;
    }

    public V getValue(K key){
        // this is done via the method calculateHashIndex
        // int hashIndex = key.hashCode() & 0x7FFFFFFF % tableSize;

        for(HashElement<K, V> hashElement : hashArray[calculateHashIndex(key, tableSize)]){
            if(((Comparable<K>)key).compareTo(hashElement.key) == 0){
                return hashElement.value;
            }
        }

        return null;
    }

    public void resize(int newSize){
        LinkedList<HashElement<K, V>>[] newHashArray = (LinkedList<HashElement<K, V>>[]) new LinkedList[newSize];

        for(int i = 0; i < newSize; i++){
            newHashArray[i] = new LinkedList<HashElement<K, V>>();
        }

        // DONE: implements a custom iterator
        // We cant use this block because to use this class (the "this"), this hash class must implement and iterator
        // Now this is usable

        for(K key : this){
            V value = getValue(key);
            HashElement<K, V> hashElement = new HashElement<K, V>(key, value);
        }

        /* TO REMOVE: comment this block after implementing the custom iterator
           This way of doing it without iterator is important anyway!!

        for (LinkedList<HashElement<K, V>> linkedList : hashArray) {
            for (HashElement<K, V> element : linkedList) {
                newHashArray[calculateHashIndex(element.key, newSize)].addFirstWithTail(element);
            }
        }
         */

        hashArray = newHashArray;
        tableSize = newSize;


    }

    public double loadFactor(){
        double loadFactor = (double) numElements / tableSize;

        return loadFactor;
    }


    public int calculateHashIndex(K key, int newOrTableSize){ // hash index and hash value are both correct names, but index is more precise if that makes sense
        int hashValue = key.hashCode();

        hashValue = hashValue & 0x7FFFFFFF;
        hashValue = hashValue % newOrTableSize; // now hashValue contains the index of the array where to add the element

        return hashValue;
    }
}



























