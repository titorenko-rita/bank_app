import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // создаём массив из 10 счетов
        Account[] accounts = new Account[10];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, 10000, 6.5); // id = i, баланс 10 000
        }

        while (true) {
            System.out.print("\nВведите ID (0-9): ");
            if (!sc.hasNextInt()) {
                System.out.println("❌ Нужно ввести число!");
                sc.next(); // очистка ввода
                continue;
            }
            int inputId = sc.nextInt();

            if (inputId < 0 || inputId >= accounts.length) {
                System.out.println("❌ Некорректный ID! Попробуйте снова.");
                continue;
            }

            Account acc = accounts[inputId]; // получаем выбранный счёт
            boolean exit = false;

            while (!exit) {
                System.out.println("\n=== Главное меню (счёт " + acc.getId() + ") ===");
                System.out.println("1. Просмотр баланса");
                System.out.println("2. Снять деньги");
                System.out.println("3. Пополнить счёт");
                System.out.println("4. Выход в меню ID");
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
                    case 4 -> exit = true;
                    default -> System.out.println("❌ Неверный выбор!");
                }
            }
        }
    }
}
