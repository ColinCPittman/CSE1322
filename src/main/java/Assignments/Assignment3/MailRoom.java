package Assignments.Assignment3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MailRoom {
    public static void main(String[] args) {
        ArrayList<Mail> deliver = new ArrayList<>();
        int mainMenuChoice;
        do {
            System.out.println(mainMenu);
            mainMenuChoice = promptUserForMenuChoice(fromOne, toFive, exit_value, "Choice: ");
            switch (mainMenuChoice) {
                case send_letter -> {
                    MailInput inputs = new MailInput();
                    inputs = captureMailInput(inputs, Letter.class);
                    if (inputs == null) break;
                    Letter newLetter = new Letter(inputs.deliveryAddress, inputs.returnAddress, inputs.width, inputs.length, inputs.thickness, inputs.content);
                    if (handleLetter(newLetter, deliver)) System.out.println("Letter accepted for delivery.");
                    else System.out.println("Letter not accepted for delivery.");
                }
                case send_flat -> {
                    MailInput inputs = new MailInput();
                    inputs = captureMailInput(inputs, Flat.class);
                    if (inputs == null) break;
                    Flat newFlat = new Flat(inputs.deliveryAddress, inputs.returnAddress, inputs.width, inputs.length, inputs.thickness, inputs.content);
                    if (handleFlat(newFlat, deliver)) System.out.println("Flat accepted for delivery.");
                    else System.out.println("Flat not accepted for delivery.");
                }
                case send_regular_box -> {
                    MailInput inputs = new MailInput();
                    inputs = captureMailInput(inputs,RegularBox.class);
                    if(inputs == null) break;
                    RegularBox newRegularBox = new RegularBox(inputs.deliveryAddress,inputs.returnAddress,inputs.width,inputs.length,inputs.height,inputs.count,inputs.items,inputs.weight);
                    if(handleRegularBox(newRegularBox,deliver)) System.out.println("Regular box accepted for delivery.");
                    else System.out.println("Regular box not accepted for delivery.");
                }
                case send_live_box -> {
                    MailInput inputs = new MailInput();
                    inputs = captureMailInput(inputs, LiveBox.class);
                    if(inputs == null) break;
                    LiveBox newLiveBox = new LiveBox(inputs.deliveryAddress,inputs.returnAddress,inputs.width,inputs.length,inputs.height,inputs.count,inputs.animal,inputs.age);
                    if(handleLiveBox(newLiveBox,deliver)) System.out.println("Live box accepted for delivery.");
                    else System.out.println("Live box not accepted for delivery");
                }
                case dispatch_items -> {
                    System.out.println("DISPATCHING THE FOLLOWING ITEMS FOR DELIVERY:\n");
                    for (Mail mail : deliver) {
                        System.out.println("==========");
                        System.out.print(mail.toString());
                    }
                    deliver.clear();
                }
                case exit_value -> System.out.println("Quitting...");
            }
        } while (mainMenuChoice != exit_value);
    }

    public static boolean handleLetter(Letter letter, ArrayList<Mail> deliver) {
        if (!hasAddresses(letter)) return false;
        if (!sizeIsValid(letter)) return false;
        if (!isRectangular(letter)) return false;
        deliver.add(letter);
        return true;
    }

    public static boolean handleFlat(Flat flat, ArrayList<Mail> deliver) {
        if (!hasAddresses(flat)) return false;
        if (!sizeIsValid(flat)) return false;
        if (!"DOCUMENTS".equals(flat.getContents())) return false;
        deliver.add(flat);
        return true;
    }

    public static boolean handleRegularBox(RegularBox box, ArrayList<Mail> deliver) {
        if (!hasAddresses(box)) return false;
        if (!sizeIsValid(box)) return false;
        if (!(3 <= box.getWeight() && box.getWeight() <= 70.0d)) return false;
        if (!(0 <= box.getCount() && box.getCount() <= 50)) return false;
        deliver.add(box);
        return true;
    }

    public static boolean handleLiveBox(LiveBox liveBox, ArrayList<Mail> deliver) {
        if (!hasAddresses(liveBox)) return false;
        if (!sizeIsValid(liveBox)) return false;
        String animalType = liveBox.getAnimal();
        if ("HONEYBEES".equals(animalType)) {
            if (!(0 <= liveBox.getCount() && liveBox.getCount() <= 20)) return false;
        } else if ("CHICKEN".equals(animalType)) {
            if (!(0 <= liveBox.getCount() && liveBox.getCount() <= 10)) return false;
        } else {
            return false;
        }
        deliver.add(liveBox);
        return true;
    }

    private static boolean isRectangular(Letter letter) {
        if (letter.getLength() - letter.getWidth() >= 1.5) {
            return true;
        }
        return false;
    }

    private static boolean hasAddresses(Letter letter) {
        if (!(letter.deliveryAddress.isEmpty() && letter.returnAddress.isEmpty())) {
            return true;
        }
        return false;
    }

    private static boolean hasAddresses(Flat flat) {
        if (!(flat.deliveryAddress.isEmpty() && flat.returnAddress.isEmpty())) {
            return true;
        }
        return false;
    }

    private static boolean hasAddresses(RegularBox box) {
        if (!(box.deliveryAddress.isEmpty() && box.returnAddress.isEmpty())) {
            return true;
        }
        return false;
    }

    private static boolean hasAddresses(LiveBox liveBox) {
        if (!(liveBox.deliveryAddress.isEmpty() && liveBox.returnAddress.isEmpty())) {
            return true;
        }
        return false;
    }

    private static boolean sizeIsValid(Flat flat) {
        if (11.5d <= flat.getLength() && flat.getLength() <= 15.0d) {
            if (6.125d <= flat.getWidth() && flat.getWidth() <= 12.0d) {
                if (0.25 <= flat.getThickness() && flat.getThickness() <= 0.75d) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean sizeIsValid(LiveBox liveBox) {
        if (6.0d <= liveBox.getLength() && liveBox.getLength() <= 27.0d) {
            if (0.25d <= liveBox.getWidth() && liveBox.getWidth() <= 17.0d) {
                if (3.0d <= liveBox.getHeight() && liveBox.getHeight() <= 17.0d) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean sizeIsValid(RegularBox box) {
        if (6.0d <= box.getLength() && box.getLength() <= 27.0d) {
            if (0.25d <= box.getWidth() && box.getWidth() <= 17.0d) {
                if (3.0d <= box.getHeight() && box.getHeight() <= 17.0d) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean sizeIsValid(Letter letter) {
        if (5.0 <= letter.getLength() && letter.getLength() <= 11.5d) {
            if (3.5 <= letter.getWidth() && letter.getWidth() <= 6.125d) {
                if (0.007 <= letter.getThickness() && letter.getThickness() <= 0.25d) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Used for getting any non-negative integer from the user via the Scanner on System.in.
     * User is continually prompted until a valid input is given, with the option typing "cancel" to return -1.
     *
     * @param choicePrompt Prompt to display for user input.
     * @return Either a non-negative int or -1.
     */
    public static int promptUserForNonNegativeInt(String choicePrompt) {
        int value;

        while (true) {
            System.out.print(choicePrompt);
            String input = scanner.nextLine();

            try {
                value = Integer.parseInt(input);
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

    /**
     * Used for getting any non-negative integer from the user via the Scanner on System.in.
     * User is continually prompted until a valid input is given, with the option typing "cancel" to return -1.
     *
     * @param choicePrompt Prompt to display for user input.
     * @return Either a non-negative int or -1.
     */
    public static double promptUserForNonNegativeDouble(String choicePrompt) {
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

    /**
     * Prompts the user with provided prompt and gives them the option to exit by entering '-1'.
     *
     * @param prompt Used to prompt the user to enter a string.
     * @return -1 if user wants to exit or a string from user.
     */
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

                if (!((lowValue <= userInput && userInput <= highValue) || userInput == exitValue)) {
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

    public static final int user_cancelled = -1;
    public static final int fromOne = 1;
    public static final int toFive = 5;
    public static final int exit_value = 6;
    public static final int send_letter = 1;
    public static final int send_flat = 2;
    public static final int send_regular_box = 3;
    public static final int send_live_box = 4;
    public static final int dispatch_items = 5;
    private static String mainMenu = """
            Welcome to KSUPS
            1- Send letter
            2- Send flat
            3- Send regular box
            4- Send live box
            5- Dispatch items
            6- Quit
            """;

    private static MailInput captureMailInput(MailInput inputs, Class<?> mailClass) {
        inputs.deliveryAddress = promptUserForString("Enter the delivery address[type '-1' to return]:");
        if ("-1".equals(inputs.deliveryAddress)) return null;

        inputs.returnAddress = promptUserForString("Enter the return address[type '-1' to return]:");
        if ("-1".equals(inputs.returnAddress)) return null;

        inputs.width = promptUserForNonNegativeDouble("Enter the width of your mail [type 'cancel' to return]:");
        if (inputs.width == user_cancelled) return null;

        inputs.length = promptUserForNonNegativeDouble("Enter the length of your mail [type 'cancel' to return]:");
        if (inputs.length == user_cancelled) return null;

        if (mailClass == Letter.class) {
            inputs.thickness = promptUserForNonNegativeDouble("Enter the thickness of your mail [type 'cancel' to return]:");
            if (inputs.thickness == exit_value) return null;

            inputs.content = promptUserForString("Enter the contents of your mail [type '-1' to cancel]:");
            if ("-1".equals(inputs.content)) return null;
        }

        if (Box.class.isAssignableFrom(mailClass)) {
            inputs.height = promptUserForNonNegativeDouble("Enter the height of your mail [type 'cancel' to return]:");
            if (inputs.height == user_cancelled) return null;

            inputs.count = promptUserForNonNegativeInt("Enter how many items your box has [type 'cancel' to return]:");
            if (inputs.count == user_cancelled) return null;
        }

        if (mailClass == RegularBox.class) {
            inputs.weight = promptUserForNonNegativeDouble("Enter the weight of your box [type 'cancel' to return]:");
            if (inputs.weight == user_cancelled) return null;

            inputs.items = promptUserForString("Enter the contents of your box [type '-1' to return]:");
            if("-1".equals(inputs.items)) return null;
        }

        if (mailClass == LiveBox.class) {
            inputs.animal = promptUserForString("Enter what animal is being shipped[type '-1' to return]:");
            if ("-1".equals(inputs.animal)) return null;

            inputs.age = promptUserForNonNegativeInt("Enter age of the oldest animal in days [type 'cancel' to return]:");
            if (inputs.age == user_cancelled) return null;
        }

        return inputs;
    }

    static class MailInput {
        String deliveryAddress, returnAddress, content, animal,items;
        double width, length, thickness, height, weight;
        int count, age;
    }
}
