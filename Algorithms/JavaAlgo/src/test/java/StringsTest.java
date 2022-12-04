import com.adrynov.Strings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringsTest {

    @Test
    void simpleMethods() {
        assertTrue(Strings.isUppercase("HELLO WORLD"));
        assertFalse(Strings.isUppercase("Hello world"));

        assertTrue(Strings.isPasswordComplex("Fh2vnq"));
        assertTrue(Strings.isPasswordComplex("FdFF5F"));

        assertTrue(Strings.isAtEventIndex("Hello World", 'l'));
        assertTrue(Strings.isAtEventIndex("Goodbye World", 'o'));
        assertTrue(Strings.isAtEventIndex("HeLlo", 'L'));
        assertFalse(Strings.isAtEventIndex("HeLlo", 'T'));
        assertFalse(Strings.isAtEventIndex("", 'H'));
        assertFalse(Strings.isAtEventIndex(null, 'H'));
    }

}
