package ie.atu.sw.indexer;

import ie.atu.sw.common.ApplicationException;

import java.io.PrintWriter;
import java.util.Map;

/**
 * The <b>Indexing API</b> contract which contains method(s) for building index from e-books or URLs.
 * <p>
 * See {@link BaseIndexer} for the minimalist state and behaviour.
 *
 * @author Andrei Drynov
 * @since 1.1
 */
public interface Indexator {
    /**
     * A page of text corresponds to 40 lines of text or blank spaces
     */
    public static final int PAGE_SIZE = 40;

    /**
     * Builds a word index either from an e-book or a URL.
     * <p>
     * likely O(n^2) as we process each word in each page
     *
     * @param path Path to the book or a web page.
     * @throws ApplicationException may be thrown while building the index
     */
    void buildIndex(String path) throws ApplicationException;

    /**
     * Returns the word index.
     * <p>
     * O(n) as we copy all map entries over
     *
     * @return Returns a copy of the index (proper encapsulation)
     */
    Map<String, WordDetail> getIndex();

    /**
     * Outputs the index to a file.
     * <p>
     * O(n) - typical looping
     *
     * @param writer Prints formatted representation of the index.
     */
    void outputIndex(PrintWriter writer);

    /**
     * Pretty-prints the first N words to the screen.
     * <p>
     * O(n)
     *
     * @param maxWords Total words to return
     */
    void printIndex(int maxWords);
}

