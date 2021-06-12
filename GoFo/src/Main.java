import java.util.Scanner;
/**
 *Simple Main function contains main method used to test the program
 * 
 * @author Norhan Abdelkader
 * @author Mariam Amr Mohamed
 * @author Nermeen Mohamed Sayed
 * @since 12-06-2021
 */

public class Main {
  	/**
	 * Main method which displays a menu that the user can interact with.
	 * 
	 * /**
	 * @param args the command line arguments
	 */
  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    
    Playground playground = new Playground();
    Account account1 = new Account();
    PlaygroundOwner owner1 = new PlaygroundOwner();
    int input = 0;

    System.out.println("Sgin up with Owner's Account."); 
    account1 = account1.signUp("Owner@yahoo", "owner1", "weeqw", "Owner");
    System.out.println(account1.toString());
    System.out.println("========================================"); 

    System.out.println("Owner creates a playground: "); 
    owner1.createPlayground();

    Account account2 = new Account();
    PlaygroundOwner owner2 = new PlaygroundOwner();

    System.out.println("Sgin up with Owner's Account."); 
    account2 = account2.signUp("Owner2@yahoo", "owner2", "weeqw", "Owner");
    System.out.println(account2.toString());
    System.out.println("========================================"); 

    System.out.println("Owner creates a playground: "); 
    owner2.createPlayground();


    Account account3 = new Account();
    Player player1 = new Player();

    System.out.println("Sgin up with Player's Account."); 
    account3 = account3.signUp("player@yahoo", "player1", "weeqw", "plyer");
    System.out.println(account3.toString());
    System.out.println("========================================"); 

    System.out.println("Player books a playground: "); 
    System.out.println("\nChoose playground to book:");
    System.out.println("List of availablePlayground:\n");
    playground.printArrayList();
    if (Playground.availablePlaygrounds.size()!=0)
    {
    	input = in.nextInt();
      player1.bookPlayground(input - 1);
    }
    else{
      System.out.println("No Available playgrounds");
    }
    System.out.println("========================================"); 

    System.out.println("Player views his books: "); 
    player1.viewBooking();
    System.out.println("========================================"); 

    Account account4 = new Account();
    Player player2 = new Player();

    System.out.println("Sgin up with Player's Account."); 
    account4 = account4.signUp("player2@yahoo", "player2", "weeqw", "plyer");
    System.out.println(account4.toString());
    System.out.println("========================================"); 

    System.out.println("Player books a playground: "); 
    System.out.println("Choose playground to book:");
    System.out.println("List of availablePlayground:");
    playground.printArrayList();

    if (Playground.availablePlaygrounds.size()!=0)
    {
    	input = in.nextInt();
      player2.bookPlayground(input - 1);
    }
    else{
      System.out.println("No Available playgrounds");
    }
    System.out.println("========================================"); 


    Account account5= new Account();
    Player player3 = new Player();

    System.out.println("Sgin up with Player's Account."); 
    account5 = account5.signUp("player3@yahoo", "player3", "ww", "plymer");
    System.out.println(account5.toString());
    System.out.println("========================================"); 

    System.out.println("Player books a playground: ");  
    System.out.println("Choose playground to book:");
    System.out.println("List of availablePlayground:");
    playground.printArrayList();


    if (Playground.availablePlaygrounds.size()!=0)
    {
    	input = in.nextInt();
      player3.bookPlayground(input - 1);
    }
    else{
      System.out.println("No Available playgrounds");
    }
    System.out.println("========================================"); 

    System.out.println("Player cancels a playground: ");  
    player3.cancelBooking();
    System.out.println("========================================"); 

  }
}
