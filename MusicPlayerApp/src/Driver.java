import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


public class Driver {

	private static ArrayList<Album> albums = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Album album = new Album("Al1", "Adele");
		album.addSong("Rolling in the deep", 4.7);
		album.addSong("Easy on me", 3.8);
		album.addSong("Hello", 5.4);
		album.addSong("Someone like you", 5.2);
		albums.add(album);
		
		album = new Album("Al2", "Demi Lovato");
		album.addSong("Heart Attack", 3.9);
		album.addSong("Cool for the summer", 5.3);
		album.addSong("Confident", 4.1);
		album.addSong("Sorry not sorry", 3.9);
		albums.add(album);
		
		//System.out.println(albums.toString());
		LinkedList<Song> playList1 = new LinkedList<>();
		albums.get(0).addToPlayList("Easy on me", playList1);
		albums.get(1).addToPlayList("Sorry not sorry", playList1);
		albums.get(0).addToPlayList("Someone like you", playList1);
		albums.get(1).addToPlayList("Confident", playList1);
		
		System.out.println();
		play(playList1);
		
	}
	
	private static void play(LinkedList<Song> playList)
	{
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		
		ListIterator<Song> list = playList.listIterator();
		
		if(playList.size() == 0)
		{
			System.out.println("This playlist has no songs");
		}
		else
		{
			System.out.println("Now playing " + list.next().toString());
			printMenu();
 		}
		
		int choice;
		while(!quit)
		{
			choice = sc.nextInt();
			//sc.nextLine();
			
			switch(choice)
			{
			case 0: 
				System.out.println("Stop playing the playlist");
				quit = true;
				break;
			case 1: 
				if(!forward) {
					if(list.hasNext()) {
						list.next();
					}
					forward = true;
				}
				if(list.hasNext()) {
					System.out.println("Now playing " + list.next().toString());
				}
				else 
				{
					System.out.println("End of the list");
					forward = false;
				}
				break;
			case 2:
				if(forward)
				{
					if(list.hasPrevious())
					{
						list.previous();
					}
					forward = false;
				}
				if(list.hasPrevious())
				{
					System.out.println("Now playing " + list.previous().toString());
				}
				else 
				{
					System.out.println("Start of the list");
				}
				break;
			case 3:
				if(forward)
				{
					if(list.hasPrevious())
					{
						System.out.println("Now playing " + list.previous().toString());
						forward = false;
					} 
					else
					{
						System.out.println("Start of the list");
					}
				}
				else
				{
					if(list.hasNext())
					{
						System.out.println("Now playing " + list.next().toString());
						forward = true;
					}
					else
					{
						System.out.println("End of the list");
					}
				}
			
				break;
			case 4: 
				printList(playList);
				break;
			case 5:
				printMenu();
				break;
			case 6: 
				if(playList.size() > 0)
				{
					list.remove();
					if(list.hasNext())
					{
						System.out.println("Now playing " + list.next().toString());
					}
					else {
						if(list.hasPrevious()) {
							System.out.println("Now playing " + list.previous().toString());
						}
					}
				}
				break;
			}
		}
	}
	
	private static void printMenu()
	{
		System.out.println();
		System.out.println("********************************");
		System.out.println("0 - Quit");
		System.out.println("1 - Play Next Song");
		System.out.println("2 - Play Previous Song");
		System.out.println("3 - Replay the Current Song");
		System.out.println("4 - List All Songs");
		System.out.println("5 - Print All Options");
		System.out.println("6 - Delete the Current Song");
		System.out.println("********************************");
		System.out.println();
	}
	
	private static void printList(LinkedList<Song> playList)
	{
		Iterator<Song> it = playList.iterator();
		System.out.println("---------------------------------");
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		System.out.println("---------------------------------");
	}
}
