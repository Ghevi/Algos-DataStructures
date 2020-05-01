package com.ghevi.ads.linkedlists;

import java.util.ListIterator;

public class Tester {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<Integer>();
        int n = 10;

        for (int i = 0; i < n; i++)
            list.addFirstWithTail(i);


        int removedFirst = list.removeFirst();
        int removedLast = list.removeLast();

        for(int x : list){
            System.out.println(x);
        }
    }
}

