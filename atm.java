import java.util.Scanner;

public class atm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);

        menu.showMainMenu();
        //file used to run the program and show menu to user
    }
}