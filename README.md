# HW4_GoFo
A system for booking playgrounds.
Files included:
Main.java: 
Testing system's functions.
////////////////////////////
User.java:
Contains fuctionalities that would be inherited by PlaygroundOwner and Player.
As "Transfer Money", "checking balance" to make sure that the user have enough money to transfer money to other users, and "addBalance": add money to the user's account.
///////////////////////////
Account.java:
Contain functionalites to create and use account as:
Sign up: for user to register for the first time.
Sign in: for users to use the account they created.
updateBalance: to update user's balance wheneve that recieve or send money to others.
getBalance: for users to view the balance in their account 
getUserName: return userName of the account.
getID: return id of the user depending on the type of the account.
toString: Print account information.
getAccountByID: Return the account with the entered ID.
getUserType: Return Account type (Player/PlaygroundOwne)
////////////////////////////
PlaygroundOwner.java:
Handles Owner's actions:
createPlayground: Owner inputs information related to the playground.
viewCreatedPlayground: Print list of playgrounds available.
displayOwnerMenu: menu for owner.
getID: return id of owner.
getAccount: return Account of owner.
toString: Print owner's information.
//////////////////////////
Playground.java:
Handles actions taken upon playground:
setUpPlayground: Set the information of the playground recieved from owner.
toString: Print owner's information. 
printArrayList: print created playgrounds.
bookPlayground: add playground to booked playground list by players.
getId: return id of playground
getOwner: return owner of playground
getCost: return cost of playgroud 
//////////////////////////
Player.java:
Handles Player's actions:
bookPlayground: player book certain playground if there are slots available. 
setSuitableSlots: Player chooses desired slots.
getSlots: return slots chosen by player.
