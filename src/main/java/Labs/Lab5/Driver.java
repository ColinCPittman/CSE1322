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
        for (int i = 0; i < 5 && !exited; i++) {
                type = dataGrabber.promptUserForChar("Please enter B for Book or P for Periodical");
                if(type.isEmpty()) break;
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
                        if (title.isEmpty())  {
                            exited = true;
                            break;
                        }
                        issue = dataGrabber.promptUserForNonNegativeInt("Please enter the issue number");
                        if (issue.isEmpty()) {
                            exited = true;
                            break;
                        }
                        Periodical newPeriodical = new Periodical(title.get(), issue.get());
                        bookCollection[i] = newPeriodical;
                    }
                    default -> System.out.println("Invalid input. Please try again.");
                }
        }
        if(exited) {
            System.out.println("Exiting...");
        }
        else {
            System.out.println("Your Items:");
            for (Item item : bookCollection) {
                System.out.println(item.getListing());
            }
        }
    }

    private static final char book = 'B';
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
            } else if (isNumber(output)) {
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

    public static Optional<Integer> promptUserForNonNegativeInt(String prompt) {
        int value;
        while (true) {
            System.out.print(prompt + " [type 'cancel' to return]:");
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

    private static boolean isNumber(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException err1) {
            try {
                Double.parseDouble(string);
                return true;
            }catch (NumberFormatException err2) {
                return false;
            }
        }
    }
}