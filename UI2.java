import java.util.Scanner;
import java.util.LinkedList;
import java.util.ListIterator;


public class UI {
private UserManager UM;
private String current;
private LinkedList<Song> temm = new LinkedList<Song>();
	public UI(LinkedList<User> Users){
		UM = new UserManager(Users);
		
	}
	public void Login() {
		while(true) {
		
		LinkedList<String> currently = new LinkedList<String>();
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
							//add song method here
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
							//borrow song
							break;
						}
						case "2": {
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
				.println("\n1. check messages\n\n2. send friend request \n\n2. Send Borrow request\n\n4. go back\n\nEnter one of the numbers above.\n");
				b = reader.next();
				switch (b) {
						case "1": {
							//check messages
							break;
						}
						case "2": {
							//send friend request
							break;
						}
						case "3": {
							//send borrow request
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
				Login();
				return;
			}
			case "8":{
				String b = "";
				
				while (b.equals("4") == false) {
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
}}
