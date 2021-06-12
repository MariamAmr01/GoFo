package hw4;

import java.util.ArrayList;

/**
 * This Class represents a client account with balance and account number
 *
 * @author Norhan Abdelkader
 * @author Mariam Amr
 * @author Nermeen Mohamed
 * @since 2021-06-10
 *
 */
public class Account {

    private String userName;
    private String email;
    private String pass;
    private String type;
    private double balance;

    /**
     * Static integer used to assign playground owner ID      
     */
    public static int idPlaygroundOwner = 0;

   /**
     * Static integer used to assign player ID      
     */
    public static int idPlayer = 0;

     /**
     * Static integer used to assign account ID      
     */
    public static int accountId = 0;

     /**
     * Static array list  used to save accounts      
     */
    public static ArrayList<Account> accounts = new ArrayList<Account>();

    /**
	 * Default Constructor to initialize the values of the attributes of the Account
	 */
    public Account() {
        userName = "";
        email = "";
        pass = "";
        type = "";
        balance = 100;
    }

    /**
     *  Method used to sign up to the  system 
     * @param email
     * @param userName
     * @param pass
     * @param type
     */
    public void signUp(String email, String userName, String pass, String type) {
        boolean flag = true;
        for (int i = 0; i < accounts.size(); i++) {

            if (accounts.get(i).email.equalsIgnoreCase(email)) {
                System.out.println("Failed to register.");
                System.out.println("There is already an account with this email.");
                flag = false;
            } else if (accounts.get(i).userName.equalsIgnoreCase(userName)) {
                System.out.println("Failed to register.");
                System.out.println("There is already an account with this name.");
                flag = false;
            }
        }
        if (flag) {
            if (type.equalsIgnoreCase("owner") || type.equalsIgnoreCase("playground owner")) {
                idPlaygroundOwner++;
                accountId++;
            } else if (type.equalsIgnoreCase("player")) {
                idPlayer++;
                accountId++;
            }
            Account a = new Account();
            a.email = email;
            a.userName = userName;
            a.pass = pass;
            a.type = type;
            accounts.add(a);
        }

    }

    
    /**
     * 
     * Method used to sign in  to specific account  in the  system 
     * @param mail
     * @param password
     * @param userType
     * @return
     */
    public boolean signIn(String mail, String password, String userType) {
        Account accountSignIn = new Account();
        for (int i = 0; i < accounts.size(); i++) {

            if (accounts.get(i).email.equalsIgnoreCase(mail) && accounts.get(i).pass.equals(password)
                    && accounts.get(i).type.equalsIgnoreCase(userType)) {
                accountSignIn = accounts.get(i);
                System.out.println("Welcome " + accountSignIn.userName + " , in your account.");
                return true;
            }
        }
        System.out.println("Failed to Sign in.");
        System.out.println("Account not found. Please check your data and try again. ");
        return false;
    }

    /**
     *
     * Method used to transfer money from the player account to playground owner account 
     * @param amountOfMoney
     * @param acc
     */
    public void transferMoney(double amountOfMoney, Account acc) {

        double currentBalance = getBalance() - amountOfMoney;
        double receiverBalance = acc.getBalance() + amountOfMoney;

        if (currentBalance < 0) {
            System.out.println("Tranfer money failed, there is not enough money in your e-Wallet. Please try again");
        } else {

            balance = updateBalance(currentBalance);
            acc.balance = updateBalance(receiverBalance);

            System.out.println("Sender Current Balance:  " + balance);
            System.out.println("ReceiverCurrent Balance: " + acc.balance);

            System.out.println("Tranfer money done successfully.");
        }
    }

    /**
     *
     * Method used to check the sender balance if valid or not
     * @param i
     * @return balance of sender
     */
    public double checkBalance(int i) {
        return Account.accounts.get(i).getBalance();
      
    }

    /**
     *
     * Method used to update receiver balance
     * @param balance
     * @return
     */
    public double updateBalance(double balance) {

        return balance;

    }

    /**
     *
     * Method used to return the new balance
     * @return
     */
    public double getBalance() {
        return balance;
    }

    /**
     *
     * Method used to convert account information to string
     * @return
     */
    public String toString() {
        return "Account informaion: " + "\n" + "Name: " + userName + "\n" + "Email: " + email + "\n" + "password: " + pass
                + "\n" + "Account Type: " + type + "\n";
    }

    /**
     *
     * Method used to print list of accounts
     */
    public void printArrayList() {
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + "- " + accounts.get(i).toString());
        }
    }

    /**
     *
     * Method used to return  user name
     * @return
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     *  Method used to return  user id
     * @param a
     * @return
     */
    public int getId(Account a) {
        if (a.type.equalsIgnoreCase("owner") || a.type.equalsIgnoreCase("playground owner")) {
            return idPlaygroundOwner;
        } else {
            return idPlayer;
        }
    }

    /**
     *  Method used to return  specific account
     * @param id
     * @return
     */
    public Account getAccountByID(int id) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId(accounts.get(i)) == id) {
                return accounts.get(i);
            }
        }
        return new Account();
    }

    /**
     *
     *  Method used to return  user type
     * @param i
     * @return
     */
    public String getUserType(int i) {
        return accounts.get(i).type;
    }
}
