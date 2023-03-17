package org.example;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Encrypt1 implements Encrypt{
    private final int n = 3;
    record PositionAndVal( int before, int after, char val ){}

    private int getTransformPosition(int index, int length) {
        return (index % n) * (length / n) + index / n;
    }

    public String encrypt( String s ) {

        final int length = s.length();

        return
            Stream
                .iterate(
                    new PositionAndVal(0, 0, s.charAt(0)),
                    pov -> new PositionAndVal(pov.before + 1, getTransformPosition(pov.before + 1, length), s.charAt(pov.before + 1))
                )
                .limit(length)
                .sorted(Comparator.comparingInt(e -> e.after))
                .map(el -> String.valueOf(el.val))
                .collect(Collectors.joining());
    }
}
