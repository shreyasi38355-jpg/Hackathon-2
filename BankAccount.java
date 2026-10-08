import java.util.Scanner;
public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Deposit successful.");
    }
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Withdrawal failed: insufficient balance.");
        }
    }
    public double checkBalance() {
        return balance;
    }
    public void displayAccount() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + checkBalance());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter account number: ");
        String accountNumber = sc.nextLine();
        System.out.print("Enter account holder name: ");
        String accountHolderName = sc.nextLine();
        System.out.print("Enter initial balance: ");
        double initialBalance = sc.nextDouble();
        BankAccount account = new BankAccount(accountNumber, accountHolderName, initialBalance);
        System.out.print("Enter deposit amount: ");
        account.deposit(sc.nextDouble());
        System.out.print("Enter withdrawal amount: ");
        account.withdraw(sc.nextDouble());
        account.displayAccount();
        sc.close();
    }
}