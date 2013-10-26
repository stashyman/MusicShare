import java.util.LinkedList;
import java.util.ListIterator;

public class User {
	//Users only have username, password, and friends list. Do we need any more?
	private String username;
	private String password;
	private LinkedList<Message> messages = new LinkedList<Message>();
	public Library ownedLibrary = new Library();
	public Library playableLibrary = new Library();
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
	public User(User _user){//copy constructor
		username = _user.getUsername();
		password = _user.getPassword();
		friends = new LinkedList<String>();
		ListIterator LI = _user.getFriends().listIterator();
		while(LI.hasNext()){
			friends.add((String)LI.next());
		}
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
		ownedLibrary.getSongs().add(s);
	}
	public void addFriends(String s) {
		friends.add(s);
	}
	public void addMessage(Message m){
		messages.add(m);
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void addBorrowedSongs(Song s) {
		playableLibrary.getSongs().add(s);
	}
	public void setUserName(String n) {
		this.username = n;
	}
	public LinkedList<String> getFriends() {
		return friends;
	}
	public void setPassword(String nPass){
		password = nPass;
	}
	public LinkedList<Message> getMessages() {
		return messages;
	}
	public Message getFirstMessage(){
		return messages.element();
	}
	public LinkedList<Song> getOwnedLibrary(){
		return ownedLibrary.getSongs();
	}
	
}
