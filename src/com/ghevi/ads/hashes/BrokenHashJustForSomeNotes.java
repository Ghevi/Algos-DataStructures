package com.ghevi.ads.hashes;

// This is just an early example, don't mind

public class BrokenHashJustForSomeNotes {

    public static void main(String[] args) {

        String s = "my name is Josh";

        char c = s.charAt(6); // e

        int i = s.charAt(6); // unicode value 101

        System.out.println(i);

        // ----

        int hashVal = hashCode(s);
    }

    public static int hashCode(String s){
        int g = 31; //
        int hash = 0;

        // permutation
        for(int i = 0; i < s.length(); i++){
            hash = g * hash + s.charAt(i);
        }

        return hash;
    }

}
