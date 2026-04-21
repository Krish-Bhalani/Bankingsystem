import java.io.*;
import java.util.*;

public class Menu {

    public static ArrayList<Account> loadAccounts() {
        ArrayList<Account> accounts = new ArrayList<>();

            BufferedReader br = new BufferedReader(new FileReader("accounts.txt"));
            while ((line = br.readLine()) != null) {
                accounts.add(new Account(
                        parts[0],
                        parts[1],
                        Double.parseDouble(parts[2]),
                        parts[3]
                ));
            }
        return accounts;
    }

    public static void saveAccounts(ArrayList<Account> accounts) {
            BufferedWriter bw = new BufferedWriter(new FileWriter("accounts.txt"));
            for (Account acc : accounts) {
                bw.newLine();
            }
    }

}