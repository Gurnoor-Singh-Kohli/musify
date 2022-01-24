package beans.input;

import java.util.List;


import com.musify.model.Artist;

public class MusicInputBean {

	private byte[] file;
	
	private List<Integer> artists;

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public List<Integer> getArtists() {
		return artists;
	}

	public void setArtists(List<Integer> artists) {
		this.artists = artists;
	}
}
