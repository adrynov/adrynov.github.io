package ie.atu.sw.indexer;

import ie.atu.sw.common.ApplicationException;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Parses a specified e-book and then builds an index by examining every word.
 *
 * @author Andrei Drynov
 */
public class BookIndexer extends BaseIndexer {

    /**
     * Constructor.
     */
    public BookIndexer() {
        super();
    }

    /**
     * Build the word index from the book, page by page, using virtual threads.
     *
     * @param path Book path
     */
    @Override
    public void buildIndex(String path) throws ApplicationException {
        Path bookPath = Path.of(path);

        // check: text file has b
        if (!Files.exists(bookPath)) {
            System.out.println("Unable to find the input file!");
            return;
        }

        // used for page number calculation
        final AtomicInteger counter = new AtomicInteger(0);

        // build the word index from the given book
        try (var es = Executors.newVirtualThreadPerTaskExecutor(); var lines = Files.lines(bookPath)) {
            lines
                    // split text content into pages
                    .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / PAGE_SIZE))
                    // process each page using virtual threads
                    .forEach((page, content) -> es.submit(() -> processPage(page + 1, content)));

        } catch (IOException e) {
            throw new ApplicationException("Unable to build book index." + e.getMessage());
        }
    }

    /**
     * Outputs the index to a user-provided output file.
     * <p>
     * Data is presented in the following format:
     * <p>
     * Word
     * <p>
     * - definition 1<br/>
     * - definition 2<br/>
     * <p>
     * Pages: 1, 17, 19, 87, 65
     */
    @Override
    public void outputIndex(PrintWriter writer) {
        if (this.isIndexPending()) {
            System.out.println("Index is not ready yet");
            return;
        }

        System.out.println();

        for (var detail : this.getIndex().values()) {
            // output actual word
            writer.printf("%s%n%n", detail.getWord());

            if (detail.getDefinitions().isEmpty()) {
                continue; // a safeguard
            }

            // output word definitions
            for (var definition : detail.getDefinitions()) {
                writer.printf("\t-%s%n", definition);
            }

            // output page numbers
            writer.printf("%n\tPages: %s%n%n", detail.getPageNumbers());

            writer.flush();
        }
    }

    /**
     * Prints first words in the index to the screen
     *
     * @param maxWords Total number of words to print (from the index beginning)
     */
    @Override
    public void printIndex(int maxWords) {
        if (this.isIndexPending()) {
            System.out.println("Index is not ready yet");
            return;
        }

        System.out.println();

        for (var detail : this.getWords(maxWords)) {
            // output actual word
            System.out.printf("%s%n%n", detail.getWord());

            // output word definitions
            for (var definition : detail.getDefinitions()) {
                System.out.printf("\t-%s%n", definition);
            }

            // output page numbers
            System.out.printf("%n\tPages: %s%n%n", detail.getPageNumbers());
        }
    }

    /**
     * Indexes the content of a text page.
     *
     * @param page        Page number
     * @param pageContent Textual content.
     */
    private void processPage(Integer page, List<String> pageContent) {
        for (String line : pageContent) { // O(n)
            // clean the text
            String content = sanitise(line);

            // skip empty lines
            if (content.isBlank()) continue;

            // process each line on the page and index its words
            Arrays.stream(content.split("\\s+")).forEach(w -> addWord(w, page));
        }
    }

    /**
     * Strip out unwanted characters from the books' text.
     * <p>
     * Punctuation is removed, e.g.  "J.R.R. Tolkien" is processed as "jrr tolkien".
     * English alphabet letters and whitespace only.
     *
     * @param input Input string
     * @return String containing only English words without numbers or punctuation.
     */
    private static String sanitise(String input) {
        if (input == null) return "";

        String value = input.toLowerCase() // make sure output is in lowercase
                .strip() // remove leading and trailing whitespace
                .replaceAll("\\p{Punct}+", ""); // remove punctuation

        // finally remove special characters etc.
        return textPattern.matcher(value).replaceAll("");
    }

    /**
     * Regex pattern for allowing alphanumeric characters
     */
    private static final Pattern textPattern = Pattern.compile("[^a-zA-Z ]+", Pattern.UNICODE_CHARACTER_CLASS);

    @Override
    protected void resetIndex() {
        super.resetIndex();

        // do required cleanup
    }
}