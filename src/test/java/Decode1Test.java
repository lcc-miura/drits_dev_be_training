import org.example.Decode;
import org.example.Decode1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Decode1Test {
    private final Decode target = new Decode1();

    @Test
    void encrypt() {
        target.decode("ADGJBEHKCFIL");

        var expected = "ABCDEFGHIJKL";
        var result = "ABCDEFGHIJKL";

        assertEquals(expected, result);
    }
}
