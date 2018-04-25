/**
 * PlayListTrack
 * 
 *   A simple interface for music tracks.
 *   
 *   @author Alex Lacey
 *   @version 20171001
 */

import java.util.Scanner;
public interface PlayListTrack {
	public String getName();
	public void setName(String name);
	public String getArtist();
	public void setArtist(String artist);
	public String getAlbum();
	public void setAlbum(String album);
	public boolean getNextTrack(Scanner infile);
		// Attempts to read a playlist track entry from a Scanner object
		// Sets the values in the object to the values given in
		// the file
		// If it successfully loads the track, return true
		// otherwise, return false
}