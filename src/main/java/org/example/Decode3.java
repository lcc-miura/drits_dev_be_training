package org.example;

public class Decode3 implements Decode {

    private String str = "";

    public String decode(String s) {

        for(int i = 0; i < s.length(); i++) {
            if(i % 2 == 0) {
                var count = Character.getNumericValue(s.charAt(i + 1));
                str += String.valueOf( s.charAt(i) ).repeat( Math.max(0, count) );
            }
        }

        return str;
    }
}
