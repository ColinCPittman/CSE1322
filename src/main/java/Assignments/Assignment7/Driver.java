package Assignments.Assignment7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws InterruptedException {
        int totalTea = 0;

        int jasmineQty = promptUserForValidInt("How many boxes of Jasmine Tea would you like to order?");

        int earlGreyQty = promptUserForValidInt("How many boxes of Earl Grey Tea would you like to order?");

        int lemonQty = promptUserForValidInt("How many boxes of Lemon Tea would you like to order?");

        TheDrum drum = new TheDrum(jasmineQty, earlGreyQty, lemonQty);

        int employeeQty = promptUserForValidInt("How many employees will help upload?");

        Employee[] employees = new Employee[employeeQty];

        initializeEmployees(drum, employees);

        startEmployeeThreads(employees);

        joinEmployeeThreads(employees);

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].toString());
            totalTea += employees[i].totalTea();
        }
        System.out.println("A total of " + totalTea + " boxes of tea were stocked.");
    }

    private static void joinEmployeeThreads(Employee[] employees) throws InterruptedException {
        for (int i = 0; i < employees.length; i++) {
            employees[i].join();
        }
    }

    private static void startEmployeeThreads(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            employees[i].start();
        }
    }

    private static void initializeEmployees(TheDrum drum, Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new Employee(drum);
        }
    }

    private static int promptUserForValidInt(String prompt) {
        int userInput;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(prompt + " ");
            try {
                userInput = sc.nextInt();
                if (userInput >= 0) break;
                System.out.println("Invalid input, please enter a positive integer.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a positive integer.");
                sc.nextLine();
            }
        }
        return userInput;
    }
}
