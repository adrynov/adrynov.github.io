package ie.atu.sw.dictionary;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * The word dictionary.
 * <p>
 * 1. Encapsulates a collection of {@link DictionaryEntry} loaded from the dictionary file provided by the user.
 * 2. Contains the 1000 most common words in English (which should be excluded from indexing).
 * 3. Provides some statistics about the words and their definitions.
 *
 * @author Andrei Drynov
 * @version 1.6
 */
public class WordDictionary {
    /**
     * English dictionary entries.
     */
    private Map<String, DictionaryEntry> entries = new ConcurrentSkipListMap<>();

    /**
     * 1000 most common English words which should be excluded from the index.
     */
    private Set<String> commonWords = ConcurrentHashMap.newKeySet();


    /**
     * Returns the dictionary entry, or null if this dictionary contains no such a word.
     * <p>
     * Big-O: O(log(n))
     *
     * @param word Word
     * @return Dictionary entry
     */
    public DictionaryEntry getEntry(String word) {
        return entries.get(word);  // O(log(n))
    }

    /**
     * Re(sets) the list of common words.
     * <p>
     * O(n) as adds multiple elements to the set
     *
     * @param words Common words
     */
    public void setCommonWords(Set<String> words) {
        // create the common words list anew
        this.commonWords = ConcurrentHashMap.newKeySet(words.size());
        this.commonWords.addAll(words);
    }

    /**
     * Adds all dictionary entries.
     *
     * @param entries List of entries
     */
    public void setEntries(Map<String, DictionaryEntry> entries) {
        this.entries = new ConcurrentSkipListMap<>();
        this.entries.putAll(entries);
    }

    /**
     * Prints the total number of English words and their definitions, also the number of Google's common words.
     */
    public void showStats() {
        if (entries.isEmpty()) {
            System.out.println("Dictionary:\tNOT SET");
        } else {
            System.out.println("Dictionary:\tVersion " + this.version);
            System.out.println("Unique words:\t" + countWords());

            // word definitions are harder to split in dictionary version 2, so ignore
            if (this.version == 1) {
                System.out.println("Definitions:\t" + countDefinitions());
            }
        }

        if (commonWords.isEmpty()) {
            System.out.println("Google list:\tNOT SET");
        } else {
            System.out.println("Google list:\tConfigured");
            System.out.println("Common words:\t" + commonWords.size());
        }
    }

    /**
     * Checks whether the word is in the Google's list of 1000 common words
     * and therefore should be excluded from indexing.
     * <p>
     * Big-O:  O(1) as uses key-based HashSet contains() operation
     *
     * @param word Word to check
     * @return True if the word was found in the common words' list
     */
    public boolean isStopWord(String word) {
        return commonWords.contains(word);
    }

    /**
     * Checks whether the English dictionary and Google's list have been loaded
     * <p>
     * Big-O: O(1)
     *
     * @return True if all pre-requisites have been met.
     */
    public boolean isReady() {
        return !entries.isEmpty() && !commonWords.isEmpty();
    }

    /**
     * Returns the number of word definitions
     * <p>
     * O(n)
     *
     * @return Total number of definitions for all words in the dictionary
     */
    private int countDefinitions() {
        int total = 0;

        for (var values : entries.values()) { // O(n)
            total += values.definitions().size();
        }

        return total;
    }

    /**
     * Returns the number of unique English words.
     * <p>
     * O(1) for size()
     *
     * @return The number of dictionary defined words.
     */
    private int countWords() {
        return this.entries.size();
    }

    /**
     * This application supports two CSV formats of the English dictionary.
     * <p>
     * - Version 1: original version of the dictionary which contains a set of over 176,000 words and their definitions
     * * <p>
     * * It has a CSV header and each line contains the word, its type and a single definition:
     * * Aback,adv.,Behind; in the rear.
     * *
     * * <p>
     * * Version 2: abridged dictionary of 98,544 Words in CSV format
     * * <p
     * It does not have a header. Each line contains the word, and after a comma, all its definitions
     * * <p>
     * * Aback,adv.: Toward the back or rear; backward.; adv.: Behind; in the rear.; adv.: Backward against the mast;
     * *
     */
    private int version = 0;

    /**
     * Gets the dictionary version (1 or 2)
     *
     * @return Dictionary version
     */
    public int getVersion() {
        return version;
    }

    /**
     * Sets the dictionary version
     *
     * @param version Version of the dictionary (1 or 2 only)
     */
    public void setVersion(int version) {
        if (version != 1 && version != 2) {
            throw new IllegalArgumentException("Dictionary verison is not supported");
        }

        this.version = version;
    }

    //<editor-fold desc="Singleton">

    // Lazy initialization
    private static final WordDictionary INSTANCE = new WordDictionary();

    /**
     * Returns the instance of Word Dictionary using Singleton pattern.
     *
     * @return WordDictionary instance
     */
    public static WordDictionary getInstance() {
        return INSTANCE;
    }

    private WordDictionary() {

    }

    //</editor-fold>
}
