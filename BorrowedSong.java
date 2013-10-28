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
			if((startTime.getTime() + playableTime) < temp.getTime()){
				return false;
			}
			else{
				System.out.println("You have played: " + this.toString());
				temp = new Date((long)(startTime.getTime() + playableTime));
				System.out.println("Song returns on " + temp);
				return true;
			}		
		}
		else {
			System.out.println("You have played: " + this.toString());		
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