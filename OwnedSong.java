import java.util.LinkedList;

public class OwnedSong extends Song{
	boolean isLent;
	LinkedList<String> queue;
	
	public OwnedSong(String Name_, String Artist_, String Album_, String year_, String composer_, String genre_, String _owner){
		super( Name_,  Artist_,  Album_,  year_, composer_,  genre_, _owner);
		isLent = false;
		queue = new LinkedList<String>();
	}
	public boolean Play(){
		if(!isLent){
			System.out.println("You have played: " + this.toString());
			return true;
		}
		else{
			System.out.println("This song is currently being borrowed.");
			return false;
		}
	}
	public void setIsLent(boolean bool){
		isLent = bool;
	}
	
	public void addToQueue(String _borrower){
		queue.add(_borrower);
	}
	public String deQueue(){
		return queue.pop();
	}
	
	public String peek(){
		return queue.peekFirst();
	}
	public boolean getIsLent(){
		return isLent;
	}
}
