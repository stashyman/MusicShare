
public class Message {
	protected User sender;
	protected User recipiant;
	protected String message;
	protected String type;
	protected String songname;
	public Message(User sender_, User recipiant_, String message_, String type_) {
		sender = sender_;
		recipiant = recipiant_;
		message = message_;
		type = type_;
	}
}
