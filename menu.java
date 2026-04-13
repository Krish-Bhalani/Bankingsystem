import java.util.Scanner;

public class menu {

    private Scanner scanner;

    public menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showMainMenu() {
        while (true) {
            System.out.println("\n=== ATM SYSTEM ===");
            System.out.println("1. Account Holder");
            System.out.println("2. Bank Administrator");
            System.out.println("3. Exit");
            System.out.print("Select option: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                userLogin();
            } else if (choice == 2) {
                adminLogin();
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                System.exit(0);
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    private void userLogin() {
        System.out.print("\nEnter Account Number: ");
        String accNum = scanner.next();

        System.out.print("Enter PIN: ");
        String pin = scanner.next();

        System.out.println("Login successful!");

        showUserMenu(accNum);
    }

    private void adminLogin() {
        System.out.print("\nEnter Admin ID: ");
        String adminId = scanner.next();

        System.out.print("Enter Admin PIN: ");
        String pin = scanner.next();

        System.out.println("Admin login successful!");

        showAdminMenu();
    }

    private void showUserMenu(String accNum) {
        while (true) {
            System.out.println("\n=== USER MENU ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Logout");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                checkBalance(accNum);
            } else if (choice == 2) {
                deposit(accNum);
            } else if (choice == 3) {
                withdraw(accNum);
            } else if (choice == 4) {
                System.out.println("Logging out...");
                return;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    private void showAdminMenu() {
        while (true) {
            System.out.println("\n=== ADMIN MENU ===");
            System.out.println("1. Open Account");
            System.out.println("2. Close Account");
            System.out.println("3. Modify Account");
            System.out.println("4. Logout");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                openAccount();
            } else if (choice == 2) {
                closeAccount();
            } else if (choice == 3) {
                modifyAccount();
            } else if (choice == 4) {
                System.out.println("Logging out...");
                return;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

private void checkBalance(String accNum) {
        System.out.println("Checking balance for account: " + accNum);
    }

    private void deposit(String accNum) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        System.out.println("Deposited $" + amount);
    }

    private void withdraw(String accNum) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        System.out.println("Withdrew $" + amount);
    }

    

    private void openAccount() {
        System.out.print("Enter new account name: ");
        String name = scanner.next();

        System.out.print("Enter initial deposit: ");
        double deposit = scanner.nextDouble();

        System.out.println("Account created for " + name);
    }

    private void closeAccount() {
        System.out.print("Enter account number to close: ");
        String accNum = scanner.next();

        System.out.println("Account " + accNum + " closed.");
    }

    private void modifyAccount() {
        System.out.print("Enter account number to modify: ");
        String accNum = scanner.next();

        System.out.println("Modifying account " + accNum);
        System.out.println("1. Change Name");
        System.out.println("2. Change PIN");

        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter new name: ");
            String name = scanner.next();
            System.out.println("Name updated to " + name);
        } else if (choice == 2) {
            System.out.print("Enter new PIN: ");
            String pin = scanner.next();
            System.out.println("PIN updated.");
        } else {
            System.out.println("Invalid option.");
        }
    }
}