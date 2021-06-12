import java.util.*;

public class Player {

	private Account account;
	private Playground playground;
	private PlaygroundOwner owner;
	private int choice;
	static public int id2 = -1;
	private int id3 = 0;
	private ArrayList<Playground> playerBooked = new ArrayList<Playground>();
	private ArrayList<String> playerSlot = new ArrayList<String>();

	public Player() {
		account = new Account();
		Player.id2++;
		id3 = Player.id2;
		if (id2 == Account.idPlayer) {
			account = account.getAccountByID(id2);
		}
	}

	public void bookPlayground(int i) {
		playground = new Playground();
		playground = Playground.availablePlaygrounds.get(i);
		if (playground.availableHours.size() != 0) {

			setSuitableSlots(i);
			playerSlot.add(playground.availableHours.get(getSlots()));
			playground.availableHours.remove(getSlots());
			this.playground.bookPlayground(i, this);

			account.transferMoney(playground.getCost(Playground.bookedPlaygrounds.size() - 1),
					playground.getOwner(i).getAccount());
			playerBooked.add(Playground.bookedPlaygrounds.get(Playground.bookedPlaygrounds.size() - 1));

		} else {
			System.out.println("No slots Available");
		}
	}

	public void setSuitableSlots(int i) {
		Scanner in = new Scanner(System.in);
		printSlots(i);
		System.out.println("Choose wanted slot");
		choice = in.nextInt();
	}

	public int getSlots() {
		return (choice - 1);
	}

	public void viewBooking() {
		System.out.println("Your booked playgrounds: ");
		for (int i = 0; i < playerBooked.size(); i++) {
			System.out.println((i + 1) + "- " + playerBooked.get(i));
		}
	}

	public void cancelBooking() {
		System.out.println("Choose playground to cancel: ");
		viewBooking();
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		String x = playerSlot.get(0);
		playerSlot.remove(0);
		playerBooked.remove(choice - 1);
		viewBooking();
		playground.cancelBooking2(choice - 1, x);
	}

	public Account getAccount() {
		if (id2 == Account.idPlayer) {
			account = account.getAccountByID(id2);
			return this.account;
		}
		return new Account();
	}

	public void printSlots(int j) {
		System.out.println("Available slots ");
		for (int i = 0; i < Playground.availablePlaygrounds.get(j).availableHours.size(); i++) {
			System.out.println((i + 1) + "- " + Playground.availablePlaygrounds.get(j).availableHours.get(i));
		}
	}

	public int getID() {
		return id3;
	}
}
