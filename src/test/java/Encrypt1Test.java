import org.example.Encrypt;
import org.example.Encrypt1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Encrypt1Test {

    @Test
    void encrypt() {
        var numSegment = 3;
        var target = new Encrypt1(numSegment);

        var expected = "ADGJBEHKCFIL";
        var result = target.encrypt("ABCDEFGHIJKL");

        assertEquals(expected, result);
    }
}
