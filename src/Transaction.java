import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date date;
    private char type;
    private double amount;
    private double balanceAfter;

    public Transaction(char type, double amount, double balanceAfter) {
        this.date = new Date();
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
    }

    @Override
    public String toString() {
        String typeStr = (type == 'D') ? "Пополнение" : "Снятие";
        return String.format("%-10s | %-10.2f | Баланс после: %-10.2f | %s",
                typeStr, amount, balanceAfter, date);
    }
}
