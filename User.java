import java.util.LinkedList;


public class User {
	//Users only have username, password, and friends list. Do we need any more?
	private String username;
	private String password;
	public LinkedList<Song> ownedLibrary = new LinkedList<Song>();
	public LinkedList<Song> playableLibrary = new LinkedList<Song>();
	public LinkedList<Song> borrowedLibrary = new LinkedList<Song>();
	private LinkedList<String> friends = new LinkedList<String>();
	
	public User(String username_, String password_, String friends_){
		username = username_;
		password = password_;
		friends = new LinkedList<String>();
		friends.add(friends_);
	}
	public User(String username_, String password_){
		username = username_;
		password = password_;
	}
	//Need to add method if friends list is empty so it does not through a no such element exception
	public void PrintFriends(User u) {
//		if(friends.getFirst() == null) {
//			System.out.println("You do not have any friends on your friends list \n");
//		}
		for(int i = 0; i < u.friends.size(); i++) {
			String g = u.friends.get(i);
			System.out.println(g);
		}
	}
	
	public void addSongsList(Song s) {
		ownedLibrary.add(s);
	}
	public void addPlayableSongs(Song s) {
		playableLibrary.add(s);
	}
	public void addFriends(String s) {
		friends.add(s);
	}
	public String getUsername() {
		return username;
		
	}
	public void addBorrowedSongs(Song s) {
		borrowedLibrary.add(s);
	}
	public void setUserName(String n) {
		this.username = n;
	}
	public LinkedList<String> getFriends() {
		return friends;
	}
}
