import java.util.ArrayList;

/**
 * This Class represents an account of users whether player or playground owner
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
     * @param  email of user
     * @param  userName of user 
     * @param  pass of user 
     * @param  type of account 
     */
    public Account signUp(String email, String userName, String pass, String type) {
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
      return a;
    }
    return this;
  }

    
    /**
     * 
     * Method used to sign in  to specific account  in the  system 
     * @param mail  which is mail of user entered to log in 
     * @param password which is pass of user entered to log in 
     * @param userType which is type of user'a account entered to log in 
     * @return true if information entered is true and false otherwise 
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
     * @param amountOfMoney amount of money to be sent to other users
     * @param acc Account set to recieve the money
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
     * @param i index of account
     * @return balance of sender
     */
    public double checkBalance(int i) {
        return Account.accounts.get(i).getBalance();
      
    }

  
    /**
     *
     * Method used to update receiver balance
     * @param balance
     * @return balance of user after updating
     */
    public double updateBalance(double balance) {

        return balance;

    }

      /**
     *
     * Method used to return the new balance
     * @return balance of user
     */
    public double getBalance() {
        return balance;
    }

    /**
     *
     * Method used to convert account information to string
     * @return information of the account 
     */
    public String toString() {
        return "Account informaion: " + "\n" + "Name: " + userName + "\n" + "Email: " + email + "\n" + "Account Type: " + type + "\n";
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
     * @return the username 
     */
    public String getUserName() {
        return this.userName;
    }
   
    /**
     *  Method used to return  user id from cerain account 
     * @param a
     * @return either id of playgroundOwner or player depending on type of account
     */
    public int getId(Account a) {
        if (a.type.equalsIgnoreCase("owner") || a.type.equalsIgnoreCase("playground owner")) {
            return idPlaygroundOwner;
        } else {
            return idPlayer;
        }
    }

    /**
     * Method used to get specific account with 
     * @param id
     * @return the account
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
     * Method used to get user type of certain account
     * @param i
     * @return type of account
     */
    public String getUserType(int i) {
        return accounts.get(i).type;
    }
}
