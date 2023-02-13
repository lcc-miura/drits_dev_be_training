import org.example.MyArrayListImpl;
import org.example.MyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        var i = 1;
        target.add(i, el4);
        var result = target.get(i);

        assertEquals(el4, result);
    }

    @Test
    void contains() {
        var result = target.contains(el1);

        assertEquals(true, result);
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

        assertEquals(expected, result);
    }

    @Test
    void toArray() {
        Object[] expected = {
                el1,
                el2,
                el3
        };

        var result = target.toArray();

        assertEquals(expected, result);
    }

    @Test
    void size() {
        var expected = 3;

        var result = target.size();

        assertEquals(expected, result);
    }
}
