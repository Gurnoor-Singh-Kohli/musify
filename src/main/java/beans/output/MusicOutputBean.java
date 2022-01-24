package beans.output;

import java.io.Serializable;
import java.util.List;


import com.musify.model.Artist;

public class MusicOutputBean implements Serializable {
	
	private byte[] file;
	
	private String fileName;
	
	private List<Artist> artists;
	
	private Integer songId;

	

	public Integer getSongId() {
		return songId;
	}

	public void setSongId(Integer songId) {
		this.songId = songId;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}
}
