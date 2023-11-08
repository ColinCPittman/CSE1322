package Labs.Lab11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        BlueRayCollection brCollection = new BlueRayCollection();
        int menuChoice;
        do {
            System.out.println(mainMenu);
            menuChoice = promptUserForMenuChoice(fromOne, toTwo, exit_value, "Choice");
            switch (menuChoice) {
                case exit_value -> System.out.println("Shutting down...");
                case add_blueray_to_collection -> {
                    String title = promptUserForString("What is the title?");
                    String director = promptUserForString("What is the director?");
                    int releaseYear = promptUserForInt("What is the year of release?");
                    double cost = promptUserForDouble("What is the cost?");
                    brCollection.add(title, director, releaseYear, cost);
                }
                case see_collection -> brCollection.show_all();
            }
        } while (menuChoice != exit_value);
    }

    public static double promptUserForDouble(String prompt) {
        while (true) {
            System.out.print(prompt + ": ");
            String input = scanner.nextLine();
            if (isNumber(input)) {
                return Double.parseDouble(input);
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public static String mainMenu = """
            
            0. Quit
            1. Add BlueRay to collection
            2. See collection""";
    public static final int exit_value = 0;
    public static final int add_blueray_to_collection = 1;
    public static final int see_collection = 2;
    public static final int fromOne = 1;
    public static final int toTwo = 2;


    public static String promptUserForString(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }


    public static int promptUserForInt(String prompt) {
        while (true) {
            System.out.print(prompt + ": ");
            String input = scanner.nextLine();
            if (isNumber(input)) {
                return Integer.parseInt(input);
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
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
     * @param choicePrompt Prompt to display for user input. Will be appended with a colon before printing.
     * @return The user's menu option choice as an int or the exit value.
     */
    public static int promptUserForMenuChoice(int lowValue, int highValue, int exitValue, String choicePrompt) {
        boolean isInputValid;
        int userInput = exitValue;

        do {
            System.out.print(choicePrompt + ":");
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


}

