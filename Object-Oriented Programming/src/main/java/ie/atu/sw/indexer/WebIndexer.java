package ie.atu.sw.indexer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

/**
 * Builds the word index from a web page.
 * <p>
 * Builds the index by processing a web page content, stripping out HTML elements, etc.
 * Actual implementation depends on the requirements and different libraries and approaches
 * exist to deal with all the complexity of web page parsing.
 * <p>
 * <b>Not implemented</b>, but demonstrates the principles of object-oriented design
 *
 * @author Andrei Drynov
 */
public class WebIndexer extends BaseIndexer {

    /**
     * The URl of a web page.
     */
    private String url;

    /**
     * Constructor
     *
     * @param url A URL
     */
    public WebIndexer(String url) {
        this.url = url;
    }

    /**
     * Build a word index from the web page.
     * <p>
     * Unimplemented, for OOP demonstration only
     */
    @Override
    public void buildIndex(String path) {
        try {
            // load the web content
            Object data = new URL(this.url).getContent();

            // parse the content
            // build the index

        } catch (IOException e) {
            // process errors
        }
    }

    @Override
    public void outputIndex(PrintWriter writer) {
        // saves the index generated from a web page to a text-based output
    }

    @Override
    public void printIndex(int maxWords) {
        // pretty-print the index in XML, or JSON, or plain text etc.
        // depending on the user requirements.
    }

    @Override
    protected void resetIndex() {
        super.resetIndex();
        this.url = null;
    }

}
