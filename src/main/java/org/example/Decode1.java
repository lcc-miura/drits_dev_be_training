package org.example;

public class Decode1 implements Decode{

    private final int n = 3;

    public String decode(String s) {
        var sb = new StringBuffer();

        int delimiterNum = s.length() / n;
        for(var i = 0; i < n; i++) {
            for(var j = delimiterNum; j < n; j += delimiterNum) {
                sb.append( s.charAt(j) );
            }
        }

        return sb.toString();
    }
}
