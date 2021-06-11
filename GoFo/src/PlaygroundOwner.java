import java.util.ArrayList;
import java.util.Scanner;

public class PlaygroundOwner extends User{
  private int hours;
  private double cost;
  private String address;
  private Account account;
  private Playground playground;

  static public int id = -1;

  public PlaygroundOwner() {
    account = new Account();
    hours = 0;
    cost = 0;
    address = "";
    playground = new Playground();
    id++;
    /*if (id == Account.idPlaygroundOwner){
      account = account.getAccountByID(id);
      System.out.println(account.toString());
    }*/
  }

  public void createPlayground() {
    ArrayList<String> slots = new ArrayList<String>();
    Scanner in = new Scanner(System.in);

    System.out.print("Enter Playground address: ");
    this.address = in.next();

    System.out.print("Enter Playground cost: ");
    this.cost = in.nextInt();

    System.out.print("Enter slot duration: ");
    int slotDuration = in.nextInt();

    System.out.print("Enter number of hours: "); 
    this.hours = in.nextInt();

    System.out.println("Enter with format HH:HH "); 

    for(int i = 0; i < (hours/slotDuration); i++){
      slots.add(in.next());
    }
    this.playground.setUpPlayground(slots, this.cost, this.address, this);
  }

  public boolean viewRequests() {
    return true;
  }

  public void viewBooks() {

  }
  public void viewCreatedPlayground(){
    this.playground.printArrayList();
  }

  public void displayOwnerMenu() {

    System.out.println("Choose what you want to do: ");
    System.out.println("1- Create a playground.");
    System.out.println("2- View Requests.");
    System.out.println("3- View Books.");

  }

  public Account getAccount(){
    if (id == Account.idPlaygroundOwner){
      account = account.getAccountByID(id);
      return this.account;
    }
    return new Account();
  }

  public String toString() {
    return "PlaygroundOwner informaion: " + "\n" + "Playground owner ID: " + id + "\n";
  }


}


