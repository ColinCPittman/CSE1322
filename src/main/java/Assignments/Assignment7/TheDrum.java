package Assignments.Assignment7;

public class TheDrum {
   private TeaBox nextTeaBox = null;

    public TeaBox getNextTeaBox() {
        TeaBox current = nextTeaBox;
        if(nextTeaBox != null) {
            nextTeaBox = nextTeaBox.getNextTea();
        }
        return current;
    }

    public TheDrum(int jasmine, int earlGrey, int lemon) {
        for (int i = 0; i < jasmine; i++) {
            nextTeaBox = new TeaBox("Jasmine",nextTeaBox);
        }
        for (int i = 0; i < earlGrey; i++) {
            nextTeaBox = new TeaBox("Earl Grey", nextTeaBox);
        }
        for (int i = 0; i < lemon; i++) {
            nextTeaBox = new TeaBox("Lemon", nextTeaBox);
        }
        System.out.println("The Drum™ has been created and shipped.");
    }
}
