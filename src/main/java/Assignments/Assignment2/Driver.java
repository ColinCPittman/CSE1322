package Assignments.Assignment2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Dispatcher dispatch = new Dispatcher();
        int choice;
        do {
            System.out.println(mainMenu);
            choice = promptUserForMenuChoice(fromOne, toNine, exit_value, "Choice: ");
            switch (choice) {
                case add_bus -> handleCaseAddBus(dispatch);
                case add_person_to_bus -> handleCaseAddPerson(dispatch);
                case remove_bus -> handleCaseRemoveBus(dispatch);
                case remove_person -> handleCaseRemovePerson(dispatch);
                case list_passengers -> handleCaesListPassengers(dispatch);
                case list_buses -> System.out.println("BUS QUEUE " + dispatch);
                case requeue_bus -> handleCaseRequeueBus(dispatch);
                case transfer_person -> handleCaseTransferPerson(dispatch);
                case dispatch_bus -> handleCaseDispatchBus(dispatch);
                case exit_value -> System.out.println("Shutting down...");
            }
        } while (choice != exit_value);
    }

    private static void handleCaseAddBus(Dispatcher dispatch) {
        Bus newBus = new Bus();
        System.out.println("Bus " + newBus + " was added to position " + dispatch.addBus(newBus));
    }

    private static void handleCaseRemoveBus(Dispatcher dispatch) {
        int busIDChoice = promptUserForNonNegative("Enter bus ID [type 'cancel' to exit]:");
        if (busIDChoice == user_cancelled) return;
        if (dispatch.findBus(busIDChoice) == null) {
            System.out.println("No bus with ID " + busIDChoice);
        } else System.out.println("Bus " + dispatch.removeBus(busIDChoice).getID() + " removed.");
    }

    private static void handleCaseAddPerson(Dispatcher dispatch) {
        int busIDChoice = promptUserForNonNegative("Enter bus ID [type 'cancel' to exit]:");
        if (busIDChoice == user_cancelled) return;
        Bus foundBus = dispatch.findBus(busIDChoice);
        if (foundBus == null) {
            System.out.println("No bush with ID " + busIDChoice);
        } else {
            String nameChoice = promptUserForString("Please enter person's name [type '-1' to cancel]:");
            if ("-1".equals(nameChoice)) return;
            Person newPerson = new Person(nameChoice);
            foundBus.addPerson(newPerson);
            System.out.println(newPerson.getName() + " has been added to bus " + foundBus);
        }
    }

    private static void handleCaseDispatchBus(Dispatcher dispatch) {
        Bus dispatchedBus = dispatch.dispatchBus();
        if (dispatchedBus == null) {
            System.out.println("Bus queue is empty.");
        } else System.out.println(dispatchedBus + " has been dispatched");
    }

    private static void handleCaseRequeueBus(Dispatcher dispatch) {
        int busIDChoice = promptUserForNonNegative("Enter bus ID [type 'cancel' to exit]:");
        if (busIDChoice == user_cancelled) return;
        Bus foundBus = dispatch.findBus(busIDChoice);
        if (foundBus == null) {
            System.out.println("No bush with ID " + busIDChoice);
        } else {
            int newPosition = promptUserForNonNegative("Enter new bus position[type 'cancel' to return to main menu]:");
            if (newPosition == user_cancelled) return;
            System.out.println("Bus " + busIDChoice + " added to position " + dispatch.addBus(foundBus, newPosition));
        }
    }

    private static void handleCaesListPassengers(Dispatcher dispatch) {
        int busIDChoice = promptUserForNonNegative("Enter bus ID [type 'cancel' to exit]: ");
        if (busIDChoice == user_cancelled) return;
        Bus foundBus = dispatch.findBus(busIDChoice);
        if (foundBus == null) {
            System.out.println("No bush with ID " + busIDChoice);
        } else System.out.println("BUS [ID] \n" + foundBus.toString());
    }

    private static void handleCaseRemovePerson(Dispatcher dispatch) {
        int busIDChoice = promptUserForNonNegative("Enter bus ID [type 'cancel' to exit]: ");
        if (busIDChoice == user_cancelled) return;
        if (dispatch.findBus(busIDChoice) == null) {
            System.out.println("No bus with ID " + busIDChoice);
        } else {
            String nameChoice = promptUserForString("Please enter person's name [type '-1' to cancel]:");
            if ("-1".equals(nameChoice)) return;
            Person foundPerson = dispatch.findBus(busIDChoice).findPerson(nameChoice);
            if (foundPerson == null) {
                System.out.println("No such person found in bus " + busIDChoice);
            } else {
                dispatch.findBus(busIDChoice).removePerson(foundPerson);
                System.out.println(nameChoice + " has been removed from bus " + busIDChoice);
            }
        }
    }

    private static void handleCaseTransferPerson(Dispatcher dispatch) {
        String nameChoice = promptUserForString("Please enter person's name [type '-1' to cancel]:");
        if ("-1".equals(nameChoice)) return;
        int initialBusIDChoice = promptUserForNonNegative("Please enter the ID of the initial bus[type 'cancel' to return to main menu]:");
        if (initialBusIDChoice == user_cancelled) return;
        int transferBusIDChoice = promptUserForNonNegative("Please enter the ID of the transfer bus[type 'cancel' to return to main menu:");
        if (transferBusIDChoice == user_cancelled) return;
        Bus foundInitialBus = dispatch.findBus(initialBusIDChoice);
        Bus foundTransferBus = dispatch.findBus(transferBusIDChoice);
        if (foundInitialBus == null) System.out.println("No bus with ID " + initialBusIDChoice);
        if (foundTransferBus == null) System.out.println("No bus with ID " + transferBusIDChoice);
        if (foundInitialBus != null) {
            Person foundPerson = foundInitialBus.findPerson(nameChoice);
            if (foundPerson == null) {
                System.out.println("No person named " + nameChoice + " on bus " + initialBusIDChoice);
            }
            if (!(foundTransferBus == null || foundPerson == null)) { //foundInitialBus will be checked for null in method transferPerson()
                if (foundInitialBus.transferPerson(foundInitialBus, foundTransferBus, foundPerson)) {
                    System.out.println("Person transferred successfully.");
                } else System.out.println("Person transfer failed.");
            } else {
            }
        }
    }

    public static String promptUserForString(String prompt) {
        String output;
        int value;
        while (true) {
            System.out.print(prompt);
            output = scanner.nextLine();
            try {
                value = Integer.parseInt(output);
                if (value != -1) {
                    System.out.println("Invalid input. Please try again.");
                } else return output;
            } catch (NumberFormatException err) {
                return output;
            }
        }
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
    public static int promptUserForNonNegative(String choicePrompt) {
        int value;

        while (true) {
            System.out.print(choicePrompt);
            String input = scanner.nextLine();

            try {
                value = Integer.parseInt(input);
                if (value < 0) {
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
    public static final int toNine = 9;
    public static final int exit_value = 0;
    public static final int add_bus = 1;
    public static final int add_person_to_bus = 2;
    public static final int remove_bus = 3;
    public static final int remove_person = 4;
    public static final int list_passengers = 5;
    public static final int list_buses = 6;
    public static final int requeue_bus = 7;
    public static final int transfer_person = 8;
    public static final int dispatch_bus = 9;
    public static final int user_cancelled = -1;
    public static String mainMenu = """
            Bus Dispatching System
                        
            1. Add bus
            2. Add person to bus
            3. Remove bus
            4. Remove person
            5. List passengers
            6. List buses
            7. Requeue bus
            8. Transfer person
            9. Dispatch bus
            0. Exit""";
}
