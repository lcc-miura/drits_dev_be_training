package org.example;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Encrypt3 implements Encrypt {

    public String encrypt(String s ) {

        return Arrays.stream( s.split("") ).reduce(
            new ArrayList<Map<String, Integer>>(),
            (accum, map) -> {
                if( accum.size() == 0 ) {
                    accum.add( Map.of(map, 1) );
                    return accum;
                }

                var beforeMap = accum.get(accum.size() - 1);
                var beforeKey = getKeyOfFirstEntryInMap(beforeMap);

                if( !map.equals(beforeKey) ) {
                    accum.add( Map.of(map, 1) );
                    return accum;
                }

                accum.remove(accum.size() - 1);
                accum.add( Map.of(beforeKey, beforeMap.get(beforeKey) + 1) );
                return accum;
            },
            (c1, c2) -> null
        ).stream().map(map -> {
            var key = getKeyOfFirstEntryInMap(map);
            return key + map.get(key);
        }).collect( Collectors.joining() );
    }

    private String getKeyOfFirstEntryInMap(Map<String, Integer> map) {
        String key = "";
        for (String tmpKey : map.keySet()) {
            key = tmpKey;
        }
        return key;
    }
}
