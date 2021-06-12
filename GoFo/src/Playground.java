
/**
 * This Class represents a client account with balance and account number
 *
 * @author Norhan Abdelkader
 * @author Mariam Amr
 * @author Nermeen Mohamed
 * @since 2021-06-10
 *
 */
import java.util.ArrayList;

public class Playground {

  private double cost;
  private String address;
  /**
     * Static integer used to assign player ID
     */
    public static int pId;

    /**
     * /**
     * Static integer used to assign playground id
     */
    public static int id = -1;
    private Player player;
    private PlaygroundOwner owner;

    /**
     * Static array list used to storage available playgrounds
     */
    public static ArrayList<Playground> availablePlaygrounds = new ArrayList<Playground>();

    /**
     * Static array list used to storage booked playgrounds
     */
    public static ArrayList<Playground> bookedPlaygrounds = new ArrayList<Playground>();

    /**
     * Static array list used to storage available hours of playground
     */
    public ArrayList<String> availableHours = new ArrayList<String>();

    /**
     * Default Constructor to initialize the values of the attributes of the
     * playground
     */
    public Playground() {
        cost = 0;
        address = "";
        pId = -1;
        player = new Player();
    }
  
 /**
     *
     * @param Slots of available playground that will be booked
     * @param cost of the playground that will be booked
     * @param address of the playground that will be booked
     * @param owner of the playground that will be booked
     */
  public void setUpPlayground(ArrayList<String> Slots, double cost, String address, PlaygroundOwner owner) {
    for (int i = 0; i < Slots.size(); i++) {
      availableHours.add(Slots.get(i));
    }

    this.cost = cost;
    this.address = address;
    this.owner = owner;
    this.pId = -1;
    Playground.id++;
    availablePlaygrounds.add(this);
    System.out.println("Playground created successfully.");
    System.out.println("========================================");
  }

    /**
     *
     * Method used to convert playground owner information to string
     *
     * @return address and cost converted into string
     */
  public String toString() {
    return "Playground informaion: " + "\n" + "Address: " + address + "\n" + "cost: " + cost + "\n" + owner;
  }
  
     /**
     *
     * Method used to print list of available playgrounds by id converted into
     * string
     */

  public void printArrayList() {
    if (availablePlaygrounds.size() != 0) {
      for (int i = 0; i < availablePlaygrounds.size(); i++) {
        System.out.println((i + 1) + "- " + availablePlaygrounds.get(i).toString());
      }
    } else {
      System.out.println("There in no available Playgrounds");
    }
  }

    /**
     *
     * @param id of playground
     * @param player who will book playground
     */
  public void bookPlayground(int id, Player player) {
    pId = player.getID();
    bookedPlaygrounds.add(availablePlaygrounds.get(id));
    if (availableHours.size() == 0) {
      availablePlaygrounds.remove(id);
      Playground.id--;
    }
  }
  
   /**
     *
     * @param i index of booked playground
     * @param slot of the playground to return it again to available
     */
  public void cancelBooking2(int i, String slot) {

    availablePlaygrounds.add(bookedPlaygrounds.get(i));
    bookedPlaygrounds.get(i).availableHours.add(slot);
    bookedPlaygrounds.remove(i);
    System.out.println("AVAILABLE: ");
    printArrayList();
  }

     /**
     *
     * Method used to return playground id
     *
     * @return id of playground
     */
  public int getId() {
    return Playground.id;
  }
  
   /**
     *
     * Method used to return playground owner id
     *
     * @param id of the playground owner of this playground
     * @return
     */
  public PlaygroundOwner getOwner(int id) {
    return bookedPlaygrounds.get(id).owner;
  }
  
  /**
     *
     * Method used to return cost of playground
     *
     * @param id
     * @return
     */
  public double getCost(int id) {
    return bookedPlaygrounds.get(id).cost;
  }
   /**
     *
     * Method used to make playground owner able to see his booked playground
     *
     * @param index of this playground
     */
  public void ownerBooks(int index) {
    for (int i = 0; i < bookedPlaygrounds.size(); i++) {
      if (index == bookedPlaygrounds.get(i).getOwner(i).getID()) {
        System.out.println("Booked Playgrounds \n" + (i + 1) + ")" + bookedPlaygrounds.get(i).toString());
      }
    }
  }
}
