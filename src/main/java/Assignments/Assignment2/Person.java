package Assignments.Assignment2;

public class Person {
    public String getName() {
        return name;
    }
    private String name;
    private int ticketNumber;
    private static int nextTicketNumber = 1;
    public Person () {
        name = "NO NAME";
        ticketNumber = nextTicketNumber++;
    }
    public Person (String name) {
        this.name = name;
        ticketNumber = nextTicketNumber++;
    }
    public String toString() {
        return ticketNumber + "\t" + name + "\n";
    }
}
