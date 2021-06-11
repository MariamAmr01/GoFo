
public class User {
  private Account account;

  public User(){
    account = new Account();
  }

  public void transferMoney(double amountOfMoney, Account acc, int send, int rec){
    double currentBalance = Account.accounts.get(send).getBalance(send) - amountOfMoney;

    double receiverBalance =  Account.accounts.get(rec).getBalance(rec) + amountOfMoney;


    if (currentBalance < 0){
      System.out.println("Tranfer money failed, there is not enough money in your e-Wallet. Please try again");
    }
    else{
      currentBalance = Account.accounts.get(send).updateBalance(currentBalance, send);
      receiverBalance = Account.accounts.get(rec).updateBalance(receiverBalance, rec);

      System.out.println("Sender Current Balance:  " + currentBalance);
      System.out.println("ReceiverCurrent Balance: " + receiverBalance);

      System.out.println("Tranfer money done successfully.");
    }
  }
  
  
  public double checkBalance(int i){
    return Account.accounts.get(i).getBalance(i);
  }

  public void addBalance(double amountOfMoney, int i){
    double currentBalance = this.account.getBalance(i) + amountOfMoney;
    this.account.updateBalance(currentBalance, i);
  }
}
