package Assignments.Assignment4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        ArrayList<Media> allMedia = new ArrayList<>();
        int mainMenuChoice;
        do {
            mainMenuChoice = DataGrabber.promptUserForMenuChoice(fromOne, toEight, exit_value, "Enter choice");
            switch (mainMenuChoice) {
                case add_image -> {
                    MediaInput inputs = new MediaInput();
                    inputs = inputs.getInputs(inputs, Image.class);
                    if (inputs == user_cancelled) break;
                    Image newImage = new Image(inputs.getName(), inputs.getImageCodec());
                    allMedia.add(newImage);
                }
                case add_music -> {
                    MediaInput inputs = new MediaInput();
                    inputs = inputs.getInputs(inputs,Music.class);
                    if(inputs == user_cancelled) break;
                    Music newMusic = new Music(inputs.getName(),inputs.getAudioCodec());
                    allMedia.add(newMusic);
                }
                case add_video -> {
                    MediaInput inputs = new MediaInput();
                    inputs = inputs.getInputs(inputs, Video.class);
                    if(inputs == user_cancelled) break;
                    Video newVideo = new Video(inputs.getName(), inputs.getImageCodec(), inputs.getAudioCodec());
                    allMedia.add(newVideo);
                }
                case show_images -> {
                    for (Media media : allMedia) {
                        System.out.println(((Image) media).getMediaInfo());
                    }
                }
            }
        }while(mainMenuChoice != exit_value);
    }
    private static final int add_image = 1;
    private static final int add_music = 2;
    private static final int add_video = 3;
    private static final int show_images = 4;
    private static final int show_music = 5;
    private static final int show_videos = 6;
    private static final int show_images_and_videos = 7;
    private static final int show_music_and_videos = 8;
    private static final int exit_value = 9;
    private static final int fromOne = 1;
    private static final int toEight = 8;
    private static final MediaInput user_cancelled = null;

    private static String mainMenu = """
                [Media Manager]
            1- Add Image
            2- Add Music
            3- Add Video
            4- Show images
            5- Show music
            6- Show videos
            7- Show images and videos
            8- Show music and videos
            9- Exit
            """;
}

/**
 * Helper class for prompting the user for and storing the data to be captured to generate a new Media object.
 */
class MediaInput {
    public String getName() {
        return name;
    }

    public String getImageCodec() {
        return imageCodec;
    }

    public String getAudioCodec() {
        return audioCodec;
    }

    private String name, imageCodec, audioCodec;

    /**
     * Fills provided MediaInput object fields with the necessary info to instantiate
     * an object of the provided Media child class.
     *
     * @param inputs For storing the information to be used to instantiate a new Media object.
     * @param mediaClass Used to determine the which information the user need for the class.
     * @return the provided input or null if the user choose to cancel.
     */
    public MediaInput getInputs(MediaInput inputs, Class<? extends Media> mediaClass) {
        inputs.name = DataGrabber.promptUserForString("Enter file name");
        if (DataGrabber.CANCEL_VALUE.equals(inputs.name)) return null;
        if (mediaClass.isAssignableFrom(Image.class) || mediaClass.isAssignableFrom(Video.class)) {
            inputs.imageCodec = DataGrabber.promptUserForString("Enter image codec");
            if (DataGrabber.CANCEL_VALUE.equals(inputs.imageCodec)) return null;
        }
        if(mediaClass.isAssignableFrom(Music.class) || mediaClass.isAssignableFrom(Video.class)) {
            inputs.audioCodec = DataGrabber.promptUserForString("Enter audio codec");
            if(DataGrabber.CANCEL_VALUE.equals(inputs.audioCodec)) return null;
        }
        return inputs;
    }
}

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
    /**
     * This value sets what the user must type to cancel from being asked for input.
     */
    public static final String CANCEL_VALUE = "cancel";
    /**
     * Returned when user chooses to cancel from a prompt asking them to enter a number.
     */
    public static final int CANCEL_OUTPUT_INT = -1;
    /**
     * Returned when user chooses to cancel form a prompt asking them to enter a character.
     */
    public static final char CANCEL_OUTPUT_CHAR = '\0';

}
