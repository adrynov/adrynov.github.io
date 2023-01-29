package ie.atu.sw.common;

/**
 * An exception class used to implement an overly-simplified system for
 * informing the user about erroneous things that are out of control
 * of the application.
 *
 * @author Andrei Drynov
 */
public class ApplicationException extends Exception {

    /**
     * Constructor override
     *
     * @param message The detail message
     */
    public ApplicationException(String message) {
        super(message);
    }
}
