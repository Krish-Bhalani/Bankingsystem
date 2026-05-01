import java.sql.*;

public class DatabaseManager {

    private static final String URL = "jdbc:mysql://localhost:3306/atm_system";
    private static final String USER = "root";
    private static final String PASSWORD = "password"; 

    public static Connection connect() {
        
        return DriverManager.getConnection(URL, USER, PASSWORD);
        //connects to database and ensures connection stays
    }
//finds account using account number
    public static Account getAccount(String accNum) {
       
            Connection conn = connect();

            String query = "SELECT * FROM accounts WHERE account_number = '" + accNum + "'";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
//if account exists, return account object with details
            if (rs.next()) {
                return new Account(
                        rs.getString("account_number"),
                        rs.getString("pin"),
                        rs.getDouble("balance"),
                        rs.getString("name")
                );
            }
    }
//updates account balance

    public static void updateBalance(String accNum, double newBalance) {
        
            Connection conn = connect();
            String query = "UPDATE accounts SET balance = " + newBalance + 
                           " WHERE account_number = '" + accNum + "'";

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
    }
    public static void createAccount(Account acc) {
     //new account in database
            Connection conn = connect();

            String query = "INSERT INTO accounts VALUES ('" +
                    acc.accountNumber + "', '" +
                    acc.pin + "', " +
                    acc.balance + ", '" +
                    acc.name + "')";

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
    }
//remove account from database
    public static void deleteAccount(String accNum) {
      
            String query = "DELETE FROM accounts WHERE account_number = '" + accNum + "'";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);

    }

    public static void updateName(String accNum, String newName) {
       //update name in database for user
            Connection conn = connect();

            String query = "UPDATE accounts SET name = '" + newName +
                           "' WHERE account_number = '" + accNum + "'";

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);

    }

    public static void updatePin(String accNum, String newPin) {
       //update pin for database for user
            Connection conn = connect();

            String query = "UPDATE accounts SET pin = '" + newPin +
                           "' WHERE account_number = '" + accNum + "'";

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);

    }
}