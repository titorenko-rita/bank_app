import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.dateCreated = new Date();
    }

    public int getId() { return id; }
    public double getBalance() { return balance; }
    public double getAnnualInterestRate() { return annualInterestRate; }
    public Date getDateCreated() { return dateCreated; }

    public double getMonthlyInterest() {
        return balance * (annualInterestRate / 100) / 12;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("❌ Недостаточно средств!");
        } else {
            balance -= amount;
            System.out.println("✅ Снято " + amount + " руб.");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("✅ Пополнено на " + amount + " руб.");
    }
}
