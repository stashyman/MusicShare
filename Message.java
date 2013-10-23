
public class Message {
	private User sender;
	private User recipiant;
	private String message;
	public Message(User sender_, User recipiant_, String message_) {
		sender = sender_;
		recipiant = recipiant_;
		message = message_;
	}
}
