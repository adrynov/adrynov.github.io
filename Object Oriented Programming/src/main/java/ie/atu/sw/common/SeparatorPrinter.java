package ie.atu.sw.common;

/**
 * Useful for printing separator lines.
 */
@FunctionalInterface
public interface SeparatorPrinter {
    /**
     * Default length of the separator line in informational blocks.
     */
    public static final int SEPARATOR_LEN = 60;

    /**
     * Prints a separator line (with an optional title)
     *
     * @param separator Separator character
     * @param title     Title
     */
    public abstract void print(char separator, String title);
}
