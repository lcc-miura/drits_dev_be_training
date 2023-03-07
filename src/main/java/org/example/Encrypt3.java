package org.example;

import java.util.LinkedHashMap;
import java.util.Map;

public class Encrypt3 implements Encrypt {

    private final Map<String, Integer> map = new LinkedHashMap<>();

    public String encrypt( String s ) {

        for(String str : s.split("")) {
            if(map.containsKey(str)) {
                map.replace(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }

        return map.entrySet().stream()
            .reduce(
                "",
                (accum, e) -> accum + e.getKey() + e.getValue(),
                (c1, c2) -> null
            );
    }
}
