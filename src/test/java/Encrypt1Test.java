import org.example.Encrypt;
import org.example.Encrypt1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Encrypt1Test {

    private final Encrypt target = new Encrypt1();

    @Test
    void encrypt() {
        var expected = "ADGJBEHKCFIL";
        var result = target.encrypt("ABCDEFGHIJKL");

        assertEquals(expected, result);
    }
}
