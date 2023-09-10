package Assignments.Assignment2;

import java.util.ArrayList;

public class Dispatcher {
    private ArrayList<Bus> busQueue = new ArrayList<>();
    public int addBus(Bus bus) {
        busQueue.add(bus);
        return busQueue.size() - 1;
    }
    public int addBus (Bus bus, int index) {
        busQueue.add(index, bus);
        return index;
    }
    public Bus findBus(int id){
        for(Bus bus : busQueue) {
            if(id == bus.getID()) return bus;
        }
        return null;
    }
    public Bus removeBus(int id) {
        Bus bus;
        for (int i = 0; i < busQueue.size(); i++) {
            bus = busQueue.get(i);
            if (bus.getID() == id) {
                busQueue.remove(i);
                return bus;
            }
        }
        return null;
    }
    public Bus dispatchBus() {
        if(busQueue.isEmpty()) {
            return null;
        }
        Bus bus = busQueue.get(0);
        busQueue.remove(0);
        return bus;
    }
    public String toString() {
        StringBuilder output = new StringBuilder("");
        for(Bus bus : busQueue) output.append(bus.toString() + "\n");
        return output.toString();
    }


}
