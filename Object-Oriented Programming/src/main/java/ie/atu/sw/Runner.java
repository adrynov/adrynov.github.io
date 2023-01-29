package ie.atu.sw;

/**
 * A multi-threaded application that allows a word index to be created from an e-book or a URL.
 * <p>
 * The index contains a list of words that relate to the page numbers on which their appear and
 * the dictionary defined meaning of each word.
 *
 * @author Andrei Drynov
 * @version 2.0
 */
public class Runner {

    /**
     * Constructor.
     */
    public Runner() {
    }

    /**
     * App entry point.
     * <p>
     * It presents the menu options to the user
     * .
     *
     * @param args Program arguments
     */
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.showMenu();
    }

}