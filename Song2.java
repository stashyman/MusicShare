
public class Song {
	//Didn't include owner of Song. Ownership of songs can be accessed through the Library, but can easily add the Owner of the song to this class.
	private String name;
	private String artist;
	private String album;
	private String year;
	private String composer;
	private String genre;
	public Song(String Name_, String Artist_, String Album_, String year_, String composer_, String genre_) {
		name = Name_;
		artist = Artist_;
		album = Album_;
		year = year_;
		composer = composer_;
		genre = genre_;
	}
	public Song() {
		name = null;
		artist = null;
		album = null;
		year = null;
		composer = null;
		genre = null;
	}
	public String toString() {
		return "[" + name + ", " + artist + ", " + album + ", " + year + ", " + composer + ", " + genre + "]";
	}
	public void setName(String n) {
		this.name = n;
	}
	public void setArtist(String a) {
		this.artist = a;
	}
	public void setAlbum(String a) {
		this.album = a;
	}
	public void setYear(String y) {
		this.year = y;
	}
	public void setComposer(String c) {
		this.composer = c;
	}
	public void setGenre(String g) {
		this.genre = g;
	}
	public String getName() {
		return name;
	}
	public String getAlbum() {
		return album;
	}
	public String getComposer() {
		return composer;
	}
	public String getYear() {
		return year;
	}
	public String getGenre() {
		return genre;
	}
	public String getArtist() {
		return artist;
	}
}
