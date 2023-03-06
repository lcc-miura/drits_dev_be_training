package org.example;

public class Encrypt1 implements Encrypt{
    private final int n = 3;

    public String encrypt( String s ){
        var sb = new StringBuffer();

        for(var i = 0; i < n; i++) {
            for(var j = i; j < s.length(); j += n) {
                sb.append( s.charAt(j) );
            }
        }

        return sb.toString();
    }
}
