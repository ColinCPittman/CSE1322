package Labs.Lab4;

public class Savings extends Account {
    private int depositCount;
    public Savings() {
        super();
        depositCount = 0;
    }

    public Savings(double amount) {
        super(amount);
        depositCount = 0;
    }
    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        if(getBalance() < 500.00d) {
            System.out.println("Charging fee of $10 because you are below $500");
            super.withdraw(10.d);
        }
    }
    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        depositCount++;
        if(depositCount < 6) {
            System.out.println("This is deposit " + depositCount + " to this account");
        }
        else {
            System.out.println("Charging a fee of $10");
            super.withdraw(10.d);
        }
    }
    public void addInterest() { //charges 1.5% interest
        double interestGained = getBalance() * 1.015;
        super.deposit(interestGained);
        System.out.printf("Customer earned $%,.2f in interest.\n", interestGained);
    }
}
