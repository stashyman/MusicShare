import java.util.LinkedList;
import java.util.ListIterator;


public class Library {
	//Library only has the Owner of the Library and the List of the Songs that the user owns.
	private User Owner;
	private LinkedList<Song> Library = new LinkedList<Song>();

	public Library(){
		
	}
	public Library(User s, LinkedList<Song> lib) {
		Owner = s;
		Library = lib;
	}
	public User getOwner() {
		return Owner;
	}
	public LinkedList<Song> getSongs(){
		return Library;
	}
	
	public void sortLib(LinkedList ll, Sort _sort){
		LinkedList sorted = new LinkedList();
		ListIterator li = sorted.listIterator();
		
	}

	
	
}
