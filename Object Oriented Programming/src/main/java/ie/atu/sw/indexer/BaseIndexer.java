package ie.atu.sw.indexer;

import ie.atu.sw.common.SortDirection;
import ie.atu.sw.dictionary.WordDictionary;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;

/**
 * The <b>Indexing API</b> abstraction.
 * <p>
 * An abstract class can have behaviour, and can include a certain state.
 * <p>
 * Since the {@link #index} is common to {@link BookIndexer} and {@link WebIndexer}, the state
 * is best encapsulated by this abstraction.
 * <p>
 * The actual index building may be implemented differently by the concrete subtypes.
 *
 * @author Andrei Drynov
 */
public abstract class BaseIndexer implements Indexator {

    /**
     * The <b>Word Index</b> contains a list of words that relate to page numbers
     * on which they appear and the dictionary defined meaning of each word.
     */
    private final Map<String, WordDetail> index;

    /**
     * Constructor for (typically implicit) invocation by subtype constructors
     */
    protected BaseIndexer() {
        this.index = new ConcurrentSkipListMap<>(); // thread-safe and fast collection, love it
    }

    /**
     * Returns the word index.
     * <p>
     * O(n) as we copy the data
     *
     * @return A copy of the index.
     */
    public Map<String, WordDetail> getIndex() {
        return new ConcurrentSkipListMap<>(this.index);
    }

    /**
     * Adds the word to the index or updates the existing word in the index.
     * <p>
     * O(log(n)) as uses Skip List's key-based operations
     *
     * @param word Word as the key
     * @param page Page number
     */
    final public void addWord(String word, int page) {
        // skip the words not present in the English dictionary
        var dictionaryEntry = WordDictionary.getInstance().getEntry(word);  // O(log(n))
        if (dictionaryEntry == null) {
            return;
        }

        // exclude all words from the list of 1,000 most common words
        if (WordDictionary.getInstance().isStopWord(word)) {
            return;
        }

        // add or update an entry in the word index
        WordDetail detail = this.index.get(word);  // O(log(n))

        if (detail != null) {
            // if the word is in the word index, all we have to update the page numbers on which it appears
            detail.addPage(page);
            this.index.put(word, detail); // O(log(n))

        } else {
            // add the word detail in the index, including its dictionary definition(s)
            detail = new WordDetail(dictionaryEntry, page);
            this.index.putIfAbsent(word, detail); // O(log(n))
        }
    }

    /**
     * Returns all words in sorted / reverse sorted order
     * <p>
     * O(n log n) as we do not know how the sorting is done and which algorithm is being used
     * In fact we do not care about the algorithm, modern sorting algorithms are as fast as they can be.
     *
     * @param direction Sort direction (ascending or descending)
     * @return Sorted word details.
     */
    public List<WordDetail> getWords(SortDirection direction) {
        // keep this function pure by making a copy of the word index
        List<WordDetail> sorted = null;

        if (direction == SortDirection.ASC) {
            sorted = this.getIndex().values().stream().sorted(WORD_COMPARATOR).toList();
        } else {
            sorted = this.getIndex().entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).map(Map.Entry::getValue).toList();
        }

        return sorted;
    }

    /**
     * Returns all words indexed on the specified page.
     *
     * @param page Page number
     * @return Details of all words found on the page.
     */
    public List<WordDetail> getWordsByPage(int page) {
        return this.getIndex().values().stream().filter(word -> word.getPages().contains(page)).collect(Collectors.toList());
    }

    /**
     * Returns the first N words.
     *
     * O(n) as copies data over
     *
     * @param totalWords the number of elements to return
     * @return N words from the beginning of the index.
     */
    public List<WordDetail> getWords(int totalWords) {
        return (totalWords > 0) ?
                this.index.values().stream().limit(totalWords).toList() :
                this.getIndex().values().stream().toList();
    }

    /**
     * Checks whether the index has not built yet.
     *
     * O(1) usually
     * @return Returns true if the index contains no word details.
     */
    protected boolean isIndexPending() {
        return this.index.isEmpty();
    }

    /**
     * Remove all entries from the word index.
     * <p>
     * O(n) as needs to iterate through all entries to set them to null.
     */
    protected void resetIndex() {
        this.index.clear();
    }

    /**
     * A comparison function for ordering data in ascending (lexicographical) order of the words they define.
     */
    private final Comparator<WordDetail> WORD_COMPARATOR = Comparator.comparing(WordDetail::getWord);
    private final Comparator<WordDetail> WORD_COMPARATOR_DESC = WORD_COMPARATOR.reversed();
}

