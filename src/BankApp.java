import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account acc = new Account(1155, 300000, 6.5);

        while (true) {
            System.out.print("\nВведите ID счёта: ");
            String inputId = sc.next();

            if (!inputId.equals(String.valueOf(acc.getId()))) {
                System.out.println("❌ Некорректный ID! Попробуйте снова.");
                continue;
            }

            boolean exit = false;
            while (!exit) {
                System.out.println("\n=== Главное меню ===");
                System.out.println("1. Просмотр баланса");
                System.out.println("2. Снять деньги");
                System.out.println("3. Пополнить счёт");
                System.out.println("4. Информация о счёте");
                System.out.println("5. Выход в меню ID");
                System.out.print("Выберите действие: ");

                if (!sc.hasNextInt()) {
                    System.out.println("❌ Нужно ввести число!");
                    sc.next();
                    continue;
                }

                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> System.out.println("💰 Баланс: " + acc.getBalance() + " руб.");
                    case 2 -> {
                        System.out.print("Введите сумму для снятия: ");
                        acc.withdraw(sc.nextDouble());
                    }
                    case 3 -> {
                        System.out.print("Введите сумму для пополнения: ");
                        acc.deposit(sc.nextDouble());
                    }
                    case 4 -> {
                        System.out.println("📅 Дата создания: " + acc.getDateCreated());
                        System.out.println("📈 Ежемесячные проценты: " + acc.getMonthlyInterest() + " руб.");
                    }
                    case 5 -> exit = true;
                    default -> System.out.println("❌ Неверный выбор!");
                }
            }
        }
    }
}
