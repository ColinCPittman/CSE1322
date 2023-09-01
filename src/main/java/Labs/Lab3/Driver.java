package Labs.Lab3;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Driver {
    public static void main(String[] args) {
        int menuChoice;
        Quiz quiz = new Quiz();
        do {
            System.out.println(mainMenu);
            menuChoice = getMenuChoice(fromOne, toFive, exitValue, "Choice: ");
            switch (menuChoice) {
                case add_question -> quiz.add_question();
                case remove_question -> quiz.remove_question();
                case modify_question -> quiz.modify_question();
                case take_the_quiz -> quiz.give_quiz();
                case exitValue -> System.out.println("Shutting down");
            }
        } while (menuChoice != exitValue);
    }

    /**
     * Get an integer input from the user using the Scanner on System.in.
     * Intended for use with simple numbered menus in coding assignments with an option to exit.
     * Prompts the user until a valid input is given.
     *
     * @param lowValue     Lowest numbered menu option.
     * @param highValue    Highest numbered menu option.
     * @param exitValue    Number option to exit the menu.
     * @param choicePrompt Prompt to display for user input.
     * @return Selected menu option or exit value.
     */
    public static int getMenuChoice(int lowValue, int highValue, int exitValue, String choicePrompt) {
        boolean isInputValid;
        int userInput = exitValue;

        do {
            System.out.print(choicePrompt);
            isInputValid = true;

            try {
                userInput = scanner.nextInt();
                scanner.nextLine();

                if (!isValidInput(userInput, lowValue, highValue, exitValue)) {
                    isInputValid = false;
                }
            } catch (InputMismatchException e) {
                isInputValid = false;
                scanner.nextLine();
            }

            if (!isInputValid) {
                System.out.println("Invalid input. Enter a choice between " + lowValue + " and " + highValue + ", or " + exitValue + " to exit.");
            }
        } while (!isInputValid);

        return userInput;
    }

    static String mainMenu = """
                        
            What would you like to do?
            1. Add a question to the quiz
            2. Remove a question from the quiz
            3. Modify a question in the quiz
            4. Take the quiz
            5. Quit""";
    static Scanner scanner = new Scanner(System.in);

    private static boolean isValidInput(int input, int lowValue, int highValue, int exitValue) {
        return (input >= lowValue && input <= highValue) || input == exitValue;
    }

    static final int add_question = 1;
    static final int remove_question = 2;
    static final int modify_question = 3;
    static final int take_the_quiz = 4;
    static final int fromOne = 1;
    static final int toFive = 5;
    static final int exitValue = 5;
}