import com.adrynov.Basic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicTests {

    @Test
    void findMaximumNumber() {
        assertEquals(3, Basic.findMaximum(1, 2, 3));
        assertEquals(8, Basic.findMaximum(8, 8, 1));
        assertEquals(12, Basic.findMaximum(3, 12, 3));
        assertEquals(9, Basic.findMaximum(1, 1, 9));
        assertEquals(9, Basic.findMaximum(9, 1, 5));
    }
}
