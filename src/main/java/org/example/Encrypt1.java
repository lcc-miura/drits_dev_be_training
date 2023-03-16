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
        ).limit(12)
        .reduce(
            new ArrayList<List<String>>( Arrays.asList( new ArrayList<>(), new ArrayList<>(), new ArrayList<>() ) ),
            (accum, iav) -> {
                switch (iav.index % n) {
                    case 0 -> accum.get(0).add(iav.val);
                    case 1 -> accum.get(1).add(iav.val);
                    case 2 -> accum.get(2).add(iav.val);
                }
                return accum;
            },
            (c1, c2) -> null
        )
        .stream().flatMap(Collection::stream)
        .collect(Collectors.joining());
    }
}
