import java.util.*;
public class Player extends User {
	
		  private Account account;
		  private Playground playground;
		  private PlaygroundOwner owner;
		  private int choice;
		  static public int id2 = -1;  
		 
		  public Player (){
			    account = new Account();
			    id2++;
			    /*if (id2 == Account.idPlayer){
			      account = account.getAccountByID(id2);
			      System.out.println(account.toString());
			    }*/
			  }
		  
		  public void bookPlayground() {
			  if (Playground.availableHours.size()!=0)
			  {  playground= new Playground();
				  setSuitableSlots( );
				  Playground.availableHours.remove(getSlots());
				 this.playground.bookPlayground(playground.getId(), this);
				//this.transferMoney(playground.getCost(playground.getId()), playground.getOwner(playground.getId()).getAccount() , Account.idPlayer,Account.idPlaygroundOwner);
			  }
		  }
		  
		  public void setSuitableSlots( ) 
		  { Scanner in = new Scanner(System.in);
			  System.out.println("choose sutable slots");
			  printSlots();
			  System.out.println("Choose wanted slot");
			  choice = in.nextInt();   
		  }
		  public int getSlots() 
		  { 
			  return (choice-1);
		  } 
		  public void viewBooking() {}
		  public void cancelBooking() {}
		  public Account getAccount(){
			    if (id2 == Account.idPlayer){
			      account = account.getAccountByID(id2);
			      return this.account;
			    }
			    return new Account();
			  }
		  public void printSlots() {
			    System.out.println("Available slots ");
			    for (int i=0; i<Playground.availableHours.size();i++)
				  {
					  System.out.println((i+1)+")"+Playground.availableHours.get(i)); 
				  }
			  }
		  public static void main(String[] args) {
		    
	      Player player=new Player();
	      player.setSuitableSlots();
		  }

	}

