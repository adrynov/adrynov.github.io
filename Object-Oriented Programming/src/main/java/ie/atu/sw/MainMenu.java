package ie.atu.sw;

import ie.atu.sw.common.ApplicationException;
import ie.atu.sw.common.FileProcessor;
import ie.atu.sw.common.SeparatorPrinter;
import ie.atu.sw.dictionary.DictionaryParser;
import ie.atu.sw.dictionary.WordDictionary;
import ie.atu.sw.indexer.BookIndexer;
import ie.atu.sw.indexer.Indexator;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

import static ie.atu.sw.common.SeparatorPrinter.SEPARATOR_LEN;


/**
 * The application uses console-based menu-driven UI that presents the user
 * with a suite of choices for using the application.
 *
 * @author Andrei Drynov
 */
public class MainMenu {

    private final Scanner scanner = new Scanner(System.in);
    private final BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

    // handles input and output paths
    private final FileProcessor fileProcessor = new FileProcessor();

    // we could have used a different"indexer" thanks to OOP
    private final Indexator indexator = new BookIndexer();

    /**
     * Constructor
     */
    public MainMenu() {

    }

    /**
     * Gets the location of an English dictionary and tries to parse it.
     */
    private void loadDictionary() {
        System.out.println("Enter the path to the CSV dictionary file:");

        try {
            String input = readInput();

            // expect the dictionary file to be available and in CSV format
            if (fileProcessor.validatePath(input, ".csv", true) == null) {
                System.out.println("The dictionary in CSV format not found.");
                return;
            }

            var parser = new DictionaryParser();

            // determine the dictionary version (175K or 98K)
            int version = parser.determineVersion(input);
            WordDictionary.getInstance().setVersion(version);

            if (version == 0) {
                System.out.println("Please provide a valid version of the English dictionary");
                return;
            }

            System.out.println("Parsing the dictionary...");
            var words = parser.parseDictionary(input, version);
            WordDictionary.getInstance().setEntries(words);

        } catch (Exception e) {
            System.out.println("Error processing dictionary" + e.getLocalizedMessage());
        }
    }

    /**
     * Gets the location of the "Google's list" file which contains most common words and tries to parse it.
     */
    private void loadCommonWords() {
        System.out.println("\nEnter the path to the Google’s list of 1,000 most common words:");

        String input = readInput();

        // validate the path to the Google's list
        if ((fileProcessor.validatePath(input, ".txt", true) == null)) {
            System.out.println("The list of common words in TXT format not found");
            return;
        }

        System.out.println("Parsing common words");

        try {
            // load common words from the file (e.g. 'google.txt')
            var parser = new DictionaryParser();
            var words = parser.parseGoogle(input);

            WordDictionary.getInstance().setCommonWords(words);

        } catch (IOException e) {
            System.out.println("Error processing common words " + e.getLocalizedMessage());
        }
    }

    /**
     * Ask to enter the location of the input text file from which the word index will be built.
     */
    private void specifyInput() {
        linePrinter.print('-', "");

        try {
            System.out.println("Specify the path of the e-book to process: ");
            String path = readInput();

            fileProcessor.setInputFile(path);

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println();
    }

    /**
     * Ask to enter the location of the output file containing the word index.
     */
    private void specifyOutput() {
        linePrinter.print('-', "");

        try {
            System.out.println("Specify the path of the text file where you want to store the word index: ");
            String input = readInput();

            fileProcessor.setOutputFile(input);

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    /**
     * Presents the main menu to the user.
     */
    public void showMenu() {
        linePrinter.print('*', "");
        System.out.println("*       ATU - Dept. Computer Science & Applied Physics     *");
        System.out.println("*                                                          *");
        System.out.println("*            Advanced Object-Oriented Programming          *");
        System.out.println("*                                                          *");
        System.out.println("*               Andrei Drynov (G00411287)                  *");
        linePrinter.print('*', "");

        while (true) {
            try {
                showStats();
                showMenuItems();

                // read user's menu choice
                String input = Objects.requireNonNull(readInput());
                int userChoice = Integer.parseInt(input);

                switch (userChoice) {
                    case 1 -> specifyInput();
                    case 2 -> loadDictionary();
                    case 3 -> loadCommonWords();
                    case 4 -> specifyOutput();
                    case 5 -> {
                        // input and output files are required
                        if (fileProcessor.getInputPath() == null || fileProcessor.getOutputPath() == null) {
                            System.out.println("Please specify the input and output files");
                            continue;
                        }

                        // build the index and save to the file
                        if (buildIndex()) outputIndex();
                    }
                    case 6 -> {
                        if (fileProcessor.getInputPath() == null) {
                            System.out.println("Please specify the input file");
                            continue;
                        }

                        if (buildIndex()) {
                            linePrinter.print('-', "");
                            System.out.println("\nPrinting the first 5 items");

                            indexator.printIndex(5);

                        }
                    }
                    case 9 -> {
                        System.out.println("Thank you for using this application");
                        System.exit(0);
                    }
                    default -> System.out.println("\nERROR: invalid choice");
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Displays menu items and allows user make a choice.
     */
    private void showMenuItems() {
        System.out.println("(1) Specify Text File");
        System.out.println("(2) Configure Dictionary");
        System.out.println("(3) Configure Common Words");
        System.out.println("(4) Specify Output File");
        System.out.println("(5) Execute and Save");
        System.out.println("(6) Execute and Print");
        System.out.println("(9) Quit");
        System.out.println();

        //Output a menu of options and solicit text from the user
        System.out.print("Select Option [1-9]>");
    }

    /**
     * Shows file paths selected, words counts in dictionaries etc.
     */
    private void showStats() {
        System.out.println();
        linePrinter.print('-', "STATUS");

        System.out.println("Input file:\t" + (fileProcessor.getInputPath() != null ? fileProcessor.getInputPath() : "NOT SET"));
        System.out.println("Output file:\t" + (fileProcessor.getOutputPath() != null ? fileProcessor.getOutputPath() : "NOT SET"));

        // show count of dictionary entries and words (delegation example)
        WordDictionary.getInstance().showStats();

        System.out.println();

        linePrinter.print('-', "MENU");
    }

    /**
     * Read the user input typed in the console.
     *
     * @return User-entered text
     */
    private String readInput() {
        try {
            return userInput.readLine().strip();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
            return null;
        }
    }

    /**
     * Tries to build the word index.
     *
     * @return True if the index has been built, otherwise false.
     */
    private boolean buildIndex() {
        System.out.println();

        // check: English dictionary and common words loaded
        if (!WordDictionary.getInstance().isReady()) {
            System.out.println("Please configure the dictionary and Google's list of common words!");
            return false;
        }

        try {
            System.out.println("Building index...");

            String inputPath = fileProcessor.getInputPath().toFile().getAbsolutePath();
            indexator.buildIndex(inputPath);

            System.out.println("Index has been built...");
            return true;

        } catch (ApplicationException e) {
            System.out.println("ERROR processing data: " + e.getMessage());
            return false;
        }
    }

    /**
     * Outputs the index to the specified text file.
     */
    private void outputIndex() {
        String outputPath = fileProcessor.getOutputPath().toString();

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outputPath, false)))) {
            System.out.println("Outputting the index...");
            indexator.outputIndex(writer);
            System.out.println("Index saved to " + outputPath);

        } catch (FileNotFoundException e) {
            System.out.println("ERROR opening the output file. " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR writing index to the output file. " + e.getMessage());
        }
    }

    /**
     * Prints a separator line with(out) a title.
     */
    private final SeparatorPrinter linePrinter = ((separator, title) -> {
        if (title.isBlank()) {
            System.out.println(String.valueOf(separator).repeat(SEPARATOR_LEN));
        } else {
            String section = String.valueOf(separator).repeat(SEPARATOR_LEN / 2 - title.length() / 2 - 1);
            System.out.println(section + " " + title + " " + section);
        }
    });
}