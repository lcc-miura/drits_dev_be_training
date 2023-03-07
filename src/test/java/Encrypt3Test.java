import org.example.Encrypt;
import org.example.Encrypt3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Encrypt3Test {
    private final Encrypt target = new Encrypt3();

    @Test
    void encrypt() {
        var expected = "B4E2H1L4";
        var result = target.encrypt("BBBBEEHLLLL");

        assertEquals(expected, result);
    }
}
