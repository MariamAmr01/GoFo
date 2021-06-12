import java.util.ArrayList;
import java.util.Scanner;
/**
 * This Class represents a playground owner and his operations
 * 
 * @author Norhan Abdelkader
 * @author Mariam Amr
 * @author Nermeen Mohamed
 * @since 2021-06-10
 * 
 */
public class PlaygroundOwner {
  private int hours;
  private double cost;
  private String address;
  private Account account;
  private Playground playground;
  /**
     * list to display playground slots
     */
  public  ArrayList<String> slots = new ArrayList<String>();
  /**
    * Static integer used to assign playground owner ID
   */
  public static int id = -1;
  private int id2 = 0;
/**
     * Default Constructor to initialize the values of the attributes of the 
     * playground owner
     */
  public PlaygroundOwner() {
    account = new Account();
    hours = 0;
    cost = 0;
    address = "";
    playground = new Playground();
    PlaygroundOwner.id++;
    id2 = PlaygroundOwner.id;
    if (id == Account.idPlaygroundOwner) {
      account = account.getAccountByID(id);
    }
  }
/**
     *
     *  Method used to create playground 
     */
  public void createPlayground() {
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

    for (int i = 0; i < (hours / slotDuration); i++) {
      slots.add(in.next());
    }
    this.playground.setUpPlayground(slots, this.cost, this.address, this);
  }
    /**
     *
     *  Method used to make playground owner able to see his booked playgrounds
     */
  public void viewBooks() {
    playground.ownerBooks(getID());
  }
 /**
     *
     * Method used to make playground owner able to see his created playgrounds
     */
  public void viewCreatedPlayground() {
    this.playground.printArrayList();
  }
 /**
     * Method used to display playground owner menu to be able to choose the operation he wants
     */
  public void displayOwnerMenu() {

    System.out.println("Choose what you want to do: ");
    System.out.println("1- Create a playground.");
    System.out.println("2- View booked playgrounds.");
    System.out.println("3- Exit.");
  }
/**
     * Method used to return playground owner id
     * @return  playground owner id
     */
  public int getID() {
    return id2;
  }
 /**
     *  Method used to return playground owner account
     * @return playground owner account by his id
     */
  public Account getAccount() {
    if (id == Account.idPlaygroundOwner) {
      account = account.getAccountByID(id);
      return this.account;
    }
    return new Account();
  }
  /**
     *  Method used to convert playground owner information into string
     * @return owner id converted to string
     */
  public String toString() {
    return "PlaygroundOwner informaion: " + "\n" + "Playground owner ID: " + (getID() + 1) + "\n";
  }

}

