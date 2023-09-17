package Assignments.Assignment3;

public class Flat extends Envelope{
    String contents;

    public Flat() {
        super();
        contents = "";
    }

    public Flat(String deliveryAddress, String returnAddress, double width, double length, double thickness, String contents) {
        super(deliveryAddress, returnAddress, width, length, thickness);
        this.contents = contents;
    }

    public String getContents() {
        return contents;
    }
}
