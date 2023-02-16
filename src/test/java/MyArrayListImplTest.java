import org.example.MyArrayListImpl;
import org.example.MyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListImplTest {
    final String el1 = "ELEMENT1";
    final String el2 = "ELEMENT2";
    final String el3 = "ELEMENT3";
    final String el4 = "ELEMENT4";
    final String[] list = {el1, el2, el3};
    final int size = 3;

    final MyList<String> target = new MyArrayListImpl<>();

    @BeforeEach
    void beforeEach(){
        Arrays.stream(list).forEach(target::add);
    }

    @Test
    void add() {
        for(int i = 0; i < list.length; i++){
            var result = target.get(i);
            assertEquals(list[i], result);
        }
    }

    @Nested
    class indexAdd {
        @Test
        void first() {
            target.add(0, el4);

            Object[] expected = {el4, el1, el2, el3};
            var result = target.toArray();

            assertArrayEquals(expected, result);
        }

        @Test
        void last() {
            target.add(size, el4);

            Object[] expected = {el1, el2, el3, el4};
            var result = target.toArray();

            assertArrayEquals(expected, result);
        }

        @Test
        void IndexOutOfBoundsException() {
            assertThrows(IndexOutOfBoundsException.class, () -> target.add(size + 1, el4));
        }
    }

    @Nested
    class contains {
        @Test
        void containsOfEl() {
        var result = target.contains(el1);
            assertTrue(result);
        }

        @Test
        void containsOfNull() {
            target.add(null);
            var result = target.contains(null);

            assertTrue(result);
        }
    }

    @Nested
    class get {
        @Test
        void first() {
            var result = target.get(0);
            assertEquals(el1, result);
        }

        @Test
        void last() {
            var result = target.get(size - 1);
            assertEquals(el3, result);
        }

        @Test
        void IndexOutOfBoundsException() {
            assertThrows(IndexOutOfBoundsException.class, () -> target.get(size));
        }
    }

    @Nested
    class remove {
        @Test
        void first() {
            Object[] expected = {
                    el2,
                    el3
            };
            target.remove(0);
            var result = target.toArray();

            assertArrayEquals(expected, result);
        }

        @Test
        void last() {
            Object[] expected = {
                    el1,
                    el2
            };
            target.remove(size - 1);
            var result = target.toArray();

            assertArrayEquals(expected, result);
        }

        @Test
        void IndexOutOfBoundsException() {
            assertThrows(IndexOutOfBoundsException.class, () -> target.remove(size));
        }
    }

    @Test
    void toArray() {
        Object[] expected = {
                el1,
                el2,
                el3
        };
        var result = target.toArray();

        assertArrayEquals(expected, result);
    }

    @Test
    void size() {
        var expected = 3;
        var result = target.size();

        assertEquals(expected, result);
    }
}
