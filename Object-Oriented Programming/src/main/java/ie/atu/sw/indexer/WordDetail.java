package ie.atu.sw.indexer;

import ie.atu.sw.dictionary.DictionaryEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;

/**
 * An Index item.
 *
 * @author Andrei Drynov
 */
public class WordDetail {
    /**
     * The word.
     * <p>
     * It makes sense to use the word as a key for natural ordering.
     */
    private final String word;

    /**
     * Dictionary entry, containing the word and all its definitions.
     */
    private final DictionaryEntry entry;

    /**
     * Page numbers on which the word appears.
     */
    private final Set<Integer> pages = new ConcurrentSkipListSet<>();

    /**
     * Constructor.
     *
     * @param entry A dictionary entry
     * @param page  Page number where the word appears
     */
    public WordDetail(DictionaryEntry entry, int page) {
        this.word = entry.word();
        this.entry = entry;
        this.pages.add(page);
    }

    /**
     * Returns the word
     *
     * @return Word value
     */
    public String getWord() {
        return word;
    }

    /**
     * Adds a page number on which the word appeared.
     *
     * @param page Page number
     */
    public void addPage(int page) {
        this.pages.add(page);
    }

    /**
     * Returns the pages on which the word appeared.
     * <p>
     * O(n) as clones the data
     *
     * @return Page numbers
     */
    public Set<Integer> getPages() {
        return new TreeSet<>(this.pages);
    }

    /**
     * Returns a comma-separate list of pages on which the word appeared.
     *
     * @return Comma-separated list of pages, e.g. "14,209,216"
     */
    public String getPageNumbers() {
        return this.pages.stream().map(Object::toString).collect(Collectors.joining(","));
    }

    /**
     * Returns word definitions.
     * <p>
     * Likely to be O(n) as depends on System.arraycopy()
     *
     * @return Returns a list of word definitions.
     */
    public List<String> getDefinitions() {
        try {
            var definitions = this.entry.definitions();
            return new ArrayList<>(definitions);
        } catch (Exception e) {
            System.out.println("ERROR getting definitions for " + this.entry.word());
            return null;
        }
    }

    /**
     * Prints definitions of the word.
     */
    public void printDefinitions() {
        if (this.entry == null || this.entry.definitions().isEmpty()) return;

        for (var definition : this.getDefinitions()) {
            System.out.println("\t - " + definition);
        }
    }
}
