public class Message {
	protected User sender;
	protected User recipiant;
	protected String message;
	public Message(User sender_, User recipiant_, String message_) {
		sender = sender_;
		recipiant = recipiant_;
		message = message_;
	}
}
