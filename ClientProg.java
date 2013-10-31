import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class ClientProg {
	public static void main(String args[]) {
		String filename = args[1];
		File file = new File(filename);
		String s = "";
		//Arrays to read in data, and split the unecessary characters
		String[] tokens = null;
		String[] userdata = null;
		String[] friendata = null;
		String[] songdata = null;
		//New Users and New Users Library
		User newuser = null;
		Library lib = null;
		Scanner in = null;
		int lastindex = 0;
		//List of everything being read in
		LinkedList<Song> SongList = new LinkedList<Song>();
		LinkedList<User> UserList = new LinkedList<User>();
		LinkedList<Library> LibraryList = new LinkedList<Library>();


		try {
			in = new Scanner(file);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Read File Line by Line and Create New Users, Songs, and Friends Lists.
		//Doesn't do any error checking, not sure what to do if incorrect file is read in. 
		//Can account for missing data in Song
		//Read all of the lines into tokens, and remove the [] and the |.
		while(in.hasNext()) {
			s = in.nextLine();


			String delims = "[|\\[\\]]";
			tokens = s.split(delims);


			for(int i = 0; i < tokens.length; i++) {
				if(tokens[i].startsWith(" ")) {
					tokens[i] = tokens[i].substring(1);
				}
				if(tokens[i].endsWith(" ")) {
					tokens[i] = tokens[i].substring(0, tokens[i].length()-1);
				}
			}
			//Create User
			//Store User data into array called UserData and remove ,
			//Remove Spaces before or after Userdata,
			//Create new User based on values being read in
			String userdelims = "[,]";
			for(int i = 0; i < 1; i++) {
				userdata = tokens[i].split(userdelims);
				for(int j = 0; i < userdata.length; i++) {
					if(userdata[i].startsWith(" ")) {
						userdata[i] = userdata[i].substring(1);
					}
					if(userdata[i].endsWith(" ")) {
						userdata[i] = userdata[i].substring(0, userdata[i].length()-1);
					}
				}
				newuser = new User(userdata[0],userdata[1]);
				newuser.setVisibility("e");
				newuser.setBorrowtime(-1);
				newuser.setPlayamount(3);

			}
			//Create Songs
			//Store Song data into array songdata after removing , and |
			//Create new song and store it into SongList
			String songdelims = "[,//|]";
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
				OwnedSong newsong = new OwnedSong(songdata[0],songdata[1],songdata[2],songdata[3],songdata[4],songdata[5],newuser.getUsername());
				SongList.add(newsong);
				newuser.getOwnedLib().getSongs().add(newsong);
				newuser.getPlayableLib().getSongs().add(newsong);
				lastindex = i;
			}
			//Create Friends
			//Create Friend Data and store into friendata after removing the ( ) and ,
			//Not sure what to do if trying to add friend that doesnt exist
			//String frienddelims = "[(//)//,]";
			for(int i = lastindex+1; i < tokens.length; i++) {
				friendata = tokens[i].split(userdelims);
				for(int j = 0; j < friendata.length; j++) {
					if(friendata[j].startsWith("(")) {
						friendata[j] = friendata[j].substring(1);
					}
					if(friendata[j].endsWith(")")) {
						friendata[j] = friendata[j].substring(0, friendata[j].length()-1);
					}
					newuser.addFriends(friendata[j]);
				}
			}
			//Create the new Library with the User and the SongList
			//Clear SongList to do it again
			lib = new Library(newuser, SongList);
			LibraryList.add(lib);
			UserList.add(newuser);//adding user to the list down here so it maintains all the other information read in
			SongList.clear();
			
		}
		
		// This loops through the user list, get each person friends list, and check if the person they have added, has them added
		// If they don't then it adds them
			for(int i=0;i<UserList.size();i++){
				String curname =UserList.get(i).getUsername();
				for (int j=0;j<UserList.get(i).getFriends().size();j++){
					String friend=UserList.get(i).getFriends().get(j);
					for(int k=0;k<UserList.size();k++){
						if(UserList.get(k).getUsername().equals(friend)){
							boolean flag=false;
							for (int a=0;a<UserList.get(k).getFriends().size();a++){
								if(UserList.get(k).getFriends().get(a).equals(curname)){
									flag=true;
								}
							}
							if(flag==false){
								if (UserList.get(k).getFriends().get(0).equals("")){
									UserList.get(k).getFriends().remove();
								}
								UserList.get(k).addFriends(curname);
							}
						}
					}
				}
				
				
			}

		
		UI ui = new UI(UserList);
		ui.Login();
	}	
}
