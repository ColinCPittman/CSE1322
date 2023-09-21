package Assignments.Assignment3;

public class LiveBox extends Box{
    private String animal;
    private int age;

    @Override
    public String toString() {
        return super.toString() +
                "\n " + getWidth() + " x " + getLength() + " x " + height +
                "\nAnimal: " + animal +
                "\nCount: " + count +
                "\nAge: " + age;
    }

    public LiveBox(String deliveryAddress, String returnAddress, double width, double length, double height, int count, String animal, int age) {
        super(deliveryAddress, returnAddress, width, length, height, count);
        this.animal = animal;
        this.age = age;
    }

    public LiveBox() {
        super();
        animal = "";
        age = 0;
    }

    public String getAnimal() {
        return animal;
    }

    public int getAge() {
        return age;
    }
}
