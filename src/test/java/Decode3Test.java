import org.example.Decode;
import org.example.Decode3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Decode3Test {
    private final Decode target = new Decode3();

    @Test
    void encrypt() {
        var expected = "BBBBEEHLLLL";
        var result = target.decode("B4E2H1L4");

        assertEquals(expected, result);
    }
}
