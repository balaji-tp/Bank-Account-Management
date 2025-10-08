import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println(" ");
        System.out.println(" WELCOME TO JAVA BANK SYSTEM ");
        System.out.println(" ");

        do {
            System.out.println("\n1️ Create Account");
            System.out.println("2️ Deposit Money");
            System.out.println("3️ Withdraw Money");
            System.out.println("4️ Check Balance");
            System.out.println("5️ Show All Accounts");
            System.out.println("6️ Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accNo = sc.next();
                    System.out.print("Enter Holder Name: ");
                    sc.nextLine(); 
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Deposit: ");
                    double deposit = sc.nextDouble();
                    bank.createAccount(accNo, name, deposit);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.next();
                    System.out.print("Enter Amount to Deposit: ");
                    double amount = sc.nextDouble();
                    bank.deposit(accNo, amount);
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.next();
                    System.out.print("Enter Amount to Withdraw: ");
                    amount = sc.nextDouble();
                    bank.withdraw(accNo, amount);
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.next();
                    bank.checkBalance(accNo);
                    break;

                case 5:
                    bank.showAllAccounts();
                    break;

                case 6:
                    System.out.println(" Thank you for using Java Bank!");
                    break;

                default:
                    System.out.println(" Invalid choice. Try again!");
            }
        } while (choice != 6);

        sc.close();
    }
}
