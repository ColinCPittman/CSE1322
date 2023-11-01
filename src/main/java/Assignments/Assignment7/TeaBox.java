package Assignments.Assignment7;

public class TeaBox {
    private String teaType;
    private TeaBox nextTea;

    public String getTeaType() {
        return teaType;
    }

    public TeaBox getNextTea() {
        return nextTea;
    }

    public TeaBox() {
        this.teaType = "";
        this.nextTea = null;
    }

    public TeaBox(String teaType, TeaBox nextTea) {
        this.teaType = teaType;
        this.nextTea = nextTea;
    }
}
