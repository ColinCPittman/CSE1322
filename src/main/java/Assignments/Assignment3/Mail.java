package Assignments.Assignment3;

public class Mail {
    String deliveryAddress;
    String returnAddress;
    double width;
    double length;
    int id;
    static int nextID = -1;

    @Override
    public String toString() {
        return id + "\n" + deliveryAddress + "\n" + returnAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getReturnAddress() {
        return returnAddress;
    }

    public void setReturnAddress(String returnAddress) {
        this.returnAddress = returnAddress;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mail(String deliveryAddress, String returnAddress, double width, double length) {
        this.deliveryAddress = deliveryAddress;
        this.returnAddress = returnAddress;
        this.width = width;
        this.length = length;
        id = nextID++;
    }

    public Mail() {
        deliveryAddress = "";
        returnAddress = "";
        width = 0.0d;
        length = 0.0d;
        id = nextID++;
    }
}
