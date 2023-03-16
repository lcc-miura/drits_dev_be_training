import org.example.Encrypt;
import org.example.Encrypt2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Encrypt2Test {

    private final Encrypt target = new Encrypt2();

    @Test
    void encrypt() {
        var expected = "BEUA.xvga (2530)";
        var result = target.encrypt("ADTZ.wufz (1429)");

        assertEquals(expected, result);
    }
}
