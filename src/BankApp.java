import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = FileStorage.loadAccount(); // загружаем счёт

        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Меню ===");
            System.out.println("1. Просмотр баланса");
            System.out.println("2. Снять деньги");
            System.out.println("3. Пополнить счёт");
            System.out.println("4. Показать историю операций");
            System.out.println("5. Выход (сохранить данные)");
            System.out.print("Выберите действие: ");

            switch (sc.nextInt()) {
                case 1 -> System.out.println("💰 Баланс: " + account.getBalance() + " руб.");
                case 2 -> {
                    System.out.print("Введите сумму для снятия: ");
                    account.withdraw(sc.nextDouble());
                }
                case 3 -> {
                    System.out.print("Введите сумму для пополнения: ");
                    account.deposit(sc.nextDouble());
                }
                case 4 -> account.showSummary();
                case 5 -> {
                    FileStorage.saveAccount(account);
                    exit = true;
                }
                default -> System.out.println("❌ Неверный выбор!");
            }
        }
    }
}
