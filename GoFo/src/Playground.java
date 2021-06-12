import java.util.ArrayList;

public class Playground {

  private double cost;
  private String address;
  public static int pId;
  public static int id = -1;
  private Player player;
  private PlaygroundOwner owner;

  public static ArrayList<Playground> availablePlaygrounds = new ArrayList<Playground>();
  public static ArrayList<Playground> bookedPlaygrounds = new ArrayList<Playground>();

  public ArrayList<String> availableHours = new ArrayList<String>();

  public Playground() {
    cost = 0;
    address = "";
    pId = -1;
    player = new Player();
  }

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

  public String toString() {
    return "Playground informaion: " + "\n" + "Address: " + address + "\n" + "cost: " + cost + "\n" + owner;
  }

  public void printArrayList() {
    if (availablePlaygrounds.size() != 0) {
      for (int i = 0; i < availablePlaygrounds.size(); i++) {
        System.out.println((i + 1) + "- " + availablePlaygrounds.get(i).toString());
      }
    } else {
      System.out.println("There in no available Playgrounds");
    }
  }

  public void bookPlayground(int id, Player player) {
    pId = player.getID();
    bookedPlaygrounds.add(availablePlaygrounds.get(id));
    if (availableHours.size() == 0) {
      availablePlaygrounds.remove(id);
      Playground.id--;
    }
  }

  public void cancelBooking2(int i, String slot) {

    availablePlaygrounds.add(bookedPlaygrounds.get(i));
    bookedPlaygrounds.get(i).availableHours.add(slot);
    bookedPlaygrounds.remove(i);
    System.out.println("AVAILABLE: ");
    printArrayList();
  }

  public int getId() {
    return Playground.id;
  }

  public PlaygroundOwner getOwner(int id) {
    return bookedPlaygrounds.get(id).owner;
  }

  public double getCost(int id) {
    return bookedPlaygrounds.get(id).cost;
  }

  public void ownerBooks(int index) {
    for (int i = 0; i < bookedPlaygrounds.size(); i++) {
      if (index == bookedPlaygrounds.get(i).getOwner(i).getID()) {
        System.out.println("Booked Playgrounds \n" + (i + 1) + ")" + bookedPlaygrounds.get(i).toString());
      }
    }
  }
}
