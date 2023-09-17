package Assignments.Assignment3;

public abstract class Box extends Mail {
    double height;
    int count;

    @Override
    public String toString() {
        return super.toString() +
                "\n" + width + " x " + length + " x " + height;
    }

    public Box(String deliveryAddress, String returnAddress, double width, double length, double height, int count) {
        super(deliveryAddress, returnAddress, width, length);
        this.height = height;
        this.count = count;
    }

    public Box() {
        this.height = 0.0d;
        this.count = 0;
    }

    public double getHeight() {
        return height;
    }

    public int getCount() {
        return count;
    }
}
