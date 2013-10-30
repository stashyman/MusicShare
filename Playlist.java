import java.util.LinkedList;


public class Playlist {
	private LinkedList<OwnedSong> playlist = new LinkedList<OwnedSong>();
	
	public Playlist(){
		
	}
	
	public Playlist(OwnedSong a){
		playlist.add(a);
		
	}
	public Playlist(LinkedList<OwnedSong> songs){
		playlist=songs;
	}
	
	public void addsong(OwnedSong a){
		playlist.add(a);
		
	}
	public Song getsong(int index){
		return playlist.get(index);
		
	}
	public int getsize(){
		return playlist.size();
		
	}
	public void removesong(Song a){
		for(int i=0;i<playlist.size();i++){
			if(playlist.get(i).equals(a)){
				playlist.remove(i);
				//System.out.println("Song :"+ a + " was removed.");
				return;
			}
		}
		System.out.println("Song :"+ a + " was not found.");
		
	}
	public void removesong(int index){
		Song temp=playlist.get(index);
		playlist.remove(index);
		System.out.println("Song :"+ temp + " was removed.");
	}
	
	public void play(){
		for (int i=0;i<playlist.size();i++){
			if(playlist.get(i).isLent==false) System.out.println("You are currently playing the song titled " + playlist.get(i).name);
			
			else System.out.println("Cannot play " + playlist.get(i).name + " right now, it is being lent");
		}
	}
	
	public String toString(){
		String a="";
		for (int i=0;i<playlist.size();i++){
			a+="Song "+(i+1) + ": "+playlist.get(i) +'\n';
			
		}
		return a;
	}
	
	
	
	
	

}
