import java.io.*;
import java.util.ArrayList;

public class FileStorage {

    private static final String FILE_NAME = "account_data.ser";

    public static void saveAccount(Account account) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(account);
            System.out.println("💾 Данные сохранены!");
        } catch (IOException e) {
            System.out.println("⚠ Ошибка при сохранении: " + e.getMessage());
        }
    }

    public static Account loadAccount() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Account acc = (Account) in.readObject();
            System.out.println("✅ Данные успешно загружены.");
            return acc;
        } catch (Exception e) {
            System.out.println("ℹ Файл не найден, создаётся новый счёт.");
            return new Account(1233, "Семен", 1100, 7.5);
        }
    }
}
