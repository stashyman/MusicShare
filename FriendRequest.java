
public class FriendRequest extends Message {
	public FriendRequest(User sender_, User recipiant_, String message_, String type_) {
		super(sender_, recipiant_, message_, type_);
		// TODO Auto-generated constructor stub
	}
	
	//find out if accepted and the friends list between the recipiant and the sender
	public boolean Accepted() {
		sender.addFriends(recipiant.getUsername());
		recipiant.addFriends(sender.getUsername());
		return true;
	}
	//find the recipiant and the sender and send a message saying that they have been denied
	public boolean Denied() {
		return false;
	}
	public String getType() {
		return type;
	}
	public String toString() {
		return "From: "+ sender.getUsername() + 
				"\nTo: "+ recipiant.getUsername() + "\n"+
				message;
	}
}
