package org.example;

import java.util.Arrays;
import java.util.List;

public class Encrypt2 implements Encrypt {

    public String encrypt( String s ) {

        return Arrays.stream(s.split(""))
            .map(str -> {
                if(str.matches("[0-9]")) return encryptUpper(str, 48, 10);
                if(str.matches("[A-Z]")) return encryptUpper(str, 65, 26);
                if(str.matches("[a-z]")) return encryptUpper(str, 97, 26);
                return str;
            })
            .reduce((result, str) -> result + str)
            .orElse("");
    }

    public String encryptUpper(String str, int baseNum, int count){
        var c = str.toCharArray()[0];
        var result =  (char)(baseNum + (c - baseNum + 1) % count);
        return String.valueOf(result);
    }
}
