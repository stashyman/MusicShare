
public class SongRequest extends Message{
	public SongRequest(User sender_, User recipiant_, String message_, String type_) {
		super(sender_, recipiant_, message_, type_);
		// TODO Auto-generated constructor stub
	}
	//add the song to the borrowed library
	public boolean Accepted(Song e) {
		recipiant.playableLibrary.getSongs().add(e);
		return true;
	}
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
