package Labs.Lab5;

import java.util.Optional;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Initializing ADD FIVE ITEMS TO CATALOG ...");
        DataGrabber dataGrabber = new DataGrabber();
        Item[] bookCollection = new Item[5];
        Optional<Character> type;
        Optional<String> title, author;
        Optional<Integer> isbn, issue;
        boolean exited = false;
        for (int i = 0; i < 5; i++) {
            do {
                type = dataGrabber.promptUserForChar("Please enter B for Book or P for Periodical");
                if(type.isEmpty()) {
                    exited = true;
                    break;
                }
                if (type.isEmpty()) break;
                switch (type.get()) {
                    case book -> {
                        title = dataGrabber.promptUserForString("Please enter the name of the Book");
                        if (title.isEmpty()) {
                            exited = true;
                            break;
                        }
                        author = dataGrabber.promptUserForString("Please enter the author of the Book");
                        if (author.isEmpty()) {
                            exited = true;
                            break;
                        }
                        isbn = dataGrabber.promptUserForNonNegativeInt("Please enter ISBN of the Book");
                        if (isbn.isEmpty()) {
                            exited = true;
                            break;
                        }
                        Book newBook = new Book(title.get(), isbn.get(), author.get());
                        bookCollection[i] = newBook;
                    }
                    case periodical -> {
                        title = dataGrabber.promptUserForString("Please enter name of Periodical");
                        if (title.isEmpty()) {
                            exited = true;
                            break;
                        }
                        issue = dataGrabber.promptUserForNonNegativeInt("Please enter the issue number");
                        if (issue.isEmpty()) {
                            exited = true;
                            break;
                        }
                        Periodical newPeriodical = new Periodical(title.get(), issue.get());
                    }
                    default -> System.out.println("Invalid input. Please try again.");
                }
            } while (!exited);
            if(exited)break;
        }
        System.out.println("Exiting...");
    }

    private static final char book = 'A';
    private static final char periodical = 'P';
}

//experimenting with optionals also wrapping up all my input getter/validators in the same class for clarity
class DataGrabber {

    public static Scanner scanner = new Scanner(System.in);

    public static Optional<String> promptUserForString(String prompt) {
        String output;
        while (true) {
            System.out.print(prompt + " [type '-1' to return]:");
            output = scanner.nextLine();
            if ("-1".equals(output)) {
                return Optional.empty();
            } else if (isNumeric(output)) {
                System.out.println("Invalid input. Please try again.");
            } else {
                return Optional.of(output);
            }
        }
    }

    public static Optional<Character> promptUserForChar(String prompt) {
        String output;
        while (true) {
            System.out.print(prompt + " [type 'cancel' to return]:");
            output = scanner.nextLine().trim();
            if ("cancel".equalsIgnoreCase(output)) {
                return Optional.empty();
            } else if (output.length() == 1) {
                return Optional.of(output.charAt(0));
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public static Optional<Integer> promptUserForNonNegativeInt(String choicePrompt) {
        int value;
        while (true) {
            System.out.print(choicePrompt);
            String input = scanner.nextLine();
            try {
                value = Integer.parseInt(input);
                if (value >= 0) {
                    return Optional.of(value);
                } else {
                    System.out.println("Please enter a non-negative value or \'cancel\' to return.");
                }
            } catch (NumberFormatException err) {
                if ("cancel".equalsIgnoreCase(input)) {
                    return Optional.empty();
                }
                System.out.println("Invalid input. Please enter a non-negative number or \'cancel\' to return.");
            }
        }
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


//import java.util.Optional;
//import java.util.Scanner;
//
//public class Driver {
//    public static void main(String[] args) {
//        System.out.println("Initializing ADD FIVE ITEMS TO CATALOG ...");
//        DataGrabber dataGrabber = new DataGrabber();
//        Item[] bookCollection = new Item[5];
//        Optional<String> title, author;
//        Optional<Integer> isbn,issue;
//        Optional<Character> type;
//        for (int i = 0; i < 5; i++) {
//            type = dataGrabber.promptUserForChar("Please enter B or Book or P for Periodical");
//            if(type.isEmpty()) break;
//            if(type.equals('B')) {
//
//            }
//        }
//    }
//}
//
//class DataGrabber {
//
//    //experimenting with optionals to get accustomed.
//    /**
//     * Prompts the user with provided prompt and gives them the option to exit by entering '-1'.
//     *
//     * @param prompt Used to prompt the user to enter a string.
//     * @return -1 if user wants to exit or a string from user.
//     */
//    public static Optional<String> promptUserForString(String prompt) {
//        String output;
//        int value;
//        while (true) {
//            System.out.print(prompt + " [type '-1' to return]:");
//            output = scanner.nextLine();
//            try {
//                value = Integer.parseInt(output);
//                if (value == -1) return Optional.of(output);
//                else return Optional.of("Invalid input. Please try again.");
//
//            } catch (NumberFormatException err) {
//                return Optional.of(output);
//            }
//        }
//    }
//
//    /**
//     * Repeatedly prompts user for a valid char or gives them the option of returning nothing.
//     * @param prompt Prompt to display for user input, proceeded by " [type 'cancel' to return]:"
//     * @return Empty optional or a char.
//     */
//    public static Optional<Character> promptUserForChar(String prompt) {
//        String output;
//        while (true) {
//            System.out.println(prompt + " [type 'cancel' to return]:");
//            output = scanner.nextLine().trim();
//
//            if (output.equals("cancel")) {
//                return Optional.empty();
//            } else if (output.length() == 1) {
//                return Optional.of(output.charAt(0));
//            } else {
//                System.out.println("Invalid input. Please try again.");
//            }
//        }
//    }
//
//    /**
//     * Used for getting any non-negative integer from the user via the Scanner on System.in.
//     * User is continually prompted until a valid input is given, with the option typing "cancel" to return -1.
//     *
//     * @param choicePrompt Prompt to display for user input.
//     * @return Either a non-negative int or -1.
//     */
//    public static Optional<Integer> promptUserForNonNegativeInt(String choicePrompt) {
//        int value;
//
//        while (true) {
//            System.out.print(choicePrompt);
//            String input = scanner.nextLine();
//
//            try {
//                value = Integer.parseInt(input);
//                if (value < -1) {
//                    System.out.println("Please enter a non-negative value or \'cancel\' to return.");
//                    continue;
//                }
//                break;
//            } catch (NumberFormatException err) {
//                if ("cancel".equalsIgnoreCase(input)) {
//                    return Optional.empty();
//                }
//                System.out.println("Invalid input. Please enter a non-negative number or \'cancel\' to return.");
//            }
//        }
//
//        return Optional.of(value);
//    }
//    public static Scanner scanner = new Scanner(System.in);
//}