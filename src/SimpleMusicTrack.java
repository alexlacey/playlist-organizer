/**
 * 
 *   A simple class for music tracks.
 *   
 *   @author Alex Lacey
 *   @version 20171001
 */

import java.util.Scanner;

public class SimpleMusicTrack implements PlayListTrack {
	private String album;
	private String artist;
	private String name;

	// prepares a track to be filled in with the Scanner
	public SimpleMusicTrack() {
	}
	
	// creates a track with a specific input
	public SimpleMusicTrack(String name, String artist, String album) {
		setName(name);
		setArtist(artist);
		setAlbum(album);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return this.artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return this.album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	// gets the next track from a text file
	public boolean getNextTrack(Scanner in) {
		try {
			this.name = in.nextLine();
			this.artist = in.nextLine();
			this.album = in.nextLine();
			return this.equals(in);
		} catch (Exception e) {
			System.out.println("Error: " + e);
			return false;
		}
	}

	// replacement of Object's equals method
	public boolean equals(SimpleMusicTrack track) {
		if ((this.name == track.getName()) && this.artist == track.getArtist() && this.album == track.getAlbum()) {
			return true;
		}
		return false;
	}

	// replacement of Object's toString method
	public String toString() {
		return "'" + getArtist() + " / " + getName() + "'";
	}
}