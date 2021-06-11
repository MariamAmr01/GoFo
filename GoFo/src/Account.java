import java.util.*;

public class Account {

  private String userName;
  private String email;
  private String pass;
  private String type;
  private double balance;


  public static int idPlaygroundOwner = 0;
  public static int idPlayer = 0;
  public static int accountId = 0;

  public static ArrayList<Account> accounts = new ArrayList<Account>();

  public Account() {
    userName = "";
    email = "";
    pass = "";
    type = "";
    balance = 100;
  }


  public void signUp(String email, String userName, String pass, String type) {
    boolean flag = true;
    for (int i = 0; i < accounts.size(); i++) {

      if (accounts.get(i).email == email) {
        System.out.println("Failed to register.");
        System.out.println("There is already an account with this email.");
        flag = false;
      } 
      else if (accounts.get(i).userName == userName) {
        System.out.println("Failed to register.");
        System.out.println("There is already an account with this name.");
        flag = false;
      }
    }
    if (flag) {
      if (type.equalsIgnoreCase("owner") || type.equalsIgnoreCase("playground owner")){
        idPlaygroundOwner++;
        accountId++;
      }
      else if(type.equalsIgnoreCase("player")){
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

  // Returns the signed in account.
  public Account signIn(String mail, String password, String userType) {
    Account accountSignIn = new Account();
    for (int i = 0; i < accounts.size(); i++) {

      if (mail == email && password == pass && userType == type) {
        accountSignIn = accounts.get(i);
        System.out.println("Welcome " + accountSignIn.userName + " , in your account.");
        return accountSignIn;
      }
    }
    System.out.println("Failed to Sign in.");
    System.out.println("Account not found. Please check your data and try again. ");
    return accountSignIn;
  }

  public void transferMoney(double amountOfMoney, Account acc){

    double currentBalance = getBalance() - amountOfMoney;
    double receiverBalance = acc.getBalance() + amountOfMoney;

    if (currentBalance < 0){
      System.out.println("Tranfer money failed, there is not enough money in your e-Wallet. Please try again");
    }
    else{
      balance = updateBalance(currentBalance);
      acc.balance = updateBalance(receiverBalance);

      System.out.println("Sender Current Balance:  " + balance);
      System.out.println("ReceiverCurrent Balance: " + acc.balance);

      System.out.println("Tranfer money done successfully.");
    }
  }

public double checkBalance(int i){
return Account.accounts.get(i).getBalance();
}

  public double updateBalance(double balance) {
    return balance;

  }

  public double getBalance() {
   return balance;
  }

  public String toString() {
    return "Account informaion: " + "\n" + "Name: " + userName + "\n" + "Email: " + email + "\n" + "password: " + pass
        + "\n" + "Account Type: " + type + "\n";
  }

  public void printArrayList() {
    for (int i = 0; i < accounts.size(); i++) {
      System.out.println((i + 1) + "- " + accounts.get(i).toString());
    }
  }

  public String getUserName(){
    return this.userName;
  }


  public int getId(Account a){
    if (a.type.equalsIgnoreCase("owner") || a.type.equalsIgnoreCase("playground owner")){
      return idPlaygroundOwner;
    }
    else{
      return idPlayer;
    }
  }

  public Account getAccountByID(int id){
    for (int i = 0; i < accounts.size(); i++) {
     if (accounts.get(i).getId(accounts.get(i)) == id){
       return accounts.get(i);
     }
    }
    return new Account();
  }

  public String getUserType(int i){
    return accounts.get(i).type;
  }
}
