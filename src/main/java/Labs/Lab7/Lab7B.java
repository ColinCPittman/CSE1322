package Labs.Lab7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab7B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(repeatNTimes("I must study recursion until it makes sense\n", 100));
        System.out.print("Enter the first string:");
        String str1 = sc.nextLine();
        System.out.print("Enter the second string:");
        String str2 = sc.nextLine();
        if (isReverse(str1, str2)) {
            System.out.println(str1 + " is the reverse of " + str2);
        } else System.out.println(str1 + " is not the reverse of " + str2);
    }

    static String repeatNTimes(String str, int num) {
        if (num <= 0) return "";
        if (num == 1) return str;
        return str + repeatNTimes(str, num - 1);
    }

    static boolean isReverse(String str1, String str2) {
        if (str1.equals("") ^ str2.equals("")) return false;
        if (str1.equals("") && str2.equals("")) return true;
        if (str1.charAt(0) == str2.charAt(str2.length() - 1))
            return isReverse(str1.substring(1), str2.substring(0, str2.length() - 1));
        else return false;
    }


}
