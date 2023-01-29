package ie.atu.sw.dictionary;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * A dictionary entry with its word definitions.
 * <p>
 * An entry can have one or many definitions whereas the word type is ignored.
 *
 * @param word        English word
 * @param definitions Word definitions.
 * @author Andrei Drynov
 */
public record DictionaryEntry(String word, List<String> definitions) {

    /**
     * Canonical constructor.
     *
     * @param word A word
     */
    public DictionaryEntry(String word) {
        this(word, new CopyOnWriteArrayList<>());
    }
}
