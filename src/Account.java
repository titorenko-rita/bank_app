import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String ownerName;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account(int id, String ownerName, double balance, double annualInterestRate) {
        this.id = id;
        this.ownerName = ownerName;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.dateCreated = new Date();
    }

    public int getId() { return id; }
    public String getOwnerName() { return ownerName; }
    public double getBalance() { return balance; }
    public double getAnnualInterestRate() { return annualInterestRate; }
    public Date getDateCreated() { return dateCreated; }
    public ArrayList<Transaction> getTransactions() { return transactions; }

    public double getMonthlyInterest() {
        return balance * (annualInterestRate / 100) / 12;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("❌ Недостаточно средств!");
        } else {
            balance -= amount;
            transactions.add(new Transaction('W', amount, balance));
            System.out.println("✅ Снято " + amount + " руб.");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction('D', amount, balance));
        System.out.println("✅ Пополнено на " + amount + " руб.");
    }

    public void showSummary() {
        System.out.println("\n===== СВОДКА ПО СЧЁТУ =====");
        System.out.println("👤 Владелец: " + ownerName);
        System.out.println("💳 ID счёта: " + id);
        System.out.println("💰 Баланс: " + balance + " руб.");
        System.out.println("📈 Годовая ставка: " + annualInterestRate + "%");
        System.out.println("\nИстория транзакций:");
        if (transactions.isEmpty()) {
            System.out.println("(пока нет операций)");
        } else {
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }
    }
}
