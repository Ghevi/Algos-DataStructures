package com.ghevi.ads.hashes;

import com.ghevi.ads.linkedlists.LinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class Hash<K, V> {

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

    LinkedList<HashElement<K, V>> [] hashArray; // the array with generics elements

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
}
