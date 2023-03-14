import org.example.Encrypt;
import org.example.Encrypt3;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Encrypt3Test {
    private final Encrypt target = new Encrypt3();

    @Test
    void encrypt() {
        var expected = "A3B1A4";
        var result = target.encrypt("AAABAAAA");

        assertEquals(expected, result);
    }
}
