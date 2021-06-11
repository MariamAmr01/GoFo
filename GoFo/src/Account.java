public class Account {
  private String userName;
  private String email;
  private String pass;
  private String type;
  private double balance;


  public static int idPlaygroundOwner = 0;
  public static int idPlayer = 0;

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
        //System.out.println(idPlaygroundOwner);
      }
      else if(type.equalsIgnoreCase("player")){
        idPlayer++;
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

  public double updateBalance(double balance, int i) {
    accounts.get(i).balance = balance;
    //return this.balance;
    return accounts.get(i).balance;
  }
  
  
}
