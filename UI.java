import java.util.Scanner;
import java.util.LinkedList;
import java.util.ListIterator;


public class UI {
private UserManager UM;
private String current;
	public UI(LinkedList<User> Users){
		UM = new UserManager(Users);
		
	}
	public void SwitchUser() {
		boolean login = false;
		while(login == false){
			System.out.println("Please Enter a Username or type exit to quit the program.");
			Scanner read = new Scanner(System.in);
			String t = read.next();
			if(t.equals("exit")) {
				System.out.println("Goodbye.");
				System.exit(0);
			}
			System.out.println("Please Enter password for " + t + ".");
			String q = read.next();
			LinkedList<User> ll1 = UM.getUsers();
			ListIterator it1 = ll1.listIterator();
			while(it1.hasNext()){
				User temp = (User)it1.next();
				if(temp.getUsername().equals(t)) {
					if(temp.getPassword().equals(q)) {
						System.out.println("Login Successful \n");
						login = true;
						current = t;	
					}
				}
				
			}
			if(login == false) {
				System.out.println("Incorrect Username or Password. Please try again. \n");
			}
			runOutput();
		}	
	}
	public void Login() {
		while(true) {
		
		boolean login = false;
		
		while(login == false){
			System.out.println("Please Enter a Username or type exit to quit the program.");
			Scanner read = new Scanner(System.in);
			String t = read.next();
			if(t.equals("exit")) {
				System.out.println("Goodbye.");
				System.exit(0);
			}
			System.out.println("Please Enter password for " + t + ".");
			String q = read.next();
			LinkedList<User> ll1 = UM.getUsers();
			ListIterator it1 = ll1.listIterator();
			while(it1.hasNext()){
				User temp = (User)it1.next();
				if(temp.getUsername().equals(t)) {
					if(temp.getPassword().equals(q)) {
						System.out.println("Login Successful \n");
						login = true;
						current = t;
						UM.setCurrentUser(t);
						UM.Loggedin.add(t);
						//Don't add multiple users to logged in list when switching users.
					}
				}
				
			}
			if(login == false) {
				System.out.println("Incorrect Username or Password. Please try again. \n");
			}
		}
		runOutput();
		}
	}
	public void runOutput(){
		System.out.println("Please enter one of the options below.\n");
		System.out.println("\n");
		String a = "";
		while (a != "3") {
			System.out
			.println("\n1. Listen to song/playlist\n\n2. add playlist/song or edit song/playlist\n\n3. borrow/take back song\n\n"
					+ "4. Profile settings\n\n5. check messages or send a friend request\n\n"
					+ "6. browse for songs\n\n7. log out\n\n8. Admin/Testing\n\nEnter one of the numbers above.\n");
			Scanner reader = new Scanner(System.in);
			String s;
			s = reader.next();
			switch (s) {
			case "1": {

				String b = "";
				while (b.equals("3") == false) {
					System.out
					.println("\n1. play song\n\n2. play playlist\n\n3. go back\n\nEnter one of the numbers above.\n");
					b = reader.next();
					switch (b) {
					//Need to check if borrowed and decrease playcount if it is.
							case "1": {
								for(int i = 0; i < UM.getUsers().size(); i++) {
									if(UM.getUsers().get(i).getUsername().equals(current)) {
										System.out.println("Hello " + current + " this is the list of songs you can play. Type the number of the song you would like to listen to.");
										for(int j = 0; j < UM.getUsers().get(i).ownedLibrary.size(); j++) {
											System.out.println(j+1 + ": " + UM.getUsers().get(i).ownedLibrary.get(j));
										}
									}
								}
								boolean playable = false;
								String songrequest = reader.next();
								int songr = Integer.parseInt(songrequest);
								System.out.println();
								for(int i = 0; i < UM.getUsers().size(); i++) {
									if(UM.getUsers().get(i).getUsername().equals(current) && songr <= UM.getUsers().get(i).ownedLibrary.size()) {
											System.out.println("You are currently playing the song titled " + UM.getUsers().get(i).ownedLibrary.get(songr-1).getName());
											playable = true;
									}
								}
								if(playable == false) {
									System.out.println("You do not have the option to play that song. Please enter a valid number from above.");
								}
								playable = false;
								break;
							}
							case "2": {
								// play playlist method here. We can list the playlist available to play here
								System.out.println("Hello " + current + " this is the list of your available playlists. Please select one of the numbers to play.");
								for(int i = 0; i < UM.getUsers().size(); i++) {
									if(UM.getUsers().get(i).getUsername().equals(current)) {
										for(int j = 0; j < UM.getUsers().get(i).playList.size(); j++) {
											for(int k = 0; k < UM.getUsers().get(i).playList.get(j).size(); k++) {
												System.out.println(k+1 + ": " + UM.getUsers().get(i).playList.get(j));
											}
										}
									}
								}
								break;
							}
							case "3":{
								break;
							}
							default: {
								System.out.println("Invalid input. Please enter one of the numerical values above.");
								break;
							}
						}
					//end switch
					}
				break;
			}
			case "2": {
				String b = "";
			
			while (b.equals("5") == false) {
				System.out
				.println("\n1. add song\n\n2. create playlist\n\n3. edit playlist\n\n4. edit song metadata\n\n"
						+ "5. go back\n\nEnter one of the numbers above.\n");
				b = reader.next();
				switch (b) {
						case "1": {
							String[] tokens = null;
							String[] songdata = null;
							String songdelims = "(|\\,\\])";
							System.out.println("Hello " + current + " Please enter the new song you want to add in the following format: (Name, Artist, Album, Year, Composer, Genre)");
							String songstring = "";
							songstring += reader.nextLine();
							tokens = s.split(songdelims);
							for(int i = 1; i < tokens.length-1; i++) {
								songdata = tokens[i].split(songdelims);
								for(int j = 0; j < songdata.length; j++) {
									if(songdata[j].startsWith(" ")) {
										songdata[j] = songdata[j].substring(1);
									}
									if(songdata[j].endsWith(" ")) {
										songdata[j] = songdata[j].substring(0, songdata[j].length()-1);
									}
								}
							
						    }
							Song newsong = new Song(songdata[0],songdata[1],songdata[2],songdata[3],songdata[4],songdata[5]);
							for(int i = 0; i < UM.getUsers().size(); i++) {
								if(UM.getUsers().get(i).getUsername().equals(current)) {
									UM.getUsers().get(i).ownedLibrary.add(newsong);
								}
							}
							break;
						}
						case "2": {
							//Need to create multiple playlists.
							for(int i = 0; i < UM.getUsers().size(); i++) {
								if(UM.getUsers().get(i).getUsername().equals(current)) {
									System.out.println("Hello " + current + " this is the list of songs you can add to your playlist. Type the number of the song you would like to add to a playlist.");
									for(int j = 0; j < UM.getUsers().get(i).ownedLibrary.size(); j++) {
										System.out.println(j+1 + ": " + UM.getUsers().get(i).ownedLibrary.get(j));
									}
								}
							}
							boolean playable = false;
							String songrequest = reader.next();
							int songr = Integer.parseInt(songrequest);
							if(playable == false) {
								System.out.println("You do not have the option to play that song. Please enter a valid option from above.");
							}
							playable = false;
							
							//create playlist
							break;
						}
						case "3": {
							for(int i = 0; i < UM.getUsers().size(); i++) {
								if(UM.getUsers().get(i).getUsername().equals(current)) {
									System.out.println("Hello " + current + " this is the list of songs you can add to your playlist. Type the number of the song you would like to add to a playlist.");
									for(int j = 0; j < UM.getUsers().get(i).ownedLibrary.size(); j++) {
										System.out.println(j+1 + ": " + UM.getUsers().get(i).ownedLibrary.get(j));
									}
								}
							}
							////edit playlist
							break;
						}
						case "4": {
							String songchange = "";
							for(int i = 0; i < UM.getUsers().size(); i++) {
								if(UM.getUsers().get(i).getUsername().equals(current)) {
									System.out.println("Hello " + current + " this is the list of songs you can edit. Type the number of the song you would like to edit.");
									for(int j = 0; j < UM.getUsers().get(i).ownedLibrary.size(); j++) {
										System.out.println(j+1 + ": " + UM.getUsers().get(i).ownedLibrary.get(j));
									}
								}
							}
							boolean playable = false;
							String songrequest = reader.next();
							int songr = Integer.parseInt(songrequest);
							System.out.println();
							for(int i = 0; i < UM.getUsers().size(); i++) {
								if(UM.getUsers().get(i).getUsername().equals(current) && songr <= UM.getUsers().get(i).ownedLibrary.size()) {
										playable = true;
								}
							}
							if(playable == false) {
								System.out.println("You do not have the option to play that song. Please enter a valid number from above.");
							}
							//Loop to change the song's metadata.
							while(playable == true && !songchange.equals("exit")) {
								System.out.println("Which part of the song would you like to change? Please enter either the Name, Album, Artist, Year, Composer, or Genre");
								songchange = reader.next();
								
								if(songchange.equals("Name")) {
									System.out.println("What will the new song's name be?");
									songchange = reader.next();
									for(int i = 0; i < UM.getUsers().size(); i++) {
										if(UM.getUsers().get(i).getUsername().equals(current) && songr <= UM.getUsers().get(i).ownedLibrary.size()) {
											    UM.getUsers().get(i).ownedLibrary.get(songr-1).setName(songchange);
												playable = false;
										}
									}
									System.out.println("The name has been changed to " + songchange + ".");
								}
								else if(songchange.equals("Album")) {
									System.out.println("What will the new song's album be?");
									songchange = reader.next();
									for(int i = 0; i < UM.getUsers().size(); i++) {
										if(UM.getUsers().get(i).getUsername().equals(current) && songr <= UM.getUsers().get(i).ownedLibrary.size()) {
											UM.getUsers().get(i).ownedLibrary.get(songr-1).setAlbum(songchange);
											playable = false;
										}
									}
									System.out.println("The album title has been changed to " + songchange + ".");
								}
								else if(songchange.equals("Artist")) {
									System.out.println("Who will be the new song's artist?");
									songchange = reader.next();
									for(int i = 0; i < UM.getUsers().size(); i++) {
										if(UM.getUsers().get(i).getUsername().equals(current) && songr <= UM.getUsers().get(i).ownedLibrary.size()) {
											UM.getUsers().get(i).ownedLibrary.get(songr-1).setArtist(songchange);
											playable = false;
										}
									}
									System.out.println("The artist has been changed to " + songchange + ".");
								}
								else if(songchange.equals("Year")) {
									System.out.println("What will be the new song's year?");
									songchange = reader.next();
									for(int i = 0; i < UM.getUsers().size(); i++) {
										if(UM.getUsers().get(i).getUsername().equals(current) && songr <= UM.getUsers().get(i).ownedLibrary.size()) {
											    UM.getUsers().get(i).ownedLibrary.get(songr-1).setYear(songchange);
												playable = false;
										}
									}
									System.out.println("The year has been changed to " + songchange + ".");
								}
								else if(songchange.equals("Composer")) {
									System.out.println("Who will be the new song's composer?");
									songchange = reader.next();
									for(int i = 0; i < UM.getUsers().size(); i++) {
										if(UM.getUsers().get(i).getUsername().equals(current) && songr <= UM.getUsers().get(i).ownedLibrary.size()) {
											UM.getUsers().get(i).ownedLibrary.get(songr-1).setComposer(songchange);
											playable = false;
										}
									}
									System.out.println("The composer has been changed to " + songchange + ".");
								}
								else if(songchange.equals("Genre")) {
									System.out.println("What will be the new song's genre?");
									songchange = reader.next();
									for(int i = 0; i < UM.getUsers().size(); i++) {
										if(UM.getUsers().get(i).getUsername().equals(current) && songr <= UM.getUsers().get(i).ownedLibrary.size()) {
											UM.getUsers().get(i).ownedLibrary.get(songr-1).setGenre(songchange);
											playable = false;
										}
									}
									System.out.println("The genre has been changed to " + songchange + ".");
								}
								else{
									System.out.println("Please enter one of the options above. Please try again or type exit to go back.");
									playable = true;
									break;
								}
								
							}
							break;
						}
						case "5": {
							
							break;
						}
						default: {
							System.out.println("Invalid input. Please enter one of the numerical values above.");
							break;
						}
				
			}
					
				}
			break;
			}
			
			case "3": {
				String b = "";
			
			while (b.equals("3") == false) {
				System.out
				.println("\n1. Borrow a song\n\n2. Take back a song\n\n3. go back\n\nEnter one of the numbers above.\n");
				b = reader.next();
				switch (b) {
						case "1": {
							//Need to set a count for how many times someone can borrow a song.
							System.out.println("Hello " + current + " who would you like to borrow a song from? The user must be logged into the system.");
							//borrow song
							break;
						}
						case "2": {
							System.out.println("Hello " + current + " who would you like to take a song back from? The user must be logged into the system.");
							//take back song
							break;
						}
						case "3": {
							break;
						}
						default: {
							System.out
							.println("Invalid input. Please enter one of the numerical values above.");
							break;
						}
				
			}
					
				}
			break;
			}
			case "4": {
				String b = "";
			
			while (b.equals("4") == false) {
				System.out
				.println("\n1. Sorting options\n\n2. Library visability\n\n3. borrow length\n\n4. go back\n\nEnter one of the numbers above.\n");
				b = reader.next();
				switch (b) {
						case "1": {
							System.out.println("Hello " + current + " how would you like to sort your Library? You can sory by Artist, Song Name, Song Year, Song Album, Or the Genre. Please Enter one of the options to sort the song by.");
							boolean sorted = false;
							String sortoption = reader.next();
							if(sortoption.equals("Artist")) {
								for(int i = 0; i < UM.getUsers().size(); i++) {
									if(UM.getUsers().get(i).getUsername().equals(current)) {
										for(int j = 0; j < UM.getUsers().get(i).ownedLibrary.size(); j++) {
											Song sortsong = UM.getUsers().get(i).ownedLibrary.get(j);
										}
										
									}
								}
							}
							//sorting options
							break;
						}
						case "2": {
							//song visability
							break;
						}
						case "3": {
							//borrow length
							break;
						}
						case "4": {
							break;
						}
						default: {
							System.out
							.println("Invalid input. Please enter one of the numerical values above.");
							break;
						}
				
			}
					
				}
			break;
			}
			case "5": {
				String b = "";
			
			while (b.equals("4") == false) {
				System.out
				.println("\n1. check messages\n\n2. send friend request \n\n3. Send Borrow request\n\n4. go back\n\nEnter one of the numbers above.\n");
				b = reader.next();
				switch (b) {
						case "1": {
							System.out.println("Hello " + current + " here are your messages.");
						for(int i = 0; i < UM.getUsers().size(); i++){
							if(UM.getUsers().get(i).getUsername().equals(current)) {
									UM.getUsers().get(i).getMessages();
							}
						}
							//check message
							break;
						}
						case "2": {
							//send friend request
							System.out.println("Hello " + current + " who would you like to send a friend request to? Please Enter the usename of the person you'd like to add.");
							String friendrequest = reader.next();
							boolean friendslist = false;
							boolean loggedin = false;
							User receiver = null;
							User sender = null;
							
							if(current.equals(friendrequest)) {
								System.out.println("You cannot send a friend request to yourself.");
								loggedin = false;
								friendslist = true;
							}
							//Check if not already on friends list
							for(int i = 0; i < UM.getUsers().size(); i++) {
								if(UM.getUsers().get(i).getUsername().equals(current)) {
									for(int j = 0; j < UM.getUsers().get(i).getFriends().size(); j++) {
										if(UM.getUsers().get(i).getFriends().get(j).equals(friendrequest)) {
											friendslist = true;
										}
									}
								}
							}
							//Check if User is logged in.
							for(int i = 0; i < UM.Loggedin.size(); i++) {
								if(friendrequest.equals(UM.Loggedin.get(i))) {
									loggedin = true;
								}
							}
							if(loggedin == false) {
								System.out.println("That user is not logged in. Can't send messages to users who have not logged in.");
							}
							if(friendslist == true) {
								System.out.println("You are already friends with that person.");
							}
							//Grab the User object of the sender & receiver
							for(int i = 0; i < UM.getUsers().size(); i++) {
								if(UM.getUsers().get(i).getUsername().equals(current)) {
									 sender = new User(UM.getUsers().get(i));
								}
								if(UM.getUsers().get(i).getUsername().equals(friendrequest)) {
									receiver = new User(UM.getUsers().get(i));
								}
							}
							//if the user is logged in and is on the friends list then send the request.
							if(loggedin == true && (friendslist == false)) {
								FriendRequest friend = new FriendRequest(sender, receiver, "You have a new friend request from " + current);
								for(int i = 0; i < UM.getUsers().size(); i++) {
									if(UM.getUsers().get(i).getUsername().equals(friendrequest)) {
										UM.getUsers().get(i).addMessage(friend);
										System.out.println("Your request has been sent.");
									}
								}
								
								
							}
							break;
						}
						//Send Friend Request
						case "3": {
							System.out.println("Hello " + current + " who would you like to borrow a song from? Please Enter the usename of the person you'd like to add. They must be on your friends list and logged into the system.");
							String songrequest = reader.next();
							boolean friendslist = false;
							boolean loggedin = false;
							User receiver = null;
							User sender = null;
							
							if(current.equals(songrequest)) {
								System.out.println("You cannot send a song request to yourself.");
								loggedin = false;
								friendslist = true;
							}
							//Check if on the person is on the requesters friends list
							for(int i = 0; i < UM.getUsers().size(); i++) {
								if(UM.getUsers().get(i).getUsername().equals(current)) {
									for(int j = 0; j < UM.getUsers().get(i).getFriends().size(); j++) {
										if(UM.getUsers().get(i).getFriends().get(j).equals(songrequest)) {
											friendslist = true;
										}
									}
								}
							}
							
							//Check if User is logged in.
							for(int i = 0; i < UM.Loggedin.size(); i++) {
								if(songrequest.equals(UM.Loggedin.get(i))) {
									loggedin = true;
								}
							}
							if(loggedin == false) {
								System.out.println("That user is not logged in. Can't send requests to users who have not logged in.");
							}
							if(friendslist == false) {
								System.out.println("That user is not on your friends list. You cannot request to borrow songs from them.");
							}
							//Grab the User object of the sender & receiver
							for(int i = 0; i < UM.getUsers().size(); i++) {
								if(UM.getUsers().get(i).getUsername().equals(current)) {
									 sender = new User(UM.getUsers().get(i));
								}
								if(UM.getUsers().get(i).getUsername().equals(songrequest)) {
									receiver = new User(UM.getUsers().get(i));
								}
							}
							//if the user is logged in and is on the friends list then send the request.
							if(loggedin == true && (friendslist == true)) {
								System.out.println("Here is a list of the songs your friend has available for playing. Select the number that you want to request to borrow.");
								for(int i = 0; i < UM.getUsers().size(); i++) {
									if(UM.getUsers().get(i).getUsername().equals(songrequest)) {
										for(int j = 0; j < UM.getUsers().get(i).ownedLibrary.size(); j++) {
											System.out.println(j+1 + ": " + UM.getUsers().get(i).ownedLibrary.get(j));
										}
									}
								}
								String songreq = reader.next();
								int songr = Integer.parseInt(songreq);
								boolean sent = false;
								System.out.println();
								for(int i = 0; i < UM.getUsers().size(); i++) {
									if(UM.getUsers().get(i).getUsername().equals(songrequest) && songr <= UM.getUsers().get(i).ownedLibrary.size()) {
										for(int j = 0; j < UM.getUsers().get(i).ownedLibrary.size(); j++) {
											if(sent == false) {
											SongRequest newrequest = new SongRequest(sender, receiver, "You have a new song request for the song " + UM.getUsers().get(i).ownedLibrary.get(songr-1).getName() + " from " + current);
											UM.getUsers().get(i).addMessage(newrequest);
											sent = true;
											System.out.println("Your request has been sent.");
											}
										}		
									}
								}
							}
							
							break;
						}
						case "4": {
							
							break;
						}
						default: {
							System.out
							.println("Invalid input. Please enter one of the numerical values above.");
							break;
						}
				
			}
					
				}
			break;
			}
			case "6": {
				String b = "";
			
			while (b.equals("4") == false) {
				System.out
				.println("\n1. search by friend\n\n2. search by all friends\n\n3. search all non friends\n\n4. go back\n\nEnter one of the numbers above.\n");
				b = reader.next();
				switch (b) {
						case "1": {
							//search by friend
							break;
						}
						case "2": {
							//search by all friends
							break;
						}
						case "3": {
							//search all non friends
							break;
						}
						case "4": {
							//go back
							break;
						}
						default: {
							System.out
							.println("Invalid input. Please enter one of the numerical values above.");
							break;
						}
				
			}
					
				}
			break;
			}
			case "7":{
				
				String b = "";
				while(b.equals("3") == false) {
					System.out.println("\n1. Logout/Login as someone new\n\n2. Switch Users\n\n3. Go Back");
					b = reader.next();
					switch(b) {
					case "1": {
						Login();
					}
					case "2": {
						SwitchUser();
					}
					case "3": {
						break;
					}
					default: {
						System.out.println("Invalid input, Please enter one of the options above");
						break;
					}
					}
				}
				
				return;
			}
			case "8":{
				String b = "";
				
				while (b.equals("5") == false) {
					System.out
					.println("\n1. print users and passwords\n\n2. Enter a user and view their owned songs. \n\n3. Add a user \n\n4. See the Current Users Loggedin\n\n5. Go back\n\nEnter one of the numbers above.\n");
					b = reader.next();
					switch (b) {
							case "1": {
								LinkedList<User> ll = UM.getUsers();
								ListIterator it = ll.listIterator();
								while(it.hasNext()){
									User temp = (User)it.next();
									System.out.println("Name: " + temp.getUsername() + " " + "Password: " + temp.getPassword());
								}
								break;
							}
							case "2": {
								System.out.println("Enter the name of a user.");
								String _user = reader.next();
								if(!UM.setCurrentUser(_user)){
									System.out.print("Name given was not a valid user.");
									break;
								}
								LinkedList<Song> ll = UM.getOwnedSongs();
								ListIterator it = ll.listIterator();
								while(it.hasNext()){	
									System.out.println(it.next().toString());
								}
								break;
							}
							case "3": {
								System.out.println("Enter the name of the new user.");
								String name = reader.next();
								System.out.println("Enter " + name + "'s password.");
								String password = reader.next();
								UM.addUser(name, password);
								break;
							}
							case "4": {
								System.out.println("The current user is " + UM.getCurrentUser() + ".\n");
								System.out.println("These are the users who are currently logged in.\n");
								for(int i = 0; i < UM.Loggedin.size(); i++) {
									System.out.println(UM.Loggedin.get(i));
								}
								
							}
							case "5": {
								break;
							}
							default: {
								System.out
								.println("Invalid input. Please enter one of the numerical values above.");
								break;
							}
			
			}
			
			}
		}
		
	}

}
}
}
