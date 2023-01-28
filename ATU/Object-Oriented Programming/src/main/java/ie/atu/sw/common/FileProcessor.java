package ie.atu.sw.common;

import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.*;

/**
 * Helper class for working with input and output files.
 *
 * @author Andrei Drynov
 */
public class FileProcessor {

    private Path inputPath = null;
    private Path outputPath = null;

    /**
     * Constructor.
     */
    public FileProcessor() {
    }

    /**
     * Returns the path of an input text file.
     *
     * @return Input path
     */
    public Path getInputPath() {
        return inputPath;
    }

    /**
     * Returns the path of an output text file.
     *
     * @return Path of the file containing the word index
     */
    public Path getOutputPath() {
        return outputPath;
    }

    /**
     * Sets the input file path it the input file's location is valid and the file exists.
     *
     * @param input Location of the input file.
     */
    public void setInputFile(String input) throws IllegalArgumentException {
        // validate the input path
        Path path = validatePath(input, ".txt", true);
        if (path == null) return;

        // the input text file must exist
        if (Files.notExists(path, LinkOption.NOFOLLOW_LINKS)) {
            System.out.println("The file located by this path does not exist");
            return;
        }

        this.inputPath = path;
    }

    /**
     * Creates an output file to keep the word index for user reference.
     * <p>
     * Optional, the user may want to print results to the screen instead.
     *
     * @param output of the output file.
     * @throws ApplicationException I/O access can be fiddly
     */
    public void setOutputFile(String output) throws ApplicationException {
        try {
            // validate the output path
            Path path = validatePath(output, ".txt", false);
            if (path == null) return;

            this.outputPath = Files.createFile(Path.of(output));

        } catch (FileAlreadyExistsException e) {
            // output file exists, ok to overwrite it
            this.outputPath = Path.of(output);

        } catch (IOException e) {
            throw new ApplicationException("The output path is invalid");
        } catch (SecurityException e) {
            throw new ApplicationException("You have not write permissions to the output destination");
        }
    }

    /**
     * Returns a normalised path to the file.
     *
     * @param location       File location
     * @param extension      File extension
     * @param checkExistence Check for file existence
     * @return File path or null if the location
     */
    public Path validatePath(String location, String extension, boolean checkExistence) {
        Path result = null;

        if (location == null || location.isBlank()) {
            System.out.println("Please provide a valid path");
            return null;
        }


        try {
            result = Paths.get(location);
        } catch (InvalidPathException | NullPointerException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

        // cannot process directories
        if (checkExistence && !Files.isRegularFile(result, LinkOption.NOFOLLOW_LINKS)) {
            System.out.println("Please provide a valid file path");
            return null;
        }

        // expect the input file to have a specific extension
        if (!location.endsWith(extension)) {
            System.out.println("The file should have the \"" + extension + "\" extension");
            return null;
        }

        return result.normalize();
    }

    private FilenameFilter fileNameFilter = (parent, fileName) -> fileName != null &&
            fileName.toLowerCase().endsWith(".txt") || fileName.toLowerCase().endsWith(".csv");
}
