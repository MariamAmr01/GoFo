# HW4_GoFo
A system for booking playgrounds.
Files included:
Main.java: 
Testing system's functions.
<br/>
////////////////////////////
<br/>
Account.java:<br/>
Contain functionalites related to account as:<br/>
Transfer Money: Transfer money from an account to another<br/>
checking balance: to make sure that the user have enough money to transfer money to other users<br/>
Contain functionalites to create and use account as:<br/>
Sign up: for user to register for the first time.<br/>
Sign in: for users to use the account they created.<br/>
updateBalance: to update user's balance wheneve that recieve or send money to others.<br/>
getBalance: for users to view the balance in their account <br/>
getUserName: return userName of the account.<br/>
getID: return id of the user depending on the type of the account.<br/>
toString: Print account information.<br/>
getAccountByID: Return the account with the entered ID.<br/>
getUserType: Return Account type (Player/PlaygroundOwne)<br/>
////////////////////////////<br/>
PlaygroundOwner.java:<br/>
Handles Owner's actions:<br/>
createPlayground: Owner inputs information related to the playground.<br/>
viewCreatedPlayground: Print list of playgrounds available.<br/>
displayOwnerMenu: menu for owner.<br/>
getID: return id of owner.<br/>
getAccount: return Account of owner.<br/>
toString: Print owner's information.<br/>
viewBooks: Shows the owner's book playgrounds.<br/>
//////////////////////////<br/>
Playground.java:<br/>
Handles actions taken upon playground:<br/>
setUpPlayground: Set the information of the playground recieved from owner.<br/>
toString: Print owner's information. <br/>
printArrayList: print created playgrounds.<br/>
bookPlayground: add playground to booked playground list by players.<br/>
getId: return id of playground.<br/>
getOwner: return owner of playground.<br/>
getCost: return cost of playgroud.<br/>
Ownerbooks: Prints books of the owner's playground.<br/>
CancelBooking: Remove playground from the booked list and set it back to be available for booking.
//////////////////////////<br/>
Player.java:<br/>
Handles Player's actions:<br/>
bookPlayground: player book certain playground if there are slots available. <br/>
setSuitableSlots: Player chooses desired slots.<br/>
getSlots: return slots chosen by player.<br/>
viewBooking: Shows playgrounds booked by player.<br/>
CancelBooking: Remove playground from the player's booked list and set it back to be available for booking.
