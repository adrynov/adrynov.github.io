package ie.atu.sw.dictionary;

//public class WordParser<T> extends Parser<T>

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;

/**
 * Parses dictionary files into data collections.
 * <p>
 * The English dictionary file should be treated differently to the Google's list of common words and so on.
 * <p>
 * The {@link WordDictionary} encapsulates the dictionary data and should not be
 * concerned with other tasks such as dictionary file processing.
 *
 * @author Andrei Drynov
 * @since 1.0
 */
public final class DictionaryParser {
    private Map<String, DictionaryEntry> entries = new ConcurrentSkipListMap<>();

    /**
     * Constructor.
     */
    public DictionaryParser() {
    }

    /**
     * Parses a file containing the Google’s list of 1,000 most common words.
     * The API should exclude these words from the word index.
     *
     * <p>
     * O(n) at least, as loops through each line of text.
     *
     * @param path Path to the file containing most common English words.
     * @return A new set containing the common words.
     * @throws IOException if an I/O error occurs opening the file
     */
    public Set<String> parseGoogle(String path) throws IOException {
        Set<String> words = ConcurrentHashMap.newKeySet();

        try (var lines = Files.lines(Path.of(path))) {
            lines.forEach(words::add);
        }

        return words;
    }

    /**
     * Processes and parses a dictionary file which contains a set of English words and their definitions.
     * <p>
     * Each line from the text file is processed by a distinct virtual thread.
     * <p>
     * O(n) as readAllLines() processes each line in a loop
     *
     * @param path    Path to the dictionary file
     * @param version Dictionary version
     * @return Dictionary entries
     * @throws IOException if an I/O error occurs opening the file
     */
    public Map<String, DictionaryEntry> parseDictionary(String path, int version) throws IOException {
        // unsupported dictionary version
        if (version != 1 && version != 2) {
            System.out.println("Dictionary version is not supported");
            return null;
        }

        Instant start = Instant.now(); // measure performance

        // Parse the dictionary file using virtual threads
        try (var es = Executors.newVirtualThreadPerTaskExecutor(); var lines = Files.lines(Path.of(path))) {
            lines
                    // 1) get rid of the CSV header (in the 176,000 dictionary version)
                    // 2) ignore the first line in the abridged version (to simplify logic)
                    .skip(1)

                    // prepares data for processing
                    .map(line -> getDictionaryEntry(line, version))

                    // filter null values from the stream
                    .filter(Objects::nonNull)

                    // add or update dictionary entries using virtual threads
                    .forEach(entry -> es.execute(() -> {
                        entries.compute(entry.word(), (key, value) -> {
                            // add a new dictionary entry, if not found in the map
                            if (value == null) {
                                return entry;
                            }

                            // otherwise add yet another definition to the existing entry
                            value.definitions().addAll(entry.definitions());
                            return value;
                        });
                    }));
        }

        System.out.println("Dictionary parsed in " + Duration.between(start, Instant.now()).toMillis() + " ms");

        return entries;
    }

    /**
     * Converts each line of text to a dictionary entry
     * <p>
     * This avoids the use of <a href="https://docs.oracle.com/en/java/javase/19/core/virtual-threads.html">Thread-Local Variables</a>
     *
     * @param line    Line of text containing the dictionary definition
     * @param version Dicitonary verions
     */
    private DictionaryEntry getDictionaryEntry(String line, int version) {
        try {
            // split each text file line into a list of word, and its type and definition(s)
            var content = Arrays.asList(line.split(","));

            final String word = content.get(0).toLowerCase();
            String definition = "";

            if (version == 1) {
                // filter out lines without full definitions such as "Antic,a.,,,,,,,,,,,,,,,,,,,,,"
                // or when definitions are difficult to parse: e.g. "Aleurone,n.,A substance (,>protein granules,>)"
                if (content.size() != 3) {
                    return null;
                }

                // skip some "dirty" entries (Excel malformed, etc.)
                if (word.equalsIgnoreCase("#NAME?")) {
                    return null;
                }

                // combine the word type and word definition for logic simplicity
                definition = content.get(1) + "," + content.get(2);

            } else if (version == 2) {
                // there should be only the word and all its definitions in one line
                if (content.size() != 2) {
                    return null;
                }

                definition = content.get(1);
            }

            // word definitions
            final List<String> definitions = new CopyOnWriteArrayList<>();
            definitions.add(definition);

            return new DictionaryEntry(word, definitions);

        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Determines the dictionary version.
     * <p>
     * See {@link WordDictionary#getVersion()}
     *
     * @param path Path to the dictionary file
     * @return Integer indicating the version of the English dictionary, or 0 if the file format is not recognised
     */
    public int determineVersion(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String firstLine = reader.readLine();

            if (firstLine == null) {
                System.out.println("The file is empty!");
                return 0;
            }

            // is there a CSV header?
            return firstLine.startsWith("word,wordtype,definition") ? 1 : 2;

        } catch (FileNotFoundException e) {
            System.out.println("Dictionary file not found");
        } catch (IOException e) {
            System.out.println("Error reading dictionary file");
        }

        System.out.println("Unable to determine the dictionary version");
        return 0;
    }
}
