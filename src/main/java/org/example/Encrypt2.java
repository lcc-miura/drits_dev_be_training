package org.example;

import java.util.Arrays;
import java.util.List;

public class Encrypt2 implements Encrypt {

    private final static List<String> alphabets = Arrays.asList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
    private final static List<String> LowerAlphabets = Arrays.asList("abcdefghijklmnopqrstuvwxyz".split(""));

    public String encrypt( String s ) {

        return Arrays.stream(s.split(""))
            .map(str -> {

                if(str.matches("[0-9]"))
                    return !str.equals("9")
                        ? increment(str)
                        : "0";

                if(str.matches("[A-Z]")) {
                    return !str.equals("Z")
                        ? alphabets.get(alphabets.indexOf(str) + 1)
                        : "A";
                }

                if(str.matches("[a-z]")) {
                    return !str.equals("z")
                        ? LowerAlphabets.get(LowerAlphabets.indexOf(str) + 1)
                        : "a";
                }

                return str;
            })
            .reduce((result, str) -> result + str)
            .orElse("");
    }

    private String increment(String s) {
        var n = Integer.parseInt(s);
        n++;
        return String.valueOf(n);
    }
}
