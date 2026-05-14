import java.util.Scanner;

class ATM {
    private double balance;

    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }

    public void checkBalance() {
        System.out.println("Balance: Rs " + balance);
    }

    public void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be positive!");
        balance += amount;
        System.out.println("Deposited Rs " + amount + ". Balance: Rs " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be positive!");
        if (amount > balance)
            throw new ArithmeticException("Insufficient funds!");
        balance -= amount;
        System.out.println("Withdrew Rs " + amount + ". Balance: Rs " + balance);
    }
}

public class ATM_SimulationB4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM(10000);   // start with Rs 10,000

        int choice;
        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1.Check Balance  2.Deposit");
            System.out.println("3.Withdraw       4.Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1: atm.checkBalance(); break;
                    case 2:
                        System.out.print("Deposit amount: ");
                        atm.deposit(sc.nextDouble()); break;
                    case 3:
                        System.out.print("Withdrawal amount: ");
                        atm.withdraw(sc.nextDouble()); break;
                    case 4: System.out.println("Thank you! Goodbye!"); break;
                    default: System.out.println("Invalid choice.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Input Error: " + e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println("Transaction Error: " + e.getMessage());
            } finally {
                System.out.println("[Transaction processed]");  // ALWAYS runs
            }

        } while (choice != 4);

        sc.close();
    }
}