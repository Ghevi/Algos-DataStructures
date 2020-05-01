package com.ghevi.ads.linkedlists;

import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

public class Tester {

    public static void main(String[] args) throws InterruptedException {

        LinkedList<Integer> list = new LinkedList<Integer>();
        int n = 100000;

        long startTime = System.nanoTime();

        for (int i = 0; i < n; i++)
            list.fasterAddLast(i);

        long stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);

        long elapsedTimeInSecond = TimeUnit.MILLISECONDS.convert(stopTime - startTime, TimeUnit.NANOSECONDS);
        System.out.println(elapsedTimeInSecond + " milliseconds");

        System.out.println();

        LinkedList<Integer> list2 = new LinkedList<Integer>();
        int n2 = 100000;

        long startTime2 = System.nanoTime();

        for (int i = 0; i < n; i++)
            list2.slowAddLast(i);

        long stopTime2 = System.nanoTime();
        System.out.println(stopTime2 - startTime2);

        long elapsedTimeInSecond2 = TimeUnit.MILLISECONDS.convert(stopTime2 - startTime2, TimeUnit.NANOSECONDS);
        System.out.println(elapsedTimeInSecond2 + " milliseconds");

        System.out.println();


        // This is for printing the list
        // for(int x : list){
        //     System.out.println(x);
        // }

        // This is just when I was figuring out how to calculate the elapsed time of execution
        long startTime1 = System.nanoTime();
        Thread.sleep(2000);
        long stopTime1 = System.nanoTime();

        System.out.println(stopTime1 - startTime1);

        long elapsedTimeInSecond1 = TimeUnit.MILLISECONDS.convert(stopTime - startTime, TimeUnit.NANOSECONDS);
        System.out.println(elapsedTimeInSecond1 + " milliseconds");
    }
}

