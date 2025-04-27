import java.util.Scanner;

public class BankAccount {
    private float balance = 5000.0f;
    private final String validId = "DIkshanigga";
    private final String validPassword = "NUlla";

    public void login(Scanner sc) {
        System.out.println("Enter the ID:");
        String enteredId = sc.nextLine();
        System.out.println("Enter the Password:");
        String enteredPassword = sc.nextLine();
        try {
            if (enteredId.equals(validId) && enteredPassword.equals(validPassword)) {
                System.out.println("Welcome!");
            } else {
                throw new Exception("Invalid ID or Password");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Exiting the system. Please try again later.");
            System.exit(0);
        }
    }

    public void checkBalance() {
        if (balance >= 1000) {
            System.out.println("Your current balance is: ₹" + balance);
        } else {
            System.out.println("Warning! Balance is low: ₹" + balance);
        }
    }

    public void deposit(Scanner sc) {
        System.out.println("Enter the amount you want to deposit:");
        float depositAmount = sc.nextFloat();
        try {
            if (depositAmount >= 500) {
                balance += depositAmount;
                System.out.println("Deposit successful! New balance: ₹" + balance);
            } else {
                throw new Exception("Enter an amount of at least ₹500 for deposit.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Exiting the system. Please try again later.");
            System.exit(0);
        }
    }

    public void withdrawal(Scanner sc) {
        System.out.println("Enter the amount to withdraw:");
        float withdrawAmount = sc.nextFloat();
        try {
            if (withdrawAmount <= balance) {
                balance -= withdrawAmount;
                System.out.println("Withdrawal successful! New balance: ₹" + balance);
            } else {
                throw new Exception("Insufficient balance. Withdrawal not possible.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Exiting the system. Please try again later.");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();

        account.login(sc);

        System.out.println("\nWhat do you want to do today:");
        System.out.println("1: Check Balance");
        System.out.println("2: Deposit");
        System.out.println("3: Withdrawal");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                account.checkBalance();
                break;
            case 2:
                account.deposit(sc);
                break;
            case 3:
                account.withdrawal(sc);
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                System.exit(0);
        }

        sc.close();
    }
}
