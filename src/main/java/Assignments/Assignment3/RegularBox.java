package Assignments.Assignment3;

public class RegularBox extends Box{
    private String items;
    private double weight;

    public RegularBox() {
        super();
        items = "";
        weight = 0.0d;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n" + getWidth() + " x " + getLength() + " x " + height +
                "\nItems: " + items +
                "\nCount: " + count +
                "\nWeight" + weight;
    }

    public String getItems() {
        return items;
    }

    public double getWeight() {
        return weight;
    }

    public RegularBox(String deliveryAddress, String returnAddress, double width, double length, double height, int count, String items, double weight) {
        super(deliveryAddress, returnAddress, width, length, height, count);
        this.items = items;
        this.weight = weight;
    }
}
