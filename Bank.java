import java.io.*;
import java.util.*;

public class Bank {
    private Map<String, Account> accounts = new HashMap<>();
    private final String FILE_PATH = "data/accounts.txt";

    public Bank() {
        loadAccounts();
    }

    public void createAccount(String accNo, String name, double initialDeposit) {
        if (accounts.containsKey(accNo)) {
            System.out.println(" Account number already exists!");
        } else {
            Account acc = new Account(accNo, name, initialDeposit);
            accounts.put(accNo, acc);
            saveAccounts();
            System.out.println(" Account created successfully!");
        }
    }

    public void deposit(String accNo, double amount) {
        Account acc = accounts.get(accNo);
        if (acc != null) {
            acc.deposit(amount);
            saveAccounts();
        } else {
            System.out.println(" Account not found!");
        }
    }

    public void withdraw(String accNo, double amount) {
        Account acc = accounts.get(accNo);
        if (acc != null) {
            acc.withdraw(amount);
            saveAccounts();
        } else {
            System.out.println(" Account not found!");
        }
    }

    public void checkBalance(String accNo) {
        Account acc = accounts.get(accNo);
        if (acc != null) {
            System.out.println(" Account Holder: " + acc.getHolderName());
            System.out.println(" Account Balance: ₹" + acc.getBalance());
        } else {
            System.out.println(" Account not found!");
        }
    }

    private void loadAccounts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String accNo = data[0];
                    String name = data[1];
                    double balance = Double.parseDouble(data[2]);
                    accounts.put(accNo, new Account(accNo, name, balance));
                }
            }
        } catch (IOException e) {
            System.out.println(" No existing data found, starting fresh...");
        }
    }

    private void saveAccounts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Account acc : accounts.values()) {
                writer.write(acc.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(" Error saving data: " + e.getMessage());
        }
    }

    public void showAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println(" No accounts found!");
        } else {
            System.out.println(" All Accounts:");
            for (Account acc : accounts.values()) {
                System.out.println("➡ " + acc.getAccountNumber() + " | " + acc.getHolderName() + " | ₹" + acc.getBalance());
            }
        }
    }
}
