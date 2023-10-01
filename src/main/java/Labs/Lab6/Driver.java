package Labs.Lab6;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        FibFormula goofy = new FibFormula();
        FibIteration goober = new FibIteration();
        System.out.print("Please enter a number: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(goofy.calculate_fib(num));
        System.out.println(goober.calculate_fib(num));
    }
}
