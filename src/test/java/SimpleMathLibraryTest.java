
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SimpleMathLibraryTest {
    SimpleMathLibrary mathLibrary = new SimpleMathLibrary();
    @Test
    public void testAdd() {
        double result = mathLibrary.add(2, 3);
        assertEquals(5.0, result, "The add method should return the sum of two numbers");
    }

    @Test
    public void testMinus() {
        double result = mathLibrary.minus(5, 3);
        assertEquals(2.0, result, "The minus method should return the difference of two numbers");
    }
}
