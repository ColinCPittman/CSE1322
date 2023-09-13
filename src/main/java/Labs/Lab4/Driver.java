package Labs.Lab4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Account checking = new Checking();
        Savings savings = new Savings();
        int mainMenuChoice;
        do {
            System.out.println(mainMenu);
            mainMenuChoice = promptUserForMenuChoice(fromOne, toSeven, exit_value, "Choice: ");
            switch (mainMenuChoice) {
                case withdraw_from_checking -> {
                    double amount = promptUserForNonNegative("Enter withdraw amount [type 'cancel' to return]:");
                    if (amount == user_cancelled) break;
                    checking.withdraw(amount);
                }
                case withdraw_from_savings -> {
                    double amount = promptUserForNonNegative("Enter withdraw amount [type 'cancel' to return]:");
                    if (amount == user_cancelled) break;
                    savings.withdraw(amount);
                }
                case deposit_to_checking -> {
                    double amount = promptUserForNonNegative("Enter deposit amount [type 'cancel' to return]:");
                    if (amount == user_cancelled) break;
                    checking.deposit(amount);
                }
                case deposit_to_savings -> {
                    double amount = promptUserForNonNegative("Enter deposit amount [type 'cancel' to return]:");
                    if (amount == user_cancelled) break;
                    savings.deposit(amount);
                }
                case balance_of_checking ->
                        System.out.println("Your checking account balance is $" + checking.getBalance());
                case balance_of_saving ->
                        System.out.println("Your savings account balance is $" + savings.getBalance());
                case award_interest_to_savings -> savings.addInterest();
                case exit_value -> System.out.println("Shutting down...");
            }

        } while (mainMenuChoice != exit_value);
    }

    public static Scanner scanner = new Scanner(System.in);

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
    public static int promptUserForMenuChoice(int lowValue, int highValue, int exitValue, String choicePrompt) {
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

    private static boolean isValidInput(int input, int lowValue, int highValue, int exitValue) {
        return (input >= lowValue && input <= highValue) || input == exitValue;
    }

    /**
     * Used for getting any non-negative integer from the user via the Scanner on System.in.
     * User is continually prompted until a valid input is given, with the option typing "cancel" to return -1.
     *
     * @param choicePrompt Prompt to display for user input.
     * @return Either a non-negative int or -1.
     */
    public static double promptUserForNonNegative(String choicePrompt) {
        double value;

        while (true) {
            System.out.print(choicePrompt);
            String input = scanner.nextLine();

            try {
                value = Double.parseDouble(input);
                if (value < 0.0d) {
                    System.out.println("Please enter a non-negative value or \"cancel\" to return.");
                    continue;
                }
                break;
            } catch (NumberFormatException err) {
                if ("cancel".equalsIgnoreCase(input)) {
                    return -1;
                }
                System.out.println("Invalid input. Please enter a non-negative number or \"cancel\" to return.");
            }
        }

        return value;
    }

    public static final int fromOne = 1;
    public static final int toSeven = 7;
    public static final int exit_value = 8;
    public static final int withdraw_from_checking = 1;
    public static final int withdraw_from_savings = 2;
    public static final int deposit_to_checking = 3;
    public static final int deposit_to_savings = 4;
    public static final int balance_of_checking = 5;
    public static final int balance_of_saving = 6;
    public static final int award_interest_to_savings = 7;
    public static final int user_cancelled = -1;
    public static String mainMenu = """
                        
            1. Withdraw from Checking
            2. Withdraw from Savings
            3. Deposit to Checking
            4. Deposit to Savings
            5. Balance of Checking
            6. Balance of Savings
            7. Award Interest to Savings Now
            8. Quit
            """;
}
