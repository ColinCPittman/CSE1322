package Assignments.Assignment3;

public class Letter extends Envelope{
    String letterBody;

    public String getLetterBody() {
        return letterBody;
    }

    public Letter(String deliveryAddress, String returnAddress, double width, double length, double thickness, String letterBody) {
        super(deliveryAddress, returnAddress, width, length, thickness);
        this.letterBody = letterBody;
    }

    public Letter() {
    super();
    letterBody = "";
    }

}
