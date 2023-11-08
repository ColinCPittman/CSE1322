package Assignments.Assignment7;

public class Employee extends Thread {
    private TheDrum pallet;
    private int totalJasmine;
    private int totalEarlGrey;
    private int totalLemon;
    private int id;
    static int nextId = 0;

    public Employee(TheDrum pallet) {
        this.pallet = pallet;
        this.totalJasmine = 0;
        this.totalEarlGrey = 0;
        this.totalLemon = 0;
        id = nextId++;
    }
    public int totalTea() {
        return totalLemon + totalJasmine + totalEarlGrey;
    }

    @Override
    public String toString() {
        return "Employee " + id + " has unloaded " + totalJasmine + " boxes of Jasmine Tea, " + totalEarlGrey + " boxes of Earl Grey, and " + totalLemon + " boxes of Lemon Tea.";
    }

    @Override
    public void run(){
        TeaBox current;
        while((current = pallet.getNextTeaBox()) != null) {
            if(current.getTeaType().equals("Jasmine")) {
                totalJasmine++;
            }else if(current.getTeaType().equals("Earl Grey")) {
                totalEarlGrey++;
            }else if (current.getTeaType().equals("Lemon")) {
                totalLemon++;
            }else {
            }
        }
    }
}
