package com.ghevi.ads.hashes;

import java.util.Random;

public class Tester {

    public static void main(String[] args) {

        Hash hash = new Hash(50);

        Random rand = new Random();

        int key = 10;
        int value = 15;

        hash.add(key, value);

        System.out.println(hash.getValue(key));

        for(int i = 0; i <= 50; i++) {
            int k = rand.nextInt();
            int v = rand.nextInt();
            hash.add(k, v);
        }

    }
}
