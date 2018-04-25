/**
 * 
 *   A simple class for music tracks.
 *   
 *   @author Alex Lacey
 *   @version 20171001
 */

import java.util.ArrayList;

public class SimplePlayList implements PlayList {
	
	public ArrayList<PlayListTrack> list = new ArrayList<PlayListTrack>();
	
	public SimplePlayList(PlayListTrack track) {
		addTrack(track);
	}

	// Get the next track
	public PlayListTrack getNextTrack() {
		PlayListTrack track = list.get(0);
		list.remove(0);
		return track;
	}

	// Shows the next track
	public PlayListTrack peekAtNextTrack() {
		return list.get(0);
	}

	// Prints the tracks that will be played
	public void remainingTracks() {
		System.out.println("Tracks remaining in playlist: ");
		System.out.println("-----------------------------");
		if (list.size() == 0) {
			System.out.println("No tracks remaining");
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(i + 1 + ".) ");
				System.out.println(list.get(i).getArtist() + " / " + list.get(i).getName() + " / " + list.get(i).getAlbum());
			}
			list.clear();
		}
	}

	// adds a track to the end of the playlist
	public void addTrack(PlayListTrack track) {
		this.list.add(track);
	}

	// checks if playlist is empty
	public boolean isEmpty() {
		if (this.list.size() >= 1) {
			return true;
		} else {
			return false;
		}
	}
	
	// returns number of songs in playlist
	public int songsInPlaylist() {
		return list.size();
	}
}