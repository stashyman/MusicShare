import java.util.LinkedList;
import java.util.ListIterator;

public class User {
	//Users only have username, password, and friends list. Do we need any more?
	private String username;
	private String password;
	private LinkedList<Message> messages = new LinkedList<Message>();
	private Library ownedLibrary = new Library();
	private Library playableLibrary = new Library();
	private LinkedList<String> friends = new LinkedList<String>();
	private String visible;
	private LinkedList<Playlist> playlist = new LinkedList<Playlist>();
	private int borrowtime;
	private int playamount;
	public User(String username_, String password_, String friends_, String visible_){
		username = username_;
		password = password_;
		friends = new LinkedList<String>();
		friends.add(friends_);
		visible = visible_;
	}
	public User(String username_, String password_){
		username = username_;
		password = password_;
	}
	public User(User _user){//copy constructor
		username = _user.getUsername();
		password = _user.getPassword();
		friends = new LinkedList<String>();
		ListIterator<String> LI = _user.getFriends().listIterator();
		while(LI.hasNext()){
			friends.add((String)LI.next());
		}
	}
	
	//Need to add method if friends list is empty so it does not through a no such element exception
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
	public void addPlaylist(Playlist s) {
		playlist.add(s);
	}
	public void addBorrowedSongs(Song s) {
		playableLibrary.getSongs().add(s);
	}
	public void setUserName(String n) {
		this.username = n;
	}
	public void setVisibility(String y) {
		visible = y;
	}
	public String getVisibility() {
		return visible;
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
	public LinkedList<Playlist> getPlaylist() {
		return playlist;
	}
	public int getPlayamount() {
		return playamount;
	}
	public Library getPlayableLib(){
		return playableLibrary;
	}
	public Library getOwnedLib(){
		return ownedLibrary;
	}
	public void setPlayamount(int playamount) {
		this.playamount = playamount;
	}
	public int getBorrowtime() {
		return borrowtime;
	}
	public void setBorrowtime(int borrowtime) {
		this.borrowtime = borrowtime;
	}
	
}
