import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showMainMenu() {
        while (true) {
            System.out.println("\n=== ATM SYSTEM ===");
            System.out.println("1. Account Holder");
            System.out.println("2. Admin");
            System.out.println("3. Exit");
//ask for user for what they want and then call proper function based on need
            int choice = scanner.nextInt();

            if (choice == 1) userLogin();
            else if (choice == 2) adminLogin();
            else if (choice == 3) System.exit(0);
        }
    }

    private void userLogin() {
        //ask details for account to retrieve details from database and ensure correct login
        System.out.print("Account Number: ");
        String accNum = scanner.next();

        System.out.print("PIN: ");
        String pin = scanner.next();

        Account acc = DatabaseManager.getAccount(accNum);

        if (acc != null && acc.pin.equals(pin)) {
            showUserMenu(acc);
        } else {
            System.out.println("Invalid login.");
        }
    }

    private void showUserMenu(Account acc) {
        //menu for when user is logged in
        while (true) {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Logout");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Balance: $" + acc.balance);
            }

            else if (choice == 2) {
                System.out.print("Amount: ");
                double amt = scanner.nextDouble();
                acc.balance += amt;
                DatabaseManager.updateBalance(acc.accountNumber, acc.balance);
            }

            else if (choice == 3) {
                System.out.print("Amount: ");
                double amt = scanner.nextDouble();

                if (amt > acc.balance) {
                    System.out.println("Insufficient funds.");
                } else {
                    acc.balance -= amt;
                    DatabaseManager.updateBalance(acc.accountNumber, acc.balance);
                }
            }

            else if (choice == 4) return;
        }
    }

    private void adminLogin() {
        //this is for admin login where it ensures admin is true and then shows page
        System.out.print("Admin ID: ");
        String id = scanner.next();

        System.out.print("PIN: ");
        String pin = scanner.next();
        Account acc = DatabaseManager.getAccount(id);

        if (acc != null && acc.pin.equals(pin)) {
            showAdminMenu();
        } else {
            System.out.println("Invalid admin login.");
        }
    }

    private void showAdminMenu() {
        while (true) {
            //shows admin options
            System.out.println("\n1. Open Account");
            System.out.println("2. Close Account");
            System.out.println("3. Modify Account");
            System.out.println("4. Logout");

            int choice = scanner.nextInt();

            if (choice == 1) openAccount();
            else if (choice == 2) closeAccount();
            else if (choice == 3) modifyAccount();
            else if (choice == 4) return;
        }
    }

    private void openAccount() {
        //allows to create new account
        System.out.print("Account Number: ");
        String num = scanner.next();

        System.out.print("Name: ");
        String name = scanner.next();

        System.out.print("PIN: ");
        String pin = scanner.next();
//ensures balance is 0
        DatabaseManager.createAccount(new Account(num, pin, 0, name));
        System.out.println("Account created.");
    }
//delete exisisting account
    private void closeAccount() {
        System.out.print("Account Number: ");
        String num = scanner.next();

        DatabaseManager.deleteAccount(num);
        System.out.println("Account deleted.");
    }

//changes to exisiting account
    private void modifyAccount() {
        System.out.print("Account Number: ");
        String num = scanner.next();

        System.out.println("1. Change Name");
        System.out.println("2. Change PIN");

        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("New Name: ");
            String name = scanner.next();
            DatabaseManager.updateName(num, name);
        }

        else if (choice == 2) {
            System.out.print("New PIN: ");
            String pin = scanner.next();
            DatabaseManager.updatePin(num, pin);
        }
    }
}

//all functions are connected to main where the sql queries are called to update the database based on user input and changes to accounts