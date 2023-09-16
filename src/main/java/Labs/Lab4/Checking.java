package Labs.Lab4;

public class Checking extends Account{
    public Checking() {
        super();
    }

    public Checking(double amount) {
        super(amount);
    }
    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        if(getBalance() < 0) {
            System.out.println("Charging overdraft fee of $20 because account is below $0");
            super.withdraw(20.d);
        }
    }
}
