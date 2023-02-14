import org.example.MyArrayListImpl;
import org.example.MyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListImplTest {
    String el1 = "ELEMENT1";
    String el2 = "ELEMENT2";
    String el3 = "ELEMENT3";
    String el4 = "ELEMENT4";
    final String[] list = {
        el1,
        el2,
        el3
    };

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

    @Test
    void indexAdd() {
        target.add(1, el4);

        Object[] expected = {
                el1,
                el4,
                el2,
                el3
        };

        var result = target.toArray();

        assertArrayEquals(expected, result);
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


    @Test
    void get() {
        var result = target.get(0);

        assertEquals(el1, result);
    }

    @Test
    void remove() {
        Object[] expected = {
            el1,
            el3
        };

        target.remove(1);
        var result = target.toArray();

        assertArrayEquals(expected, result);
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
