import java.util.*;

public class Player {

	private Account account;
	private Playground playground;
	private PlaygroundOwner owner;
	private int choice;
	static public int id2 = -1;
	private int id3 = 0;

	public Player() {
		account = new Account();
		Player.id2++;
		id3 = Player.id2;
		if (id2 == Account.idPlayer) {
			account = account.getAccountByID(id2);
		}
	}

	public void bookPlayground(int i) {
		if (Playground.availableHours.size() != 0) {
			playground = new Playground();

			setSuitableSlots();
			Playground.availableHours.remove(getSlots());

			this.playground.bookPlayground(i, this);

			System.out.println("Account id: " + Account.accountId);
			System.out.println("PlaygroundOwner id: " + Account.idPlaygroundOwner);

			account.transferMoney(playground.getCost(Playground.bookedPlaygrounds.size() - 1),
					playground.getOwner(i).getAccount());

		}
	}

	public void setSuitableSlots() {
		Scanner in = new Scanner(System.in);
		System.out.println("choose sutable slots");
		printSlots();
		System.out.println("Choose wanted slot");
		choice = in.nextInt();
	}

	public int getSlots() {
		return (choice - 1);
	}

	public void viewBooking() {
		playground.playBooks(getID());
	}

	public void cancelBooking() {
	}

	public Account getAccount() {
		if (id2 == Account.idPlayer) {
			account = account.getAccountByID(id2);
			return this.account;
		}
		return new Account();
	}

	public void printSlots() {
		System.out.println("Available slots ");
		for (int i = 0; i < Playground.availableHours.size(); i++) {
			System.out.println((i + 1) + ")" + Playground.availableHours.get(i));
		}
	}

	public int getID() {
		return id3;
	}
}
