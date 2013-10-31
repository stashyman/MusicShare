import java.util.Date;

public class BorrowedSong extends Song{
	private Date startTime;
	private float playableTime;
	private int playsLeft;
	private String borrower;
	
	public BorrowedSong(String Name_, String Artist_, String Album_, String year_, String composer_, String genre_, int _playsLeft, String _borrower, String _owner){
		super( Name_,  Artist_,  Album_,  year_, composer_,  genre_, _owner);
		playsLeft = _playsLeft;
		startTime = null;
		playableTime = -1;
		borrower = _borrower;
		
	}
	public BorrowedSong(String Name_, String Artist_, String Album_, String year_, String composer_, String genre_, float _playableTime, String _borrower, String _owner){
		super( Name_,  Artist_,  Album_,  year_, composer_,  genre_, _owner);
		playsLeft = -1;
		startTime = new Date();
		playableTime = _playableTime * 60000;//playable time in milliseconds.  Playable time is passed in minutes.
		borrower = _borrower;
		
	}
	public boolean play(){
		if(playsLeft == -1){
			Date temp = new Date();
			float time=(startTime.getTime() + playableTime);
			Date temp1= new Date((long) time);
			boolean asd=temp1.before(temp);
			if(temp1.before(temp)){
				return false;
			}
			else{
				System.out.println("You are currently playing the song titled: " +this.getName()+ '\n');
				temp = new Date((long)(startTime.getTime() + playableTime));
				System.out.println("Song returns on " + temp);
				return true;
			}		
		}
		else {
			System.out.println("You are currently playing the song titled: " +this.getName()+ '\n');		
			playsLeft += -1;
			System.out.println("Plays left: " + playsLeft);
			if(playsLeft == 0){
				return false;
			}
			return true;
		}
	}
	
	public String getBorrower(){
		return borrower;
	}
	
	public void setBorrower(String _borrower){
		borrower = _borrower;
	}
}
