package Labs.Lab5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Initializing ADD FIVE ITEMS TO CATALOG ...");
        DataGrabber dataGrab = new DataGrabber();
        Item[] bookCollection = new Item[5];
        int type;
        String title, author;
        int isbn, issue;
        boolean exited = false;
        for (int i = 0; i < 5 && !exited; i++) {
            type = dataGrab.promptUserForChar("Please enter B for Book or P for Periodical");
            if (type == dataGrab.CANCEL_OUTPUT_CHAR) {
                exited = true;
                break;
            }
            switch (type) {
                case book -> {
                    title = dataGrab.promptUserForString("Please enter the name of the Book");
                    if (title == dataGrab.CANCEL_OUTPUT_STRING) {
                        exited = true;
                        break;
                    }
                    author = dataGrab.promptUserForString("Please enter the author of the Book");
                    if (author == dataGrab.CANCEL_OUTPUT_STRING) {
                        exited = true;
                        break;
                    }
                    isbn = dataGrab.promptUserForNonNegativeInt("Please enter ISBN of the Book");
                    if (isbn == dataGrab.CANCEL_OUTPUT_INT) {
                        exited = true;
                        break;
                    }
                    Book newBook = new Book(title, isbn, author);
                    bookCollection[i] = newBook;
                }
                case periodical -> {
                    title = dataGrab.promptUserForString("Please enter name of Periodical");
                    if (title == dataGrab.CANCEL_OUTPUT_STRING) {
                        exited = true;
                        break;
                    }
                    issue = dataGrab.promptUserForNonNegativeInt("Please enter the issue number");
                    if (issue == dataGrab.CANCEL_OUTPUT_INT) {
                        exited = true;
                        break;
                    }
                    Periodical newPeriodical = new Periodical(title, issue);
                    bookCollection[i] = newPeriodical;
                }
                default -> System.out.println("Invalid input. Please try again.");
            }
        }
        if (exited) {
            System.out.println("Exiting...");
        } else {
            System.out.println("Your Items:");
            for (Item item : bookCollection) {
                System.out.println(item.getListing());
            }
        }
    }

    private static final char book = 'B';
    private static final char periodical = 'P';
}

/**
 * Helper class used for all the various input and input-validation related tasks
 * that these assignments often require. Offers various methods to assist with
 * coding elements that involve prompting the user and reading input from the scanner.
 */
class DataGrabber {

    /**
     * Repeatedly prompts the user for a string input until a string is given that cannot be parsed into a number.
     *
     * @param prompt The prompt to display to the user.
     * @return The user's input as a string, or null if the user cancels.
     */
    public static String promptUserForString(String prompt) {
        String output;
        while (true) {
            System.out.print(prompt + " [type \'" + CANCEL_VALUE + "\' to return]:");
            output = scanner.nextLine();
            if (CANCEL_VALUE.equals(output)) {
                return CANCEL_OUTPUT_STRING;
            } else if (isNumber(output)) {
                System.out.println("Invalid input. Please try again.");
            } else {
                return output;
            }
        }
    }
    /**
     * Repeatedly prompts the user for a single character until valid one is given.
     *
     * @param prompt The prompt to display to the user.
     * @return The user's input as a char, or '\0' if the user cancels.
     */
    public static char promptUserForChar(String prompt) {
        String output;
        while (true) {
            System.out.print(prompt + " [type \'" + CANCEL_VALUE + "\' to return]:");
            output = scanner.nextLine().trim();
            if (CANCEL_VALUE.equalsIgnoreCase(output)) {
                return CANCEL_OUTPUT_CHAR;
            } else if (output.length() == 1) {
                return output.charAt(0);
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
    /**
     * Checks if the given string is a non-negative integer.
     *
     * @param input The string to check.
     * @return True if the string can be parsed to an integer that is greater or equal to 0, false otherwise.
     */
    private static boolean isNonNegativeInteger(String input) {
        try {
            return Integer.parseInt(input) >= 0;
        } catch (NumberFormatException err) {
            return false;
        }
    }
    /**
     * Checks if the given string is a non-zero integer.
     *
     * @param input The string to check.
     * @return True if the string can be parsed to an integer that is greater than 0, false otherwise.
     */
    private static boolean isNonZeroInteger(String input) {
        try {
            return Integer.parseInt(input) > 0;
        } catch (NumberFormatException err) {
            return false;
        }
    }
    /**
     * Repeatedly prompts the user for a non-negative integer until a valid one is given.
     *
     * @param prompt The prompt to display to the user for input.
     * @return The user's input as a non-negative integer, or -1 if the user cancels.
     */
    public static int promptUserForNonNegativeInt(String prompt) {
        while (true) {
            System.out.print(prompt + " [type \'" + CANCEL_VALUE + "\' to return]:");
            String input = scanner.nextLine();
            if (isNonNegativeInteger(input)) {
                return Integer.parseInt(input);
            } else if (CANCEL_VALUE.equalsIgnoreCase(input)) {
                return CANCEL_OUTPUT_INT;
            } else {
                System.out.println("Invalid input. Please enter a non-negative number or " + CANCEL_VALUE + "  to return.");
            }
        }
    }
    /**
     * Repeatedly prompts the user for a non-zero integer until a valid one is given.
     *
     * @param prompt The prompt to display to the user for input.
     * @return The user's input as a non-zero integer, or -1 if the user cancels.
     */
    public static int promptUserForNonZeroInt(String prompt) {
        while (true) {
            System.out.print(prompt + " [type \'" + CANCEL_VALUE + "\' to return]:");
            String input = scanner.nextLine();
            if (isNonZeroInteger(input)) {
                return Integer.parseInt(input);
            } else if (CANCEL_VALUE.equalsIgnoreCase(input)) {
                return CANCEL_OUTPUT_INT;
            } else {
                System.out.println("Invalid input. Please enter a non-zero number or \'" + CANCEL_VALUE + "\' to return.");
            }
        }
    }
    /**
     * Checks if the given string is an integer or a double.
     *
     * @param string The string to check.
     * @return True if the string can be parsed for an integer or a double, false otherwise.
     */
    private static boolean isNumber(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException err1) {
            try {
                Double.parseDouble(string);
                return true;
            } catch (NumberFormatException err2) {
                return false;
            }
        }
    }

    /**
     * Repeatedly prompts the user for an integer until a valid one is given.
     * Intended for use with simple numbered menus in coding assignments with an option to exit.
     * User is restricted to only returning an int from lowValue to highValue or the exit value which
     * should correspond to the numbered menu option to exit the menu.
     *
     * @param lowValue     Lowest numbered menu option.
     * @param highValue    Highest numbered menu option.
     * @param exitValue    Number option to exit the menu.
     * @param choicePrompt Prompt to display for user input.
     * @return The user's menu option choice as an int or the exit value.
     */
    public static int promptUserForMenuChoice(int lowValue, int highValue, int exitValue, String choicePrompt) {
        boolean isInputValid;
        int userInput = exitValue;

        do {
            System.out.print(choicePrompt);
            isInputValid = true;

            try {
                userInput = scanner.nextInt();
                scanner.nextLine();

                if (!isValidMenuInput(userInput, lowValue, highValue, exitValue)) {
                    isInputValid = false;
                }
            } catch (InputMismatchException e) {
                isInputValid = false;
                scanner.nextLine();
            }

            if (!isInputValid) {
                System.out.println("Invalid input. Enter a choice between " + lowValue + " and " + highValue + ", or " + exitValue + " to return.");
            }
        } while (!isInputValid);

        return userInput;
    }
    /**
     * Checks if a given menu choice falls within the parameters.
     *
     * @param input     The menu choice to check.
     * @param lowValue  The lowest valid menu option.
     * @param highValue The highest valid menu option.
     * @param exitValue The menu option for exiting.
     * @return True if the menu choice is valid, false otherwise.
     */
    private static boolean isValidMenuInput(int input, int lowValue, int highValue, int exitValue) {
        return (input >= lowValue && input <= highValue) || input == exitValue;
    }

    public static Scanner scanner = new Scanner(System.in);
    public static final String CANCEL_VALUE = "cancel";
    public static final int CANCEL_OUTPUT_INT = -1;
    public static final char CANCEL_OUTPUT_CHAR = '\0';
    public static final String CANCEL_OUTPUT_STRING = null;
}