package Assignments.Assignment3;

public abstract class Envelope extends Mail{
    private double thickness;

    public Envelope(String deliveryAddress, String returnAddress, double width, double length, double thickness) {
        super(deliveryAddress, returnAddress, width, length);
        this.thickness = thickness;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n" + width + " x " + length + " x " + thickness;
    }

    public double getThickness() {
        return thickness;
    }

    public Envelope() {
    super();
    thickness = 0.0d;
    }
}
