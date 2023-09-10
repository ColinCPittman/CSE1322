package Assignments.Assignment2;

import java.util.ArrayList;

public class Bus {
    ArrayList<Person> passengers;
    private static int nextID = 0;
    private int busID;

    public Bus() {
        passengers = new ArrayList<>();
        busID = nextID++;
    }

    public int getID() {
        return busID;
    }

    public void addPerson(Person person) {
        passengers.add(person);
    }

    public boolean removePerson(Person person) {
        for (int i = 0; i < passengers.size(); i++) {
            if (person.getName().equalsIgnoreCase(passengers.get(i).getName())) {
                passengers.remove(i);
                return true;
            }
        }
        return false;
    }

    public Person findPerson(String name) {
        for (int i = 0; i < passengers.size(); i++) {
            if (name.equalsIgnoreCase(passengers.get(i).getName())) {
                return passengers.get(i);
            }
        }
        return null;
    }

    public static boolean transferPerson(Bus initialBus, Bus transferBus, Person person) {
        for (int i = 0; i < initialBus.passengers.size(); i++) {
            if (person.getName().equalsIgnoreCase(initialBus.passengers.get(i).getName())) {
                initialBus.passengers.remove(i);
                transferBus.addPerson(person);
                return true;
            }
        }
        return false;
    }

    public String getPassengers() {
        StringBuilder output = new StringBuilder("");
        for (Person person : passengers) output.append(person.toString() + "\n");
        return output.toString();
    }

    public String toString() {
        return "" + busID;
    }
}
