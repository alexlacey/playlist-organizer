import java.io.*;
import java.util.Scanner;

/**
 * 
 *   
 *   @author Alex Lacey
 *   @version 20171001
 */
public class Project03 {
	
	static PlayListTrack track = new SimpleMusicTrack();
	static Scanner infile = new Scanner(System.in);
	static SimplePlayList playList;
	public String userInput;
	public int counter = 0;
	
	public static void main(String[] args) {
		Project03 project03 = new Project03();
	}
	
	public Project03() {
		playList = new SimplePlayList(track);
		getFile();
		boolean keepGoing = true;
		while (keepGoing == true) {
			displayInfo();
			userSelection();
		}
	}

	
	// user inputs the file name
	public static void getFile() {
		Scanner in = new Scanner(System.in);
		System.out.print("Input filename: ");
		try {
			File inputFile = new File(in.nextLine());
			Scanner input = new Scanner(inputFile);
			track.getNextTrack(input);
			while (input.hasNext()) {
				PlayListTrack track = new SimpleMusicTrack();
				track.getNextTrack(input);
				playList.addTrack(track);
			}
			input.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

	}
	
	// print the current track and next track
	public void displayInfo() {
		
		if (counter == 0) {
			System.out.println("Currently playing: No Song Playing");
		}  else if (playList.songsInPlaylist() + 1 == 0) {
			System.out.println("No songs remaining");
			return;
		} else {
			System.out.println("Currently playing: " + track.toString());
		}
		
		if (playList.songsInPlaylist() >= 1){
			System.out.println("Next track to play: " + playList.peekAtNextTrack());
		} else {
			System.out.println("Next track to play: No songs remaining in playlist");
		} 
		
	}

	// gets the user selection (play, add, or quit) and makes it happen
	public boolean userSelection() {
		
		Scanner in = new Scanner(System.in);

		if (playList.songsInPlaylist() >= 1){
			System.out.println("[P]lay next track");
		}
		System.out.println("[A]dd a new track");
		System.out.println("[Q]uit");
		String userInput = in.next();
		
		if ((userInput.equals("p")) || (userInput.equals("P"))) {
			userPlay();
			return true;
		} else if ((userInput.equals("a")) || (userInput.equals("A"))) {
			userAdd();
			return true;
		} else if ((userInput.equals("q")) || (userInput.equals("Q"))) {
			userQuit();
			return false;
		} else {
			System.out.println("Invalid input");
			userSelection();
		}
		return false;
		
	}

	// if the user decides to play the track
	public void userPlay() {
		track = playList.getNextTrack();
		this.counter += 1;
	}
	
	// if the user decides to add a track
	public void userAdd() {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter track name:");
		String name = in.nextLine();
		System.out.println("Enter artist name:");
		String artist = in.nextLine();
		System.out.println("Enter album name:");
		String album = in.nextLine();
		PlayListTrack newTrack = new SimpleMusicTrack(name, artist, album);
		
		System.out.println("New track: " + newTrack.getName());
		System.out.println("Artist: " + newTrack.getArtist());
		System.out.println("Album: " + newTrack.getAlbum());
		System.out.println("Are you sure you want to add this track [y/n]?");
		String confirmation = in.nextLine();

		if ((confirmation.equals("y") || confirmation.equals("Y"))) {
			playList.addTrack(newTrack);
		}
		
		
	}
	
	// if the user decides to quit
	public void userQuit() {
		playList.remainingTracks();
		System.exit(0);
	}

	
}