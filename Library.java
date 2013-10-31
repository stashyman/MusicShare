import java.util.LinkedList;
import java.util.ListIterator;


public class Library {
	//Library only has the Owner of the Library and the List of the Songs that the user owns.
	private User Owner;
	private LinkedList<Song> Library = new LinkedList<Song>();
	private Sort sortedBy;

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
	public void setSortBy(Sort _sort){
		sortedBy = _sort;
	}
	public void sortLib(){
		LinkedList<Song> temp = new LinkedList<Song>();
		ListIterator<Song> libIt = Library.listIterator();

		//while there are elements in the library
		while(libIt.hasNext()){
			boolean insert = false;
			//reset the new library iterator
			ListIterator<Song> tempIt = temp.listIterator();
			//if the library is empty just add the element
			if(!tempIt.hasNext()){
				temp.add(libIt.next());
				insert = true;
			}
			else{
				while(tempIt.hasNext() && insert == false){
					switch(sortedBy){
					case title:{
						if(libIt.next().getName().compareTo(tempIt.next().getName()) <= 0){
							libIt.previous();
							tempIt.previous();
							temp.add(tempIt.nextIndex(), libIt.next());	
							insert = true;
						}
						else{
							libIt.previous();
						}
						break;
					}
					
					case artist:{
						if(libIt.next().getArtist().compareTo(tempIt.next().getArtist()) <= 0){
							libIt.previous();
							tempIt.previous();
							temp.add(tempIt.nextIndex(), libIt.next());	
							insert = true;
						}
						else{
							libIt.previous();
						}
						break;
					}
					
					case genre:{
						if(libIt.next().getGenre().compareTo(tempIt.next().getGenre()) <= 0){
							libIt.previous();
							tempIt.previous();
							temp.add(tempIt.nextIndex(), libIt.next());	
							insert = true;
						}
						else{
							libIt.previous();
						}
						break;
					}
					
					case composer:{
						if(libIt.next().getComposer().compareTo(tempIt.next().getComposer()) <= 0){
							libIt.previous();
							tempIt.previous();
							temp.add(tempIt.nextIndex(), libIt.next());	
							insert = true;
						}
						else{
							libIt.previous();
						}
						break;
					}
					
					case year:{
						if(libIt.next().getYear().compareTo(tempIt.next().getYear()) <= 0){
							libIt.previous();
							tempIt.previous();
							temp.add(tempIt.nextIndex(), libIt.next());	
							insert = true;
						}
						else{
							libIt.previous();
						}
						break;
					}
					
					case album:{
						if(libIt.next().getAlbum().compareTo(tempIt.next().getAlbum()) <= 0){
							libIt.previous();
							tempIt.previous();
							temp.add(tempIt.nextIndex(), libIt.next());	
							insert = true;
						}
						else{
							libIt.previous();
						}
						break;
					}
					
					default:{
						
					}
					}


				}

				if(!insert){
					temp.add(libIt.next());
				}
			}}
		Library = temp;
	}
}
