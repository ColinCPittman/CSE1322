package Assignments.Assignment7;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws InterruptedException {
        int totalTea = 0;
        System.out.print("How many boxes of Jasmine Tea would you like to order? ");
        Scanner sc = new Scanner(System.in);
        int jasmineQty = sc.nextInt();
        System.out.print("How many boxes of Earl Grey Tea would you like to order? ");
        int earlGreyQty = sc.nextInt();
        System.out.print("How many boxes of Lemon Tea would you like to order? ");
        int lemonQty = sc.nextInt();
        TheDrum drum = new TheDrum(jasmineQty,earlGreyQty,lemonQty);
        System.out.print("How many employees will help upload? ");
        int employeeQty = sc.nextInt();
        Employee[] employees = new Employee[employeeQty];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new Employee(drum);
        }
        for (int i = 0; i < employees.length; i++) {
            employees[i].start();
        }
        for (int i = 0; i < employees.length; i++) {
            employees[i].join();
        }
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].toString());
            totalTea += employees[i].totalTea();
        }
        System.out.println("A total of " + totalTea + " boxes of tea were stocked.");
    }
}
