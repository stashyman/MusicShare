import java.util.Scanner;

public class UI {
	public static void main(String args[]){

		String a = "";
		while (a != "3") {
			System.out
			.println("\n1. Listen to song/playlist\n\n2. add playlist/song or edit song/playlist\n\n3. borrow/take back song\n\n"
					+ "4. Profile settings\n\n5. check messages or send a friend request\n\n"
					+ "6. browse for songs\n\n7. log out\n\nEnter one of the numbers above.\n");
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
							case "1": {
								//play song method here I figure we show them what songs they can choose to play in here
								break;
							}
							case "2": {
								// play playlist method here. We can list the playlist available to play here
							
								break;
							}
							case "3":{
								break;
							}
							default: {
								System.out
								.println("Invalid input. Please enter one of the numerical values above.");
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
							//create playlist
							break;
						}
						case "3": {
							////edit playlist
							break;
						}
						case "4": {
							//edit song here
							break;
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
				reader.close();
				return;
			
			}
			
			}
		}
		
	}

}