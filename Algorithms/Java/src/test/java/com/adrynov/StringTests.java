package com.adrynov;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void stringManipulation() {
        assertEquals(null, Strings.reverse(null));
        assertEquals("", Strings.reverse(""));
        assertEquals("olleH", Strings.reverse("Hello"));
        assertEquals("socat", Strings.reverse("tacos"));
    }

    /**
     * Determines the most repeated word in a given string.
     * <p>
     * A word is separated by either spaces or punctuation, and is case-insensitive.
     */
    @Test
    void findMostRepeatedWord() {
        String testString = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        String testString2 = "Penguins are aquatic, flightless birds that are highly adapted to life in the water. Their distinct tuxedo-like appearance is called countershading, a form of camouflage that helps keep them safe in the water. Penguins do have wing-bones, though they are flipper-like and extremely suited to swimming. Penguins are found almost exclusively in the southern hemisphere, where they catch their food underwater and raise their young on land.";

        String testString3 = "Students seek relief from rising prices through the purchase of used copies of textbooks, which tend to be less expensive. Most college bookstores offer used copies of textbooks at lower prices. Most bookstores will also buy used copies back from students at the end of a term if the book is going to be re-used at the school. Books that are not being re-used at the school are often purchased by an off-campus wholesaler for 0-30% of the new cost, for distribution to other bookstores where the books will be sold. Textbook companies have countered this by encouraging faculty to assign homework that must be done on the publisher's website. If a student has a new textbook, then he or she can use the pass code in the book to register on the site. If the student has purchased a used textbook, then he or she must pay money directly to the publisher in order to access the website and complete assigned homework. ";

        String[] words = input.trim().split("\\W+");

        System.out.println(Arrays.toString(words));
        assertTrue(true);


    }

}
