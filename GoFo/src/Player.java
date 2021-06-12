import java.util.ArrayList;
import java.util.Scanner;
/**
 * This Class represents a client account with balance and account number
 *
 * @author Norhan Abdelkader
 * @author Mariam Amr
 * @author Nermeen Mohamed
 * @since 2021-06-10
 *
 */
public class Player {

	private Account account;
	private Playground playground;
	private PlaygroundOwner owner;
	private int choice;
	  /**
     * Static integer used to assign player ID
     */
	static public int id2 = -1;
	private int id3 = 0;
	private ArrayList<Playground> playerBooked = new ArrayList<Playground>();
	private ArrayList<String> playerSlot = new ArrayList<String>();
    /**
     * Default Constructor to initialize the values of the attributes of the
     * player
     *
     */
	public Player() {
		account = new Account();
		Player.id2++;
		id3 = Player.id2;
		if (id2 == Account.idPlayer) {
			account = account.getAccountByID(id2);
		}
	}
    /**
     * Method used to book playground
     *
     * @param i the index of this playground
     */
	public void bookPlayground(int i) {
		playground = new Playground();
		playground=Playground.availablePlaygrounds.get(i);
		if (playground.availableHours.size() != 0) {
			
			setSuitableSlots(i);
	        playerSlot.add(playground.availableHours.get(getSlots()));
			playground.availableHours.remove(getSlots());
			playground.bookPlayground(i, this);

			account.transferMoney(playground.getCost(Playground.bookedPlaygrounds.size() - 1),
			playground.getOwner(i).getAccount());
			playerBooked.add(Playground.bookedPlaygrounds.get(Playground.bookedPlaygrounds.size() - 1));
 
		}
		else {System.out.println("No slots Available");} 
	}
    /**
     * Method used to choose suitable hours
     *
     * @param i index of the slots which the player will choose from
     */
	public void setSuitableSlots(int i) {
		Scanner in = new Scanner(System.in);
		printSlots(i);
		System.out.println("Choose wanted slot");
		choice = in.nextInt();
	}
    /**
    *
    * Method used to return playground slot
    *
    * @return
    */
	public int getSlots() {
		return (choice - 1);
	}
  /**
    *
    * Method used to make player able to see his booking
    */
	public void viewBooking() {
		System.out.println("Your booked playgrounds: ");
		for (int i = 0; i < playerBooked.size(); i++) {
		      System.out.println((i + 1) + "- " + playerBooked.get(i));
		    }
	}
    /**
    *
    * Method used to make player cancel his booking
    */
	public void cancelBooking() {
		System.out.println("Choose playground to cancel: ");
		viewBooking();
		Scanner in = new Scanner(System.in);
		int choice=in.nextInt();
		String x = playerSlot.get(0);
		playerSlot.remove(0);
		playerBooked.remove(choice-1);
		viewBooking();
		playground.cancelBooking2(choice-1,x);
	}
	 /**
    *
    * Method used to return player account
    *
    * @return player account by id
    */
	public Account getAccount() {
		if (id2 == Account.idPlayer) {
			account = account.getAccountByID(id2);
			return this.account;
		}
		return new Account();
	}
    /**
    *
    * Method used to print the available slots
    *
    * @param j index of available slots
    */
	public void printSlots(int j) {
		System.out.println("Available slots ");
		for (int i = 0; i < Playground.availablePlaygrounds.get(j).availableHours.size(); i++) {
			System.out.println( (i + 1) + "- "+Playground.availablePlaygrounds.get(j).availableHours.get(i)); 
		}
	}
	 /**
    *
    * Method used to return player id
    *
    * @return id of the player
    */
	public int getID() {
		return id3;
	}
}
