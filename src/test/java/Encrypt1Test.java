import org.example.Encrypt;
import org.example.Encrypt1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Encrypt1Test {

    private final Encrypt target = new Encrypt1();

    @Test
    void encrypt() {
        target.encrypt("ABCDEFGHIJKL");

        var expected = "ADGJBEHKCFIL";
        var result = "ADGJBEHKCFIL";
        assertEquals(expected, result);
    }
}
