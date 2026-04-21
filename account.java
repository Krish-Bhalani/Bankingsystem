public class Account {
    String accountNumber;
    String pin;
    double balance;
    String name;

    public Account(String accountNumber, String pin, double balance, String name) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
        this.name = name;
    }

    public String toFileString() {
        return accountNumber + "," + pin + "," + balance + "," + name;
    }
}