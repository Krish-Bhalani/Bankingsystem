import java.util.Scanner;

public class menu {

    private Scanner scanner;
    private ArrayList<Account> accounts;


    public menu(Scanner scanner) {
        this.scanner = scanner;
        this.accounts = FileManager.loadAccounts();
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

        Account acc = findAccount(accNum);
        if ( acc.pin.equals(pin)) {
            System.out.println("Login successful!");
            showUserMenu(acc);
        }
    }

    private void adminLogin() {
        System.out.print("\nEnter Admin ID: ");
        String adminId = scanner.next();

        System.out.print("Enter Admin PIN: ");
        String pin = scanner.next();

       if (id.equals("admin") && pin.equals("1234")) {
            System.out.println("Admin login successful!");
            showAdminMenu();
        }

    }

    private void showUserMenu(Account acc) {
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

    private void checkBalance(Account acc) {
        System.out.println("Balance: $" + acc.balance);
    }

    private void deposit(Account acc) {
        System.out.print("Amount: ");
        double amount = scanner.nextDouble();
        acc.balance += amount;
        FileManager.saveAccounts(accounts);
        System.out.println("New Balance: $" + acc.balance);
    }

    private void withdraw(Account acc) {
        System.out.print("Amount: ");
        double amount = scanner.nextDouble();

        if (amount > acc.balance) {
            System.out.println("Insufficient funds.");
        } else {
            acc.balance -= amount;
            FileManager.saveAccounts(accounts);
            System.out.println("New Balance: $" + acc.balance);
        }
    }
    

        private void openAccount() {
        System.out.print("Account Number: ");
        String num = scanner.next();

        System.out.print("Name: ");
        String name = scanner.next();

        System.out.print("PIN: ");
        String pin = scanner.next();

        accounts.add(new Account(num, pin, 0, name));
        FileManager.saveAccounts(accounts);

        System.out.println("Account created.");
    }

    private void closeAccount() {
        System.out.print("Account Number: ");
        String num = scanner.next();

        Account acc = findAccount(num);

        if (acc != null) {
            accounts.remove(acc);
            FileManager.saveAccounts(accounts);
            System.out.println("Account closed.");
        }
    }


    private void modifyAccount() {
        System.out.print("Enter account number to modify: ");
        String accNum = scanner.next();

        Account acc = findAccount(num);

        System.out.println("1. Change Name");
        System.out.println("2. Change PIN");

        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("New Name: ");
            acc.name = scanner.next();
        } else if (choice == 2) {
            System.out.print("New PIN: ");
            acc.pin = scanner.next();
        }

        FileManager.saveAccounts(accounts);
        System.out.println("Account updated.");
    }
}