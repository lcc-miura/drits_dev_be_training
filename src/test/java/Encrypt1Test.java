import org.example.Encrypt;
import org.example.Encrypt1;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Encrypt1Test {

    @Nested
    class encrypt {
        @Test
        void SegmentIs3() {
            var numSegment = 3;
            var target = new Encrypt1(numSegment);

            var expected = "ADGJBEHKCFIL";
            var result = target.encrypt("ABCDEFGHIJKL");

            assertEquals(expected, result);
        }

        @Test
        void SegmentIs4() {
            var numSegment = 4;
            var target = new Encrypt1(numSegment);

            var expected = "AEIBFJCGKDHL";
            var result = target.encrypt("ABCDEFGHIJKL");

            assertEquals(expected, result);
        }

        @Test
        void returnExceptionWhenParameterInjusticeOfLessThannumSegment() {
            var numSegment = 3;
            var target = new Encrypt1(numSegment);

            assertThrows(IllegalArgumentException.class, () -> target.encrypt("A"));
        }

        @Test
        void returnExceptionWhenParameterInjusticeOfNotMultiple() {
            var numSegment = 3;
            var target = new Encrypt1(numSegment);

            assertThrows(IllegalArgumentException.class, () -> target.encrypt("ABCD"));
        }
    }


}
