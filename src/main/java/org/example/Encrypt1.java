package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Encrypt1 implements Encrypt{
    private final int n = 3;
    private record IndexAndVal( int index, String val ){}

    public String encrypt( String s ){

        return Stream.iterate(
            new IndexAndVal(0, String.valueOf( s.charAt(0) )),
            iav -> new IndexAndVal(iav.index + 1, String.valueOf( s.charAt(iav.index + 1) ))
        ).limit(s.length())
        .reduce(
            new ArrayList<List<String>>( Arrays.asList( new ArrayList<>(), new ArrayList<>(), new ArrayList<>() ) ),
            (accum, iav) -> {
                for (int i = 0; i < n; i++) {
                    if(iav.index % n == i) accum.get(i).add(iav.val);
                }
                return accum;
            },
            (c1, c2) -> null
        )
        .stream().flatMap(Collection::stream)
        .collect(Collectors.joining());
    }
}