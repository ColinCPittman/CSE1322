package Labs.Lab7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab7A {
    public static void main(String[] args) {
        int menuChoice;
        do{
            System.out.println(mainMenu);
            menuChoice = DataGrabber.promptUserForMenuChoice(fromOne, toThree, exit_value, "Enter choice");
            switch (menuChoice) {
                case multiply_two_numbers ->{
                    int firstNum = DataGrabber.promptUserForAnyInt("Enter first number");
                    if(firstNum == DataGrabber.CANCEL_OUTPUT_INT) break;
                    int secondNum = DataGrabber.promptUserForAnyInt("Enter second number");
                    if(secondNum == DataGrabber.CANCEL_OUTPUT_INT) break;
                    System.out.println("Answer: " + recursive_multiply(firstNum, secondNum));
                }
                case div_two_numbers -> {
                    int firstNum = DataGrabber.promptUserForAnyInt("Enter first number");
                    if(firstNum == DataGrabber.CANCEL_OUTPUT_INT) break;
                    int secondNum = DataGrabber.promptUserForAnyInt("Enter second number");
                    if(secondNum == DataGrabber.CANCEL_OUTPUT_INT) break;
                    System.out.println("Answer: " + recursive_div(firstNum,secondNum));
                }
                case mod_two_numbers -> {
                    int firstNum = DataGrabber.promptUserForAnyInt("Enter first number");
                    if(firstNum == DataGrabber.CANCEL_OUTPUT_INT) break;
                    int secondNum = DataGrabber.promptUserForAnyInt("Enter second number");
                    if(secondNum == DataGrabber.CANCEL_OUTPUT_INT) break;
                    System.out.println("Answer: " + recursive_mod(firstNum,secondNum));
                }
            }
        }while(menuChoice != exit_value);

    }

    public static int recursive_mod(int num1, int num2) {
        if (num2 == 0) return -1;

        boolean isNegative = (num1 < 0);

        num1 = Math.abs(num1);
        num2 = Math.abs(num2);

        if (num2 > num1) return num1;

        return isNegative ? -recursive_mod(num1 - num2, num2) : recursive_mod(num1 - num2, num2);
    }

    public static int recursive_div(int num1, int num2) {
        if (num2 == 0) return -1;

        boolean isNegative = (num1 < 0) ^ (num2 < 0);

        num1 = Math.abs(num1);
        num2 = Math.abs(num2);

        if (num1 < num2) return 0;

        if (num1 == num2) return 1;

        int result = 1 + recursive_div(num1 - num2, num2);
        return isNegative ? -result : result;
    }

    /**
     * Recursively multiplies two ints by addition.
     * Takes the past of the least resistance by adding the larger of the two and
     * recursively calling by lesser number of times.
     *
     * @param num1 Number to be multiplied with num2.
     * @param num2 Number to be multiplied with num1.
     * @return the multiplication of the two numbers together.
     */
    public static int recursive_multiply(int num1, int num2) {
        if (num2 == 0) return 0;

        boolean isNegative = (num1 < 0) ^ (num2 < 0);
        int smallerNum = Math.abs(Math.min(num1, num2));
        int largerNum = Math.abs(Math.max(num1, num2));

        int result = largerNum + recursive_multiply(largerNum, smallerNum - 1);

        return isNegative ? -result : result;
    }
    public static final int fromOne = 1;
    public static final int toThree = 3;
    public static final int exit_value = 0;
    public static final int multiply_two_numbers = 1;
    public static final int div_two_numbers = 2;
    public static final int mod_two_numbers = 3;

    public static String mainMenu = """
            
            Choose from the following:
            0. Quit
            1. Multiply 2 numbers
            2. Div 2 numbers
            3. Mod 2 numbers
                        """;

    /**
     * Helper class for the input and input validation operations
     * that these assignments often call for.
     */
    class DataGrabber {

        /**
         * Repeatedly prompts the user for a string input until a string is given that cannot be parsed into a number.
         * Prompt is proceeded by " [type 'CANCEL_VALUE' to return]:" where CANCEL_VALUE
         * is an exit value that breaks from the sequence and returns a value to indicate
         * the user wishes to return without proceeding.
         * CANCEL_VALUE is determined by the class's final string of the same name.
         *
         * @param prompt The prompt to display to the user.
         * @return The user's input as a string, or null if the user cancels.
         */
        public static String promptUserForString(String prompt) {
            String output;
            while (true) {
                System.out.print(prompt + " [type '" + CANCEL_VALUE + "' to return]:");
                output = scanner.nextLine();
                if (CANCEL_VALUE.equals(output)) {
                    return CANCEL_VALUE;
                } else if (isNumber(output)) {
                    System.out.println("Invalid input. Please try again.");
                } else {
                    return output;
                }
            }
        }

        /**
         * Repeatedly prompts the user for a single character until a valid one is given.
         * Prompt is proceeded by " [type 'CANCEL_VALUE' to return]:" where CANCEL_VALUE
         * is an exit value that breaks from the sequence and returns a value to indicate
         * the user wishes to return without proceeding.
         * CANCEL_VALUE is determined by the class's final string of the same name.
         *
         * @param prompt The prompt to display to the user for input.
         * @return The user's input as a char, or '\0' if the user cancels.
         */
        public static char promptUserForChar(String prompt) {
            String output;
            while (true) {
                System.out.print(prompt + " [type '" + CANCEL_VALUE + "' to return]:");
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
         * Prompt is proceeded by " [type 'CANCEL_VALUE' to return]:" where CANCEL_VALUE
         * is an exit value that breaks from the sequence and returns a value to indicate
         * the user wishes to return without proceeding.
         * CANCEL_VALUE is determined by the class's final string of the same name.
         *
         * @param prompt The prompt to display to the user for input.
         * @return The user's input as a non-negative integer, or -1 if the user cancels.
         */
        public static int promptUserForNonNegativeInt(String prompt) {
            while (true) {
                System.out.print(prompt + " [type '" + CANCEL_VALUE + "' to return]:");
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
         * Repeatedly prompts the user for an integer until a valid one is given.
         * Prompt is proceeded by " [type 'CANCEL_VALUE' to return]:" where CANCEL_VALUE
         * is an exit value that breaks from the sequence and returns a value to indicate
         * the user wishes to return without proceeding.
         * CANCEL_VALUE is determined by the class's final string of the same name.
         *
         * @param prompt The prompt to display to the user for input.
         * @return The user's input as an integer, or -1 if the user cancels.
         */
        public static int promptUserForAnyInt(String prompt) {
            while (true) {
                System.out.print(prompt + " [type '" + CANCEL_VALUE + "' to return]:");
                String input = scanner.nextLine();
                if (isNumber(input)) {
                    return Integer.parseInt(input);
                } else if (CANCEL_VALUE.equalsIgnoreCase(input)) {
                    return CANCEL_OUTPUT_INT;
                } else {
                    System.out.println("Invalid input. Please enter a number or '" + CANCEL_VALUE + "' to return.");
                }
            }
        }
        /**
         * Repeatedly prompts the user for a non-zero integer until a valid one is given.
         * Prompt is proceeded by " [type 'CANCEL_VALUE' to return]:" where CANCEL_VALUE
         * is an exit value that breaks from the sequence and returns a value to indicate
         * the user wishes to return without proceeding.
         * CANCEL_VALUE is determined by the class's final string of the same name.
         *
         * @param prompt The prompt to display to the user for input.
         * @return The user's input as a non-zero integer, or -1 if the user cancels.
         */
        public static int promptUserForNonZeroInt(String prompt) {
            while (true) {
                System.out.print(prompt + " [type '" + CANCEL_VALUE + "' to return]:");
                String input = scanner.nextLine();
                if (isNonZeroInteger(input)) {
                    return Integer.parseInt(input);
                } else if (CANCEL_VALUE.equalsIgnoreCase(input)) {
                    return CANCEL_OUTPUT_INT;
                } else {
                    System.out.println("Invalid input. Please enter a non-zero number or '" + CANCEL_VALUE + "' to return.");
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
        /**
         * This value sets what the user must type to cancel from being asked for input.
         */
        public static final String CANCEL_VALUE = "cancel";
        /**
         * Returned when user chooses to cancel from a prompt asking them to enter a number.
         */
        public static final int CANCEL_OUTPUT_INT = Integer.MIN_VALUE;
        /**
         * Returned when user chooses to cancel form a prompt asking them to enter a character.
         */
        public static final char CANCEL_OUTPUT_CHAR = '\0';

    }
}
