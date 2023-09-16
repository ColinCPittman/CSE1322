package Labs.Lab4;

public class Account {
    protected int accountNumber;

    public void setBalance(double amount) {
        this.balanceCents = (int) (amount * 100);
    }

    public double getBalance() {
        return (balanceCents / 100.0d);
    }

    public Account() {
        setBalance(0.0d);
        accountNumber = nextAccountNumber++;
    }

    public Account(double amount) {
        accountNumber = nextAccountNumber++;
        setBalance(amount);
    }

    public void withdraw(double amount) {
        balanceCents -= Math.round(amount * 100);
    }

    public void deposit(double amount) {
        balanceCents += Math.round(amount * 100);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    private static int nextAccountNumber = 10001;
    private long balanceCents;
}
