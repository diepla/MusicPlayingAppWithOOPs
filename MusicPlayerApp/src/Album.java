import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

	private String name;
	private String artist;
	private ArrayList<Song> songs;
	
	public Album()
	{
	}

	public Album(String name, String artist) {
		super();
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<Song>();
	}
	
	public boolean findSong(String title)
	{
		for(Song checkSong : songs)
		{
			if(checkSong.getTitle().equals(title))
			{
				return true;
			}
		}
		return false;
	}
	
	public Song getSong(String title)
	{
		for(Song song : songs)
		{
			if(song.getTitle().equals(title))
			{
				System.out.println("name: " + name + " artist: " + artist + " song: " + title);
				return song;
			}
		}
		return null;
	}
	
	public boolean addSong(String title, double duration)
	{
		if(!findSong(title)) 
		{
			songs.add(new Song(title, duration));
			System.out.println(title + " successfully added to the list");
			return true;
		}
		else
		{
			System.out.println("Song with title " + title + " already exist in the list");
			return false;
		}
	}
	
	public boolean addToPlayList(String title, LinkedList<Song> playList)
	{
		if(findSong(title))
		{
			playList.add(getSong(title));
			return true;
		}
		else
		{
			System.out.println("Title " + title + " does not exist in the album");
			return false;
		}
	}

	@Override
	public String toString() {
		return "Album [name=" + name + ", artist=" + artist + ", songs=" + songs + "]";
	}
	
}
