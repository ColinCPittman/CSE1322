package Labs.Lab8;

import java.util.Scanner;

public class Lab8 {
    public static void main(String[] args) throws InvalidTimeException {
        Scanner sc = new Scanner(System.in);
        int seconds1 = 0, seconds2 = 0;

        System.out.println("Enter time 1 in 24hr format as follows (HH:MM:SS)");
        String FirstTime24h = sc.nextLine();
        boolean inputIsValid = false;
        try {
            seconds1 = convertTimeToInt(FirstTime24h);
            inputIsValid = true;
        } catch (InvalidTimeException e) {
            System.out.println(e.getMessage());
        }
        if(inputIsValid) {
            System.out.println("Enter time 1 in 24hr format as follows (HH:MM:SS)");
            String SecondTime24h = sc.nextLine();
            try {
                seconds2 = convertTimeToInt(SecondTime24h);
                inputIsValid = true;
            } catch (InvalidTimeException e) {
                System.out.println(e.getMessage());
            }
        }
        if (inputIsValid) {
            System.out.println(seconds1 - seconds2);
        }
    }

    static int convertTimeToInt(String time24h) throws InvalidTimeException {
        if (time24h == null || time24h.isEmpty()) throw new InvalidFormatException("Invalid time format");
        String[] split = time24h.split(":",3);
        if(split.length != 3) throw new InvalidFormatException("Invalid time format");
        int hours = validateHours(split[0]);
        int minutes = validateMinutes(split[1]);
        int seconds = validateSeconds(split[2]);
        return (hours * 60 * 60) + (minutes * 60) + seconds;
    }

    private static int validateSeconds(String seconds) throws InvalidSecondException {
        if(seconds.length() != 2) throw new InvalidSecondException("Invalid character count in seconds");
        for (char chars : seconds.toCharArray()) {
            if(!Character.isDigit(chars)) throw new InvalidSecondException("Invalid character in seconds");
        }
        int secondsInt= Integer.parseInt(seconds);
        if(secondsInt >= 60) throw new InvalidSecondException("Seconds must be below 60");
        return secondsInt;
    }

    private static int validateMinutes(String minutes) throws  InvalidMinuteException{
        if(minutes.length() != 2) throw new InvalidMinuteException("Invalid character count in minutes");
        for (char chars : minutes.toCharArray()) {
            if(!Character.isDigit(chars)) throw new InvalidMinuteException("Invalid character in minutes");
        }
        int minutesInt = Integer.parseInt(minutes);
        if(minutesInt>=60) throw new InvalidMinuteException("Minute must be below 60");
        return minutesInt;
    }

    static int validateHours(String hours) throws InvalidHourException{
        if(hours.length() != 2) throw new InvalidHourException("Invalid character count in hours");
        for (char chars : hours.toCharArray()) {
            if(!Character.isDigit(chars)) throw new InvalidHourException("Invalid character in hours");
        }
        int hoursInt = Integer.parseInt(hours);
        if(hoursInt>=24) throw new InvalidHourException("Hours must be below 24");
        return hoursInt;
    }

    static class InvalidTimeException extends Exception {
        public InvalidTimeException() {
        }

        public InvalidTimeException(String message) {
            super(message);
        }
    }

    static class InvalidHourException extends InvalidTimeException {
        public InvalidHourException() {
        }

        public InvalidHourException(String message) {
            super(message);
        }
    }

    static class InvalidMinuteException extends InvalidTimeException {
        public InvalidMinuteException() {
        }

        public InvalidMinuteException(String message) {
            super(message);
        }
    }

    static class InvalidSecondException extends InvalidTimeException {
        public InvalidSecondException() {
        }

        public InvalidSecondException(String message) {
            super(message);
        }
    }

    static class InvalidFormatException extends InvalidTimeException {
        public InvalidFormatException() {
        }

        public InvalidFormatException(String message) {
            super(message);
        }
    }
}
