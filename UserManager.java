//UserManager
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Enumeration;

public class UserManager{
	private Hashtable<String, User> Users;
	private String currentUser;
	public LinkedList<String> Loggedin = new LinkedList<String>();
	private String type;
	
	/*Constructor*/
	public UserManager(LinkedList<User> _Users){
		Users = new Hashtable<String, User>();
		ListIterator UI = _Users.listIterator();
		while(UI.hasNext()){
			User temp = (User)UI.next();
			Users.put(temp.getUsername(), temp);
		}
	}
	
	
	//add a user
	public boolean addUser(User _user){
		if(Users.put(_user.getUsername(), _user) == null){
			return false;
		}
		return true;
	}
	//add user
	public void addUser(String name, String _password){
		User temp = new User(name, _password);
		Users.put(name, temp);
	}
	//change a user's password
	public boolean changePass(String oPass, String nPass, User _user){
		if(_user.getPassword().equals(oPass)){
			_user.setPassword(nPass);
			return true;
		}
		else{
			return false;
		}
	}
	public LinkedList<String> getUserNames(){//returns a linked list of all the keys(user names)
		Enumeration<String> e = Users.keys();
		LinkedList<String> ll = new LinkedList<String>();
		while(e.hasMoreElements()){
			ll.add(e.nextElement());
		}
		return ll;
	}
	
	public LinkedList<User> getUsers(){//returns a linked list of all the users
		Enumeration<User> e = Users.elements();
		LinkedList<User> ll = new LinkedList<User>();
		while(e.hasMoreElements()){
			ll.add(e.nextElement());
		}
		return ll;
	}
	
	public void sendFriendRequest(String receiver, String message){//add a message to the receivers message linkedlist
		FriendRequest FR = new FriendRequest(Users.get(currentUser), Users.get(receiver), message, type);
		Users.get(receiver).addMessage(FR);
	}
	//returns a linked list of all the owned songs
	public LinkedList<Song> getOwnedSongs(){
		return Users.get(currentUser).getOwnedLibrary();
	}
	
	public Message getFirstMessage(){//grabs the first element in the list, removes it from the list, and returns the message
		return Users.get(currentUser).getFirstMessage();	
	}
	//Get the current User
	public String getCurrentUser() {
		return currentUser;
	}
	public Library getOwnedLib(){
		return Users.get(currentUser).getOwnedLib();
	}
	public Library getPlayableLib(){
		return Users.get(currentUser).getPlayableLib();
	}
	public boolean setCurrentUser(String _user){
		User tempUser = Users.get(_user);
		if(tempUser == null){
			return false;
		}
		currentUser = _user;
		return true;
	}
	

	
}
