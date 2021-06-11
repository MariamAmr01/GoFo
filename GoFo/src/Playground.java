import java.util.*;

public class Playground {

  private double cost;
  private String address;
  private  int pId;
  public static int id = -1; 
  private Player player;
  private PlaygroundOwner owner;

  public static ArrayList<Playground> availablePlaygrounds = new ArrayList<Playground>();
  public static ArrayList<Playground> bookedPlaygrounds = new ArrayList<Playground>();

  public static ArrayList<String> availableHours = new ArrayList<String>();

  public Playground() {
    cost = 0;
    address = "";
    pId=-1;
    player = new Player();
  }

  public void setUpPlayground(ArrayList<String> Slots, double cost, String address, PlaygroundOwner owner) {
    availableHours = Slots;

    this.cost = cost;
    this.address = address;
    this.owner = owner;
    this.pId=-1;
    Playground.id++;
    availablePlaygrounds.add(this);
	printArrayList();
  }

  public String toString() {
    return "Playground informaion: " + "\n" + "Address: " + address + "\n" + "cost: " + cost + "\n"
        + this.owner.toString();
  }

  public void printArrayList() {
    System.out.println("Created Playgrounds List: ");
    for (int i = 0; i < availablePlaygrounds.size(); i++) {
      System.out.println((i + 1) + "- " + availablePlaygrounds.get(i).toString());
    }
  }
  public void bookPlayground (int id , Player player )
  {   
	  setPid(player.getID());
	  bookedPlaygrounds.add(availablePlaygrounds.get(id));
	  availablePlaygrounds.remove(id);
	  Playground.id--;
	/* for (int i = 0; i < bookedPlaygrounds.size(); i++) {
	      System.out.println((i + 1) + "- " + bookedPlaygrounds.get(i).toString());
	    }*/
  } 
  public void playBooks(int id)
  { int j=-1;
	  for (int i = 0; i < bookedPlaygrounds.size(); i++) {
		  System.out.println("input id"+ id);
		  System.out.println("pID "+bookedPlaygrounds.get(i).pId);
		  if(bookedPlaygrounds.get(i).pId==id)
		  { 
			  j=i;
			  break;
	    }
	  }
		  if(j!=-1) {
			  System.out.println( bookedPlaygrounds.get(j).toString());
			  }
			  else   {System.out.println("Player not found");}
  }
  public void ownerBooks(int id)
  { 
	  for (int i = 0; i < bookedPlaygrounds.size(); i++) {
		  System.out.println((i + 1) + "- " + bookedPlaygrounds.get(i).toString());
	    }
  }
  public int getId()
  {
	  return Playground.id;
  }
  public PlaygroundOwner getOwner(int id)
  {
	  return bookedPlaygrounds.get(id).owner;
  }
  public double getCost(int id)
  {
	  return	  bookedPlaygrounds.get(id).cost;
  }
  public void setPid(int id)
  {
	  pId=id;
  }
  public int getPid()
  {
	  return	  pId;
  }
  
}