import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount Deposited Successfully!");
        } else {
            System.out.println("Invalid Deposit Amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Withdrawal Amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal Successful!");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: Rs " + balance);
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid Input! Enter a number: ");
                sc.next();
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter Deposit Amount: ");
                    while (!sc.hasNextDouble()) {
                        System.out.print("Invalid Amount! Enter Again: ");
                        sc.next();
                    }
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter Withdrawal Amount: ");
                    while (!sc.hasNextDouble()) {
                        System.out.print("Invalid Amount! Enter Again: ");
                        sc.next();
                    }
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank You For Using ATM!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}

public class DecodeLabs_P3_Java {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(10000);
        ATM atm = new ATM(account);
        atm.showMenu();
    }
}