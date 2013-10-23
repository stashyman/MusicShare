
public class SongRequest extends Message{
	private User sender;
	private User recipiant;
	private String message;
	public SongRequest(User sender_, User recipiant_, String message_) {
		super(sender_, recipiant_, message_);
		// TODO Auto-generated constructor stub
	}
	//add the song to the borrowed library
	public boolean Accepted(Song e) {
		recipiant.borrowedLibrary.add(e);
		return true;
	}
	public boolean Denied() {
		return false;
	}

}
