package org.example;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Encrypt1 implements Encrypt{

    private final int numSegment;
    record PositionAndVal( int position, char val ){}

    public Encrypt1(int numSegment) {
        this.numSegment = numSegment;
    }

    public String encrypt( String s ) {

        final int length = s.length();

        if(length % numSegment != 0) throw new IllegalArgumentException();

        return
            Stream
                .iterate(new PositionAndVal(0, s.charAt(0)), pov -> createNextPositionAndVal(pov, s))
                .map(pov -> new PositionAndVal(getDestinationPosition(pov.position, length), pov.val))
                .limit(length)
                .sorted(Comparator.comparingInt(e -> e.position))
                .map(el -> String.valueOf(el.val))
                .collect(Collectors.joining());
    }

    private int getDestinationPosition(int idxSource, int length) {
        return (idxSource % numSegment) * (length / numSegment) + idxSource / numSegment;
    }

    private PositionAndVal createNextPositionAndVal(PositionAndVal pov, String s) {
        var nextPosition = pov.position + 1;
        return new PositionAndVal(nextPosition, s.charAt(nextPosition));
    }
}
